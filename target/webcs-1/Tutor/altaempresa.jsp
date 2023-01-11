<%-- 
    Document   : altaempresa
    Created on : 26 dic 2022, 23:43:46
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <title>Alta</title>
    </head>
    <body>
        <nav class="navbar navbar-expand navbar-light bg-light">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="/panelTutor">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ControladorTutor?accion=alta_empresa">Alta empresa</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ControladorTutor?accion=finalizar_practicas">Finalizar practicas</a>
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
        <h1>Alta Empresa</h1>
        <br /><br />
        <h2>Introduzca los datos de la empresa y las prácticas</h2>
        <form action="ControladorTutor?accion=nuevaempresa" method="POST" autocomplete="off">
                        
            <p>
                Nombre:
                <input id="nombre" name="nombre" type="text" />
                
            </p>
            
            <p>
                Direccion:
                <input id="direccion" name="direccion" type="text" />
                
            </p>
            
            <p>
                Ambito:
                <input id="ambito" name="ambito" type="text" />
                
            </p>
            
            <p>
                Web:
                <input id="web" name="web" type="text">
                
            </p>
            
            <p>
                Teléfono:
                <input id="telefono" name="telefono" type="text" />
                
            </p>
            
            <p>
                Nº máximo de alumnos:
                <select name="n_alumnos">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </p>
            
            <p>
                Horario prácticas:
                <select name="horario">
                    <option value="mañana">Mañana(9:00-13:00)</option>
                    <option value="tarde">Tarde (16:00-20:00)</option>
                </select>
                
            </p>
            
            <p>
                
                Duración de las prácticas (meses):
                <select name="duracion">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                
                
            </p>
                         
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>
