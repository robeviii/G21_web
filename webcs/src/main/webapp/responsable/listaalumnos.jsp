<%-- 
    Document   : listaalumnos
    Created on : 9 ene 2023, 13:37:25
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de alumnos</title>
    </head>
    <body>
        <h1>Lista de alumnos</h1>
         <br /><br />
        <form action="action" method="POST" autocomplete="off">
            
            <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Dni</th>
                        <th>Nota media</th>
                        <th>Email</th>
                        <th>id tutor</th>
                    </tr>
                </thead>
                
                <tbody>
                    
                    <c:forEach var="alumno" items="${lista}">
                        <tr>
                            <td><c:out value="${alumno.nombre}"/></td>
                            <td><c:out value="${alumno.dni}"/></td>
                            <td><c:out value="${alumno.notamedia}"/></td>
                            <td><c:out value="${alumno.email}"/></td>
                            <td><c:out value="${alumno.id_tutor_al}"/></td>
                        </tr>

                    </c:forEach>

                </tbody>
 
            </table>

        </form>
         
         <a href="responsablecontroller?accion=volverindex">Volver al índice</a>
         <a href="responsablecontroller?accion=volverlistaempresa">Volver a la lista de empresas</a>
        
    </body>
</html>
