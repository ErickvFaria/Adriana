package CRUD.controller;

import CRUD.dao.ParqueDAO;
import CRUD.model.Parque;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaParqueController {

    @FXML
    private void cadastrarParque(ActionEvent event) {
        abrirTela("/fxml/TelaCadastrarParque.fxml", "Cadastrar Parque");
    }

    @FXML
    private void listarParque(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TelaLista.fxml"));
            Parent root = loader.load();

            // Configura DAO e classe de entidade igual ao Bicicleta
            TelaListaController<Parque> controller = loader.getController();
            controller.configurar(new ParqueDAO(), Parque.class);

            // Abre nova tela
            Stage stage = new Stage();
            stage.setTitle("Lista de Parques");
            stage.setScene(new Scene(root));
            stage.show();

            // Fecha a janela atual
            Stage stageAtual = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageAtual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void VoltarTelaInicial(ActionEvent event) {
        abrirTela("/fxml/TelaInicial.fxml", "Tela Inicial");
        // Fecha a janela atual
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Método genérico para abrir qualquer FXML
     *
     * @param fxmlPath Caminho do FXML dentro de resources
     * @param titulo   Título da nova janela
     */
    private void abrirTela(String fxmlPath, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao abrir a tela: " + fxmlPath);
        }
    }
}
