import java.util.Scanner;

public class CalculoMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a nota da Prova 1 (P1): ");
        double P1 = sc.nextDouble();

        System.out.print("Digite a nota da Entrega 1 (E1): ");
        double E1 = sc.nextDouble();

        System.out.print("Digite a nota da Entrega 2 (E2): ");
        double E2 = sc.nextDouble();

        System.out.print("Digite a nota da Atividade Extra (X): ");
        double X = sc.nextDouble();

        System.out.print("Digite a nota da Prova Substitutiva (SUB): ");
        double SUB = sc.nextDouble();

        System.out.print("Digite a nota do Projeto Integrador (AP): ");
        double AP = sc.nextDouble();

        double parteBase = (P1 * 0.5) + (E1 * 0.2) + (E2 * 0.3) + X + (SUB * 0.15);

        double parte1 = parteBase * 0.5;

        double diferenca = parteBase - 5.9;
        double parte2 = 0.0;
        if (diferenca > 0) {
            parte2 = (Math.max(diferenca, 0) / diferenca) * AP * 0.5;
        }

        double media = parte1 + parte2;

        System.out.printf("A média final é: %.2f%n", media);

        sc.close();
    }
}
