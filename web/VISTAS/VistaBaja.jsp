<%-- 
    Document   : VistaBaja
    Created on : 22-nov-2018, 17:29:34
    Author     : owa_7
--%>
<jsp:include page="pruebaMenu.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



<body>

    <div class="container d-flex justify-content-center align-items-center" style="height:350px;">
        <form action="../ControladorBajaVotante" method="post">
            <div class="col d-flex justify-content-center">
                <div class="alert alert-warning" role="alert" style="width:423px;"><span style="margin-right:29px;"><strong>¿Confirma que quiere darse de baja?</strong></span><button class="btn btn-primary" type="submit">Sí</button></div>
            </div>
        </form>
    </div>

</body>

</html>
