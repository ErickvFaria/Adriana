package CRUD.config;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.stream.Collectors;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try {
            // Conecta sem banco para criar caso não exista
            try (Connection conn = ConnectionFactory.getConnection(null)) {

                // Lê o arquivo schema.sql
                InputStream is = DatabaseInitializer.class.getResourceAsStream("/db_config/schema.sql");
                if (is == null) {
                    throw new RuntimeException("Arquivo schema.sql não encontrado em /db_config");
                }

                String sql = new BufferedReader(new InputStreamReader(is))
                        .lines()
                        .collect(Collectors.joining("\n"));

                // Divide os comandos pelo ';'
                String[] commands = sql.split(";");

                try (Statement stmt = conn.createStatement()) {
                    for (String command : commands) {
                        command = command.trim();
                        if (!command.isEmpty()) {
                            stmt.execute(command);
                        }
                    }
                }

                System.out.println("Banco inicializado com sucesso!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inicializar o banco: " + e.getMessage(), e);
        }
    }
}
