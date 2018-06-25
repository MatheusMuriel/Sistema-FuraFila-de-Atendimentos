package furafila;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage telaPrincipal) throws Exception{

        Parent painelChamadas = FXMLLoader.load(getClass().getResource("resources/painelChamadas.fxml"));
        telaPrincipal.setTitle("Fura Fila - Painel");
        telaPrincipal.setScene(new Scene(painelChamadas, 300, 275));
        telaPrincipal.setAlwaysOnTop(true);
        telaPrincipal.show();

        Parent tiraSenhas = FXMLLoader.load(getClass().getResource("resources/tiraSenhas.fxml"));
        Stage janelaClientes = new Stage();
        janelaClientes.setTitle("Terminal dos clientes");
        janelaClientes.setScene(new Scene(tiraSenhas, 300,200));
        janelaClientes.show();

        Parent controleOperador= FXMLLoader.load(getClass().getResource("resources/controleOperador.fxml"));
        Stage janelaOperador = new Stage();
        janelaOperador.setTitle("Controle do operador");
        janelaOperador.setScene(new Scene(controleOperador, 300,200));
        janelaOperador.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
