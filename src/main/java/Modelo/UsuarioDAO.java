
package Modelo;
import static Modelo.Usuario.parseRol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    public static ArrayList<Usuario> obtenerUsuarios() {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = Conexion.getConnection();
        String query = "SELECT id_usuario, nombre_usuario, rol FROM usuario";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_usuario");
            String nombre = rs.getString("nombre_usuario");
            Rol rol = parseRol(rs.getString("rol"));

            Usuario usuario = new Usuario(id, nombre, rol);
            listaUsuarios.add(usuario);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener la lista de usuarios: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    return listaUsuarios;
}
    
}
