package furafila.controllers;

import furafila.ContextoFuraFila;
import javafx.event.Event;
import javafx.fxml.FXML;

import java.time.Duration;

public class ControleOperadorController {
    @FXML private void chamarProximoPressed(Event e) {
        ContextoFuraFila.getInstance().getFilaAtendimentos().desenfileirar();
    }

    @FXML private void maisUmMinutoPressed(Event e) {
        ContextoFuraFila.getInstance().avancarTempo(Duration.ofMinutes(1));
    }

    @FXML private void maisCincoMinutosPressed(Event e) {
        ContextoFuraFila.getInstance().avancarTempo(Duration.ofMinutes(5));
    }

    @FXML private void maisDezMinutosPressed(Event e) {
        ContextoFuraFila.getInstance().avancarTempo(Duration.ofMinutes(10));
    }
}
