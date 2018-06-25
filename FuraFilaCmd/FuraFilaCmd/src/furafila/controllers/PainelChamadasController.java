package furafila.controllers;

import furafila.ContextoFuraFila;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PainelChamadasController {

    public void filaComumSelected(Event e) {
        ContextoFuraFila.getInstance().setTipoFila(ContextoFuraFila.TipoFila.SIMPLES);
    }

    public void filaOrdenadaSelected(Event e) {
        ContextoFuraFila.getInstance().setTipoFila(ContextoFuraFila.TipoFila.ORDENADA);
    }

    public void filaPrioritariaSelected(Event e) {
        ContextoFuraFila.getInstance().setTipoFila(ContextoFuraFila.TipoFila.PRIORITARIA);
    }

    // referências views
    @FXML private Label dataHora;
    @FXML private Label senhaChamada;
    @FXML private ListView<String> proximasSenhas;
}
