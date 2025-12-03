package CRUD.model;

public class Parque {
    private int id;
    private String nome;
    private String localizacao;
    private String tipoTerreno;
    private String foto;

    public Parque() {
    }

    public Parque(int id, String nome, String localizacao, String tipoTerreno, String foto) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoTerreno = tipoTerreno;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
