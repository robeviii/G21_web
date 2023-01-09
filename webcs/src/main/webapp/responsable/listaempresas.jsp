<%-- 
    Document   : listaempresas
    Created on : 9 ene 2023, 13:37:12
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de empresas</title>
    </head>
    <body>
        <h1>Lista de empresas</h1>
        <br /><br />
        <form action="action" method="POST" autocomplete="off">
            
            <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Capacidad</th>
                        <th>Horario</th>
                        <th>Duracion</th>
                        <th>Tutor id</th>
                        <th></th>
                    </tr>
                </thead>
                
                <tbody>
                    
                    <c:forEach var="empresa" items="${lista}">
                        <tr>
                            <td><c:out value="${empresa.nombre}"/></td>
                            <td><c:out value="${empresa.nalumnos}"/></td>
                            <td><c:out value="${empresa.horario}"/></td>
                            <td><c:out value="${empresa.duracion}"/></td>
                            <td><c:out value="${empresa.id_tutor}"/></td>
                            <td><a href="responsablecontroller?accion=mostraralumnos&id_tutor=<c:out value="${empresa.id_tutor}" />">Ver alumnos</a></td>
                        </tr>

                    </c:forEach>

                </tbody>

            </table>

        </form>
        
        <a href="responsablecontroller?accion=volverindex">Volver al índice</a>
        
    </body>
</html>
