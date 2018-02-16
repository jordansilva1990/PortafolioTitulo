<%@page import="Model.ResolucionesDetalle"%>
<%@page import="Model.Resoluciones"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="Model.PermisosDetalles"%>
<%-- 
    Document   : PDFResoluciones
    Created on : 11-12-2017, 20:43:37
    Author     : Jonathan
--%>

<%@page import="Model.Usuarios"%>
<%@page import="Model.TiposPermisos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>SGP -  Imprimir Resoluciones</title>

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
                            <h1>Detalle de la Resolución</h1>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="table-responsive" id="div_print" >

                                        <%
                                            List<Resoluciones> lst = (List<Resoluciones>) request.getAttribute("Resoluciones");
                                            for (Resoluciones res : lst) {
                                                String id = javax.xml.bind.DatatypeConverter.printHexBinary(res.getIdResolucion());
                                                String estado = "";
                                                out.println("<h2 align='justify'><b>Ilustre Municipalidad Vista Hermosa</b></h2>");
                                                out.println("<p align='justify'><b>A continuacion se detalla la resolución generada</b>");
                                                out.println("<p align='justify'><b>Id de Resolución: </b>" + id + "</p>");
                                                out.println("<p align='justify'><b>Nombre Descriptivo: </b>" + res.getResolucion() + " </p>");
                                                List<ResolucionesDetalle> lst2 = (List<ResolucionesDetalle>) request.getAttribute("ResolucionesDetalle");
                                                int num = 1;

                                                for (ResolucionesDetalle resDet : lst2) {
                                                    out.println("<h4 align='justify'><b>Permiso </b>" + num + " </h4>");
                                                    String id2 = javax.xml.bind.DatatypeConverter.printHexBinary(resDet.getIdDetalleResolucion());
                                                    out.println("<p align='justify'><b>ID Detalle: </b>" + id2 + " </p>");
                                                    out.println("<p align='justify'><b>Nombre Solicitante: </b>" + resDet.getPermisos().getUsuarios().getNombre() + " </p>");
                                                    out.println("<p align='justify'><b>Rut Solicitante: </b>" + resDet.getPermisos().getUsuarios().getRut() + " </p>");
                                                    out.println("<p align='justify'><b>Fecha de Emisión: </b>" + resDet.getFechaemision() + " </p>");
                                                    out.println("<p align='justify'><b>Días Afectos </b>" + resDet.getPermisos().getTiposPermisos().getDiasafectos() + " </p>");
                                                    out.println("<p align='justify'><b>Detalle de Permiso </b>" + resDet.getJustificacion() + " </p>");
                                                    out.println("<p align='justify'><b>Recurso Legal: </b>" + resDet.getRecursolegalafecto() + " </p>");
                                                    num = num + 1;
                                                }

                                            }
                                        %>  
                                    </div>
                                    <center><input name="b_print" type="button" class="ipt" onClick="printdiv('div_print');" value=" Imprimir Detalle Permiso "></center>

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

<!-- Impresion del DIV  -->
<script language="javascript">
                                        function printdiv(printpage)
                                        {
                                            var headstr = "<html><head><title></title></head><body>";
                                            var footstr = "</body>";
                                            var newstr = document.all.item(printpage).innerHTML;
                                            var oldstr = document.body.innerHTML;
                                            document.body.innerHTML = headstr + newstr + footstr;
                                            window.print();
                                            document.body.innerHTML = oldstr;
                                            return false;
                                        }
</script>


</html>
