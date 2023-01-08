<%-- 
    Document   : finalizar_practicas
    Created on : 26 dic 2022, 23:45:07
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizar Practicas</title>
    </head>
    <body>      
        <h1>Finalización de practicas</h1>
        <br /><br />
        <form action="action" method="POST" autocomplete="off">
            
            <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Dni</th>
                        <th>Nota media</th>
                        <th>Email</th>
                        <th>Nota Practicas</th>
                        <th>Id tutor</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                
                <tbody>
                    
                    <c:forEach var="alumno" items="${lista}">
                        <tr>
                            <td><c:out value="${alumno.nombre}"/></td>
                            <td><c:out value="${alumno.dni}"/></td>
                            <td><c:out value="${alumno.notamedia}"/></td>
                            <td><c:out value="${alumno.email}"/></td>
                            <td><c:out value="${alumno.notaprac}"/></td>
                            <td><c:out value="${alumno.id_tutor_al}"/></td>
                            <td><a href="tutorcontroller?accion=darnota&idalumno=<c:out value="${alumno.idalumno}" />">Dar nota</a></td>
                            <td><a href="tutorcontroller?accion=escribirinforme&idalumno=<c:out value="${alumno.idalumno}" />">Escribir informe</a></td>
                            
                        </tr>
                        
                        
                        
                        
                    </c:forEach>
                               
                               
                               
                               
                    
                    
                    
                </tbody>
                
                
                
                
            </table>

            
        </form>
    </body>
</html>
