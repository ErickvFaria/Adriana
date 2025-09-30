package LinguagemProgramacao.exercicio_2;

import java.io.File;
import ClasseEscritaLeitura.CSVEscritaLeitura;


public class Bicicleta {
    private String cor;
    private int tamanho;
    private int qntDeRodas;

    public Bicicleta(String cor, int tamanho, int qntDeRodas) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.qntDeRodas = qntDeRodas;
    }

    public void salvar() {
        String caminho = "bicicletas.csv";
        File arquivo = new File(caminho);
        String[] cabecalho = arquivo.exists() ? null : new String[]{"Cor", "Tamanho", "Rodas"};
        String[][] dados = {{cor, String.valueOf(tamanho), String.valueOf(qntDeRodas)}};
        new CSVEscritaLeitura().escreverCSV(caminho, cabecalho, dados);
    }

    // getters e setters
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public int getTamanho() { return tamanho; }
    public void setTamanho(int tamanho) { this.tamanho = tamanho; }
    public int getQntDeRodas() { return qntDeRodas; }
    public void setQntDeRodas(int qntDeRodas) { this.qntDeRodas = qntDeRodas; }
}
