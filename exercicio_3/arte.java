package exercicio_3;

public class Arte {
    private double preco;
    private int anoCriacao;
    private int id;

    public Arte(double preco, int anoCriacao, int id) {
        this.preco = preco;
        this.anoCriacao = anoCriacao;
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void seValorizar(double percentual) {
        this.preco += this.preco * (percentual / 100);
        System.out.println("A arte ID " + id + " foi valorizada. Novo preço: R$ " + preco);
    }

    public String toString() {
        return "Arte{id=" + id + ", ano=" + anoCriacao + ", preço=R$ " + preco + "}";
    }
}
