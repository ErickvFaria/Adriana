package LinguagemProgramacao.exercicio_7.controllers;

import LinguagemProgramacao.exercicio_7.CalculoMedia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class CalculoMediaController {

    @FXML private TextField txtP1;
    @FXML private TextField txtE1;
    @FXML private TextField txtE2;
    @FXML private TextField txtX;
    @FXML private TextField txtSUB;
    @FXML private TextField txtAP;
    @FXML private Button btnCalcular;
    @FXML private Label lblResultado;

    @FXML
    private void initialize() {
        btnCalcular.setOnAction(e -> {
            try {
                double P1 = Double.parseDouble(txtP1.getText());
                double E1 = Double.parseDouble(txtE1.getText());
                double E2 = Double.parseDouble(txtE2.getText());
                double X = Double.parseDouble(txtX.getText());
                double SUB = Double.parseDouble(txtSUB.getText());
                double AP = Double.parseDouble(txtAP.getText());

                double media = CalculoMedia.calcular(P1, E1, E2, X, SUB, AP);
                lblResultado.setText(String.format("Média final: %.2f", media));

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Digite apenas números válidos!");
                alert.showAndWait();
            }
        });
    }
}
