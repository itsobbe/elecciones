<%-- 
    Document   : VistaResultadoElegidos
    Created on : 20-dic-2018, 17:20:14
    Author     : owa_7
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="modelo.Parametros"%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page import="modelo.PartidoCandidato"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    ArrayList<PartidoCandidato> array = (ArrayList<PartidoCandidato>) session.getAttribute("partidoCandidato");

    Gson gsonObj = new Gson();
    Map<Object, Object> map = null;
    List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

    for (PartidoCandidato a : array) {
        map = new HashMap<Object, Object>();
        map.put("label", a.getDenominacion());
        map.put("y", a.getEscaños());
        map.put("exploded", true);
        list.add(map);
    }
    String dataPoints = gsonObj.toJson(list);
%>


<!DOCTYPE html>
<html>



    <script type="text/javascript">
        window.onload = function () {

            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2",
                animationEnabled: true,
                exportFileName: "Elecciones",
                exportEnabled: true,
                title: {
                    text: "Resultado de las elecciones"
                },
                data: [{
                        type: "pie",
                        showInLegend: true,
                        legendText: "{label}",
                        toolTipContent: "{label}: <strong>{y}</strong>",
                        indexLabel: "{label} {y}",
                        dataPoints: <%out.print(dataPoints);%>
                    }]
            });

            chart.render();

        }
    </script>
    <body>
        <%

            ArrayList<PartidoCandidato> partidos = (ArrayList<PartidoCandidato>) session.getAttribute("partidoCandidato");

        %>
        <!-- menu -->
        <div class="container" style="height:508px;">
            <form action="">
                <div class="card" style="margin:20px;overflow: hidden">
                    <div class="card-header">
                        <p>Elecciones <%=  ((Parametros) session.getAttribute("parametros")).getCircunscripcion()%> <%= ((Parametros) session.getAttribute("parametros")).getFechaConsulta().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"))%> </p>
                    </div>
                    <% for (PartidoCandidato a : partidos) {

                    %>
                    <div class="form-row" style="margin-top: 10px;margin-bottom: 10px;">
                        <div class="col d-flex justify-content-center align-items-center"><img src="<%= a.getLogo()%>" style="height:112px;width:181px;border-radius:50px;"></div>
                        <div class="col d-flex justify-content-center align-items-center">
                            <p><%= a.getDenominacion()%></p>
                        </div>

                        <div class="col d-flex justify-content-center align-items-center">
                            <p>Total escaños:
                                <span class="badge badge-pill badge-info">
                                    <%=a.getEscaños()%>
                                </span>
                            </p>
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
            <div >
                <div id="chartContainer" style="height: 370px; width: 100%;"></div>
            </div>
        </div>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
</html>