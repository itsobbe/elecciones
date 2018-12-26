<%-- 
    Document   : VistaResultadoVotos
    Created on : 13-dic-2018, 17:08:26
    Author     : owa_7
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="modelo.Parametros"%>
<%@page import="modelo.Partido"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    ArrayList<Partido> array = (ArrayList<Partido>) session.getAttribute("partidosVotos");

    Gson gsonObj = new Gson();
    Map<Object, Object> map = null;
    List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

    for (Partido partido : array) {
        map = new HashMap<Object, Object>();
        map.put("label", partido.getDenominacion());
        //map.put("x", partido.getDenominacion());
        map.put("y", partido.getVotos());
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

            //ArrayList<Partido> partidos = (ArrayList<Partido>) session.getAttribute("partidosVotos");

        %>
        <!-- menu -->
        <div class="container" style="height:508px;">
            <form action="">
                <div class="card" style="margin:20px;">
                    <div class="card-header">
                        <p>Elecciones <%=  ((Parametros) session.getAttribute("parametros")).getCircunscripcion()%> <%= ((Parametros) session.getAttribute("parametros")).getFechaConsulta().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"))%> </p>
                    </div>
                    <% for (Partido a : array) {

                    %>
                    <div class="form-row">
                        <div class="col d-flex justify-content-center"><img src="<%= a.getLogo()%>" style="height:112px;width:181px;border-radius:50px;"></div>
                        <div class="col d-flex justify-content-center align-items-center">
                                <p><%= //out.print(a.getDenominacion()) ;
                                    a.getDenominacion()%></p>
                        </div>
                        <div class="col d-flex justify-content-center align-items-center"><input name="votos" value="<%= a.getVotos()%>" type="text"></div>
                    </div>
                    <% }%>

                </div>
            </form>
            <div id="chartContainer" style="height: 370px; width: 100%;"></div>
        </div>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

    </body>

</html>