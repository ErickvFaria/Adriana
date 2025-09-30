package LinguagemProgramacao.exercicio_4.controllers;

import LinguagemProgramacao.ClasseEscritaLeitura;
import LinguagemProgramacao.exercicio_4.Carro;
import LinguagemProgramacao.exercicio_4.Foguete;
import LinguagemProgramacao.exercicio_4.Personagem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Ex4Controller {

    // Campos Carro
    @FXML private TextField txtModeloCarro;
    @FXML private TextField txtVelocidadeCarro;
    @FXML private TextField txtCorCarro;
    @FXML private Button btnSalvarCarro;

    // Campos Foguete
    @FXML private TextField txtNomeFoguete;
    @FXML private TextField txtCombustivelFoguete;
    @FXML private TextField txtAltitudeFoguete;
    @FXML private Button btnSalvarFoguete;

    // Campos Personagem
    @FXML private TextField txtNomePersonagem;
    @FXML private TextField txtHumorPersonagem;
    @FXML private TextField txtEnergiaPersonagem;
    @FXML private Button btnSalvarPersonagem;

    private ClasseEscritaLeitura csv = new ClasseEscritaLeitura();

    @FXML
    private void initialize() {
        btnSalvarCarro.setOnAction(e -> salvarCarro());
        btnSalvarFoguete.setOnAction(e -> salvarFoguete());
        btnSalvarPersonagem.setOnAction(e -> salvarPersonagem());
    }

    private void salvarCarro() {
        Carro carro = new Carro(
                txtModeloCarro.getText(),
                Integer.parseInt(txtVelocidadeCarro.getText()),
                txtCorCarro.getText()
        );
        String[][] dados = {{carro.getModelo(), String.valueOf(carro.getVelocidade()), carro.getCor()}};
        csv.escreverCSV("carro.csv", new String[]{"Modelo","Velocidade","Cor"}, dados);
        System.out.println("Carro salvo!");
    }

    private void salvarFoguete() {
        Foguete foguete = new Foguete(
                txtNomeFoguete.getText(),
                txtCombustivelFoguete.getText(),
                Integer.parseInt(txtAltitudeFoguete.getText())
        );
        String[][] dados = {{foguete.getNome(), foguete.getCombustivel(), String.valueOf(foguete.getAltitude())}};
        csv.escreverCSV("foguete.csv", new String[]{"Nome","Combustivel","Altitude"}, dados);
        System.out.println("Foguete salvo!");
    }

    private void salvarPersonagem() {
        Personagem p = new Personagem(
                txtNomePersonagem.getText(),
                txtHumorPersonagem.getText(),
                Integer.parseInt(txtEnergiaPersonagem.getText())
        );
        String[][] dados = {{p.getNome(), p.getHumor(), String.valueOf(p.getEnergia())}};
        csv.escreverCSV("personagem.csv", new String[]{"Nome","Humor","Energia"}, dados);
        System.out.println("Personagem salvo!");
    }
}
