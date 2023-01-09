<%-- 
    Document   : solicitud_practicas
    Created on : 9 ene 2023, 15:35:13
    Author     : victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Informe del Alumno</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>
        <nav class="navbar navbar-expand navbar-light bg-light">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="/panelAlumno">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ControladorAlumno?action=solicitud_practicas">Solicitud</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ControladorAlumno?action=ver_informe">Informes</a>
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
        <h1>Solicitud de practicas</h1>
        
        <h3>Empresas Solicitadas</h3>
        <form action="ControladorAlumno?action=eliminar_practicas" method="POST" autocomplete="off">
            <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Direccion</th>
                        <th>Ambito</th>
                        <th>Web</th>
                        <th>Telefono</th>
                        <th>Plazas</th>
                        <th>Horario</th>
                        <th>Duracion</th>
                        <th>Preferencia</th>
                    </tr>
                </thead>

                <tbody>
                     <c:forEach var="empresa" items="${sessionScope.empresas_solicitadas}">
                        <tr>
                            <td><c:out value="${empresa.value.nombre}"/></td>
                            <td><c:out value="${empresa.value.direccion}"/></td>
                            <td><c:out value="${empresa.value.ambito}"/></td>
                            <td><c:out value="${empresa.value.web}"/></td>
                            <td><c:out value="${empresa.value.telefono}"/></td>
                            <td><c:out value="${empresa.value.nalumnos}"/></td>
                            <td><c:out value="${empresa.value.horario}"/></td>
                            <td><c:out value="${empresa.value.duracion}"/></td>
                            <td><c:out value="${empresa.key}"/></td>   
                            <td><input type="submit" name="${empresa.value.nombre}" value="Eliminar"/></td>
                        </tr>




                    </c:forEach>



                </tbody>


            </table>
        </form>
        <h3>Empresas Disponibles</h3>
        <form action="ControladorAlumno?action=añadir_practicas" method="POST" autocomplete="off">
            <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Direccion</th>
                        <th>Ambito</th>
                        <th>Web</th>
                        <th>Telefono</th>
                        <th>Plazas</th>
                        <th>Horario</th>
                        <th>Duracion</th>
                        <th>Preferencia</th>
                    </tr>
                </thead>

                <tbody>
                     <c:forEach var="empresa" items="${sessionScope.empresas_no_solicitadas}">
                        <tr>
                            <td><c:out value="${empresa.nombre}"/></td>
                            <td><c:out value="${empresa.direccion}"/></td>
                            <td><c:out value="${empresa.ambito}"/></td>
                            <td><c:out value="${empresa.web}"/></td>
                            <td><c:out value="${empresa.telefono}"/></td>
                            <td><c:out value="${empresa.nalumnos}"/></td>
                            <td><c:out value="${empresa.horario}"/></td>
                            <td><c:out value="${empresa.duracion}"/></td>
                            <td>
                                <select name="${empresa.nombre}">
                                    <option value="0">Sin asignar</option>
                                    <c:forEach var="preferencia" items="${sessionScope.preferencias}">
                                        <option value="${preferencia}"><c:out value="${preferencia}"/></option>
                                    </c:forEach>

                                </select>
                            </td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="submit" value="Solicitar"/>Solicitar</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </body>
</html>
