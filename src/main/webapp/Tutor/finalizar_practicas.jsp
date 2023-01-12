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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <link href="estilos.css" rel="stylesheet" />

    </head>
    <body>      
        <nav class="navbar navbar-expand navbar-light bg-light">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="panelTutor">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ControladorTutor?accion=alta_empresa">Alta empresa</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ControladorTutor?accion=finalizar_practicas">Finalizar practicas</a>
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

            <h1>Finalización de practicas</h1>
            <br /><br />
            <form action="action" method="POST" autocomplete="off">

                <table class="table table-light table-bordered">
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
                                <td><c:out value="${alumno.nota_media}"/></td>
                                <td><c:out value="${alumno.email}"/></td>
                                <td><c:out value="${alumno.nota_practica}"/></td>
                                <td><c:out value="${alumno.id_tutor}"/></td>
                                <td><a class="link-primary" href="ControladorTutor?accion=darnota&idalumno=<c:out value="${alumno.id}" />">Dar nota</a></td>
                                <td><a class="link-primary" href="ControladorTutor?accion=escribirinforme&idalumno=<c:out value="${alumno.id}" />">Escribir informe</a></td>

                            </tr>




                        </c:forEach>



                    </tbody>


                </table>
            
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>
