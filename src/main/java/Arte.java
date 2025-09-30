package ClasseEscritaLeitura;

import java.io.File;


public class Arte {
    private String id;
    private int anoCriacao;
    private double preco;

    public Arte(String id, int anoCriacao, double preco) {
        this.id = id;
        this.anoCriacao = anoCriacao;
        this.preco = preco;
    }

    public String getId() { return id; }
    public int getAnoCriacao() { return anoCriacao; }
    public double getPreco() { return preco; }

    public void salvar() {
        String caminho = "artes.csv";
        File arquivo = new File(caminho);
        String[] cabecalho = arquivo.exists() ? null : new String[]{"ID","AnoCriacao","Preco"};
        String[][] dados = {{id, String.valueOf(anoCriacao), String.valueOf(preco)}};
        new CSVEscritaLeitura().escreverCSV(caminho, cabecalho, dados);
    }
}
