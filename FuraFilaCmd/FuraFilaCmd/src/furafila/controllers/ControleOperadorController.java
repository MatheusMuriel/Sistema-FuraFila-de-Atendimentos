package furafila.controllers;

import furafila.ContextoFuraFila;
import javafx.event.Event;

import java.time.Duration;
import java.util.Optional;

public class ControleOperadorController {
    public void chamarProximoPressed(Event e) {
        ContextoFuraFila contexto = ContextoFuraFila.getInstance();
        contexto.setSenhaChamada(
                Optional.of(contexto.getFilaAtendimentos().desenfileirar()));
    }

    public void maisUmMinutoPressed(Event e) {
        ContextoFuraFila.getInstance().avancarTempo(Duration.ofMinutes(1));
    }

    public void maisCincoMinutosPressed(Event e) {
        ContextoFuraFila.getInstance().avancarTempo(Duration.ofMinutes(5));
    }

    public void maisDezMinutosPressed(Event e) {
        ContextoFuraFila.getInstance().avancarTempo(Duration.ofMinutes(10));
    }
}
