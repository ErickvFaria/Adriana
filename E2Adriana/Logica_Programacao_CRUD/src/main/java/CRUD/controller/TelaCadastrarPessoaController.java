package CRUD.controller;

import CRUD.dao.PessoaDAO;
import CRUD.model.Pessoa;
import CRUD.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class TelaCadastrarPessoaController {

    @FXML
    private TextField txf_nome;

    @FXML
    private TextField txf_idade;

    @FXML
    private TextField txf_altura;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSelecionarFoto;

    @FXML
    private ImageView imgFoto;

    private File arquivoSelecionado;
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private Pessoa pessoaAtual; // null = cadastro, não null = edição

    private TelaListaController<Pessoa> telaListaController; // referência da tela de lista

    @FXML
    public void initialize() {
        // inicializações adicionais podem ser feitas aqui
    }

    public void setTelaListaController(TelaListaController<Pessoa> controller) {
        this.telaListaController = controller;
    }

    @FXML
    private void handleSelecionarFoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar Foto da Pessoa");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) btnSelecionarFoto.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            arquivoSelecionado = file;
            imgFoto.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    private void handleSalvar() {
        String nome = txf_nome.getText().trim();
        String idadeStr = txf_idade.getText().trim();
        String alturaStr = txf_altura.getText().trim();

        if (nome.isEmpty() || idadeStr.isEmpty() || alturaStr.isEmpty()) {
            Alerts.mostrarErro("Erro", "Preencha todos os campos!");
            return;
        }

        int idade;
        double altura;
        try {
            idade = Integer.parseInt(idadeStr);
            altura = Double.parseDouble(alturaStr.replace(",", "."));
        } catch (NumberFormatException e) {
            Alerts.mostrarErro("Erro", "Idade ou altura inválida!");
            return;
        }

        if (pessoaAtual == null) { // Novo cadastro
            Pessoa p = new Pessoa();
            p.setNome(nome);
            p.setIdade(idade);
            p.setAltura(altura);
            p.setFoto(arquivoSelecionado != null ? arquivoSelecionado.getAbsolutePath() : null);
            pessoaDAO.inserir(p);
            Alerts.mostrarInformacao("Cadastro", "Pessoa cadastrada com sucesso!");
        } else { // Edição
            pessoaAtual.setNome(nome);
            pessoaAtual.setIdade(idade);
            pessoaAtual.setAltura(altura);
            pessoaAtual.setFoto(arquivoSelecionado != null ? arquivoSelecionado.getAbsolutePath() : pessoaAtual.getFoto());
            pessoaDAO.atualizar(pessoaAtual);
            Alerts.mostrarInformacao("Atualização", "Pessoa atualizada com sucesso!");
        }

        // Atualiza cards na tela de lista, se existir
        if (telaListaController != null) {
            telaListaController.atualizarCards();
        }

        fecharTela();
    }

    @FXML
    private void handleCancelar() {
        fecharTela();
    }

    private void fecharTela() {
        Stage stageAtual = (Stage) btnCancelar.getScene().getWindow();
        stageAtual.close();
    }

    /**
     * Preenche os campos caso seja edição
     */
    public void preencherCampos(Pessoa p) {
        this.pessoaAtual = p;
        txf_nome.setText(p.getNome());
        txf_idade.setText(String.valueOf(p.getIdade()));
        txf_altura.setText(String.valueOf(p.getAltura()));

        if (p.getFoto() != null && !p.getFoto().isBlank()) {
            File file = new File(p.getFoto());
            if (file.exists()) {
                imgFoto.setImage(new Image(file.toURI().toString()));
            }
        }
    }
}
