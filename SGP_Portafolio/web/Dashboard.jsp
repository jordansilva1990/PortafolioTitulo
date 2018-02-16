<%-- 
    Document   : Dashboard
    Created on : 22-10-2017, 18:45:50
    Author     : Jordan Silva
--%>

<%@page import="Model.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>SGP Web</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Light Bootstrap Table core CSS    -->
        <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />


        <!--     Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

    </head>
    <body>
        <div class="sidebar" data-color="white">


            <div class='sidebar-wrapper'>
                <div class='logo' style='background-color: #109BF8; height: 200px'>
                    <a href='Dashboard.jsp' class='simple-text'>
                        <img src='assets/img/circulo.png' style='max-width: 50%'><br>
                        <p style="align-content: center"><c:out value="${usuarioActivo.getNombre()}"/></p>
                        
                </div>
                </a>
                <ul class="nav">                    
                    <c:choose>

                        <c:when test = "${perfil == 1}">
                            <li>
                                <a href="ControllerMisPermisos">
                                    <p>Mis Permisos</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaSolicitud">
                                    <p>Nuevo Permiso</p>
                                </a>
                            </li>

                            <li>
                                <a href="ControllerNuevaResolucion">
                                    <p>Generar Resoluciones</p>
                                </a>
                            </li>
                            <li>
                                <a href="VerificarDocumento.jsp">
                                    <p>Verificador Documentos</p>
                                </a>
                            </li>
                            <li style="margin-top: 100px;">
                                <a href="ControllerLogout"style="color:red">
                                    <p>Cerrar Sesión</p>
                                </a>
                            </li>
                        </c:when>

                        <c:when test = "${perfil ==2}">
                            <li>
                                <a href="ControllerListarPermisos">
                                    <p>Permisos Generales</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaResolucion">
                                    <p>Generar Resoluciones</p>
                                </a>
                            </li>
                            <li>
                                <a href="VerificarDocumento.jsp">
                                    <p>Verificador Documentos</p>
                                </a>
                            </li>
                            <li style="margin-top: 100px;">
                                <a href="ControllerLogout"style="color:red">
                                    <p>Cerrar Sesión</p>
                                </a>
                            </li>
                            
                        </c:when>
                        <c:when test = "${perfil ==3}">
                            <li>
                                <a href="ControllerMisPermisos">
                                    <p>Mis Permisos</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaSolicitud">
                                    <p>Nuevo Permiso</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerAprobarSolicitudes">
                                    <p>Aprobar Solicitudes</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaResolucion">
                                    <p>Generar Resoluciones</p>
                                </a>
                            </li>
                            <li>
                                <a href="VerificarDocumento.jsp">
                                    <p>Verificador Documentos</p>
                                </a>
                            </li>
                            <li style="margin-top: 100px;">
                                <a href="ControllerLogout"style="color:red">
                                    <p>Cerrar Sesión</p>
                                </a>
                            </li>
                        </c:when>
                        <c:when test = "${perfil ==4}">
                            <li>
                                <a href="ControllerMisPermisos">
                                    <p>Mis Permisos</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaSolicitud">
                                    <p>Nuevo Permiso</p>
                                </a>
                            </li>                      
                            <li>
                                <a href="VerificarDocumento.jsp">
                                    <p>Verificador Documentos</p>
                                </a>
                            </li>
                            <li style="margin-top: 100px;">
                                <a href="ControllerLogout"style="color:red">
                                    <p>Cerrar Sesión</p>
                                </a>
                            </li>
                        </c:when>
                        <c:when test = "${perfil ==5}">
                            <li>
                                <a href="ControllerMisPermisos">
                                    <p>Mis Permisos</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaSolicitud">
                                    <p>Nuevo Permiso</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerAprobarSolicitudes">
                                    <p>Aprobar Solicitudes</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaResolucion">
                                    <p>Generar Resoluciones</p>
                                </a>
                            </li>
                            <li>
                                <a href="VerificarDocumento.jsp">
                                    <p>Verificador Documentos</p>
                                </a>
                            </li>
                            <li style="margin-top: 100px;">
                                <a href="ControllerLogout"style="color:red">
                                    <p>Cerrar Sesión</p>
                                </a>
                            </li>
                        </c:when>
                        <c:when test = "${perfil ==6}">
                            <li>
                                <a href="ControllerMisPermisos">
                                    <p>Mis Permisos</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaSolicitud">
                                    <p>Nuevo Permiso</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerAprobarSolicitudes">
                                    <p>Aprobar Solicitudes</p>
                                </a>
                            </li>
                            <li>
                                <a href="ControllerNuevaResolucion">
                                    <p>Generar Resoluciones</p>
                                </a>
                            </li>
                            <li>
                                <a href="VerificarDocumento.jsp">
                                    <p>Verificador Documentos</p>
                                </a>
                            </li>
                            <li style="margin-top: 100px;">
                                <a href="ControllerLogout"style="color:red">
                                    <p>Cerrar Sesión</p>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="Login.jsp">
                                    <p>Sesión Invalida, Vueva a iniciar Sesión</p>
                                </a>
                            </li>
                            <li style="margin-top: 100px;">
                                <a href="ControllerLogout"style="color:red">
                                    <p>Cerrar Sesión</p>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>


                </ul>
            </div>
        </div>
        <div class="wrapper">
            <div id="sidebar"></div>
            <div class="main-panel">
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="header">
                                        <h2 class="title" style='text-align: center'>Bienvenido al "Sistema de Gestión de Permisos" de la municipalidad de vista hermosa</h2>
                                        <br>
                                        <br>                                        
                                    </div>
                                    <!-- Ejemplo Tabla -->
                                </div>
                                <div class="content">
                                    <center>
                                        <img src="assets/img/logoMuni.png">
                                    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <p class="category" style='text-align: center'><strong>Avenida Recoleta 5640, Santiago de Chile<br>Contacto (2) 2719 7000</strong></p>
                </footer>
            </div>
        </div>



    </body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
    <script src="assets/js/light-bootstrap-dashboard.js"></script>

    <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>


</html>

