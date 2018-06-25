package furafila;

import furafila.colecoes.Fila;
import furafila.colecoes.FilaOrdenada;
import furafila.colecoes.FilaPrioritaria;
import furafila.colecoes.FilaSimples;
import furafila.entities.SenhaAtendimento;

import java.time.Duration;
import java.util.Optional;

public class ContextoFuraFila {

    private ContextoFuraFila() {
        emissorSenhasAtendimento = new EmissorSenhasAtendimento();
        filaAtendimentos = new FilaSimples<>();
        avancoTempo = Duration.ZERO;
        senhaChamada = Optional.empty();
    }

    public static ContextoFuraFila getInstance() {
        if (singletonInstance == null) singletonInstance = new ContextoFuraFila();
        return singletonInstance;
    }

    public EmissorSenhasAtendimento getEmissorSenhasAtendimento() {
        return emissorSenhasAtendimento;
    }

    public Fila<SenhaAtendimento> getFilaAtendimentos() {
        return filaAtendimentos;
    }

    public void setTipoFila(TipoFila tipo) {
        switch (tipo) {
            case SIMPLES:
                filaAtendimentos = new FilaSimples(filaAtendimentos);
                break;
            case ORDENADA:
                filaAtendimentos = new FilaOrdenada(filaAtendimentos);
                break;
            case PRIORITARIA:
                filaAtendimentos = new FilaPrioritaria(filaAtendimentos);
                break;
        }
    }

    public Duration getAvancoTempo() {
        return avancoTempo;
    }

    public void avancarTempo(Duration avanco) {
        avancoTempo = avancoTempo.plus(avanco);
    }

    public Optional<SenhaAtendimento> getSenhaChamada() {
        return senhaChamada;
    }

    public void setSenhaChamada(Optional<SenhaAtendimento> senhaChamada) {
        this.senhaChamada = senhaChamada;
    }

    private Duration avancoTempo;
    private EmissorSenhasAtendimento emissorSenhasAtendimento;
    private Fila<SenhaAtendimento> filaAtendimentos;
    private Optional<SenhaAtendimento> senhaChamada;

    private static ContextoFuraFila singletonInstance;

    public enum TipoFila {
        SIMPLES, ORDENADA, PRIORITARIA;
    }
}
