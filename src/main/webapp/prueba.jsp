<%-- 
    Document   : prueba
    Created on : 3 may 2024, 17:27:53
    Author     : m05vi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>

<form action="SvUsuario" method="post">
    <img src="images/formulario.png" alt="..." class="img-circle">
                            <h1>Crear una cuenta</h1>
                            <div>
                                <label>Tipo de persona:</label><br>
                                <input type="radio" name="tipo_persona" value="administrador" onclick="mostrarCampos(this.value)"> Administrador<br>
                                <input type="radio" name="tipo_persona" value="docente" onclick="mostrarCampos(this.value)"> Docente<br>
                                <input type="radio" name="tipo_persona" value="estudiante" onclick="mostrarCampos(this.value)"> Estudiante<br>
                            </div>
                            <div id="cargoDiv" style="display:none;">
                                <input type="text" class="form-control" placeholder="Cargo" name="cargo" />
                            </div>
                            <div id="carreraDiv" style="display:none;">
                                <input type="text" class="form-control" placeholder="Carrera" name="carrera" />
                                <label for="fecha_inscripcion">Fecha de inscripción</label>
                                <input type="date" class="form-control" name="fecha_inscripcion" id="fecha_inscripcion" />
                            </div>
                            <div id="areaDiv" style="display:none;">
                                <input type="text" class="form-control" placeholder="Area" name="area" />
                            </div>
    <input type="submit" value="Guardar">
</form>

</body>
</html>
