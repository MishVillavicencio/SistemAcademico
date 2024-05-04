
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_academico?serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en la conexion: " + e);
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
