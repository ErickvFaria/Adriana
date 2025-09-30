package ClasseEscritaLeitura;
import java.io.File;

public class Lixo {
    private double peso;
    private int quantidade;
    private String cheiro;

    public Lixo(double peso, int quantidade, String cheiro) {
        this.peso = peso;
        this.quantidade = quantidade;
        this.cheiro = cheiro;
    }

    public double getPeso() { return peso; }
    public int getQuantidade() { return quantidade; }
    public String getCheiro() { return cheiro; }

    public void salvar() {
        String caminho = "lixos.csv";
        File arquivo = new File(caminho);
        String[] cabecalho = arquivo.exists() ? null : new String[]{"Peso","Quantidade","Cheiro"};
        String[][] dados = {{String.valueOf(peso), String.valueOf(quantidade), cheiro}};
        new CSVEscritaLeitura().escreverCSV(caminho, cabecalho, dados);
    }
}
