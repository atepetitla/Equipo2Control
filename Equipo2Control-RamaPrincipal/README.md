# Equipo2Control
Creacion de control escolar usando git

Para que funcione correctamente necesitas estos scripts y que la base de datos se llame digipro:

CREATE TABLE Alumno(
idalumno NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
apellidopaterno VARCHAR(50)NOT NULL,
apellidomaterno VARCHAR(50)NOT NULL);

INSERT INTO alumno (nombre, apellidopaterno, apellidomaterno) VALUES ('Sheyla ','Rivera','Cruz');
INSERT INTO alumno (nombre, apellidopaterno, apellidomaterno) VALUES ('Angel ','Tepetitla','Rodriguez');
INSERT INTO alumno (nombre, apellidopaterno, apellidomaterno) VALUES ('Gariel ','Florencio','Rosales');


CREATE TABLE Materia(
idmateria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
nombre VARCHAR(50)NOT NULL,
costo NUMBER NOT NULL);

INSERT INTO Materia(nombre, costo) VALUES ('Programacion','150');
INSERT INTO Materia(nombre, costo) VALUES ('Ciberseguridad','100');
INSERT INTO Materia(nombre, costo) VALUES ('Ingles','120');


-- Tabla intermedia para la relación "Estudiantes toman Materias"
CREATE TABLE AlumnoMateria(
    idalumnomateria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    idalumno INT,
    idmateria INT,
    FOREIGN KEY (idalumno) REFERENCES Alumno(idalumno),
    FOREIGN KEY (idmateria) REFERENCES Materia(idmateria)
);


-- Inserciones en la tabla intermedia AlumnoMateria
INSERT INTO AlumnoMateria (idalumno, idmateria) VALUES
(1, 1); 

INSERT INTO AlumnoMateria (idalumno, idmateria) VALUES
(2, 2); 
INSERT INTO AlumnoMateria (idalumno, idmateria) VALUES
(3, 3); 

INSERT INTO AlumnoMateria (idalumno, idmateria) VALUES
(1, 3);

INSERT INTO AlumnoMateria (idalumno, idmateria) VALUES
(2, 1); 


