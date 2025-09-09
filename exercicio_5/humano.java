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

    public void vestirRoupa(String novaRoupa) {
        this.roupa = novaRoupa;
        System.out.println(nome + " está usando agora: " + roupa);
    }

    public void adicionarOvelha(Ovelha ovelha) {
        ovelhas.add(ovelha);
        System.out.println(ovelha.nome + " agora pertence a " + nome);
    }
}
