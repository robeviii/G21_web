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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <link href="estilos.css" rel="stylesheet" />
    </head>
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
        <div class="w-50 mx-auto pt-5 ">
            <h1>Lista de empresas</h1>
            <br /><br />
            <form action="action" method="POST" autocomplete="off">

            <table class="table table-light table-bordered">
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
                            <td><a href="ControladorResponsable?accion=mostraralumnos&id_tutor=${empresa.id_tutor}"/>Ver alumnos</a></td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>

            </form>
            </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        
    </body>
</html>
