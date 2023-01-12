# G21_web

Practica para asignatura de __ARQUITECTURA Y DISEÑO DE SISTEMAS WEB Y C/S__

## 👨‍🎨 Autores

- [Víctor Mora](https://github.com/VicMoraGit)
- [Rodrigo Becerra](https://github.com/robeviii)

## 🐋 Despliegue

Se ha optado por un sistema de contenedores para desplegar la aplicacion implementado con Docker. A continuacion, se detallan los pasos para su despligue:
1. Tener instalado Docker en el sistema donde se vaya a desplegar la aplicacion.
    Manual de instalacion:
    - 🟦 [Windows](https://docs.docker.com/desktop/install/windows-install/)
    - 🐧 [Linux](https://docs.docker.com/desktop/install/linux-install/)
2. Abrir el la carpeta del proyecto en una terminal
3. Ejecutar desde esa terminal el siguiente comando, habiendo antes dejado libres los puertos 8080 y 3306 para tomcat y mariadb respectivamente.
  ```
  docker-compose up
  ```
4. Esperar a que los contenedores esten corriendo.
5. Abrir en el navegador [localhost:8080/webcs-1](http://localhost:8080/webcs-1) para visitar la aplicacion.

 
