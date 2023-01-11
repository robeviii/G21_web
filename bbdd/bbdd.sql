CREATE DATABASE ingenieros_al_peso;
USE ingenieros_al_peso;

-- ingenieros_al_peso.tutor definition

CREATE TABLE tutor (
  nombre varchar(100) DEFAULT NULL,
  apellido varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  id_tutor varchar(100) NOT NULL,
  PRIMARY KEY (id_tutor)
);

-- ingenieros_al_peso.empresa definition

CREATE TABLE empresa (
  nombre_e varchar(100) NOT NULL,
  direccion varchar(100) DEFAULT NULL,
  ambito varchar(100) DEFAULT NULL,
  web varchar(100) DEFAULT NULL,
  telefono varchar(100) DEFAULT NULL,
  nalumnos varchar(100) DEFAULT NULL,
  horario varchar(100) DEFAULT NULL,
  duracion varchar(100) DEFAULT NULL,
  id_tutor varchar(100) DEFAULT NULL,
  PRIMARY KEY (nombre_e),
  KEY empresa_FK (id_tutor),
  CONSTRAINT empresa_FK FOREIGN KEY (id_tutor) REFERENCES tutor (id_tutor)
);


-- ingenieros_al_peso.alumno definition

CREATE TABLE alumno (
  id_alumno varchar(100) NOT NULL,
  nombre varchar(100) DEFAULT NULL,
  nota_media varchar(100) DEFAULT NULL,
  dni varchar(100) DEFAULT NULL,
  id_tutor varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  nota_practica varchar(100) DEFAULT NULL,
  informe text DEFAULT NULL,
  nombre_empresa_practicas varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_alumno),
  KEY alumno_FK (nombre_empresa_practicas),
  KEY alumno_FK_1 (id_tutor),
  CONSTRAINT alumno_FK FOREIGN KEY (nombre_empresa_practicas) REFERENCES empresa (nombre_e),
  CONSTRAINT alumno_FK_1 FOREIGN KEY (id_tutor) REFERENCES tutor (id_tutor)
);


-- ingenieros_al_peso.practicas definition

CREATE TABLE practicas (
  id_alumno varchar(100) NOT NULL,
  nombre_empresa varchar(100) NOT NULL,
  preferencia varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_alumno,nombre_empresa),
  KEY practicas_FK_1 (nombre_empresa),
  CONSTRAINT practicas_FK FOREIGN KEY (id_alumno) REFERENCES alumno (id_alumno),
  CONSTRAINT practicas_FK_1 FOREIGN KEY (nombre_empresa) REFERENCES empresa (nombre_e)
);

-- ingenieros_al_peso.responsable definition

CREATE TABLE responsable (
  id_responsable varchar(100) NOT NULL,
  nombre varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  apellido varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_responsable)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- Popular base de datos

-- Tutores