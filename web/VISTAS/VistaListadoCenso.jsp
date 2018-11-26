<%-- 
    Document   : VistaListadoCenso
    Created on : 21-nov-2018, 18:25:06
    Author     : owa_7
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listado de cajas</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="../CSS/assets/css/styles.min.css">
        <link rel="stylesheet" href="../CSS/assets/css/csspropio.css">
    </head>

    <body>
        
        <div>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container"><a class="navbar-brand" href="#">E-lecciones</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
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
        
        
            
                <div class="container d-flex flex-column justify-content-center" style="height:350px;">
                    <div class="row"  style="margin-bottom: 50px;">
                        <div class="col-md-12">
                            <div>
                                <h1>Censo</h1>
                                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>NIF</th>
                                            <th>NOMBRE</th>
                                            <th>ROL</th>
                                            <th>VOTADO</th>

                                        </tr>

                                    </thead>
                                    <tbody>
                                        <% ArrayList<Votante> a = (ArrayList) (session.getAttribute("arrayListadoCenso")); %>
                                        <% for (Votante obj : a) {
                                        %>
                                        <tr>
                                            <td><%= obj.getNif()%></td>
                                            <td><%= obj.getNombre()%></td>
                                            <td><%= obj.getRol()%></td>
                                            <td><%= obj.getVotado()%></td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
        <script src="../CSS/assets/js/script.min.js"></script>
    </body>

</html>