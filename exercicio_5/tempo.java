package exercicio_5;
import java.util.ArrayList;
import java.util.List;

public class Tempo {
    private int anoAtual;
    private int decada;
    private String eventoHistorico;

    
    public Tempo(int anoAtual, int decada, String eventoHistorico) {
        this.anoAtual = anoAtual;
        this.decada = decada;
        this.eventoHistorico = eventoHistorico;
    }

    public int getAnoAtual() {
        return anoAtual;
    }

    public void setAnoAtual(int anoAtual) {
        this.anoAtual = anoAtual;
    }

    public int getDecada() {
        return decada;
    }

    public void setDecada(int decada) {
        this.decada = decada;
    }

    public String getEventoHistorico() {
        return eventoHistorico;
    }

    public void setEventoHistorico(String eventoHistorico) {
        this.eventoHistorico = eventoHistorico;
    }

    public void passarAnos(int anos) {
        this.anoAtual += anos;
        this.decada += anos / 10;
        this.eventoHistorico = "Após " + anos + " anos, mudanças ocorreram";
    }
}
