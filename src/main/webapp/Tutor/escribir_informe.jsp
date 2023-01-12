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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos.css" rel="stylesheet" />

        <title>Redacción de informe</title>
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
        <div class="w-75 mx-auto pt-5 ">

            <h1>Redacción de informe</h1>
        
            <form action="ControladorTutor?accion=actualizarinforme" method="POST" autocomplete="off">

                <input id="idalumno" name="idalumno" type="hidden" value="<c:out value="${alumno.id}"/>"/>
                <input id="nombre" name="nombre" type="hidden" value="<c:out value="${alumno.nombre}"/>"/>
                <input id="dni" name="dni" type="hidden" value="<c:out value="${alumno.dni}"/>"/>
                <input id="notamedia" name="notamedia" type="hidden" value="<c:out value="${alumno.nota_media}"/>"/>
                <input id="email" name="email" type="hidden" value="<c:out value="${alumno.email}"/>"/>
                <input id="notaprac" name="notaprac" type="hidden" value="<c:out value="${alumno.nota_practica}"/>"/>
                <input id="id_tutor_al" name="id_tutor_al" type="hidden" value="<c:out value="${alumno.id_tutor}"/>"/>

                <p>
                    Escribir informe:
                    <br/>
                    <textarea id="informe" name="informe" class="form-control" style="height: 50vh">Redacte su informe</textarea>

                </p>

                <button id="guardarinforme" name="guardarinforme" type="submit" class="btn btn-primary">Guardar</button>

            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
   
    </body>
</html>
