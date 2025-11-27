package LinguagemProgramacao.exercicio_2;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML private TextField campoNome;
    @FXML private TextField campoIdade;

    @FXML private TableView<Pessoa> tabelaPessoas;
    @FXML private TableColumn<Pessoa, Integer> colId;
    @FXML private TableColumn<Pessoa, String> colNome;
    @FXML private TableColumn<Pessoa, Integer> colIdade;

    private PessoaDAO pessoaDAO = new PessoaDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getId()).asObject());
        colNome.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getNome()));
        colIdade.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getIdade()).asObject());

        carregarTabela();
    }

    @FXML
    public void salvarPessoa() {
        String nome = campoNome.getText();
        int idade = Integer.parseInt(campoIdade.getText());

        pessoaDAO.salvar(new Pessoa(nome, idade));
        carregarTabela();

        campoNome.clear();
        campoIdade.clear();
    }

    private void carregarTabela() {
        tabelaPessoas.getItems().setAll(pessoaDAO.listar());
    }
}
