<%-- 
    Document   : email
    Created on : 11 ene 2023, 20:01:01
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Envio de email</h1>
        <form name="enviar email" method="POST" action="email?accion=envio_email">
              
            <input type="submit" value="enviar email" name="btnver"/>
            
        </form>
        <a href="email?accion=volverindex">Volver al índice</a>
    </body>
</html>
