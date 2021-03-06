package furafila.controllers;

import furafila.ContextoFuraFila;
import furafila.EmissorSenhasAtendimento;
import furafila.FuraFilaCmd;
import furafila.entities.SenhaAtendimento;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TiraSenhasController {

    private void atualizarFichaUltimaSenha(SenhaAtendimento senhaTirada) {
        //ultimaSenha.setText(senhaTirada.toString());
        FuraFilaCmd.escreverSenhaEmitida(senhaTirada);
    }

    private void tirarSenha(SenhaAtendimento.TipoCliente tipo) {
        ContextoFuraFila contexto = ContextoFuraFila.getInstance();
        EmissorSenhasAtendimento emissor = contexto.getEmissorSenhasAtendimento();
        SenhaAtendimento senhaTirada = emissor.emitirSenha(tipo);

        contexto.getFilaAtendimentos().add(senhaTirada);
        atualizarFichaUltimaSenha(senhaTirada);
    }

    public void tirarSenhaComum(Event e) {
        tirarSenha(SenhaAtendimento.TipoCliente.COMUM);
    }

    public void tirarSenhaIdoso(Event e) {
        tirarSenha(SenhaAtendimento.TipoCliente.IDOSO);
    }

    public void tirarSenhaEspecial(Event e) {
        tirarSenha(SenhaAtendimento.TipoCliente.NECESSIDADES_ESPECIAIS);
    }

    public Label ultimaSenha;
}
