<%-- 
    Document   : VistaMensajeCorrecto
    Created on : 22-nov-2018, 18:43:10
    Author     : owa_7
--%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
    <div class="container d-flex flex-column justify-content-center" style="height:350px;width:100vw;">
        <div class="alert alert-success" role="alert"><span><strong>Éxito </strong><% out.print(request.getParameter("mensaje")); %></span></div>
    </div>
</body>
</html>
