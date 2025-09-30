package LinguagemProgramacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;


import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Ex3.fxml")));
        primaryStage.setTitle("Gerenciador de Atributos");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


}