<%-- 
    Document   : PanelControlAlumnoView
    Created on : 29 dic 2022, 18:38:17
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Panel de Control</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <link href="styles.css" rel="stylesheet" />

    </head>
    <body>
        <nav class="navbar navbar-expand navbar-light bg-light">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="#">Solicitud</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Informes</a>
                 </li>

            </ul>
             <div class="dropdown">
                <a class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fa-solid fa-user"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="#">Cerrar sesión</a></li>
                </ul>
            </div>
            
        </nav>
        
        <div class="w-50 mx-auto pt-5">
            <table id="informacion" class="table table-light table-bordered">
                <tbody>
                <tr>
                    <td>Nombre</td>
                    <td>Victor</td>        
                </tr>
                <tr>
                    <td>Dni</td>
                    <td>0908297Y</td>        
                </tr>
                <tr>
                    <td>Nota media</td>
                    <td>7.4</td>        
                 </tr>
                <tr>
                    <td>Email</td>
                    <td>victor@mora.es</td>        
                 </tr>
                </tbody>
            </table>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>
