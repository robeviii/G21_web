<%-- 
    Document   : nota
    Created on : 26 dic 2022, 23:44:42
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Otorgar nota</title

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

            <h1>Dar nota de las practicas</h1>
            <form action="ControladorTutor?accion=actualizarnota" method="POST" autocomplete="off">

                <input id="idalumno" name="idalumno" type="hidden" value="<c:out value="${alumno.id}"/>"/>
                <input id="nombre" name="nombre" type="hidden" value="<c:out value="${alumno.nombre}"/>"/>
                <input id="dni" name="dni" type="hidden" value="<c:out value="${alumno.dni}"/>"/>
                <input id="notamedia" name="notamedia" type="hidden" value="<c:out value="${alumno.nota_media}"/>"/>
                <input id="email" name="email" type="hidden" value="<c:out value="${alumno.email}"/>"/>
                <input id="id_tutor_al" name="id_tutor_al" type="hidden" value="<c:out value="${alumno.id_tutor}"/>"/>

                <p>
                    Otorgando nota a <c:out value="${alumno.nombre}"/>

                </p>

                <p>
                    <label for="notaprac" class="form-label">Dar nota:</label>
                    <input required class="form-control" id="notaprac" name="notaprac" type="number" step="0.1" min="0" max="10" value="<c:out value="${alumno.nota_practica}"/>" />
                </p>

                <button id="guardarnota" name="guardarnota" type="submit" class="btn btn-primary">Guardar</button>

            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>
