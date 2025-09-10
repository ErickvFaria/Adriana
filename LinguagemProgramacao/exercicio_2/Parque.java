public class Parque {
    private String localizacao;
    private String nome;
    private String tipoDeTerreno;

    public Parque(String localizacao, String nome, String tipoDeTerreno) {
        this.localizacao = localizacao;
        this.nome = nome;
        this.tipoDeTerreno = tipoDeTerreno;
    }


    public void receberPessoa(Pessoa pessoa) {
        System.out.println("O parque " + nome + " recebeu " + pessoa.getNome());
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeTerreno() {
        return tipoDeTerreno;
    }

    public void setTipoDeTerreno(String tipoDeTerreno) {
        this.tipoDeTerreno = tipoDeTerreno;
    }
}
