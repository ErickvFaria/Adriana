package exercicio_4;

public class Carro {
    private String modelo;
    private int velocidade;
    private String cor;

    public Carro(String modelo, int velocidade, String cor) {
        this.modelo = modelo;
        this.velocidade = velocidade;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void acelerar() {
        velocidade += 10;
        System.out.println("O carro acelerou. Velocidade: " + velocidade + " km/h");
    }

    public void frear() {
        if (velocidade >= 10) {
            velocidade -= 10;
        } else {
            velocidade = 0;
        }
        System.out.println("O carro freou. Velocidade: " + velocidade + " km/h");
    }

    public void buzinar() {
        System.out.println("Buzinando: FOOH FOOH!");
    }
}
