CREATE DATABASE ingenieros_al_peso;
USE ingenieros_al_peso;

CREATE TABLE tutor (
  nombre varchar(100) DEFAULT NULL,
  apellido varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  id_tutor varchar(100) NOT NULL,
  PRIMARY KEY (id_tutor)
);


CREATE TABLE alumno(
  id_alumno varchar(100) NOT NULL,
  nombre varchar(100) DEFAULT NULL,
  nota_media varchar(100) DEFAULT NULL,
  dni varchar(100) DEFAULT NULL,
  id_tutor varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  nota_practica varchar(100) DEFAULT NULL,
  informe varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_alumno),
  
  FOREIGN KEY (id_tutor) REFERENCES tutor (id_tutor)
);


CREATE TABLE practicas (
  nombre varchar(100) DEFAULT NULL,
  descripcion varchar(100) DEFAULT NULL,
  id_practicas varchar(100) DEFAULT NULL,
  plazas int(11) DEFAULT NULL,
  duracion int(11) DEFAULT NULL,
  id_tutor varchar(100) DEFAULT NULL,
  KEY Practicas_FK (id_tutor),
  CONSTRAINT Practicas_FK FOREIGN KEY (id_tutor) REFERENCES tutor (id_tutor)
);

CREATE TABLE responsable (
  id_responsable varchar(100) NOT NULL,
  nombre varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  apellido varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_responsable)
);

CREATE TABLE empresa (
  nombre_e varchar(100) DEFAULT NULL,
  direccion varchar(100) DEFAULT NULL,
  ambito varchar(100) DEFAULT NULL,
  web varchar(100) DEFAULT NULL,
  telefono varchar(100) DEFAULT NULL,
  nalumnos varchar(100) DEFAULT NULL,
  horario varchar(100) DEFAULT NULL,
  duracion varchar(100) DEFAULT NULL,
  id_tutor varchar(100) DEFAULT NULL,
  KEY empresa_FK (id_tutor),
  CONSTRAINT empresa_FK FOREIGN KEY (id_tutor) REFERENCES tutor (id_tutor)
);
