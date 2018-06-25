package furafila.entities;

import java.time.LocalDateTime;

public class SenhaAtendimento {

    public SenhaAtendimento(int numeroSenha, TipoCliente tipoCliente, LocalDateTime marcadorChegada) {
        this.numeroSenha = numeroSenha % NUMERO_SENHA_MAXIMO;
        this.tipoCliente = tipoCliente;
        this.marcadorChegada = marcadorChegada;
    }

    public int getNumeroSenha() {
        return numeroSenha;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public LocalDateTime getMarcadorChegada() {
        return marcadorChegada;
    }

    private int numeroSenha;
    private TipoCliente tipoCliente;
    private LocalDateTime marcadorChegada;

    private static final int NUMERO_SENHA_MAXIMO = 1000;

    public enum TipoCliente {
        COMUM("C"), IDOSO("I"), NECESSIDADES_ESPECIAIS("E");

        TipoCliente(String codigo) {
            this.codigo = codigo;
        }

        public String getCodigo() {
            return codigo;
        }

        private String codigo;
    }
}
