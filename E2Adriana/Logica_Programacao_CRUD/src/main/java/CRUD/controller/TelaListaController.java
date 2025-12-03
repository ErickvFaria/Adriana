package CRUD.controller;

import CRUD.dao.BicicletaDAO;
import CRUD.dao.PessoaDAO;
import CRUD.dao.ParqueDAO;
import CRUD.interfaces.Listavel;
import CRUD.model.Bicicleta;
import CRUD.model.Pessoa;
import CRUD.model.Parque;
import CRUD.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class TelaListaController<T> {

    // ================= CONFIGURAÇÃO DE TAMANHO =================
    private static final double CARD_WIDTH = 350;
    private static final double CARD_HEIGHT = 150;
    private static final double IMAGE_WIDTH = 120;
    private static final double IMAGE_HEIGHT = 120;
    private static final double CARD_SPACING = 10;

    private static final double BTN_WIDTH = 100;
    private static final double BTN_HEIGHT = 40;
    // =========================================================

    @FXML
    private FlowPane cardsBox;

    @FXML
    private TextField TextFieldNomePesquisa;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnVoltar;

    private Listavel<T> dao;
    private Class<T> classeEntidade;

    public void configurar(Listavel<T> dao, Class<T> classeEntidade) {
        this.dao = dao;
        this.classeEntidade = classeEntidade;
        criarCards("");
    }

    @FXML
    private void buscarInformacao() {
        String termo = TextFieldNomePesquisa.getText() != null ? TextFieldNomePesquisa.getText().trim() : "";
        criarCards(termo);
    }

    @FXML
    private void voltar() {
        try {
            String fxmlDestino = null;

            if (classeEntidade == Bicicleta.class) {
                fxmlDestino = "/fxml/TelaBicicleta.fxml";
            } else if (classeEntidade == Pessoa.class) {
                fxmlDestino = "/fxml/TelaPessoa.fxml";
            } else if (classeEntidade == Parque.class) {
                fxmlDestino = "/fxml/TelaParque.fxml";
            }

            if (fxmlDestino != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDestino));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Tela Principal");
                stage.setScene(new Scene(root));
                stage.show();

                // Fecha a tela atual
                Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
                stageAtual.close();
            } else {
                System.err.println("Classe de entidade desconhecida, não é possível voltar.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao voltar para a tela anterior.");
        }
    }

    public void atualizarCards() {
        String termo = TextFieldNomePesquisa.getText() != null ? TextFieldNomePesquisa.getText().trim() : "";
        criarCards(termo);
    }

    private void criarCards(String termo) {
        if (dao == null) {
            System.err.println("DAO não configurado! Chame configurar() antes de abrir a tela.");
            return;
        }

        cardsBox.getChildren().clear();
        List<T> itens = termo.isBlank() ? dao.listarTodos() : dao.buscarPorNome(termo);

        if (itens == null || itens.isEmpty()) {
            Label lbl = new Label("Nenhum item encontrado.");
            lbl.setStyle("-fx-font-size: 16px; -fx-text-fill: gray;");
            cardsBox.getChildren().add(lbl);
            return;
        }

        for (T item : itens) {
            VBox textBox = new VBox(5);
            textBox.setAlignment(Pos.CENTER);
            textBox.setPrefWidth(CARD_WIDTH - IMAGE_WIDTH - 3 * CARD_SPACING);

            ImageView img = new ImageView();
            img.setFitHeight(IMAGE_HEIGHT);
            img.setFitWidth(IMAGE_WIDTH);
            img.setPreserveRatio(true);

            try {
                String caminhoFoto = null;

                if (item instanceof Bicicleta b) caminhoFoto = b.getFoto();
                else if (item instanceof Pessoa p) caminhoFoto = p.getFoto();
                else if (item instanceof Parque par) caminhoFoto = par.getFoto();

                if (caminhoFoto != null && !caminhoFoto.isBlank()) {
                    img.setImage(new Image("file:" + caminhoFoto));
                } else {
                    img.setImage(new Image(getClass().getResource("/images/Usuario.png").toExternalForm()));
                }

            } catch (Exception e) {
                img.setImage(new Image(getClass().getResource("/images/Usuario.png").toExternalForm()));
            }

            // Preencher informações do card
            if (item instanceof Bicicleta b) {
                textBox.getChildren().addAll(
                        criarLabelCard("Cor: " + b.getCor()),
                        criarLabelCard("Tamanho: " + b.getTamanho()),
                        criarLabelCard("Preço: R$ " + b.getPreco())
                );
            } else if (item instanceof Pessoa p) {
                textBox.getChildren().addAll(
                        criarLabelCard("Nome: " + p.getNome()),
                        criarLabelCard("Idade: " + p.getIdade()),
                        criarLabelCard("Altura: " + p.getAltura() + " m")
                );
            } else if (item instanceof Parque par) {
                textBox.getChildren().addAll(
                        criarLabelCard("Nome: " + par.getNome()),
                        criarLabelCard("Localização: " + par.getLocalizacao()),
                        criarLabelCard("Tipo de Terreno: " + par.getTipoTerreno())
                );
            }

            // Criar card primeiro
            HBox card = new HBox(CARD_SPACING, img, textBox);
            card.setAlignment(Pos.CENTER);
            card.setPadding(new Insets(10));
            card.setPrefSize(CARD_WIDTH, CARD_HEIGHT);
            card.getStyleClass().add("card-item");

            // Botão de excluir
            Button btnExcluir = new Button("\uD83D\uDDD1");
            btnExcluir.setPrefWidth(BTN_WIDTH);
            btnExcluir.setPrefHeight(BTN_HEIGHT);
            btnExcluir.getStyleClass().add("eye-btn");
            btnExcluir.setOnAction(evt -> {
                boolean confirmado = Alerts.confirmarAcao("Confirmação", "Deseja realmente excluir este item?");
                if (confirmado) {
                    if (item instanceof Bicicleta b) new BicicletaDAO().excluir(b.getId());
                    else if (item instanceof Pessoa p) new PessoaDAO().excluir(p.getId());
                    else if (item instanceof Parque par) new ParqueDAO().excluir(par.getId());

                    cardsBox.getChildren().remove(card);
                }
            });

            card.getChildren().add(btnExcluir);

            // Clique no card para abrir edição
            card.setOnMouseClicked(evt -> abrirVisualizador(item));

            cardsBox.getChildren().add(card);
        }
    }

    private Label criarLabelCard(String texto) {
        Label lbl = new Label(texto);
        lbl.setAlignment(Pos.CENTER);
        lbl.getStyleClass().add("label-card");
        return lbl;
    }

    private void abrirVisualizador(T item) {
        try {
            FXMLLoader loader = null;
            Parent root = null;

            if (item instanceof Bicicleta b) {
                loader = new FXMLLoader(getClass().getResource("/fxml/TelaCadastrarBicicleta.fxml"));
                root = loader.load();
                TelaCadastrarBicicletaController controller = loader.getController();
                controller.preencherCampos(b);
                controller.setTelaListaController((TelaListaController<Bicicleta>) this);

            } else if (item instanceof Pessoa p) {
                loader = new FXMLLoader(getClass().getResource("/fxml/TelaCadastrarPessoa.fxml"));
                root = loader.load();
                TelaCadastrarPessoaController controller = loader.getController();
                controller.preencherCampos(p);
                controller.setTelaListaController((TelaListaController<Pessoa>) this);

            } else if (item instanceof Parque par) {
                loader = new FXMLLoader(getClass().getResource("/fxml/TelaCadastrarParque.fxml"));
                root = loader.load();
                TelaCadastrarParqueController controller = loader.getController();
                controller.preencherCampos(par);
                controller.setTelaListaController((TelaListaController<Parque>) this);
            }

            if (root != null) {
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Visualizador");
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
