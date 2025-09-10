package exercicio_4;

public class Personagem {
    private String nome;
    private String humor;
    private int energia;

    public Personagem(String nome, String humor, int energia) {
        this.nome = nome;
        this.humor = humor;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHumor() {
        return humor;
    }

    public void setHumor(String humor) {
        this.humor = humor;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void sorrir() {
        System.out.println(nome + " está sorrindo!");
    }

    public void andar() {
        System.out.println(nome + " está andando.");
    }

    public void falar(String mensagem) {
        System.out.println(nome + " diz: " + mensagem);
    }
}
