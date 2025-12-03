package CRUD;

import CRUD.config.DatabaseInitializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Inicializa o banco de dados
        DatabaseInitializer dbInitializer = new DatabaseInitializer();
        dbInitializer.initializeDatabase();

        // Carrega a tela inicial
        scene = new Scene(loadFXML("/fxml/TelaInicial"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Sistema CRUD");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
