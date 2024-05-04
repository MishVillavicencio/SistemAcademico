<%-- Author: Mishell Villavicencio --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- cabecera -->
        <%@ include file="componentes/header.jsp" %>
        <title>SGA Administrador</title>
    </head>
    
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                
                <!-- barra lateral y de navegación -->
                <%@ include file="componentes/nav_admin.jsp" %>
                
                <!-- Inicio CONTENIDO -->
                <div class="container" style="text-align: center;">
                    <img src="images/administrador.png"  style="  padding: 25px 300px 25px 500px;
                         background-color: white; " alt="..." class="">
                </div>
                <!-- Fin CONTENIDO -->
                
                <!-- footer -->
                <footer>
                    <%@ include file="componentes/footer.jsp" %>
                </footer>
            </div>
        </div>
        
        <!-- Scrips -->
        <%@ include file="componentes/scrips.jsp" %>
    </body>
</html>
