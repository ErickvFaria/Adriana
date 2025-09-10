package exercicio_5;
import java.util.ArrayList;
import java.util.List;

public class Ovelha {
    private String nome;
    private int idade;
    private double quantidadeLana;

    Tempo tempo;

    public Ovelha(String nome, int idade, double quantidadeLana, Tempo tempo) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeLana = quantidadeLana;
        this.tempo = tempo;
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

    public double getQuantidadeLana() {
        return quantidadeLana;
    }

    public void setQuantidadeLana(double quantidadeLana) {
        this.quantidadeLana = quantidadeLana;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public void tosquiar() {
        System.out.println(nome + " foi tosquiada. Lã coletada: " + quantidadeLana + " kg");
        this.quantidadeLana = 0;
    }
}
