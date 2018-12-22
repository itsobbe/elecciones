<%-- 
    Document   : VistaResultadoElegidos
    Created on : 20-dic-2018, 17:20:14
    Author     : owa_7
--%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page import="modelo.PartidoCandidato"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



    <body>
        <%

            ArrayList<PartidoCandidato> partidos = (ArrayList<PartidoCandidato>) session.getAttribute("partidoCandidato");

        %>
        <!-- menu -->
        <div class="container" style="height:508px;">
            <form action="">
                <div class="card" style="margin:20px;">
                    <div class="card-header">
                        <p>Elecciones 2019 de albacete</p>
                    </div>
                    <% for (PartidoCandidato a : partidos) {

                    %>
                    <div class="form-row" style="margin-top: 10px;margin-bottom: 10px;">
                        <div class="col d-flex justify-content-center align-items-center"><img src="<%= a.getLogo()%>" style="height:112px;width:181px;border-radius:50px;"></div>
                        <div class="col d-flex justify-content-center align-items-center">
                                <p><%= //out.print(a.getDenominacion()) ;
                                    a.getDenominacion()%></p>
                        </div>
                        <!--<div class="col d-flex justify-content-center align-items-center"><input name="votos" value="<%= a.getEscaños()%>" type="text"></div>-->

                        <div class="col d-flex justify-content-center align-items-center">
                                <p>Total escaños: <%= //out.print(a.getDenominacion()) ;
                                    a.getEscaños()%></p>
                        </div>
                        
                        <div class="card" style="width: 18rem;">
                            <div class="card-header">
                                <p>Elegidos</p>
                            </div>
                            <ul class="list-group list-group-flush">
                                <% for (int i = 0; i < a.getCandidatos().size(); i++) {
                                %>
                                <li class="list-group-item"><%= a.getCandidatos().get(i).getNombre_apellidos()%></li>

                                <%}%>
                            </ul>
                        </div>

                    </div>
                    <% }%>

                </div>
            </form>
        </div>

    </body>

</html>