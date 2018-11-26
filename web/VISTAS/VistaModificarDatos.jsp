<%-- 
    Document   : VistaModificarDatos
    Created on : 25-nov-2018, 11:59:49
    Author     : owa_7
--%>

<%@page import="modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

<body>
    <%  Votante votante=(Votante)session.getAttribute("votante");  %>
    <div>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container"><a class="navbar-brand" href="#">Company Name</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse"
                    id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link active" href="#">First Item</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="#">Second Item</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="#">Third Item</a></li>
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Dropdown </a>
                            <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">First Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="container d-flex justify-content-center" style="height:350px;">
        <form action="../ControladorModificarDatos">
            <div class="form-row">
                <div class="col">
                    <div class="form-group"><label>Nombre</label><input class="form-control" type="text" name="nombre" value="<% out.print(votante.getNombre()); %>" autofocus=""></div>
                </div>
                <div class="col">
                    <div class="form-group"><label>Apellidos</label><input class="form-control" type="text" name="apellidos" value="<% out.print(votante.getApellidos()); %>"></div>
                </div>
            </div>
            <div class="form-row">
                <div class="col">
                    <div class="form-group"><label>NIF</label><input class="form-control" type="text" name="nif" value="<% out.print(votante.getNif()); %>" readonly=""></div>
                </div>
                <div class="col">
                    <div class="form-group"><label>Contraseña</label><input class="form-control" type="password" name="contrasena" value="123456789"></div>
                </div>
            </div>
            <div class="form-row">
                <div class="col">
                    <div class="form-group"><label>Domicilio</label><input class="form-control" type="text" name="domicilio" value="<% out.print(votante.getDomicilio()); %>"></div>
                </div>
                <div class="col">
                    <div class="form-group"><label>Fecha de nacimiento</label><input class="form-control" type="date" name="fechaNac" value="<% out.print(votante.getFechaNac()); %>"></div>
                </div>
            </div>
                <button class="btn btn-primary" type="submit">Button</button>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>