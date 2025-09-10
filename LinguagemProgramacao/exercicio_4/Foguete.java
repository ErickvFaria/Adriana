package exercicio_4;

public class Foguete {
    private String nome;
    private String combustivel;
    private int altitude;

    public Foguete(String nome, String combustivel, int altitude) {
        this.nome = nome;
        this.combustivel = combustivel;
        this.altitude = altitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void decolar() {
        altitude += 1000;
        System.out.println(nome + " decolou! Altitude atual: " + altitude + " m");
    }

    public void pousar() {
        altitude = 0;
        System.out.println(nome + " pousou em segurança.");
    }

    public void lancarFoguete() {
        System.out.println(nome + " foi lançado com combustível " + combustivel + "!");
    }
}
