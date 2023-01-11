<%-- 
    Document   : organizaralumnos
    Created on : 9 ene 2023, 19:54:04
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignacion practicas</title>
    </head>
    <body>
        <h1>Asignacion practicas</h1>
        <c:out value="${requestScope.hay_practicas}"></c:out>
        <c:choose>
            <c:when test="${requestScope.hay_practicas}">
                <form action="/ControladorResponsable?accion=asignarpracticas" method="POST" autocomplete="off">
                    <button type="submit" value="Asignar">Asignar</button> 
                </form>        
            </c:when>
            <c:otherwise>
                <p>Las practicas ya se han asignado!</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>
