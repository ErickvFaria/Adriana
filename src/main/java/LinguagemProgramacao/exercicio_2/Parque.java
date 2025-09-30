package LinguagemProgramacao.exercicio_2;

import java.io.File;
import ClasseEscritaLeitura.CSVEscritaLeitura;

public class Parque {
    private String localizacao;
    private String nome;
    private String tipoDeTerreno;

    public Parque(String localizacao, String nome, String tipoDeTerreno) {
        this.localizacao = localizacao;
        this.nome = nome;
        this.tipoDeTerreno = tipoDeTerreno;
    }

    public void salvar() {
        String caminho = "parques.csv";
        File arquivo = new File(caminho);
        String[] cabecalho = arquivo.exists() ? null : new String[]{"Localizacao", "Nome", "Tipo"};
        String[][] dados = {{localizacao, nome, tipoDeTerreno}};
        new CSVEscritaLeitura().escreverCSV(caminho, cabecalho, dados);
    }

    // getters e setters
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipoDeTerreno() { return tipoDeTerreno; }
    public void setTipoDeTerreno(String tipoDeTerreno) { this.tipoDeTerreno = tipoDeTerreno; }
}
