package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/pessoas";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "guilherme77";

    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

}
