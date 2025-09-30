package LinguagemProgramacao.exercicio_7;

public class CalculoMedia {

    // Método público e estático para ser usado pelo Controller
    public static double calcular(double P1, double E1, double E2, double X, double SUB, double AP) {
        double parteBase = (P1 * 0.5) + (E1 * 0.2) + (E2 * 0.3) + X + (SUB * 0.15);
        double parte1 = parteBase * 0.5;

        double diferenca = parteBase - 5.9;
        double parte2 = 0.0;
        if (diferenca > 0) {
            parte2 = (Math.max(diferenca, 0) / diferenca) * AP * 0.5;
        }

        return parte1 + parte2;
    }
}
