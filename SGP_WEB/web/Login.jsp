<%-- 
    Document   : Login
    Created on : 18-10-2017, 14:35:59
    Author     : Jordan Silva O
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portafolio</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/stylesLog.css">
   
</head>

<body>
    
    
    <div class="login-dark" style="background-image:url(&quot;assets/img/vista hermosa.jpg&quot;);height:677px;color:rgb(192,192,192);">
        <div style="height:75px;background-color:rgba(149,137,137,0.52);">
            <h1 class="text-center" style="color:rgb(0,0,0);margin:0px;padding:17px;">Ilustre Municipalidad de Vista Hermosa</h1></div>
        <form action="<c:url value="/ControllerLogin" />" method="post" style="border:2px solid;border-radius:25px;color:rgba(145,56,56,0.33);">
            <div class="illustration"><i class="fa fa-user-circle" style="color:rgb(0,0,0);"></i></div>
            <div class="form-group">
                <input class="form-control" type="text" name="rut" placeholder="Usuario" style="color:rgb(0,0,0);border:2px solid;border-radius:25px;background-color:#282222;">
            </div>
            <div class="form-group">
                <input class="form-control" type="password" name="password" placeholder="Contraseña" style="border:2px solid;border-radius:25px;color:rgb(0,0,0);background-color:#232020;">
            </div>
           
            
            <div class="form-group">
                <button id="invokesToastMessage" class="btn btn-primary btn-block" type="submit" style="border-radius:20px;">Iniciar Sesion</button>
            </div>
            <a href="#" class="forgot"> </a>
        </form>
             <div class="form-group">
            <c:out value="${estado}"/>">
            </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>


</html>