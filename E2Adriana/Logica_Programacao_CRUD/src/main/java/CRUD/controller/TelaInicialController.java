package CRUD.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialController {

    @FXML
    private Button btn_bicicleta;

    @FXML
    private Button btn_parque;

    @FXML
    private Button btn_pessoas;

    // Método chamado ao clicar no botão Bicicleta
    @FXML
    private void selecionarBicicleta(ActionEvent event) {
        abrirTelaEFecharAtual("/fxml/TelaBicicleta.fxml", "Cadastro de Bicicletas", event);
    }

    // Método chamado ao clicar no botão Parque
    @FXML
    private void selecionarParque(ActionEvent event) {
        abrirTelaEFecharAtual("/fxml/TelaParque.fxml", "Cadastro de Parques", event);
    }

    // Método chamado ao clicar no botão Pessoas
    @FXML
    private void SelecionarPessoas(ActionEvent event) {
        abrirTelaEFecharAtual("/fxml/TelaPessoa.fxml", "Cadastro de Pessoas", event);
    }

    /**
     * Método genérico para abrir uma tela FXML e fechar a tela atual
     *
     * @param fxmlPath Caminho do FXML dentro de resources
     * @param titulo   Título da nova janela
     * @param event    Evento do botão clicado
     */
    private void abrirTelaEFecharAtual(String fxmlPath, String titulo, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage novaStage = new Stage();
            novaStage.setTitle(titulo);
            novaStage.setScene(new Scene(root));
            novaStage.show();

            // Fecha a janela atual
            Stage stageAtual = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stageAtual.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao abrir a tela: " + fxmlPath);
        }
    }
}
