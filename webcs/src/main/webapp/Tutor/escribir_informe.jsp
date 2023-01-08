<%-- 
    Document   : escribir_informe
    Created on : 26 dic 2022, 23:44:24
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redacción de informe</title>
    </head>
    <body>
        <h1>Redacción de informe</h1>
        
        <form action="tutorcontroller?accion=actualizarinforme" method="POST" autocomplete="off">
            
            <input id="idalumno" name="idalumno" type="hidden" value="<c:out value="${alumno.idalumno}"/>"/>
            <input id="nombre" name="nombre" type="hidden" value="<c:out value="${alumno.nombre}"/>"/>
            <input id="dni" name="dni" type="hidden" value="<c:out value="${alumno.dni}"/>"/>
            <input id="notamedia" name="notamedia" type="hidden" value="<c:out value="${alumno.notamedia}"/>"/>
            <input id="email" name="email" type="hidden" value="<c:out value="${alumno.email}"/>"/>
            <input id="notaprac" name="notaprac" type="hidden" value="<c:out value="${alumno.notaprac}"/>"/>
            <input id="id_tutor_al" name="id_tutor_al" type="hidden" value="<c:out value="${alumno.id_tutor_al}"/>"/>
            
            <p>
                Escribir informe:
                <br/>
                <textarea id="informe" name="informe" rows="30" cols="80">Redacte su informe</textarea>
                
            </p>
            
            <button id="guardarinforme" name="guardarinforme" type="submit">Guardar</button>
            
        </form>
        
    </body>
</html>
