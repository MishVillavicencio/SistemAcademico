<%-- 
    Document   : estudiante
    Created on : 3 may 2024, 3:23:39
    Author     : m05vi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- cabecera -->
        <%@ include file="componentes/header.jsp" %>
        <title>SGA Estudiante</title>
    </head>
    
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                
                <!-- barra lateral y de navegación -->
                <%@ include file="componentes/nav_estudiante.jsp" %>
                
                <!-- Inicio CONTENIDO -->
                <div class="container" style="text-align: center;">
                    <img src="images/estudiante.png"  style="  padding: 50px 300px 25px 481px;
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
