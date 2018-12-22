<%-- 
    Document   : VistaResultadoVotos
    Created on : 13-dic-2018, 17:08:26
    Author     : owa_7
--%>

<%@page import="modelo.Partido"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



<body>
    <% 
    
        ArrayList<Partido> partidos=(ArrayList<Partido>)session.getAttribute("partidosVotos");
        
    %>
    <!-- menu -->
    <div class="container" style="height:508px;">
        <form action="">
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
                    <div class="col d-flex justify-content-center align-items-center"><input name="votos" value="<%= a.getVotos() %>" type="text"></div>
                </div>
                <% } %>
                
            </div>
        </form>
    </div>
 
</body>

</html>