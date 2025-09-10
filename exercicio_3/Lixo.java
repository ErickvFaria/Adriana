package exercicio_3;

public class Lixo {
    private int qnt;
    private double peso;
    private String cheiro;

    public Lixo(int qnt, double peso, String cheiro) {
        this.qnt = qnt;
        this.peso = peso;
        this.cheiro = cheiro;
    }

    public Arte seTransformar(int id, int anoCriacao, double precoInicial) {
        System.out.println("O lixo foi transformado em arte.");
        return new Arte(precoInicial, anoCriacao, id);
    }
}

