package furafila;

import furafila.entities.SenhaAtendimento;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class EmissorSenhasAtendimento {

    public EmissorSenhasAtendimento() {
        contadorSenhas = new HashMap<>();
    }

    public SenhaAtendimento emitirSenha(SenhaAtendimento.TipoCliente tipo) {
        int numeroSenha = contadorSenhas.getOrDefault(tipo, -1) + 1;
        contadorSenhas.put(tipo, numeroSenha);
        LocalDateTime tempoSimulado = LocalDateTime.now().plus(ContextoFuraFila.getInstance().getAvancoTempo());
        return new SenhaAtendimento(numeroSenha, tipo, tempoSimulado);
    }

    private Map<SenhaAtendimento.TipoCliente, Integer> contadorSenhas;
}
