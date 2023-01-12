<%-- 
    Document   : LoginView
    Created on : 27 dic 2022, 17:30:11
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html lang="es">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Inicio de sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <div id="background" class="text-light d-flex flex-column w-100 h-100 align-items-center justify-content-center">
            <h1>Acceso</h1>
            <div class="mx-auto w-50  h-50 d-flex flex-column justify-content-center">
                
                <form method="POST" action="login" class="w-100 h-100 mx-auto d-flex flex-column justify-content-center login" >
                    <fieldset class="my-5">
                        <div class="form-group mb-4"> 
                            <label for="email-input" class="visually-hidden form-label">Email</label>
                            <input required type="email" class="form-control form-control-lg bg-primary-subtle" id="email-input" placeholder="Email" name="email"></input>
                        </div>
                        <div class="form-group"> 
                            <label for="pass-input " class="visually-hidden form-label">Contraseña</label>
                            <input required type="password" class="form-control form-control-lg bg-primary-subtle" id="pass-input" placeholder="Contraseña" name="password"></input>
                        </div>                       
                    </fieldset>

                    <c:set var="nologin" value="${sessionScope.nologin}"></c:set>
                    <c:if test="${nologin}">
                        <div class="alert alert-danger" role="alert">No se encontro ese usuario</div>                  
                    </c:if>
                    <c:set var="nologin" scope="session" value="false"></c:set>
                    
                    <button type="submit" class="text-primary btn btn-light"><b>ENTRAR</b></button>
                </form>

            </div>
        </div>
            
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </body>
</html>
