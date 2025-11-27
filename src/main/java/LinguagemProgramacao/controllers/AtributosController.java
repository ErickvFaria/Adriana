package LinguagemProgramacao.controllers;

import ClasseEscritaLeitura.Artista;
import ClasseEscritaLeitura.Arte;
import ClasseEscritaLeitura.Lixo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class AtributosController {

    // ==== TAB ARTISTA ====
    @FXML
    private TextField txtNomeArtista;
    @FXML
    private TextField txtIdadeArtista;
    @FXML
    private TextField txtTipoArte;
    @FXML
    private Button btnSalvarArtista;

    // ==== TAB ARTE ====
    @FXML
    private TextField txtIdArte;
    @FXML
    private TextField txtAnoCriacao;
    @FXML
    private TextField txtPreco;
    @FXML
    private Button btnSalvarArte;

    // ==== TAB LIXO ====
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TextField txtCheiro;
    @FXML
    private Button btnSalvarLixo;

    @FXML
    private void initialize() {
        // Botão salvar Artista
        btnSalvarArtista.setOnAction(e -> {
            try {
                String nome = txtNomeArtista.getText();
                int idade = Integer.parseInt(txtIdadeArtista.getText());
                String tipo = txtTipoArte.getText();

                Artista artista = new Artista(nome, idade, tipo);
                artista.salvar();

                alertInfo("Artista salvo com sucesso!");
                limparCamposArtista();

            } catch (NumberFormatException ex) {
                alertErro("info inválida!");
            }
        });

        // Botão salvar Arte
        btnSalvarArte.setOnAction(e -> {
            try {
                String id = txtIdArte.getText();
                int ano = Integer.parseInt(txtAnoCriacao.getText());
                double preco = Double.parseDouble(txtPreco.getText());

                Arte arte = new Arte(id, ano, preco);
                arte.salvar();

                alertInfo("Arte salva com sucesso!");
                limparCamposArte();

            } catch (NumberFormatException ex) {
                alertErro("Ano ou preço inválido!");
            }
        });

        // Botão salvar Lixo
        btnSalvarLixo.setOnAction(e -> {
            try {
                double peso = Double.parseDouble(txtPeso.getText());
                int quantidade = Integer.parseInt(txtQuantidade.getText());
                String cheiro = txtCheiro.getText();

                Lixo lixo = new Lixo(peso, quantidade, cheiro);
                lixo.salvar();

                alertInfo("Lixo salvo com sucesso!");
                limparCamposLixo();

            } catch (NumberFormatException ex) {
                alertErro("Peso ou quantidade inválidos!");
            }
        });
    }

    // ==== MÉTODOS AUXILIARES ====
    private void alertInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void alertErro(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void limparCamposArtista() {
        txtNomeArtista.clear();
        txtIdadeArtista.clear();
        txtTipoArte.clear();
    }

    private void limparCamposArte() {
        txtIdArte.clear();
        txtAnoCriacao.clear();
        txtPreco.clear();
    }

    private void limparCamposLixo() {
        txtPeso.clear();
        txtQuantidade.clear();
        txtCheiro.clear();
    }
}
