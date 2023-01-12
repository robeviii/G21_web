<%-- 
    Document   : ver_informe
    Created on : 9 ene 2023, 13:05:22
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Informe del Alumno</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <link href="estilos.css" rel="stylesheet" />
    </head>
    <body>
        <nav class="navbar navbar-expand navbar-light bg-light">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="panelAlumno">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ControladorAlumno?accion=solicitud_practicas">Solicitud</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ControladorAlumno?accion=ver_informe">Informes</a>
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
        <div class="w-75 mx-auto pt-5 ">
            <h1 class="my-5">Informe</h1>
            <div class="bg-secondary-subtle rounded">
                <p><c:out default="Todavia no se ha emitido un informe" value="${sessionScope.informe}"></c:out></p>
            </div>
                <c:if test="${not empty sessionScope.informe}">
                    <form method="POST" action="/Pdf">
              
                        <input type="submit" value="Descargar PDF" name="btnver"/>
            
                    </form>
                </c:if>
            
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    
    </body>
</html>
