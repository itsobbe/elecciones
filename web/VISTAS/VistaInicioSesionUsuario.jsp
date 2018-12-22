<%-- 
    Document   : VistaInicioSesionUsuario
    Created on : 19-nov-2018, 18:21:50
    Author     : owa_7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>E-lecciones</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="../CSS/assets/css/styles.min.css">
    </head>
    <body>
        <div class="login-clean" style="height:720px;">
            <form action="../ControladorInicioSesion" method="POST">
                <h2 class="sr-only">Login Form</h2>
                <div class="illustration"><i class="icon ion-ios-navigate" style="color:rgb(0,0,0);"></i></div>
                <div class="form-group"><input class="form-control" type="text" name="nif" placeholder="NIF" required=""></div>
                <div class="form-group"><input class="form-control" type="password" name="contrasena" placeholder="Contraseña" required=""></div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color:rgb(0,0,0);">Inicio de sesión</button></div><a href="VistaRegistroVotante.jsp" class="forgot">Registrate</a></form>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
