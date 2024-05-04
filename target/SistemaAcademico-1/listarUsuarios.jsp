
<%@page import="Modelo.Persona"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
<title>Lista de Usuarios</title>
</head>
<body>
    <h1>Lista de Usuarios</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Rol</th>
        </tr>
        <% 
            ArrayList<Persona> listaUsuarios = (ArrayList) request.getSession().getAttribute("usuarios");
        %>
        <!-- Iteramos sobre la lista de usuarios enviada desde el servlet -->
        <% for (Persona usu: listaUsuarios){%>
            <tr>
                <td><%=usu.getNombre()%></td>
                <td><%=usu.getApellido() %></td>
                <td><%=usu.getDireccion()%></td>
                <td><%=usu.getTelefono() %></td>
            </tr>
        <%}%>
    </table>
    </body>
</html>
