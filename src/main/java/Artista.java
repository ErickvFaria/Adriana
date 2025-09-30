package ClasseEscritaLeitura;
import java.io.File;

public class Artista {
    private String nome;
    private int idade;
    private String tipoArte;

    public Artista(String nome, int idade, String tipoArte) {
        this.nome = nome;
        this.idade = idade;
        this.tipoArte = tipoArte;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getTipoArte() { return tipoArte; }

    // Salvar no CSV
    public void salvar() {
        String caminho = "artistas.csv";
        File arquivo = new File(caminho);
        String[] cabecalho = arquivo.exists() ? null : new String[]{"Nome","Idade","TipoArte"};
        String[][] dados = {{nome, String.valueOf(idade), tipoArte}};
        new CSVEscritaLeitura().escreverCSV(caminho, cabecalho, dados);
    }
}
