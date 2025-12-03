package CRUD.controller;

import CRUD.dao.ParqueDAO;
import CRUD.model.Parque;
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

public class TelaCadastrarParqueController {

    @FXML
    private TextField txf_nome;

    @FXML
    private TextField txf_localizacao;

    @FXML
    private ComboBox<String> cbox_tipoTerreno;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSelecionarFoto;

    @FXML
    private ImageView imgFoto;

    private File arquivoSelecionado;
    private final ParqueDAO parqueDAO = new ParqueDAO();
    private Parque parqueAtual; // se null = novo, se não null = edição
    private TelaListaController<Parque> telaListaController; // referência da tela de lista

    @FXML
    public void initialize() {
        cbox_tipoTerreno.getItems().addAll("Plano", "Acidentado", "Misto");
        cbox_tipoTerreno.getSelectionModel().selectFirst();
    }

    public void setTelaListaController(TelaListaController<Parque> controller) {
        this.telaListaController = controller;
    }

    @FXML
    private void handleSelecionarFoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar Foto do Parque");
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
        String localizacao = txf_localizacao.getText().trim();
        String tipoTerreno = cbox_tipoTerreno.getValue();

        if (nome.isEmpty() || localizacao.isEmpty() || tipoTerreno.isEmpty()) {
            Alerts.mostrarErro("Erro", "Preencha todos os campos!");
            return;
        }

        if (parqueAtual == null) { // novo cadastro
            Parque p = new Parque();
            p.setNome(nome);
            p.setLocalizacao(localizacao);
            p.setTipoTerreno(tipoTerreno);
            p.setFoto(arquivoSelecionado != null ? arquivoSelecionado.getAbsolutePath() : null);
            parqueDAO.inserir(p);
            Alerts.mostrarInformacao("Cadastro", "Parque cadastrado com sucesso!");
        } else { // edição
            parqueAtual.setNome(nome);
            parqueAtual.setLocalizacao(localizacao);
            parqueAtual.setTipoTerreno(tipoTerreno);
            parqueAtual.setFoto(arquivoSelecionado != null ? arquivoSelecionado.getAbsolutePath() : parqueAtual.getFoto());
            parqueDAO.atualizar(parqueAtual);
            Alerts.mostrarInformacao("Atualização", "Parque atualizado com sucesso!");
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

    /**
     * Preenche os campos para edição, igual ao BicicletaController
     */
    public void preencherCampos(Parque p) {
        this.parqueAtual = p;
        txf_nome.setText(p.getNome());
        txf_localizacao.setText(p.getLocalizacao());
        cbox_tipoTerreno.setValue(p.getTipoTerreno());

        if (p.getFoto() != null && !p.getFoto().isBlank()) {
            File file = new File(p.getFoto());
            if (file.exists()) {
                imgFoto.setImage(new Image(file.toURI().toString()));
            }
        }
    }
}
