package LinguagemProgramacao.exercicio_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainExercicio2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Corrigido: remover duplicidade "FXMLLoader loader = new FXMLLoader loader ="
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ex2.fxml"));

        // Cria a cena
        Scene scene = new Scene(loader.load());
        stage.setTitle("Cadastro Exercício 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
