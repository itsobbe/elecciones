<%-- 
    Document   : VistaPruebaGrafica
    Created on : 13-dic-2018, 20:03:13
    Author     : owa_7
--%>

<%@page import="modelo.PartidoCandidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
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

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            window.onload = function () {

                var chart = new CanvasJS.Chart("chartContainer", {
                    theme: "light2",
                    animationEnabled: true,
                    exportFileName: "New Year Resolutions",
                    exportEnabled: true,
                    title: {
                        text: "Top Categories of New Year's Resolution"
                    },
                    data: [{
                            type: "pie",
                            showInLegend: true,
                            legendText: "{label}",
                            toolTipContent: "{label}: <strong>{y}%</strong>",
                            indexLabel: "{label} {y}%",
                            dataPoints: <%out.print(dataPoints);%>
                        }]
                });

                chart.render();

            }
        </script>
    </head>
    <body>
        <div >
            <div id="chartContainer" style="height: 370px; width: 100%;"></div>
        </div>
        
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
</html>