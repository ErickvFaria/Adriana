package LinguagemProgramacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ClasseEscritaLeitura {

    // Escrever CSV com cabeçalho e dados
    public void escreverCSV(String arquivo, String[] cabecalho, String[][] dados) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            // Se o arquivo estiver vazio, escreve o cabeçalho
            java.io.File f = new java.io.File(arquivo);
            if (f.length() == 0) {
                bw.write(String.join(",", cabecalho));
                bw.newLine();
            }

            // Escreve os dados
            for (String[] linha : dados) {
                bw.write(String.join(",", linha));
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
