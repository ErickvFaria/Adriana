package exercicio_3;

class Arte {
    double preco;
    int anoCriacao;
    int id;

    Arte(double preco, int anoCriacao, int id) {
        this.preco = preco;
        this.anoCriacao = anoCriacao;
        this.id = id;
    }

    void seValorizar(double percentual) {
        this.preco += this.preco * (percentual / 100);
        System.out.println("A arte ID " + id + " foi valorizada. Novo preço: R$ " + preco);
    }

    public String toString() {
        return "Arte{id=" + id + ", ano=" + anoCriacao + ", preço=R$ " + preco + "}";
    }
}
