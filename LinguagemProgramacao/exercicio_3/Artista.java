package exercicio_3;

public class Artista {
    private String tipoDeArte;
    private String nome;
    private int idade;

    public Artista(String tipoDeArte, String nome, int idade) {
        this.tipoDeArte = tipoDeArte;
        this.nome = nome;
        this.idade = idade;
    }

    public String getTipoDeArte() {
        return tipoDeArte;
    }

    public void setTipoDeArte(String tipoDeArte) {
        this.tipoDeArte = tipoDeArte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Arte criar(Lixo lixo, int id, int anoCriacao, double precoInicial) {
        System.out.println(nome + " está criando arte a partir do lixo...");
        return lixo.seTransformar(id, anoCriacao, precoInicial);
    }
}
