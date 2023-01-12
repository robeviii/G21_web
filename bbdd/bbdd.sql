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


-- 10 tutores

INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('John', 'Doe', 'password123', 'johndoe@email.com', 1);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Jane', 'Smith', 'password456', 'janesmith@email.com', 2);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Bob', 'Johnson', 'password789', 'bobjohnson@email.com', 3);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Alice', 'Williams', 'password101', 'alicewilliams@email.com', 4);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Charlie', 'Jones', 'password112', 'charliejones@email.com', 5);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('David', 'Brown', 'password113', 'davidbrown@email.com', 6);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Emily', 'Miller', 'password114', 'emilymiller@email.com', 7);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Michael', 'Moore', 'password115', 'michaelmoore@email.com', 8);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Matthew', 'Taylor', 'password116', 'matthewtaylor@email.com', 9);
INSERT INTO tutor (nombre, apellido, password, email, id_tutor) VALUES ('Joshua', 'Anderson', 'password117', 'joshuaanderson@email.com', 10);

-- 30 empresas 

INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Tech Innovations', 'Calle Falsa 123', 'Tecnología de la información y la comunicación', 'www.empresa1.com', '555-555-5555', 1, 'mañana', 8, 1);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('DataStream Solutions', 'Calle Falsa 456', 'Inteligencia artificial', 'www.empresa2.com', '555-555-5556', 2, 'tarde', 12, 2);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Cloud9 Solutions', 'Calle Falsa 789', 'Ciberseguridad', 'www.empresa3.com', '555-555-5557', 3, 'mañana', 6, 3);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('ByteWise', 'Calle Falsa 321', 'Internet de las cosas', 'www.empresa4.com', '555-555-5558', 10, 'tarde', 16, 4);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('CodeCrusaders', 'Calle Falsa 654', 'Realidad virtual y aumentada', 'www.empresa5.com', '555-555-5559', 2, 'mañana', 4, 5);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('ByteBuilders', 'Calle Falsa 987', 'Tecnología de drones', 'www.empresa6.com', '555-555-5560', 6, 'tarde', 20, 6);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('CloudNation', 'Calle Falsa 159', 'Nanotecnología', 'www.empresa7.com', '555-555-5561', 3, 'mañana', 12, 7);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Acme Inc.', '123 Main St', 'Informática', 'www.acme.com', '5755-555-5555', 5, 'mañana', 8, 1);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Beta Corp.', '456 Park Ave', 'Informática', 'www.beta.com', '555-5655-5555', 8, 'tarde', 12, 1);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Gamma LLC', '789 Elm St', 'Informática', 'www.gamma.com', '555-5855-5555', 3, 'mañana', 6, 3);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Delta Co.', '321 Oak St', 'Informática', 'www.delta.com', '555-555-55355', 6, 'tarde', 10, 1);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Epsilon Inc.', '159 Pine St', 'Informática', 'www.epsilon.com', '555-5556-5555', 9, 'mañana', 16, 1);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Zeta Enterprises', '753 Birch St', 'Informática', 'www.zeta.com', '555-5535-5555', 4, 'tarde', 8, 2);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Eta LLC', '951 Maple St', 'Informática', 'www.eta.com', '555-555-56555', 2, 'mañana', 6, 7);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Theta Corp.', '135 Willow St', 'Informática', 'www.theta.com', '5575-5585-52555', 7, 'tarde', 14, 2);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Innovatek', '1234 Innovation St.', 'Tecnología de la información y la comunicación', 'www.innovatek.com', '555-555-1111', 6, 'mañana', 12, 8);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('SmartTech', '5678 Smart Blvd.', 'Inteligencia artificial', 'www.smarttech.com', '555-555-2222', 8, 'tarde', 16, 8);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('CyberGuard', '91011 Cyber Rd.', 'Ciberseguridad', 'www.cyberguard.com', '555-555-3333', 4, 'mañana', 8, 8);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('IoT Hub', '121314 IoT Ave.', 'Internet de las cosas', 'www.iot-hub.com', '555-555-4444', 6, 'tarde', 12, 9);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('VirtualGenius', '151617 Virtual St.', 'Realidad virtual y aumentada', 'www.virtualgenius.com', '555-555-5555', 1, 'mañana', 8, 9);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('DroneFly', '181918 Drone St.', 'Tecnología de drones', 'www.dronefly.com', '555-555-6666', 5, 'tarde', 10, 9);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('NanoNexus', '212223 Nano Ave.', 'Nanotecnología', 'www.nanonexus.com', '555-555-7777', 7, 'mañana', 14, 10);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('BioTech', '242526 Bio St.', 'Biotecnología', 'www.biotech.com', '555-555-8888', 4, 'tarde', 12, 10);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('StemTech', '272829 Stem Ave.', 'Tecnología de células madre', 'www.stemtech.com', '555-555-9999', 6, 'mañana', 10, 10);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('BlockChain Solutions', '303132 Blockchain St.', 'Tecnología blockchain', 'www.blockchainsolutions.com', '555-555-1010', 8, 'tarde', 16, 10);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('RoboTech', '333435 Robo St.', 'Robótica', 'www.robo-tech.com', '555-555-1212', 4, 'mañana', 8, 1);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('QuantumTech', '363738 Quantum St.', 'Tecnologías cuánticas', 'www.quantumtech.com', '555-555-1313', 6, 'tarde', 12, 5);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('SpaceTech', '394041 Space St.', 'Tecnología espacial', 'www.spacetech.com', '555-555-1414', 2, 'mañana', 8, 4);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('GreenTech', '414243 Green St.', 'Tecnologías sostenibles', 'www.greentech.com', '555-555-1515', 5, 'tarde', 10, 6);
INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES ('Teching', '3434 Green St.', 'Tecnologías sostenibles', 'www.teching.com', '555-555-1815', 5, 'tarde', 10, 5);


-- 15 alumnos sin practicas asignadas

INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (1, 'Eduardo', 8.5, '96345678A', 1, 'johndoef@email.com', 'password1');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (2, 'Juana', 9.0, '21425789V', 2, 'janedoe@email.com', 'password2');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (3, 'Bob', 7.0, '34567890C', 3, 'bobsmith@email.com', 'password3');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (4, 'Alicia', 8.0, '45645901D', 4, 'alicejohnson@email.com', 'password4');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (5, 'Juan', 9.5, '56789322E', 5, 'charliewilliams@email.com', 'password5');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (6, 'David', 6.5, '67840233F', 6, 'davejones@email.com', 'password6');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (7, 'Eva', 8.0, '78934544G', 7, 'evebrown@email.com', 'password7');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (8, 'Francis', 7.5, '89032555J', 8, 'frankdavis@email.com', 'password8');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (9, 'Gina', 9.0, '90154265P', 9, 'ginamiller@email.com', 'password9');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (10, 'Mike', 9.7, '56789022O', 4, 'mikerodriguez@email.com', 'password15');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (11, 'Igor', 8.2, '12345678K', 10, 'igorgarcia@email.com', 'password11');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (12, 'Julia', 9.5, '23456789L', 1, 'juliamartinez@email.com', 'password12');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (13, 'Kevin', 7.3, '34567890M', 2, 'kevinrobinson@email.com', 'password13');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (14, 'Lena', 8.1, '45678901N', 3, 'lenaclark@email.com', 'password14');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password) VALUES (15, 'Nina',  8.9, '67890345P', 5, 'ninagarcia@email.com', 'password16');

-- 10 alumnos con practicas asignadas

INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (16, 'John', 8.5, '12345678A', 1, 'johnad4oe@email.com', 'password1',8.5,'El alumno ha mostrado habilidades en resolución de problemas y pensamiento lógico en su experiencia en programación.','Tech Innovations');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (17, 'Jane', 9.0, '23456789B', 2, 'janfe4doe@email.com', 'password2',8.8,'El alumno ha demostrado buenas habilidades de trabajo en equipo en su experiencia en desarrollo de proyectos de software.','DataStream Solutions');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (18, 'Bob', 7.0, '34567890C', 3, 'bobsmddith@email.com', 'password3',7.5,'El alumno ha tenido éxito en la implementación de prácticas ágiles en su experiencia en gestión de proyectos.','Cloud9 Solutions');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (19, 'Alice', 8.0, '45678901D', 4, 'alice7ajohnson@email.com', 'password4',8.2,'El alumno ha sido eficaz en la optimización y el rendimiento de aplicaciones en su experiencia en ingeniería de software.','ByteWise');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (20, 'Charlie', 9.5, '56789022E', 5, 'charli2ewilliams@email.com', 'password5',9.0,'El alumno ha tenido un enfoque en la seguridad y la privacidad en su experiencia en desarrollo de aplicaciones móviles.','CodeCrusaders');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (21, 'Dave', 6.5, '67890233F', 6, 'dave4jones@email.com', 'password6',7.0,'El alumno ha mostrado una gran capacidad para el aprendizaje continuo en su experiencia en inteligencia artificial y aprendizaje automático.','ByteBuilders');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (22, 'Eve', 8.0, '78903444G', 7, 'evebrow3n@email.com', 'password7',8.3,'El alumno ha demostrado una comprensión sólida de los fundamentos de bases de datos en su experiencia en administración de bases de datos.','CloudNation');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (23, 'Frank', 7.5, '89034555H', 8, 'fr5ankdavis@email.com', 'password8',7.8,'El alumno ha tenido una experiencia exitosa en la automatización de procesos en su experiencia en robótica y automatización.','Innovatek');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (24, 'Gina', 9.0, '90456555I', 9, 'ginami2ller@email.com', 'password9',8.9,'El alumno ha mostrado habilidades en la toma de decisiones y la comunicación en su experiencia en liderazgo técnico.','IoT Hub');
INSERT INTO alumno (id_alumno, nombre, nota_media, dni, id_tutor, email, password,nota_practica,informe,nombre_empresa_practicas) VALUES (25, 'Harry', 6.0, '01234567J', 10, 'harrymoeore@email.com', 'password10',6.5,'El alumno ha tenido experiencia en el desarrollo de soluciones en la nube en su experiencia en infraestructura y devops.','StemTech');

-- 3 reponsables

INSERT INTO responsable (id_responsable, nombre, email, password, apellido) VALUES (1, 'Juan', 'juan@email.com', 'abc123', 'Pérez');
INSERT INTO responsable (id_responsable, nombre, email, password, apellido) VALUES (2, 'Maria', 'maria@email.com', 'def456', 'Gómez');
INSERT INTO responsable (id_responsable, nombre, email, password, apellido) VALUES (3, 'Carlos', 'carlos@email.com', 'ghi789', 'Sánchez');

-- 30 practicas 

INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (1, 'Tech Innovations', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (2, 'DataStream Solutions', 3);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (3, 'ByteWise', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (1, 'SmartTech', 3);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (2, 'VirtualGenius', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (3, 'BioTech', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (4, 'QuantumTech', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (2, 'Tech Innovations', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (4, 'DataStream Solutions', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (1, 'ByteWise', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (2, 'SmartTech', 4);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (2, 'BioTech', 5);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (3, 'VirtualGenius', 3);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (4, 'BioTech', 3);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (3, 'Tech Innovations', 4);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (6, 'DataStream Solutions', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (7, 'ByteWise', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (8, 'SmartTech', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (9, 'VirtualGenius', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (10, 'BioTech', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (6, 'QuantumTech', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (7, 'Tech Innovations', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (8, 'DataStream Solutions', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (9, 'ByteWise', 2);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (10, 'SmartTech', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (11, 'VirtualGenius', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (12, 'BioTech', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (13, 'QuantumTech', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (14, 'Tech Innovations', 1);
INSERT INTO practicas (id_alumno, nombre_empresa, preferencia) VALUES (15, 'DataStream Solutions', 1);
