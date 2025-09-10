public class Bicicleta {
    private String cor;
    private int tamanho;
    private int qntDeRodas;
    
    public Bicicleta(String cor, int tamanho, int qntDeRodas) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.qntDeRodas = qntDeRodas;
    }


    public void pedalar() {
        System.out.println("A bicicleta de cor " + cor + " está sendo pedalada!");
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getQntDeRodas() {
        return qntDeRodas;
    }

    public void setQntDeRodas(int qntDeRodas) {
        this.qntDeRodas = qntDeRodas;
    }
}
