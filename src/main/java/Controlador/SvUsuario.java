package Controlador;

import Modelo.Conexion;
import Modelo.Persona;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {
    // Crear una instancia de la clase Conexion para establecer la conexión con la base de datos
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
try {
            // Consulta SQL para obtener todos los usuarios
            String sql = "SELECT nombre, apellido, direccion, telefono FROM persona";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            // Crear una lista para almacenar los usuarios
            ArrayList<Persona> usuarios = new ArrayList<>();
            
            // Iterar sobre los resultados y crear objetos Usuario
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                
                Persona usu = new Persona(nombre, apellido, direccion, telefono);
                usuarios.add(usu);
            }
            
            // Agregar la lista de usuarios al objeto request
            request.setAttribute("usuarios", usuarios);
            
            // Redirigir a la página para mostrar los usuarios
            request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
            
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir al interactuar con la base de datos
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String contrasenia = request.getParameter("contrasenia");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String tipoPersona = request.getParameter("tipo_persona");
        String cargo = request.getParameter("cargo");
        String carrera = request.getParameter("carrera");
        String area = request.getParameter("area");
        String fechaInscripcion = request.getParameter("fecha_inscripcion");

        // Obtener el parámetro específico según el tipo de persona
        String parametroEspecifico = "";
        if (tipoPersona.equals("administrador")) {
            parametroEspecifico = request.getParameter("cargo");
        } else if (tipoPersona.equals("docente")) {
            parametroEspecifico = request.getParameter("area");
        } else if (tipoPersona.equals("estudiante")) {
            parametroEspecifico = request.getParameter("carrera");
        }

        
        try {
            // Consulta SQL para insertar en la tabla persona
            String sqlPersona = "INSERT INTO persona (nombre, apellido, direccion, telefono) VALUES (?, ?, ?, ?)";
            
            // Consulta SQL para insertar en la tabla usuario
            String sqlUsuario = "INSERT INTO usuario (nombre_usuario, contraseña, rol) VALUES (?, ?, ?)";
            // Preparar la consulta SQL para insertar un nuevo registro en la tabla correspondiente
            String sqlTipoPersona = "";
            switch (tipoPersona) {
                case "administrador":
                    sqlTipoPersona = "INSERT INTO administrador (cargo, id_usuario) VALUES (?, ?)";
                    break;
                case "docente":
                    sqlTipoPersona = "INSERT INTO docente (area, id_usuario) VALUES (?, ?)";
                    break;
                case "estudiante":
                    sqlTipoPersona = "INSERT INTO estudiante (carrera, fecha_inscripcion, id_usuario) VALUES (?, ?, ?)";
                    break;
                default:
                    break;
            }
            
            // Insertar en la tabla usuario
            PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario);
            pstmtUsuario.setString(1, nombre);
            pstmtUsuario.setString(2, contrasenia);
            pstmtUsuario.setString(3, tipoPersona);
            pstmtUsuario.executeUpdate();
            
            // Obtener el ID generado para el usuario insertado
            String idUsuarioQuery = "SELECT LAST_INSERT_ID()";
            PreparedStatement pstmtIdUsuario = connection.prepareStatement(idUsuarioQuery);
            pstmtIdUsuario.execute();
            pstmtIdUsuario.getResultSet().next();
            int idUsuario = pstmtIdUsuario.getResultSet().getInt(1);

            // Insertar en la tabla persona
            PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona);
            pstmtPersona.setString(1, nombre);
            pstmtPersona.setString(2, apellido);
            pstmtPersona.setString(3, direccion);
            pstmtPersona.setString(4, telefono);
            pstmtPersona.executeUpdate();
            
            // Crear un objeto PreparedStatement con la consulta SQL
            preparedStatement = connection.prepareStatement(sqlTipoPersona);

            // Insertar en la tabla correspondiente según el tipo de persona
            PreparedStatement pstmtTipoPersona = connection.prepareStatement(sqlTipoPersona);
            pstmtTipoPersona.setString(1, (cargo != null) ? cargo : ((area != null) ? area : carrera));
            if (tipoPersona.equals("estudiante")) {
                pstmtTipoPersona.setString(2, fechaInscripcion);
                pstmtTipoPersona.setInt(3, idUsuario);
            } else {
                pstmtTipoPersona.setInt(2, idUsuario);
            }
            

            // Ejecutar la consulta SQL para insertar el nuevo registro en la base de datos
            pstmtTipoPersona.executeUpdate();
            
            // Cerrar conexiones y redirigir a una página de éxito
            pstmtUsuario.close();
            pstmtIdUsuario.close();
            pstmtPersona.close();
            pstmtTipoPersona.close();
            connection.close();
            // Redirigir a una página de éxito
            response.sendRedirect("login.jsp");
            
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir al interactuar con la base de datos
            e.printStackTrace();
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
