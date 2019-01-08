<%-- 
    Document   : VistaRegistroVotante
    Created on : 19-nov-2018, 18:11:00
    Author     : owa_7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>elecciones</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../CSS/assets/css/styles.min.css">
</head>
    <style>
    body{
        background-color: #f1f7fc !important; 
    }
</style>
<body>
    <div class="login-clean" style="height:720px;">
        <form action="../ControladorRegistroVotante" method="POST" style="width:430px;padding:21px;">
            <h2 class="sr-only">Login Form</h2>
            <h1 class="text-center">Registro de votante</h1>
            <div class="illustration"><i class="icon ion-ios-navigate" style="background-color:#ffffff;color:rgb(0,0,0);"></i></div>
            <div class="form-row">
                <div class="col">
                    <div class="form-group"><input class="form-control" type="text" name="nombre" placeholder="Nombre" required="" autofocus=""></div>
                </div>
                <div class="col">
                    <div class="form-group"><input class="form-control" type="password" name="contrasena" placeholder="Contraseña" required=""></div>
                </div>
            </div>
            <div class="form-row">
                <div class="col">
                    <div class="form-group"><input class="form-control" type="text" name="apellidos" placeholder="Apellidos" required=""></div>
                </div>
                <div class="col">
                    <div class="form-group"><input class="form-control" type="text" name="nif" placeholder="NIF" required=""></div>
                </div>
            </div>
            <div class="form-row">
                <div class="col">
                    <div class="form-group"><input name="fechaNac" class="form-control" type="date" required=""><small class="form-text text-muted">Introduzca fecha de nacimiento</small></div>
                </div>
                <div class="col">
                    <div class="form-group"><input class="form-control" type="text" name="domicilio" placeholder="Domicilio" required=""></div>
                </div>
            </div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color:rgb(3,3,3);">Inicio de sesión</button></div>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>
