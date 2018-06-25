package furafila;

import furafila.controllers.ControleOperadorController;
import furafila.controllers.PainelChamadasController;
import furafila.controllers.TiraSenhasController;
import furafila.entities.SenhaAtendimento;
import javafx.event.Event;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class FuraFilaCmd {

    public static void main(String[] args) {
	    escreverBoasVindas();
	    interacaoFuraFilaCmd();
    }

    public static void escreverSenhaEmitida(SenhaAtendimento emitida) {
        System.out.println("Emitida senha código: " + formatarCodigoSenha(Optional.of(emitida)));
    }

    private static void interacaoFuraFilaCmd() {
        AcaoUsuarioCmd acao;
        do {
            escreverEstadoAtendimentos();
            acao = receberAcaoUso();
            acao.getDespacho().accept(new Event(Event.ANY));
        } while (acao != AcaoUsuarioCmd.TERMINAR);
    }

    private static AcaoUsuarioCmd receberAcaoUso() {
        System.out.println(menuOpcoes);
        String opcao = null;
        do {
            if (opcao != null) System.out.println("Código entrado não é válido. Entre novamente.");
            opcao = entradaOpcao("Digite o código da operação desejada: ");
        } while(!codigosAcoes.containsKey(opcao));

        return codigosAcoes.getOrDefault(opcao, AcaoUsuarioCmd.TERMINAR);
    }

    private static String entradaOpcao(String msgDialogo) {
        System.out.print(msgDialogo);
        return entradaTeclado.nextLine();
    }

    private static void escreverEstadoAtendimentos() {
        final ContextoFuraFila contexto = ContextoFuraFila.getInstance();
        // final Iterator<SenhaAtendimento> iter = contexto.getFilaAtendimentos().iterator();
        final String estadoAtendimentos = String.format(
                "Relógio: %s.\nSenha chamada: %s. Cinco próximas: %s, %s, %s, %s, %s.",
                LocalDateTime.now().plus(contexto.getAvancoTempo()).toString(),
                formatarCodigoSenha(contexto.getSenhaChamada()),

                // TODO: Após implementar iterators para as três TADs Fila, substituir
                // Optional.empty() das linhas a seguir por Optional.of(iter.next())
                formatarCodigoSenha(Optional.empty()),
                formatarCodigoSenha(Optional.empty()),
                formatarCodigoSenha(Optional.empty()),
                formatarCodigoSenha(Optional.empty()),
                formatarCodigoSenha(Optional.empty()));

        System.out.println(estadoAtendimentos);
    }

    private static String formatarCodigoSenha(Optional<SenhaAtendimento> senhaChamada) {
        if (!senhaChamada.isPresent()) return "----";

        SenhaAtendimento senha = senhaChamada.get();
        return String.format("%s%03d",
                senha.getTipoCliente().getCodigo(),
                senha.getNumeroSenha());
    }

    private static void escreverBoasVindas() {
        final String msgBoasVindas =
                "-- FuraFila (by Lab2 Technologies) --\n" +
                "Interface de linha de comando provisória.";

        System.out.println(msgBoasVindas);
    }

    private static ControleOperadorController controleOperadorController;
    private static PainelChamadasController painelChamadasController;
    private static TiraSenhasController tiraSenhasController;

    private static final Scanner entradaTeclado;

    private static final String menuOpcoes;
    private static final HashMap<String, AcaoUsuarioCmd> codigosAcoes;

    static {
        controleOperadorController = new ControleOperadorController();
        painelChamadasController = new PainelChamadasController();
        tiraSenhasController = new TiraSenhasController();

        entradaTeclado = new Scanner(System.in);

        StringBuilder builderMenuOpcoes = new StringBuilder("Opções de operação:\n");
        codigosAcoes = new HashMap<>();
        for (AcaoUsuarioCmd acao : AcaoUsuarioCmd.values()) {
            builderMenuOpcoes.append("\t").append(acao.getTextoMenu()).append("\n");
            codigosAcoes.put(acao.getCodigoOpcao(), acao);
        }
        menuOpcoes = builderMenuOpcoes.deleteCharAt(builderMenuOpcoes.length() - 1).toString();
    }



    private enum AcaoUsuarioCmd {
        EMITIR_SENHA_COMUM(tiraSenhasController::tirarSenhaComum, "11", "Emitir senha comum"),
        EMITIR_SENHA_IDOSO(tiraSenhasController::tirarSenhaIdoso, "12", "Emitir senha para idoso"),
        EMITIR_SENHA_ESPECIAL(tiraSenhasController::tirarSenhaEspecial, "13", "Emitir senha especial"),

        CHAMAR_PROXIMA_SENHA(controleOperadorController::chamarProximoPressed, "21", "Chamar proximo atendimento"),
        SIMULAR_PASSAGEM_1_MINUTO(controleOperadorController::maisUmMinutoPressed, "31", "Simular passagem de 1 minuto"),
        SIMULAR_PASSAGEM_5_MINUTOS(controleOperadorController::maisCincoMinutosPressed, "32", "Simular passagem de 5 minutos"),
        SIMULAR_PASSAGEM_10_MINUTOS(controleOperadorController::maisDezMinutosPressed, "33", "Simular passagem de 10 minutos"),

        MUDAR_TIPO_FILA_SIMPLES(painelChamadasController::filaComumSelected, "41", "Mudar organização para fila simples"),
        MUDAR_TIPO_FILA_ORDENADA(painelChamadasController::filaOrdenadaSelected, "42", "Mudar organização para fila ordenada"),
        MUDAR_TIPO_FILA_PRIORITARIA(painelChamadasController::filaPrioritariaSelected, "43", "Mudar organização para fila prioritária"),

        TERMINAR((e) -> System.out.println("Finalizando programa."), "00", "Terminar programa");

        AcaoUsuarioCmd(Consumer<Event> despacho, String codigoOpcao, String descricaoOpcao) {
            this.despacho = despacho;
            this.codigoOpcao = codigoOpcao;
            this.descricaoOpcao = descricaoOpcao;
        }

        public Consumer<Event> getDespacho() {
            return despacho;
        }

        public String getCodigoOpcao() {
            return codigoOpcao;
        }

        public String getTextoMenu() {
            return codigoOpcao + "- " + descricaoOpcao +".";
        }

        private Consumer<Event> despacho;
        private String codigoOpcao;
        private String descricaoOpcao;
    }
}
