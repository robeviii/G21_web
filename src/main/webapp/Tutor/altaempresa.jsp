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
        <link href="estilos.css" rel="stylesheet" />

        <title>Alta</title>
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
            <h1>Alta Empresa</h1>
            <br /><br />
            <h2>Introduzca los datos de la empresa y las prácticas</h2>
            <form action="ControladorTutor?accion=nuevaempresa" method="POST" autocomplete="off" class="">
                <div>
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input required id="nombre" name="nombre" type="text" placeholder="ej. Pedro" class="form-control"/>
                </div>
                <div>

                <label for="direccion" class="form-label">Direccion:</label>
                <input required id="direccion" name="direccion" type="text" placeholder="ej. Calle Octavio paz, 1..." class="form-control"/>
                </div>

                <div>

                <label for="ambito" class="form-label">Ambito:</label>
                <input required id="ambito" name="ambito" type="text" placeholder="ej. Inteligencia Artificial" class="form-control"/>

                </div>

                <div>

                <label for="web" class="form-label">Web:</label>
                <input id="web" name="web" type="text" placeholder="ej. www.empresa.com" class="form-control"/>
                </div>

                <div>

                <label for="telefono" class="form-label">Teléfono:</label>
                <input  required id="telefono" name="telefono" type="tel" pattern="[1-9][0-9]{8}" placeholder="ej. 695874589" class="form-control"/>
                </div>

                <div>

                <label for="n_alumnos" class="form-label">Nº máximo de alumnos:</label>
                <select  id="n_alumnos" name="n_alumnos" class="form-control">
                    <option selected value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                </div>
               
                <div>

                <label for="horario" class="form-label">Horario prácticas:</label>
                <select required id="horario" name="horario" class="form-control">
                    <option selected value="mañana">Mañana(9:00-13:00)</option>
                    <option value="tarde">Tarde (16:00-20:00)</option>
                </select>
                </div>

                <div>

                <label for="duracion" class="form-label">Duración de las prácticas (meses):</label>
                <select required id="duracion" name="duracion" class="form-control">
                    <option selected value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
                </div>
                <div class="mt-3">
                    <button id="guardar" name="guardar" type="submit" class="btn btn-primary">Guardar</button>
                </div>
            </form>
         </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>
