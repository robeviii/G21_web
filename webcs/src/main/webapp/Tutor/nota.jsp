<%-- 
    Document   : nota
    Created on : 26 dic 2022, 23:44:42
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Otorgar nota</title>
    </head>
    <body>
        <h1>Dar nota de las practicas</h1>
        <form action="tutorcontroller?accion=actualizarnota" method="POST" autocomplete="off">
            
            <input id="idalumno" name="idalumno" type="hidden" value="<c:out value="${alumno.idalumno}"/>"/>
            <input id="nombre" name="nombre" type="hidden" value="<c:out value="${alumno.nombre}"/>"/>
            <input id="dni" name="dni" type="hidden" value="<c:out value="${alumno.dni}"/>"/>
            <input id="notamedia" name="notamedia" type="hidden" value="<c:out value="${alumno.notamedia}"/>"/>
            <input id="email" name="email" type="hidden" value="<c:out value="${alumno.email}"/>"/>
            <input id="id_tutor_al" name="id_tutor_al" type="hidden" value="<c:out value="${alumno.id_tutor_al}"/>"/>

            <p>
                Otorgando nota a <c:out value="${alumno.nombre}"/>
                
            </p>
            
            <p>
                Dar nota:
                <input id="notaprac" name="notaprac" type="text" value="<c:out value="${alumno.notaprac}"/>" />
                
            </p>
            
            <button id="guardarnota" name="guardarnota" type="submit">Guardar</button>
            
        </form>
    </body>
</html>
