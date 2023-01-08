<%-- 
    Document   : altaempresa
    Created on : 26 dic 2022, 23:43:46
    Author     : 34646
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta</title>
    </head>
    <body>
        <h1>Alta Empresa</h1>
        <br /><br />
        <h2>Introduzca los datos de la empresa y las prácticas</h2>
        <form action="tutorcontroller?accion=nuevaempresa" method="POST" autocomplete="off">
                        
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
            
            <p>
                ID Tutor:
                <input id="id_tutor" name="id_tutor" type="text" />
                
            </p>
            
                
                
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>
