
use SQLADV


---CREACION DE USUARIOS---
CREATE USER doctor1 IDENTIFIED BY 123456 default tablespace users;
CREATE USER paciente1 IDENTIFIED BY 123456 default tablespace users;

--CREACION DE ROLES----
create role medicos;
create role pacientes;

---CREACION DE SINONIMOS PARA LAS TABLAS
create public synonym ingresos for ingresos;
create public synonym medico for medico;
create public synonym paciente for paciente;

----DAR PERMISOS A USUARIOS TANTO DE ROLES COMO DE TABLAS Y SESION
GRANT CREATE SESSION TO paciente1;
GRANT CREATE SESSION TO doctor1;
grant medicos to doctor1;
grant pacientes to paciente1;
grant select,insert on ingresos to paciente1;
grant select,insert on paciente to paciente1;
grant select on medico to paciente1;
grant select on medico to doctor1;
grant select on ingresos to doctor1;
grant select on paciente to doctor1;
----------------------------------------------


-------TABLAS------------


---------USUARIOS---------

create table Rol(
IDRol int PRIMARY KEY identity (100,1),
Rol varchar(50)

);

insert into Rol(Rol) values('PACIENTE'),('MEDICO');

create table Usuarios(
IDUsuario int PRIMARY KEY identity (100,1),
ID_DatosUsuario int,
Usuario varchar(50)unique,
Contraseña varchar(50),
Rol int,
Activa char(1),
constraint Rolfk FOREIGN KEY (Rol) REFERENCES Rol(IDRol),
constraint UsuarioPCTfk FOREIGN KEY (ID_DatosUsuario) REFERENCES pacientes(ID_PACIENTE),
constraint UsuarioMCfk FOREIGN KEY (ID_DatosUsuario) REFERENCES Medico(ID_medico)
);
-----------PACIENTES----------
drop table pacientes
create table pacientes(
ID_PACIENTE int PRIMARY KEY identity (001,1),
Cedula varchar(10) NOT NULL,
Nombres varchar(50),
Apellidos varchar(50),
Fecha_nacimiento varchar(10),
Provincia varchar(50),
canton varchar(50),
Codigo_postal varchar(5),
Direccion varchar(50),
Telefono varchar(10),
NumCelular varchar(10),

);
alter table pacientes
add canton varchar(50);
delete from pacientes
select*from pacientes
----INGRESO DE DATOS PACIENTE
insert into  pacientes(Cedula,Nombres,Apellidos ,Fecha_nacimiento,Provincia,Codigo_postal,Direccion,Telefono,NumCelular,canton )
values('0946584566','Angel','Vergara','31/01/2000','Guayas','09465','xxxxxx','044541268','0984659455','Guayaquil'),
('0985694588','David','Paredes','24/04/1999','Guayas','0945','xxxxx','041236845','0954685666','Guayaquil'),
('1718593209','Lucía','García','08/09/1992','Guayas','17010','Calle A No.23-45','049685748','0987456321','Guayaquil'),
('0914761293','Pedro','Martínez','12/05/1985','Guayas','13010','Avenida B No.34-12','049996874','0987123456','Guayaquil'),
('1301876512','María','Paz','03/12/1976','Guayas','01010','Calle C No.12-34','041368588','0998456789','Guayaquil'),
('1718645203','Andrés','Alvarado','25/06/1990','Guayas','08010','Avenida D No.45-67','0248695522','0967452314','Guayaquil'),
('0913758294','Sofía','Vásquez','14/10/1987','Santa Elena','12010','Calle E No.56-78','027496684','0987321567','Salinas'),
('0996548265','Juan','Flores','28/02/1986','Santa Elena','10010','Avenida F No.67-89','024856987','0997456321','La libertad'),
('0986554852','Carla','Barrera','16/07/1983','Santa Elena','07010','Calle G No.78-90','0478863548','0967452314','Santa Elena'),
('0956842548','Fernando','Gómez','29/11/1991','Santa Elena','24010','Avenida H No.89-12','045568135','0987321567','La libertad');


commit;
select*from paciente;


-------TABLAS MEDICO-------

create table Medico(
ID_medico INT PRIMARY KEY identity (0001,1),
CodigoMedico varchar(100),
Cedula varchar(10),
Nombres varchar(50),
Apellidos varchar(50),
Especialidad varchar(100),
Telefono varchar(10),
NumCelular varchar(10),
DireccionDomicilio varchar(100)
);



delete from Medico

------INGRESO USUARIO MEDICO----
insert into  medico (CodigoMedico,Cedula,Nombres,Apellidos, Especialidad,NumCelular,Telefono,DireccionDomicilio )
values('DCG1500','0948654881','Jose','Aguilera','Ginecologo','0946854558','046958455','Prosperina, la 38 Mz 1 s4'),
('DCFS501','0984685540','Sofía','López','Cardióloga','0987456321','048469522','Gallegos Lara, El condor Mz 99 s12'),
('DCR1502','0978458515','Andrés','García','Pediatra','0987123456','045896622','Cristo del Consuelo,Callejon H2 A Mz 87 s66'),
('DCFS503','0948556488','María','Paz','Dermatóloga','0998456789','043336555','Juan Montalvo,Calle Juan venitez Mz 44 s2'),
('DCE1504','0948456844','Carlos','Mora','Oncólogo','0967452314','048974555','AV. Ferroviaria,Calle Eloy Alfaro C Mz 10 s13'),
('DCDF505','0948458666','Ana','Salazar','Neuróloga','0987321567','043364849','9 de Octubre,Calle principal D Mz 12 s6'),
('DCGT506','1244685488','Juan','Flores','Endocrinólogo','0997456321','047784632','Guasmo sur,Calle principal E Mz 34 sA'),
('DCR507','0948564855','Carla','Barrera','Gastroenteróloga','0967452314','041246977','Isla trinitaria,Calle principal A Mz 9 s44'),
('DCX1508','0944485688','Fernando','Gómez','Traumatólogo','0987321567','041112485','Bastion Popular,Bloque 3 A Mz 1 s22');
commit;
select*from medico;


---------TABLA CITAS MEDICAS------
create table Citas_Medicas (
IDCita  INT PRIMARY KEY identity (0001,1),
CodigoCita varchar(10) not null,
IDPaciente INT  not null,
IDMedico INT not null,
IDHorarioCitas INT not null,
Motivo varchar(200),
constraint pcientfk FOREIGN KEY (IDPaciente) REFERENCES pacientes(ID_Paciente),
constraint medicfk FOREIGN KEY (IDMedico) REFERENCES Medico(ID_Medico)
);

alter table citas_medicas
add constraint horariocitafk FOREIGN KEY (IDHorarioCitas) REFERENCES HorariosCitas(ID_HORARIO)
SELECT*FROM pacientes
SELECT*FROM Medico
SELECT*FROM Citas_Medicas
INSERT INTO citas_medicas (CodigoCita ,IDPaciente,IDMedico,IDHorarioCitas,Motivo) 
VALUES 
( 'CT124', 17, 19,  1, 'Me Enferme'),
('CT125', 18, 21,  2, 'Me Enferme MAS');

/*
( 'CT126', 19, 20, 3, '20/10/2023', '11:00', 'Me Enferme'),
( 'CT127', 20, 22, 2, '25/11/2023', '07:00', 'Me Enferme'),
( 'CT128', 21, 19, 5, '27/11/2023', '07:00', 'Me Enferme'),
( 'CT129', 22, 27, 6, '28/11/2023', '10:00', 'Me Enferme'),*/

---RESTRINCCION DE DOCTOR UNICO---------
alter table ingresos add constraint verificacion UNIQUE(identificacion, cod_medico);


-----------DATOS CITAS MEDICAS-------------

insert into  ingresos (codigo_ingreso,identificacion,cod_medico,num_cam, fecha_ingreso,num_habitacion )
values('2000','0946584566','A123','100','09/03/2023','15');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2001', '1718593209', 'A123', '101', '09/03/2023', '16');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2002', '0914761293', 'B456', '102', '10/03/2023', '17');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2003', '1301876512', 'A123', '103', '11/03/2023', '18');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2004', '1718645203', 'C789', '104', '12/03/2023', '19');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2005', '0913758294', 'B456', '105', '13/03/2023', '20');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2006', '1314768295', 'C789', '106', '14/03/2023', '21');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2007', '1314968210', 'B456', '107', '15/03/2023', '22');
insert into ingresos (codigo_ingreso, identificacion, cod_medico, num_cam, fecha_ingreso, num_habitacion) 
values('2008', '1114768215', 'A123', '108', '16/03/2023', '23');

select*from Citas_Medicas;


create table HorariosCitas(
ID_HORARIO  INT PRIMARY KEY identity (0001,1),
ID_Doctor int,
Areas int,
FechaHora datetime,
Disponibilidad char(1),
constraint MEDICoFK FOREIGN KEY (ID_Doctor) REFERENCES Medico(ID_Medico)
);

SELECT*FROM HorariosCitas

insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(19,1,'12/11/23 16:30','S'),(20,2,'15/11/23 11:30','S'),(21,4,'19/11/23 13:00','S')
,(22,5,'22/11/23 11:00','S'),(23,3,'18/11/23 10:30','S');

create table Laboratorio


create table Areas(
ID_Areas INT PRIMARY KEY identity (0001,1),
ID_Doctor int not null,
Habitacion varchar(10),
Disponibilidad char(1)
constraint MEDICoFK2 FOREIGN KEY (ID_Doctor) REFERENCES Medico(ID_Medico)
);

SELECT*FROM Areas
insert into Areas (ID_Doctor ,Habitacion ,Disponibilidad ) 
values(19,'A12','S'),(20,'A13','S'),(21,'A14','S'),(22,'A15','S'),(23,'A16','S'),(24,'A17','S'),
(25,'A18','S'),(26,'A19','S'),(27,'A20','S');


create table Horario_Medicos(
ID_HorMedico INT PRIMARY KEY identity (0200,1),
ID_Doctor int not null,
Fecha date,
Hora_Entrada time,
Hora_Salida time,
constraint MEDICoFK3 FOREIGN KEY (ID_Doctor) REFERENCES Medico(ID_Medico)
);



-- Crear tabla de Historial Medico
CREATE TABLE Historial_Medico (
    ID_Historial INT PRIMARY KEY identity (1200,1),
    ID_Paciente INT,
    ID_Medico INT,
    FechaVisita int,
    Sintomas VARCHAR(255),
    Diagnostico VARCHAR(255),
    Tratamiento VARCHAR(255),
    Receta VARCHAR(255),
   constraint pcientefk FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente),
   constraint mediccofk FOREIGN KEY (ID_Medico) REFERENCES Medico(ID_Medico),
   constraint Citafk FOREIGN KEY (FechaVisita) REFERENCES Citas_Medicas(IDCita)
);
SELECT*FROM Historial_Medico
-- Ingresar datos en la tabla de Pacientes

SELECT
    Historial_Medico.Sintomas,
    Historial_Medico.Diagnostico,
    Historial_Medico.Tratamiento,
    Historial_Medico.Receta,
    pacientes.Apellidos AS APELLIDO_Paciente,
    Medico.Apellidos AS APELLIDO_Medico,
	HorariosCitas.FechaHora AS HORARIO

FROM
    Historial_Medico
INNER JOIN
    Pacientes ON Historial_Medico.ID_Paciente = Pacientes.ID_Paciente
INNER JOIN
    Medico ON Historial_Medico.ID_Medico = Medico.ID_Medico
	
inner join HorariosCitas on HorariosCitas.ID_HORARIO=Historial_Medico.FechaVisita;

SELECT*FROM HorariosCitas
SELECT*FROM Citas_Medicas



INSERT INTO Historial_Medico (   ID_Paciente,ID_Medico,FechaVisita,Sintomas, Diagnostico,Tratamiento,Receta) 
VALUES 
( 17, 19, 1, 'LE DUELE EL ESTOMAGO', 'DIARREA', 'CUIDADO ESTOMACAL', 'SUERO ORAL');
( 'Ana', 'García', '1990-08-15', 'Femenino', 'Urdesa Central', '234567890', 'ana.garcia@email.com'),
( 'Carlos', 'Gómez', '1985-12-03', 'Masculino', 'La Alborada', '345678901', 'carlos.gomez@email.com'),
( 'María', 'López', '1982-06-25', 'Femenino', 'Los Ceibos', '456789012', 'maria.lopez@email.com'),
( 'Luis', 'Rodríguez', '1978-11-07', 'Masculino', 'Samborondón', '567890123', 'luis.rodriguez@email.com'),
( 'Laura', 'Martínez', '1992-02-19', 'Femenino', 'Alborada', '678901234', 'laura.martinez@email.com'),
( 'Andrés', 'Hernández', '1975-04-30', 'Masculino', 'La Garzota', '789012345', 'andres.hernandez@email.com'),
( 'Sofía', 'Díaz', '1988-07-14', 'Femenino', 'Vía a la Costa', '890123456', 'sofia.diaz@email.com'),
( 'Jorge', 'Suárez', '1983-09-22', 'Masculino', 'Los Esteros', '901234567', 'jorge.suarez@email.com'),
( 'Gabriela', 'Pazmiño', '1995-01-28', 'Femenino', 'Ceibos Norte', '012345678', 'gabriela.pazmino@email.com'),
( 'Mario', 'Moreno', '1981-03-17', 'Masculino', 'Urdesa', '123456780', 'mario.moreno@email.com'),
( 'Isabel', 'Guzmán', '1993-06-02', 'Femenino', 'La Joya', '234567890', 'isabel.guzman@email.com'),
( 'Pablo', 'Chávez', '1979-08-12', 'Masculino', 'Guasmo', '345678901', 'pablo.chavez@email.com'),
( 'Elena', 'Sánchez', '1984-11-05', 'Femenino', 'Alborada', '456789012', 'elena.sanchez@email.com'),
('Ricardo', 'Ramírez', '1977-02-15', 'Masculino', 'Los Vergeles', '567890123', 'ricardo.ramirez@email.com'),
( 'Mónica', 'Andrade', '1991-05-23', 'Femenino', 'Norte de Guayaquil', '678901234', 'monica.andrade@email.com'),
( 'Diego', 'Orozco', '1986-07-31', 'Masculino', 'Mucho Lote', '789012345', 'diego.orozco@email.com'),
('Valeria', 'Aguilar', '1980-10-09', 'Femenino', 'Los Ríos', '890123456', 'valeria.aguilar@email.com'),
( 'Fernando', 'Vargas', '1994-01-19', 'Masculino', 'Los Ángeles', '901234567', 'fernando.vargas@email.com'),
('Alejandra', 'Rojas', '1982-04-25', 'Femenino', 'Las Peñas', '012345678', 'alejandra.rojas@email.com'),
('José', 'Paredes', '1976-06-11', 'Masculino', 'Sauces', '123456780', 'jose.paredes@email.com'),
( 'Carmen', 'Bustamante', '1990-09-28', 'Femenino', 'Guasmo Central', '234567890', 'carmen.bustamante@email.com'),
('Roberto', 'Estrada', '1985-12-17', 'Masculino', 'Ceibos Sur', '345678901', 'roberto.estrada@email.com'),
('Alicia', 'Rivadeneira', '1979-02-14', 'Femenino', 'Alborada', '456789012', 'alicia.rivadeneira@email.com'),
('Gustavo', 'Cordova', '1993-05-22', 'Masculino', 'Guasmo Sur', '567890123', 'gustavo.cordova@email.com'),
('Lucía', 'Moreira', '1978-08-29', 'Femenino', 'La Puntilla', '678901234', 'lucia.moreira@email.com'),
('Fabián', 'Sosa', '1991-11-08', 'Masculino', 'Samborondón', '789012345', 'fabian.sosa@email.com'),
('Marcela', 'Calderón', '1986-02-05', 'Femenino', 'Urdesa', '890123456', 'marcela.calderon@email.com'),
( 'Héctor', 'Vera', '1981-04-20', 'Masculino', 'La Garzota', '901234567', 'hector.vera@email.com'),
('Camila', 'Molina', '1995-07-18', 'Femenino', 'Urdesa Central', '012345678', 'camila.molina@email.com');



