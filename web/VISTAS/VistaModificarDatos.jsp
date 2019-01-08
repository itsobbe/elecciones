<%-- 
    Document   : VistaModificarDatos
    Created on : 25-nov-2018, 11:59:49
    Author     : owa_7
--%>
<%@page import="modelo.Parametros"%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page import="modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>



    <body>
        <%
            Votante votante = (Votante) session.getAttribute("votante");
            if (votante.getVotado().equals("S")) {
                String mensaje = "Una vez votado no se pueden cambiar los datos";
                response.sendRedirect("VistaMensajeError.jsp?error=" + mensaje);
            } else if (((Parametros)request.getSession().getAttribute("parametros")).getConsultaAbierta().equals("N")) {
                String mensaje="Consulta cerrada, no puede modificar datos";
                response.sendRedirect("VistaMensajeError.jsp?error="+mensaje);
            }else if (((Parametros)request.getSession().getAttribute("parametros")).getEscrutinioAbierto().equals("N")) {
                String mensaje="Escrutinio cerrado, no puede modificar datos";
                response.sendRedirect("VistaMensajeError.jsp?error="+mensaje);
            }
        %>

        <div class="container d-flex justify-content-center" style="height:350px;">
            <form action="../ControladorModificarDatos">
                <div class="form-row">
                    <div class="col">
                        <div class="form-group"><label>Nombre</label><input class="form-control" type="text" name="nombre" value="<% out.print(votante.getNombre()); %>" autofocus=""></div>
                    </div>
                    <div class="col">
                        <div class="form-group"><label>Apellidos</label><input class="form-control" type="text" name="apellidos" value="<% out.print(votante.getApellidos()); %>"></div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col">
                        <div class="form-group"><label>NIF</label><input class="form-control" type="text" name="nif" value="<% out.print(votante.getNif()); %>" readonly=""></div>
                    </div>
                    <div class="col">
                        <div class="form-group"><label>Contraseña</label><input class="form-control" type="password" name="contrasena" value="" required></div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col">
                        <div class="form-group"><label>Domicilio</label><input class="form-control" type="text" name="domicilio" value="<% out.print(votante.getDomicilio()); %>"></div>
                    </div>
                    <div class="col">
                        <div class="form-group"><label>Fecha de nacimiento</label><input class="form-control" type="date" name="fechaNac" value="<% out.print(votante.getFechaNac());%>"></div>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Button</button>
            </form>
        </div>
    </body>
</html>