package LinguagemProgramacao.exercicio_2.controllers;

import LinguagemProgramacao.exercicio_2.Bicicleta;
import LinguagemProgramacao.exercicio_2.Parque;
import LinguagemProgramacao.exercicio_2.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Ex2Controller {

    // ==== Bicicleta ====
    @FXML private TextField txtCorBike;
    @FXML private TextField txtTamanhoBike;
    @FXML private TextField txtRodasBike;
    @FXML private Button btnSalvarBike;

    // ==== Parque ====
    @FXML private TextField txtLocalizacaoParque;
    @FXML private TextField txtNomeParque;
    @FXML private TextField txtTerrenoParque;
    @FXML private Button btnSalvarParque;

    // ==== Pessoa ====
    @FXML private TextField txtNomePessoa;
    @FXML private TextField txtIdadePessoa;
    @FXML private TextField txtAlturaPessoa;
    @FXML private Button btnSalvarPessoa;

    @FXML
    private void initialize() {

        btnSalvarBike.setOnAction(e -> {
            try {
                String cor = txtCorBike.getText();
                int tamanho = Integer.parseInt(txtTamanhoBike.getText());
                int rodas = Integer.parseInt(txtRodasBike.getText());
                new Bicicleta(cor, tamanho, rodas).salvar();
                alertInfo("Bicicleta salva!");
                txtCorBike.clear();
                txtTamanhoBike.clear();
                txtRodasBike.clear();
            } catch (NumberFormatException ex) {
                alertErro("Tamanho ou rodas inválidos!");
            }
        });

        btnSalvarParque.setOnAction(e -> {
            new Parque(txtLocalizacaoParque.getText(), txtNomeParque.getText(), txtTerrenoParque.getText()).salvar();
            alertInfo("Parque salvo!");
            txtLocalizacaoParque.clear();
            txtNomeParque.clear();
            txtTerrenoParque.clear();
        });

        btnSalvarPessoa.setOnAction(e -> {
            try {
                String nome = txtNomePessoa.getText();
                int idade = Integer.parseInt(txtIdadePessoa.getText());
                double altura = Double.parseDouble(txtAlturaPessoa.getText());
                new Pessoa(nome, idade, altura).salvar();
                alertInfo("Pessoa salva!");
                txtNomePessoa.clear();
                txtIdadePessoa.clear();
                txtAlturaPessoa.clear();
            } catch (NumberFormatException ex) {
                alertErro("Idade ou altura inválida!");
            }
        });
    }

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
}
