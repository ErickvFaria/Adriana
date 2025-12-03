package CRUD.controller;

import CRUD.dao.BicicletaDAO;
import CRUD.model.Bicicleta;
import CRUD.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class TelaCadastrarBicicletaController {

    @FXML
    private ComboBox<String> cbox_tamanho;

    @FXML
    private TextField txtCor;

    @FXML
    private TextField txtPreco;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSelecionarFoto;

    @FXML
    private ImageView imgFoto;

    private File arquivoSelecionado;
    private final BicicletaDAO bicicletaDAO = new BicicletaDAO();

    private TelaListaController<Bicicleta> telaListaController; // referência da tela de lista
    private Bicicleta bicicletaAtual; // se for edição

    @FXML
    public void initialize() {
        cbox_tamanho.getItems().addAll("Grande", "Média", "Pequena");
        cbox_tamanho.getSelectionModel().selectFirst();
    }

    public void setTelaListaController(TelaListaController<Bicicleta> controller) {
        this.telaListaController = controller;
    }

    @FXML
    private void handleSelecionarFoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar Foto da Bicicleta");
        fileChooser.getExtensionFilters().addAll(
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
        String tamanho = cbox_tamanho.getValue();
        String cor = txtCor.getText();
        String precoStr = txtPreco.getText();

        if (cor.isEmpty() || precoStr.isEmpty()) {
            Alerts.mostrarErro("Erro", "Preencha todos os campos!");
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoStr.replace(",", "."));
        } catch (NumberFormatException e) {
            Alerts.mostrarErro("Erro", "Preço inválido!");
            return;
        }

        if (bicicletaAtual == null) {
            Bicicleta bicicleta = new Bicicleta();
            bicicleta.setTamanho(tamanho);
            bicicleta.setCor(cor);
            bicicleta.setPreco(preco);
            bicicleta.setFoto(arquivoSelecionado != null ? arquivoSelecionado.getAbsolutePath() : null);
            bicicletaDAO.inserir(bicicleta);
            Alerts.mostrarInformacao("Cadastro", "Bicicleta cadastrada com sucesso!");
        } else {
            bicicletaAtual.setTamanho(tamanho);
            bicicletaAtual.setCor(cor);
            bicicletaAtual.setPreco(preco);
            bicicletaAtual.setFoto(arquivoSelecionado != null ? arquivoSelecionado.getAbsolutePath() : bicicletaAtual.getFoto());
            bicicletaDAO.atualizar(bicicletaAtual);
            Alerts.mostrarInformacao("Atualização", "Bicicleta atualizada com sucesso!");
        }

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

    public void preencherCampos(Bicicleta b) {
        this.bicicletaAtual = b; // seta para edição
        txtCor.setText(b.getCor());
        cbox_tamanho.setValue(b.getTamanho());
        txtPreco.setText(String.valueOf(b.getPreco()));

        if (b.getFoto() != null && !b.getFoto().isBlank()) {
            File file = new File(b.getFoto());
            if (file.exists()) {
                imgFoto.setImage(new Image(file.toURI().toString()));
            }
        }
    }
}
