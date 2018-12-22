<%-- 
    Document   : VistaMensajeError
    Created on : 22-nov-2018, 18:42:58
    Author     : owa_7
--%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



<body>
    <% 
        int id=0;
        
        //id=(int)Integer.valueOf(request.getParameter("id"));
        try{
            id=(int)Integer.parseUnsignedInt(request.getParameter("id"));
        }catch(NumberFormatException e){}
       //int id=1;
       
    %>
    <div>

    </div>
    <div class="container d-flex flex-column justify-content-center" style="height:350px;">
        <div>
            <div class="alert alert-danger" role="alert">
                <span>
                    <strong>Error</strong>
                    <% 
                        out.println(request.getParameter("error")); 
                    %>
                    <% if (id==1) {%>
                      <a class="nav-link" href="VistaInicioSesionUsuario.jsp">Volver a inicio de sesión</a>      
                     <%   }
                    %>
                    
                </span>
            </div>
        </div>
    </div>

</body>

</html>