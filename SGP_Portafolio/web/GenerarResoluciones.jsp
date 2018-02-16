<%-- 
    Document   : GenerarResoluciones
    Created on : 24-10-2017, 9:48:17
    Author     : Jonathan
--%>
<%@page import="Model.Resoluciones"%>
<%@page import="Model.ResolucionesDetalle"%>
<%@page import="Model.Unidades"%>
<%@page import="java.util.List"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="com.sun.org.apache.xml.internal.serialize.OutputFormat"%>
<%@page import="com.sun.org.apache.xml.internal.serialize.XMLSerializer"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory;"%>
<%@page import="javax.xml.parsers.DocumentBuilder;"%>
<%@page import="javax.xml.transform.Transformer;"%>
<%@page import="javax.xml.transform.TransformerFactory;"%>
<%@page import="javax.xml.transform.dom.DOMSource;"%>
<%@page import="javax.xml.transform.stream.StreamResult;"%>
<%@page import="org.w3c.dom.Attr;"%>
<%@page import="org.w3c.dom.Document;"%>
<%@page import="org.w3c.dom.Element;"%>
<%@page import="java.io.File;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>SGP - Generar Resoluciones</title>

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
                        dateFormat: 'MM yy',
                        changeMonth: true,
                        changeYear: true,
                        showButtonPanel: false,

                        onClose: function (dateText, inst) {
                            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                            $(this).val($.datepicker.formatDate('MM yy', new Date(year, month, 1)));
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
                            <h1>Generar Resoluciones</h1>
                            <div class="form-group">                           
                                <a class='btn btn-success' style="width: 200px; padding-top: 15px" href="ControllerAgregarResolucion">
                                    <p>Nueva Resolución</p>
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="card">
                                                <!-- Ejemplo Tabla -->
                                                <div class="content table-responsive table-full-width">
                                                    <form action="<c:url value="/ControllerResolucionPrint" />" method="post" >
                                                        <table class="table table-hover table-striped">
                                                            <tr>    
                                                                <th>ID Resolución</th>
                                                                <th>Detalle Resolución</th>
                                                                <th>PDF</th>
                                                            </tr>
                                                            <%                                                        List<Resoluciones> lst2 = (List<Resoluciones>) request.getAttribute("resoluciones");
                                                                for (Resoluciones v : lst2) {
                                                                    String id = javax.xml.bind.DatatypeConverter.printHexBinary(v.getIdResolucion());

                                                                    out.println("<tr>");
                                                                    out.println("<td>" + id + "</td>");
                                                                    out.println("<td>" + v.getResolucion() + "</td>");
                                                                    out.println("<td><button type='submit' class='btn btn-success' name='id' value='" + id + "' style=';max-width:60%;text-align: center; width: 7em;'>PDF</button></td>");
                                                                    
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

    <script>
            function myFunction() {
        <%            try {
                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();

                // root element
                Element rootElement = doc.createElement("resoluciones");
                doc.appendChild(rootElement);
                for (Resoluciones res : lst2) {
                    Element resolucion = doc.createElement("resolucion");
                    rootElement.appendChild(resolucion);
                    // carname element
                    Element carnameRoot = doc.createElement("idDetallePermiso");
                    carnameRoot.appendChild(doc.createTextNode(javax.xml.bind.DatatypeConverter.printHexBinary(res.getIdResolucion())));
                    resolucion.appendChild(carnameRoot);

                    Element carnameRoot2 = doc.createElement("nombreDescriptivo");
                    carnameRoot2.appendChild(doc.createTextNode(res.getResolucion()));
                    resolucion.appendChild(carnameRoot2);
                    List<ResolucionesDetalle> lst3 = (List<ResolucionesDetalle>) request.getAttribute("ResolucionesDetalle");
                    for (ResolucionesDetalle resDet : lst3) {
                        if (javax.xml.bind.DatatypeConverter.printHexBinary(res.getIdResolucion()).equals(javax.xml.bind.DatatypeConverter.printHexBinary(resDet.getResoluciones().getIdResolucion()))) {
                            // supercars element
                            Element resolucionesDetalles = doc.createElement("resolucionesDetalles");
                            resolucion.appendChild(resolucionesDetalles);

                            // carname element
                            Element carname6 = doc.createElement("idDetallePermiso");
                            carname6.appendChild(doc.createTextNode(javax.xml.bind.DatatypeConverter.printHexBinary(resDet.getIdDetalleResolucion())));
                            resolucionesDetalles.appendChild(carname6);

                            // carname element
                            Element carname2 = doc.createElement("nombreSolicitante");
                            carname2.appendChild(doc.createTextNode(resDet.getPermisos().getUsuarios().getNombre()));
                            resolucionesDetalles.appendChild(carname2);

                            // carname element
                            Element carname3 = doc.createElement("rutSolicitante");
                            carname3.appendChild(doc.createTextNode(resDet.getPermisos().getUsuarios().getRut()));
                            resolucionesDetalles.appendChild(carname3);

                            // carname element
                            Element carname = doc.createElement("fechaEmision");
                            carname.appendChild(doc.createTextNode(resDet.getFechaemision().toString()));
                            resolucionesDetalles.appendChild(carname);

                            // carname element
                            Element carname1 = doc.createElement("justificacion");
                            carname1.appendChild(doc.createTextNode(resDet.getJustificacion()));
                            resolucionesDetalles.appendChild(carname1);

                            // carname element
                            Element carname4 = doc.createElement("diasAfecto");
                            carname4.appendChild(doc.createTextNode(resDet.getPermisos().getTiposPermisos().getDiasafectos().toString()));
                            resolucionesDetalles.appendChild(carname4);

                            // carname element
                            Element carname5 = doc.createElement("recursoLegal");
                            carname5.appendChild(doc.createTextNode(resDet.getRecursolegalafecto().toString()));
                            resolucionesDetalles.appendChild(carname5);
                        }
                    }
                }
                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("C:\\Users\\Jonathan\\Desktop\\XMLResoluciones.xml"));
                transformer.transform(source, result);

                // Output to console for testing
                OutputFormat format = new OutputFormat(doc);
                format.setIndenting(true);
                XMLSerializer serializer = new XMLSerializer(System.out, format);
                serializer.serialize(doc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
            }
    </script>

</html>

