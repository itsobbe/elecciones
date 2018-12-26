<%-- 
    Document   : VistaMenuVotante
    Created on : 21-nov-2018, 17:42:49
    Author     : owa_7
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="modelo.Parametros"%>
<%@page import="modelo.Votante"%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<body>
    <div class="container">


        <div class="card text-center ">
            <img class="card-img-top" src="../CSS/assets/img/urna.png" alt="Card image cap" height="250px">
            <div class="card-header">
                Bienvenido a las elecciones <span class="badge badge-info"><%= ((Votante) session.getAttribute("votante")).getNombre()%></span>
            </div>
            <div class="card-body">
                <h5 class="card-title">Ambito: <%= ((Parametros) session.getAttribute("parametros")).getTipoConsulta()%></h5>
                <p class="card-text"><%= ((Parametros) session.getAttribute("parametros")).getCircunscripcion()%></p>
                <p class="card-text">Nº de escaños: <%= ((Parametros) session.getAttribute("parametros")).getNumCandidatos()%></p>

            </div>
            <div class="card-footer text-muted">
                Comienzo con fecha: <%= ((Parametros) session.getAttribute("parametros")).getFechaConsulta().format(DateTimeFormatter.ofPattern("d MMM uuu"))%>
            </div>
        </div>
    </div>
    
</body>

</html>
