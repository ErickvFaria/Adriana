package LinguagemProgramacao.exercicio_3;

public class Lixo {
    private double peso;
    private int quantidade;
    private String cheiro;

    public Lixo(double peso, int quantidade, String cheiro) {
        this.peso = peso;
        this.quantidade = quantidade;
        this.cheiro = cheiro;
    }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getCheiro() { return cheiro; }
    public void setCheiro(String cheiro) { this.cheiro = cheiro; }

    public Arte seTransformar(int id, int anoCriacao, double precoInicial) {
        System.out.println("O lixo foi transformado em arte!");
        return new Arte(precoInicial, anoCriacao, id);
    }

    @Override
    public String toString() {
        return "Lixo{peso=" + peso + ", quantidade=" + quantidade + ", cheiro='" + cheiro + "'}";
    }
}
