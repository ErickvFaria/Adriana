package CRUD.controller;

import CRUD.dao.BicicletaDAO;
import CRUD.model.Bicicleta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaBicicletaController {

    @FXML
    private void cadastrarBicicleta(ActionEvent event) {
        abrirTela("/fxml/TelaCadastrarBicicleta.fxml", "Cadastrar Bicicleta");
    }

    @FXML
    private void listarBicicletas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TelaLista.fxml"));
            Parent root = loader.load();

            // Pega o controller e configura o DAO e a classe da entidade
            CRUD.controller.TelaListaController<Bicicleta> controller = loader.getController();
            controller.configurar(new BicicletaDAO(), Bicicleta.class);

            // Abre nova tela
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Lista de Bicicletas");
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
