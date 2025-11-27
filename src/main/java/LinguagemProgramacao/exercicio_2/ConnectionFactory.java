package LinguagemProgramacao.exercicio_2.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/parque_db";
    private static final String USER = "root";
    private static final String PASS = "sua_senha";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao BD: " + e.getMessage());
        }
    }
}
