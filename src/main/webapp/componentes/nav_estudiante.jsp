<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-solid fa-graduation-cap"></i><span style="font-size: medium"> Gestión Académica</span></a>
        </div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <div class="profile_info">
                <span>Bienvenido</span>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>Estudiante</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-edit"></i> Gestión de Reportes <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="form.html">Reporte Calificaciones</a></li>
                            <li><a href="form_advanced.html">Notas exámenes</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

        </div>
        <!-- /sidebar menu -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <div class="nav toggle">
            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
        </div>
        <nav class="nav navbar-nav">
            <ul class=" navbar-right">
                <li class="nav-item" style="padding-left: 15px; display: flex; align-items: center;">
                    <img src="images/usuario.png" alt="" style="width: 30px; height: 30px; margin-right: 10px;" class="img-circle">
                    <span style="padding-right: 10px;">John Doe</span>
                    <a href="login.html" class="user-profile">
                        <i class="fa fa-sign-out"></i>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->
