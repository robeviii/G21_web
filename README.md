# G21_web

Práctica para asignatura de __ARQUITECTURA Y DISEÑO DE SISTEMAS WEB Y C/S__

## 👨‍🎨 Autores

- [Víctor Mora](https://github.com/VicMoraGit)
- [Rodrigo Becerra](https://github.com/robeviii)

## 🐋 Despliegue

Se ha optado por un sistema de contenedores para desplegar la aplicación implementado con Docker. A continuación, se detallan los pasos para su despliegue:
1. Tener instalado Docker en el sistema donde se vaya a desplegar la aplicación.
    Manual de instalación:
    - 🟦 [Windows](https://docs.docker.com/desktop/install/windows-install/)
    - 🐧 [Linux](https://docs.docker.com/desktop/install/linux-install/)
2. Abrir el la carpeta del proyecto en una terminal
3. Ejecutar desde esa terminal el siguiente comando, habiendo antes dejado libres los puertos 8080 y 3306 para tomcat y mariadb respectivamente.
  ```
  docker-compose up
  ```
4. Esperar a que los contenedores esten corriendo y a que mariadb haya populado la BBDD (2-3 mins)
5. Abrir en el navegador [localhost:8080/webcs-1](http://localhost:8080/webcs-1) para visitar la aplicacion.

En caso de querer consultar la base de datos para verificar los datos en un gestor grafico de bases de datos como DBeaver,  phpMyAdmin... La url de conexion de la BBDD en el contenedor de Docker para acceder desde fuera de este es: localhost:36 usuario "root" y contraseña "webcs"

Los usuarios predeterminados que se especifican en el enunciado de la practica se han modificado ya que nuestra aplicacion solo permite loguearse con correos validos y contraseña: 

Email: admin@admin.com Password: admin
Tutor: tutor@email.com Password: tutor
Alumno: alumno@email.com Password: alumno

## 📄 Javadoc

El javadoc se encuentra en: [javadoc](/javadoc/index.html) (Abrirlo desde la carpeta del proyecto para que se muestre en el navegador).
