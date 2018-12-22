<%-- 
    Document   : pruebaMenu
    Created on : 12-dic-2018, 17:39:53
    Author     : owa_7
--%>

<%@page import="modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>elecciones</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../CSS/assets/css/styles.min.css">
    </head>
    <body>
        <%  //con esto mandarle una variable para no poner el menu en la vista error/exito?
           //String r=request.getParameter("errini");
                
            
           //como para iniciar sesion puede no haber un votante debo controlarlo
            if (((Votante)session.getAttribute("votante"))!=null) {
                    String rol=((Votante)session.getAttribute("votante")).getRol();
                
            if (rol.equals("votante")) {
        %>
        <div>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container"><a class="navbar-brand" href="VistaMenuVotante.jsp">E-lecciones</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse"
                    id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="VistaBaja.jsp">Dar de baja</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="VistaModificarDatos.jsp">Modificar datos</a></li>
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Resultados</a>
                            <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="../ControladorMostrarResultadoVotos">Votos</a><a class="dropdown-item" role="presentation" href="../ControladorMostrarResultadoElegidos">Escaños/elegidos</a></div>
                        </li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="../ControladorCargarDatosVistaVotar">Votar</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        </div>
        <%  }else{
        %>
        <div>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container"><a class="navbar-brand" href="VistaMenuVotante.jsp">E-lecciones</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse"
                    id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="../ControladorListadoCenso">Listar Censo</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="../ControladorAsignarEsca_os">Asignar escaños</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="../ControladorCargarDatosVistaVotar">Votar</a></li>
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Resultados</a>
                            <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="../ControladorMostrarResultadoVotos">Votos</a><a class="dropdown-item" role="presentation" href="../ControladorMostrarResultadoElegidos">Escaños/elegidos</a></div>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Escrutinio</a>
                            <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="../ControladorEscrutinio?id=2">Abrir</a><a class="dropdown-item" role="presentation" href="../ControladorEscrutinio?id=1">Cerrar</a></div>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Consulta</a>
                            <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="../ControladorConsulta?id=2">Abrir</a><a class="dropdown-item" role="presentation" href="../ControladorConsulta?id=1">Cerrar</a></div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        </div>
        <%  
            }
            }
        %>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
