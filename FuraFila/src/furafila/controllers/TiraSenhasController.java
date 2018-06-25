package furafila.controllers;

import furafila.ContextoFuraFila;
import furafila.EmissorSenhasAtendimento;
import furafila.entities.SenhaAtendimento;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TiraSenhasController {

    private void atualizarFichaUltimaSenha(SenhaAtendimento senhaTirada) {
        ultimaSenha.setText(senhaTirada.toString());
    }

    private void tirarSenha(SenhaAtendimento.TipoCliente tipo) {
        ContextoFuraFila contexto = ContextoFuraFila.getInstance();
        EmissorSenhasAtendimento emissor = contexto.getEmissorSenhasAtendimento();
        SenhaAtendimento senhaTirada = emissor.emitirSenha(tipo);

        contexto.getFilaAtendimentos().add(senhaTirada);
        atualizarFichaUltimaSenha(senhaTirada);
    }

    @FXML private void tirarSenhaComum(Event e) {
        tirarSenha(SenhaAtendimento.TipoCliente.COMUM);
    }

    @FXML private void tirarSenhaIdoso(Event e) {
        tirarSenha(SenhaAtendimento.TipoCliente.IDOSO);
    }

    @FXML private void tirarSenhaEspecial(Event e) {
        tirarSenha(SenhaAtendimento.TipoCliente.NECESSIDADES_ESPECIAIS);
    }

    @FXML private Label ultimaSenha;
}
