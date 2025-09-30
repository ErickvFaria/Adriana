package ClasseEscritaLeitura;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVEscritaLeitura {

    // Escreve um CSV (append = true para não sobrescrever)
    public void escreverCSV(String caminhoArquivo, String[] cabecalho, String[][] dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {

            // Escreve cabeçalho apenas se o arquivo não existir
            if (cabecalho != null) {
                writer.write(String.join(";", cabecalho));
                writer.newLine();
            }

            // Escreve dados
            for (String[] linha : dados) {
                writer.write(String.join(";", linha));
                writer.newLine();
            }

            System.out.println("Arquivo CSV gravado com sucesso em: " + caminhoArquivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lê CSV e retorna lista de arrays de String
    public List<String[]> lerCSV(String caminhoArquivo, String separador) {
        List<String[]> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(separador);
                linhas.add(campos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }
}
