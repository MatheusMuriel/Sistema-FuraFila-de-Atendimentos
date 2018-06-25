package furafila.controllers;

import furafila.ContextoFuraFila;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PainelChamadasController {

    // referências views
    @FXML private Label dataHora;
    @FXML private Label senhaChamada;
    @FXML private ListView<String> proximasSenhas;
}
