package CRUD.model;

public class Bicicleta {
    private int id;
    private String cor;
    private String tamanho;
    private double preco;
    private String foto; // caminho ou URL da foto

    public Bicicleta() {
    }

    public Bicicleta(int id, String cor, String tamanho, double preco, String foto) {
        this.id = id;
        this.cor = cor;
        this.tamanho = tamanho;
        this.preco = preco;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
