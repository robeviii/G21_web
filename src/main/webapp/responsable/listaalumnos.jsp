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
        <nav class="navbar navbar-expand navbar-light bg-light">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="/panelResponsable">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ControladorResponsable?accion=mostrarempresas">Mostrar empresas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ControladorResponsable?accion=organizaralumnos">Organizar Alumnos</a>
                </li>
                
            </ul>
             <div class="dropdown">
                <a class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fa-solid fa-user"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="/login?cerrarSesion=true">Cerrar sesión</a></li>
                </ul>
            </div>
            
        </nav>
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
                            <td><c:out value="${alumno.nota_media}"/></td>
                            <td><c:out value="${alumno.email}"/></td>
                            <td><c:out value="${alumno.id_tutor}"/></td>
                        </tr>

                    </c:forEach>

                </tbody>
 
            </table>

        </form>
         
    </body>
</html>
