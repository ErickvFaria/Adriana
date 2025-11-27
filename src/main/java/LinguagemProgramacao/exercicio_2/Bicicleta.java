package LinguagemProgramacao.exercicio_2;

public class Bicicleta {
    private int id;
    private String modelo;
    private int marchas;

    public Bicicleta() {}

    public Bicicleta(int id, String modelo, int marchas) {
        this.id = id;
        this.modelo = modelo;
        this.marchas = marchas;
    }

    public Bicicleta(String modelo, int marchas) {
        this.modelo = modelo;
        this.marchas = marchas;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getMarchas() { return marchas; }
    public void setMarchas(int marchas) { this.marchas = marchas; }
}
