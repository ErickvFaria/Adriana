package CRUD.model;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private double altura;
    private String foto;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, int idade, double altura, String foto) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
