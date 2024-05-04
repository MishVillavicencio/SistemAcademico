<%-- Author: Mishell Villavicencio --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- cabecera -->
        <%@ include file="componentes/header.jsp" %>
        <!-- Animate.css -->
        <link href="vendors/animate.css/animate.min.css" rel="stylesheet">
        <title>SGA Login</title>
    </head>

    <body class="login" style="background-color: #EFFEFC">
        <div>
            <a class="hiddenanchor" id="signup"></a>
            <a class="hiddenanchor" id="signin"></a>

            <div class="login_wrapper">
                <div class="animate form login_form">
                    <section class="login_content">
                        <form>
                            <img src="images/login.jpg" alt="..." class="">
                            <h1>Login</h1>
                            <p>Recuerda que tu Usuario es el nombre con el que te registraste</p>
                            <div>
                                <input type="text" class="form-control" placeholder="Usuario" required="" />
                            </div>
                            <div>
                                <input type="password" class="form-control" placeholder="Contraseña" required="" />
                            </div>
                            <div>
                                <a style="background-color: #2c3b54; color: white;" class="btn btn-default submit" href="administrador.jsp">Iniciar sesión</a>
                            </div>

                            <div class="clearfix"></div>

                            <div class="separator">
                                <p class="change_link">¿Eres nuevo?
                                    <a href="#signup" class="to_register"> Regí­strate aquí­ </a>
                                </p>

                                <div class="clearfix"></div>
                                <br />

                                <div>
                                    <p>@All Rights Reserved.</p>
                                </div>
                            </div>
                        </form>
                    </section>
                </div>

                <div id="register" class="animate form registration_form" style="margin-top: -30%">
                    <section class="login_content">
                        <form action="SvUsuario" method="POST">
                            <img src="images/formulario.png" alt="..." class="img-circle">
                            <h1>Crear una cuenta</h1>
                            <div>
                                <label>Tipo de persona:</label><br>
                                <input type="radio" name="tipo_persona" value="administrador" onclick="mostrarCampos(this.value)" > Administrador<br>
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
                            <div>
                                <input type="text" class="form-control" placeholder="Nombre" name="nombre" required />
                            </div>
                            <div>
                                <input type="password" class="form-control" placeholder="Contraseña" name="contrasenia" required />
                            </div>
                            <div>
                                <input type="text" class="form-control" placeholder="Apellido" name="apellido" required />
                            </div>
                            <div>
                                <input type="text" class="form-control" placeholder="Direccion" name="direccion" required />
                            </div>
                            <div>
                                <input type="text" class="form-control" placeholder="Telefono" name="telefono" required />
                            </div>
                            <div>
                                <input type="submit" class="btn btn-default submit" value="Guardar" id="submitBtn" 
                                       style="background-color: #2c3b54; color: white;"/>
                            </div>

                            <div class="clearfix"></div>

                            <div class="separator">
                                <p class="change_link">¿Ya tienes una cuenta?
                                    <a href="#signin" class="to_register"> Inicia sesión</a>
                                </p>

                                <div class="clearfix"></div>
                                <br />

                                <div>
                                    <p>@All Rights Reserved.</p>
                                </div>
                            </div>
                        </form>
                        <div id="datosGuardados" style="display:none;">
                            <h2>Datos Guardados</h2>
                            <table border="1">
                                <tr>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th>Tipo de Persona</th>
                                    <th>Cargo/Area/Carrera</th>
                                </tr>
                                <tr>
                                    <td id="nombreGuardado"></td>
                                    <td id="apellidoGuardado"></td>
                                    <td id="direccionGuardado"></td>
                                    <td id="telefonoGuardado"></td>
                                    <td id="tipoPersonaGuardado"></td>
                                    <td id="cargoAreaCarreraGuardado"></td>
                                </tr>
                            </table>
                        </div>

                        <script>
                            function mostrarCampos(tipo) {
                                document.getElementById('cargoDiv').style.display = (tipo === 'administrador') ? 'block' : 'none';
                                document.getElementById('carreraDiv').style.display = (tipo === 'estudiante') ? 'block' : 'none';
                                document.getElementById('areaDiv').style.display = (tipo === 'docente') ? 'block' : 'none';

                                // Limpiar campos adicionales cuando se cambia de opción
                                document.getElementById('cargoDiv').getElementsByTagName('input')[0].value = '';
                                document.getElementById('carreraDiv').getElementsByTagName('input')[0].value = '';
                                document.getElementById('carreraDiv').getElementsByTagName('input')[1].value = '';
                                document.getElementById('areaDiv').getElementsByTagName('input')[0].value = '';

                                // Hacer el campo requerido solo cuando se muestra
                                document.getElementById('cargo').required = (tipo === 'administrador');
                                document.getElementById('carrera').required = (tipo === 'estudiante');
                                document.getElementById('area').required = (tipo === 'docente');
                            }
                        </script>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>
