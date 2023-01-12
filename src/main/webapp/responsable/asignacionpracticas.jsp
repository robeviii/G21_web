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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <link href="estilos.css" rel="stylesheet" />

    </head>
    <body>
        <nav class="navbar navbar-expand navbar-light bg-light">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="panelResponsable">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ControladorResponsable?accion=mostrarempresas">Mostrar empresas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ControladorResponsable?accion=practicas">Asignar practicas</a>
                </li>
                
            </ul>
             <div class="dropdown">
                <a class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fa-solid fa-user"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="login?cerrarSesion=true">Cerrar sesión</a></li>
                </ul>
            </div>
            
        </nav>
        <h1>Asignacion practicas</h1>
        <c:out value="${requestScope.hay_practicas}"></c:out>
        <c:choose>
            <c:when test="${requestScope.hay_practicas}">
                <form action="ControladorResponsable?accion=asignarpracticas" method="POST" autocomplete="off">
                    <button type="submit" value="Asignar">Asignar</button> 
                </form>        
            </c:when>
            <c:otherwise>
                <p>¡Practicas asignadas, y correos mandados!</p>
            </c:otherwise>
        </c:choose>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
    
</html>
