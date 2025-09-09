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

   public Arte criar(Lixo lixo, int id, int anoCriacao, double precoInicial) {
        System.out.println(nome + " está criando arte a partir do lixo...");
        return lixo.seTransformar(id, anoCriacao, precoInicial);
    }
}
