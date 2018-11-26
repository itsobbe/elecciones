<%-- 
    Document   : VistaMenuVotante
    Created on : 21-nov-2018, 17:42:49
    Author     : owa_7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>elecciones</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../CSS/assets/css/styles.min.css">
</head>

<body>
    <div>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container"><a class="navbar-brand" href="#">E-lecciones</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse"
                    id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="VistaBaja.jsp">Dar de baja</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="VistaModificarDatos.jsp">Modificar datos</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="#">Resultados</a></li>
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Dropdown </a>
                            <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">First Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="d-flex flex-column m-auto" style="height:500px;width:650px;">
        <h1 class="text-center">Bienvenido a las elecciones</h1><img class="d-flex align-items-center m-auto" src="../CSS/assets/img/elecciones-votos.jpg" height="250px" style="/*display:inline-block;*/"></div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>
