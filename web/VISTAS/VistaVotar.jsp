<%-- 
    Document   : VistaVotar
    Created on : 27-nov-2018, 10:31:44
    Author     : owa_7
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="modelo.Parametros"%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page import="modelo.Partido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
    <% 
    
        ArrayList<Partido> partidos=(ArrayList<Partido>)session.getAttribute("partido");
        
    %>

    <div class="container" style="height:508px;">
        <form action="../ControladorVotar">
            <div class="card" style="margin:20px;">
                <div class="card-header">
                    <p>Elecciones <%=  ((Parametros)session.getAttribute("parametros")).getCircunscripcion()%> <%= ((Parametros)session.getAttribute("parametros")).getFechaConsulta().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")) %> </p>
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
                    <div class="col offset-8 d-flex justify-content-center"><button class="btn btn-primary flex-column" type="submit">Votar</button></div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>