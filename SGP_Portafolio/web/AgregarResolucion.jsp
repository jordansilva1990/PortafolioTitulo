<%-- 
    Document   : MisPermisos
    Created on : 22-10-2017, 12:59:57
    Author     : Jordan Silva
--%>
<%@page import="java.math.BigDecimal"%>
<%@page import="Model.PermisosDetalles"%>
<%@page import="Model.Unidades"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>SGP -  Nueva Resolución</title>

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

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <!--jquery-->
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <!--     Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
        <script type="text/javascript">
            $.noConflict();
            jQuery(document).ready(function ($) {
                // Code that uses jQuery's $ can follow here.

                $(document).ready(function ()
                {
                    $(".monthPicker").datepicker({
                        dateFormat: 'mm-yy',
                        changeMonth: true,
                        changeYear: true,
                        showButtonPanel: false,

                        onClose: function (dateText, inst) {
                            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                            $(this).val($.datepicker.formatDate('mm-yy', new Date(year, month, 1)));
                        }
                    });

                    $(".monthPicker").focus(function () {
                        $(".ui-datepicker-calendar").hide();
                        $("#ui-datepicker-div").position({
                            my: "center top",
                            at: "center bottom",
                            of: $(this)
                        });
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="sidebar" data-color="white">

            <div class="sidebar-wrapper"> 
                <div class="logo" style="background-color: #109BF8;height: 200px"> 
                    <a href="Dashboard.jsp" class="simple-text"> 
                        <img src="assets/img/circulo.png" style="max-width: 50%"><br>
                        <p style="align-content: center"><c:out value="${usuarioActivo.getNombre()}"/></p>
                    </a> 
                </div>

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
                        <div class="navbar-header">
                            <h1>Agregar Resoluciones</h1>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="card">

                                                <form action="<c:url value="/ControllerAgregarResolucion" />" method="post" style="margin-left: 50px">
                                                    <br> 
                                                    <center>
                                                        <div  class="form-group"  >
                                                            <text> Unidad :   </text>
                                                            <br>
                                                            <select name="depto" id="depto">
                                                                <option value="seleccione" required>Seleccione...</option>

                                                                <%
                                                                    List<Unidades> lst = (List<Unidades>) request.getAttribute("unidades");
                                                                    for (Unidades v : lst) {

                                                                        out.println("<option style='width: 200px' value='" + v.getNombreunidad() + "'>" + v.getNombreunidad() + "</option> ");

                                                                    }

                                                                %>

                                                            </select>
                                                        </div>
                                                        <div class="form-group" > 
                                                            <text> Fecha :   </text>
                                                            <br>
                                                            <input type="text" id="mes" name="mes" class="monthPicker" />
                                                        </div>
                                                        <br>
                                                        <br>
                                                        <div class="form-group">
                                                            <button class='btn btn-success' name="accion" value="consultar" type="submit" style="width: 200px" required>Consultar</button>
                                                            <a class='btn btn-warning' style="width: 200px; height: 40px;" href="ControllerNuevaResolucion"><p>Volver</p></a>
                                                            <button class='btn btn-success' name="accion" value="generar" type="submit" style="width: 200px" required>Generar</button>
                                                        </div>
                                                    </center>
                                                    <table class="table table-hover table-striped">
                                                        <tr>
                                                        <tr>
                                                            <th>Nombre</th>
                                                            <th>Ingreso</th>                                                
                                                            <th>Inicio</th>
                                                            <th>Termino</th>
                                                            <th>Dias</th>
                                                            <th>Tipo</th>
                                                            <th>Estado</th>
                                                            <th></th>
                                                        </tr>
                                                        </tr>
                                                        <%                                                            List<PermisosDetalles> lst2 = (List<PermisosDetalles>) request.getAttribute("permisos");
                                                            for (PermisosDetalles v : lst2) {
                                                                String id = javax.xml.bind.DatatypeConverter.printHexBinary(v.getIdDetallePermiso());
                                                                String estado = "";

                                                                if (v.getEstado().compareTo(new BigDecimal(1)) == 0) {
                                                                    estado = "Pendiente";
                                                                } else if (v.getEstado().compareTo(new BigDecimal(2)) == 0) {
                                                                    estado = "Aprobado";
                                                                } else if (v.getEstado().compareTo(new BigDecimal(3)) == 0) {
                                                                    estado = "Rechazado";
                                                                }

                                                                out.println("<tr>");
                                                                out.println("<td>" + v.getUsuarios().getNombre() + "</td>");
                                                                out.println("<td>" + v.getFechaemision() + "</td>");
                                                                out.println("<td>" + v.getFechainicio() + "</td>");
                                                                out.println("<td>" + v.getFechafin() + "</td>");
                                                                out.println("<td>" + v.getDias() + "</td>");
                                                                out.println("<td>" + v.getPermisos().getTiposPermisos().getDetallepermiso() + "</td>");
                                                                out.println("<td>" + estado + "</td>");
                                                                out.println("</tr>");

                                                            }
                                                        %>  
                                                    </table>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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