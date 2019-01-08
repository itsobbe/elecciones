<%-- 
    Document   : VistaListadoCenso
    Created on : 21-nov-2018, 18:25:06
    Author     : owa_7
--%>

<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
                <div class="container d-flex flex-column justify-content-center" style="height:350px;margin-top:270px">
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
        <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script> 
    </body>

</html>