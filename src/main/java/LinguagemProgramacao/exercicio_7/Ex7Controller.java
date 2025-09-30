package LinguagemProgramacao.exercicio_7.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Ex7Controller {

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
        btnCalcular.setOnAction(e -> calcularMedia());
    }

    private void calcularMedia() {
        try {
            double P1 = Double.parseDouble(txtP1.getText());
            double E1 = Double.parseDouble(txtE1.getText());
            double E2 = Double.parseDouble(txtE2.getText());
            double X = Double.parseDouble(txtX.getText());
            double SUB = Double.parseDouble(txtSUB.getText());
            double AP = Double.parseDouble(txtAP.getText());

            double parteBase = (P1 * 0.5) + (E1 * 0.2) + (E2 * 0.3) + X + (SUB * 0.15);
            double parte1 = parteBase * 0.5;

            double diferenca = parteBase - 5.9;
            double parte2 = 0.0;
            if (diferenca > 0) {
                parte2 = AP * 0.5;
            }

            double media = parte1 + parte2;

            lblResultado.setText(String.format("Média final: %.2f", media));

        } catch (NumberFormatException ex) {
            lblResultado.setText("Digite valores válidos!");
        }
    }
}
