<%-- 
    Document   : MisPermisos
    Created on : 22-10-2017, 12:59:57
    Author     : Jordan Silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>SGP -  Mis Permisos</title>

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
        <div class="wrapper">
            <div id="sidebar"></div>
            <div class="main-panel">
                <div class="content">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <h1>Solicitar Permiso</h1>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">

                                    <form action="<c:url value="/ControllerNuevaSolicitud" />" method="post" style="margin-left: 50px">
                                        <br>
                                        <div class="form-group" > 
                                            <text> Motivo  :</text>
                                            <input class="form-control" type="text" name="motivo" placeholder="motivo" style="max-width: 170px;">
                                        </div>
                                        <div class="form-group" > 
                                            <text> Días :</text>
                                            <input class="form-control" type="text" name="dias" placeholder="Dias" style="max-width: 170px;">
                                        </div>
                                        <div class="form-group" >
                                            <text> Inicio :</text>
                                            <br>
                                            <input placeholder="Inicio" class="textbox-n" type="text" onfocus="(this.type = 'date')"  id="date" name="inicio"> 
                                        </div>
                                        <div class="form-group" > 
                                            <text> Termino :   </text>
                                            <br>
                                            <input placeholder="Termino" class="textbox-n" type="text" onfocus="(this.type = 'date')"  id="date"name="termino"> 
                                        </div>
                                        <div  class="form-group"  >
                                            <text> Tipo :   </text>
                                            <br>
                                            <select name="tipo">
                                                <option value="seleccione">Seleccione...</option>
                                                <c:forEach var="v" items="${tipos}">
                                                    <option value="<c:out value="${v.getIdTipoPermiso()}"/>"><c:out value="${v.getIdTipoPermiso().toString()}"/></option>                            
                                                </c:forEach>  

                                            </select>
                                        </div>    


                                        <div class="form-group">
                                            <button class="btn btn-primary btn-block" type="submit" style="background-color:rgb(0,102,255);max-width:50%; color: white">Solicitar Permiso</button>
                                        </div></form>
                                    <c:out value="${EstadoSolicitud}"/>">

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
<script src="assets/js/sidebar.js"></script>


</html>
<script type="text/javascript">
                                                sidebar("sidebar");
</script>



























