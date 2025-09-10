package exercicio_5;

import java.util.ArrayList;
import java.util.List;

public class Humano {
    private String nome;
    private int idade;
    private String roupa;
    List<Ovelha> ovelhas; 
    Tempo tempo;         

    public Humano(String nome, int idade, String roupa, Tempo tempo) {
        this.nome = nome;
        this.idade = idade;
        this.roupa = roupa;
        this.tempo = tempo;
        this.ovelhas = new ArrayList<>();
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public List<Ovelha> getOvelhas() {
        return ovelhas;
    }

    public void setOvelhas(List<Ovelha> ovelhas) {
        this.ovelhas = ovelhas;
    }

    public String getRoupa() {
        return roupa;
    }

    public void setRoupa(String roupa) {
        this.roupa = roupa;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void vestirRoupa(String novaRoupa) {
        this.roupa = novaRoupa;
        System.out.println(nome + " está usando agora: " + roupa);
    }

    public void adicionarOvelha(Ovelha ovelha) {
        ovelhas.add(ovelha);
        System.out.println(ovelha.nome + " agora pertence a " + nome);
    }
}
