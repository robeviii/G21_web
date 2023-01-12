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

 
## 📄 Javadoc

El javadoc se encuentra en: [javadoc](/javadoc/index.html) (Abrirlo desde la carpeta del proyecto para que se muestre en el navegador.
