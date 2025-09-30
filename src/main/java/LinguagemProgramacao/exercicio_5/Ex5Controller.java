package LinguagemProgramacao.exercicio_5.controllers;

import LinguagemProgramacao.ClasseEscritaLeitura;
import LinguagemProgramacao.exercicio_5.Humano;
import LinguagemProgramacao.exercicio_5.Ovelha;
import LinguagemProgramacao.exercicio_5.Tempo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Ex5Controller {

    // Campos Humano
    @FXML private TextField txtNomeHumano;
    @FXML private TextField txtIdadeHumano;
    @FXML private TextField txtRoupaHumano;
    @FXML private TextField txtAnoHumano;
    @FXML private TextField txtDecadaHumano;
    @FXML private TextField txtEventoHumano;
    @FXML private Button btnSalvarHumano;

    // Campos Ovelha
    @FXML private TextField txtNomeOvelha;
    @FXML private TextField txtIdadeOvelha;
    @FXML private TextField txtLanaOvelha;
    @FXML private Button btnSalvarOvelha;

    // Botão associar
    @FXML private Button btnAssociarOvelha;

    private ClasseEscritaLeitura csv = new ClasseEscritaLeitura();
    private List<Humano> humanos = new ArrayList<>();
    private List<Ovelha> ovelhas = new ArrayList<>();

    @FXML
    private void initialize() {
        btnSalvarHumano.setOnAction(e -> salvarHumano());
        btnSalvarOvelha.setOnAction(e -> salvarOvelha());
        btnAssociarOvelha.setOnAction(e -> associarOvelha());
    }

    private void salvarHumano() {
        Tempo tempo = new Tempo(
                Integer.parseInt(txtAnoHumano.getText()),
                Integer.parseInt(txtDecadaHumano.getText()),
                txtEventoHumano.getText()
        );
        Humano h = new Humano(
                txtNomeHumano.getText(),
                Integer.parseInt(txtIdadeHumano.getText()),
                txtRoupaHumano.getText(),
                tempo
        );
        humanos.add(h);
        String[][] dados = {{h.getNome(), String.valueOf(h.getIdade()), h.getRoupa(), String.valueOf(tempo.getAnoAtual()), String.valueOf(tempo.getDecada()), tempo.getEventoHistorico()}};
        csv.escreverCSV("humano.csv", new String[]{"Nome","Idade","Roupa","Ano","Decada","Evento"}, dados);
        System.out.println("Humano salvo!");
    }

    private void salvarOvelha() {
        // Assumimos que a primeira humano define o tempo, ou criamos tempo neutro
        Tempo tempo = humanos.isEmpty() ? new Tempo(0,0,"") : humanos.get(0).getTempo();
        Ovelha o = new Ovelha(
                txtNomeOvelha.getText(),
                Integer.parseInt(txtIdadeOvelha.getText()),
                Double.parseDouble(txtLanaOvelha.getText()),
                tempo
        );
        ovelhas.add(o);
        String[][] dados = {{o.getNome(), String.valueOf(o.getIdade()), String.valueOf(o.getQuantidadeLana()), String.valueOf(o.getTempo().getAnoAtual())}};
        csv.escreverCSV("ovelha.csv", new String[]{"Nome","Idade","Lana","Ano"}, dados);
        System.out.println("Ovelha salva!");
    }

    private void associarOvelha() {
        if (humanos.isEmpty() || ovelhas.isEmpty()) {
            System.out.println("Nenhum humano ou ovelha para associar");
            return;
        }
        // Associa a última ovelha ao último humano
        Humano h = humanos.get(humanos.size() - 1);
        Ovelha o = ovelhas.get(ovelhas.size() - 1);
        h.adicionarOvelha(o);
        System.out.println("Ovelha " + o.getNome() + " associada a " + h.getNome());
    }
}
