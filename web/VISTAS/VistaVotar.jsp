<%-- 
    Document   : VistaVotar
    Created on : 27-nov-2018, 10:31:44
    Author     : owa_7
--%>

<%@page import="modelo.Partido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>elecciones</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body>
    <% 
    
        ArrayList<Partido> partidos=(ArrayList<Partido>)session.getAttribute("partido");
        
    %>
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
    <div class="container" style="height:508px;">
        <form action="../ControladorVotar">
            <div class="card" style="margin:20px;">
                <div class="card-header">
                    <p>Elecciones 2019 de albacete</p>
                </div>
                <% for(Partido a:partidos){
                    
                 %>
                <div class="form-row">
                    <div class="col d-flex justify-content-center"><img src="<%= a.getLogo()%>" style="height:112px;width:181px;border-radius:50px;"></div>
                    <div class="col d-flex justify-content-center align-items-center">
                        <p><%= //out.print(a.getDenominacion()) ;
                                a.getDenominacion()
                            %></p>
                    </div>
                    <div class="col d-flex justify-content-center align-items-center"><input name="elegido" value="<%= a.getId() %>" type="radio"></div>
                </div>
                <% } %>
                <div class="form-row">
                    <div class="col offset-8 d-flex justify-content-center"><button class="btn btn-primary flex-column" type="submit">Button</button></div>
                </div>
            </div>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>