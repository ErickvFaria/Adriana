package CRUD.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/";
    private static final String PARAMETERS = "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection(String dbName) {
        String url = SERVER_URL + ((dbName != null && !dbName.isEmpty()) ? dbName : "") + PARAMETERS;
        try {
            return DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() {
        return getConnection("exercicio_CRUD");
    }
}
