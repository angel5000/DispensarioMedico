
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

create table UsuariosPaciente(
IDUsuario int PRIMARY KEY identity (100,1),
ID_DatosUsuario int,
Usuario varchar(50)unique,
Contraseña varchar(50),
Rol int,
Activa char(1),
constraint Rolfk FOREIGN KEY (Rol) REFERENCES Rol(IDRol),
constraint UsuarioPCTfk FOREIGN KEY (ID_DatosUsuario) REFERENCES pacientes(ID_PACIENTE)

);
create table UsuariosMedicos(
IDUsuario int PRIMARY KEY identity (100,1),
ID_DatosMedico int,
Usuario varchar(50)unique,
Contraseña varchar(50),
Rol int,
Activa char(1),
constraint Rolfk2 FOREIGN KEY (Rol) REFERENCES Rol(IDRol),
constraint UsuarioMCfk FOREIGN KEY (ID_DatosMedico) REFERENCES Medico(ID_medico)
);

select *from pacientes
select*from Rol
select*from UsuariosPaciente
insert into UsuariosPaciente(ID_DatosUsuario,Usuario,Contraseña,Rol,Activa ) 
values(17,'angel5000','123456',100,'S');

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


select*from Medico
/*delete from Medico*/

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

INSERT INTO medico (CodigoMedico, Cedula, Nombres, Apellidos, Especialidad, NumCelular, Telefono, DireccionDomicilio)
VALUES
  ('DCG1501', '0948654999', 'Laura', 'Martínez', 'Ginecóloga', '0946001122', '046958400', 'Alborada, la 38 Mz 1 s4'),
  ('DCFS502', '0984005540', 'Martín', 'Gómez', 'Cardiólogo', '0987000000', '048448569', 'Garzota, El condor Mz 99 s12'),
  ('DCR1503', '0948633299', 'Isabel', 'García', 'Pediatra', '0987000001', '0456984552', 'Urb. Kennedy, Callejon H2 A Mz 87 s66'),
  ('DCFS504', '0948111222', 'Carlos', 'Ruiz', 'Dermatólogo', '0998000000', '043311144', 'Alborada, Calle Juan venitez Mz 44 s2'),
  ('DCE1505', '0946846985', 'Elena', 'Mora', 'Oncóloga', '0967000000', '047895632', 'AV. Olmedo, Calle Eloy Alfaro C Mz 10 s13'),
  ('DCDF506', '0945684587', 'Santiago', 'Salazar', 'Neurólogo', '0987000002', '04356845', 'Alborada, Calle principal D Mz 12 s6'),
  ('DCGT507', '1216988745', 'Diana', 'Flores', 'Endocrinóloga', '0998000001', '047123654', 'Urb. Kennedy, Calle principal E Mz 34 sA'),
  ('DCR508', '0986987455', 'Pedro', 'Barrera', 'Gastroenterólogo', '0967000001', '041223695', 'Alborada, Calle principal A Mz 9 s44'),
  ('DCX1509', '0913666840', 'Gabriela', 'Gómez', 'Traumatóloga', '0987000002', '041489874', 'AV. Olmedo, Bloque 3 A Mz 1 s22');


  INSERT INTO medico (CodigoMedico, Cedula, Nombres, Apellidos, Especialidad, NumCelular, Telefono, DireccionDomicilio)
VALUES
  -- Ginecólogos
  ('DCG1501', '0968654999', 'Laura', 'Martínez', 'Ginecóloga', '0946001122', '046958400', 'Alborada, la 38 Mz 1 s4'),
  ('DCG1502', '0948654881', 'Jose', 'Aguilera', 'Ginecólogo', '0946854558', '046958455', 'Prosperina, la 38 Mz 1 s4'),
  ('DCG1503', '0978663599', 'Gabriela', 'Ramírez', 'Ginecóloga', '0999697111', '043548966', 'Sauces, Calle principal G Mz 5 s19'),

  -- Cardiólogos
  ('DCFS502', '0984005540', 'Martín', 'Gómez', 'Cardiólogo', '0987468566', '044685966', 'Garzota, El condor Mz 99 s12'),
  ('DCFS503', '0948556488', 'María', 'Paz', 'Cardióloga', '0998456789', '043336555', 'Juan Montalvo, Calle Juan venitez Mz 44 s2'),
  ('DCFS504', '0996364486', 'Carlos', 'Ruiz', 'Cardiólogo', '0998987458', '043311148', 'Alborada, Calle Juan venitez Mz 44 s2'),

  -- Pediatras
  ('DCR1502', '0978458515', 'Andrés', 'García', 'Pediatra', '0987123456', '045896622', 'Cristo del Consuelo, Callejon H2 A Mz 87 s66'),
  ('DCR1503', '0978000000', 'Isabel', 'García', 'Pediatra', '0987135221', '049684477', 'Urb. Kennedy, Callejon H2 A Mz 87 s66'),
  ('DCR1504', '0948456844', 'Carlos', 'Mora', 'Pediatra', '0967452314', '048974555', 'AV. Ferroviaria, Calle Eloy Alfaro C Mz 10 s13'),

  -- Dermatólogos
  ('DCFS504', '0948453222', 'Carlos', 'Ruiz', 'Dermatólogo', '0998984666', '043313189', 'Alborada, Calle Juan venitez Mz 44 s2'),
  ('DCFS503', '0948512488', 'María', 'Paz', 'Dermatóloga', '0998456789', '049485555', 'Juan Montalvo, Calle Juan venitez Mz 44 s2'),
  ('DCFS505', '0948369777', 'Raúl', 'Fernández', 'Dermatólogo', '0988111222', '049684555', 'Samborondón, Calle principal D Mz 8 s32'),

  -- Oncólogos
  ('DCE1504', '0948456844', 'Carlos', 'Mora', 'Oncólogo', '0967452314', '048974555', 'AV. Ferroviaria, Calle Eloy Alfaro C Mz 10 s13'),
  ('DCE1505', '0948456333', 'Elena', 'Mora', 'Oncóloga', '0967631485', '048964788', 'AV. Olmedo, Calle Eloy Alfaro C Mz 10 s13'),
  ('DCE1506', '0948639888', 'Juan', 'Cruz', 'Oncólogo', '0998487664', '044685555', 'Urdesa, Calle principal E Mz 30 s14'),

  -- Neurólogos
  ('DCDF505', '0988458666', 'Ana', 'Salazar', 'Neuróloga', '0987321567', '043364849', '9 de Octubre, Calle principal D Mz 12 s6'),
  ('DCDF506', '0958125444', 'Santiago', 'Salazar', 'Neurólogo', '0987139582', '043322200', 'Alborada, Calle principal D Mz 12 s6'),
  ('DCDF507', '0968788999', 'Eva', 'Gómez', 'Neuróloga', '0968698744', '049684586', 'Ceibos, Calle principal F Mz 15 s9'),

  -- Endocrinólogos
  ('DCGT506', '0984685488', 'Juan', 'Flores', 'Endocrinólogo', '0997456321', '047784632', 'Guasmo sur, Calle principal E Mz 34 sA'),
  ('DCGT507', '0948564855', 'Carla', 'Barrera', 'Endocrinóloga', '0967452314', '041246977', 'Isla trinitaria, Calle principal A Mz 9 s44'),
  ('DCGT508', '0948112000', 'Andrea', 'Gómez', 'Endocrinóloga', '0998111333', '043948777', 'Samanes, Calle principal G Mz 7 s20'),

  -- Gastroenterólogos
  ('DCR507', '0948564855', 'Carla', 'Barrera', 'Gastroenteróloga', '0967452314', '041246977', 'Isla trinitaria, Calle principal A Mz 9 s44'),
  ('DCR508', '0948123555', 'Pedro', 'Barrera', 'Gastroenterólogo', '0967964851', '046987777', 'Alborada, Calle principal A Mz 9 s44'),
  ('DCR509', '0948136988', 'Mónica', 'López', 'Gastroenteróloga', '0998111666', '041211122', 'Ceibos, Calle principal G Mz 11 s15'),

  -- Traumatólogos
  ('DCX1508', '0944485688', 'Fernando', 'Gómez', 'Traumatólogo', '0987321567', '041112485', 'Bastión Popular, Bloque 3 A');









commit;
select*from medico;

select*from Citas_Medicas
---------TABLA CITAS MEDICAS------
create table Citas_Medicas (
IDCita  INT PRIMARY KEY identity (0001,1),
CodigoCita varchar(10) not null,
IDPaciente INT  not null,
IDMedico INT not null,
IDHorarioCitas INT not null,
Motivo int,
constraint pcientfk FOREIGN KEY (IDPaciente) REFERENCES pacientes(ID_Paciente),
constraint medicfk FOREIGN KEY (IDMedico) REFERENCES Medico(ID_Medico)
constraint motivfk FOREIGN KEY (Motivo) REFERENCES MotivosCitasMedicas(IDMotivo)
);
select*from MotivosCitasMedicas

alter table Citas_Medicas add  Motivo int
update Citas_Medicas set Motivo=2 where IDCita=2
SELECT
   pacientes.Apellidos,
   Medico.Apellidos,
   Medico.Especialidad,
    MotivosCitasMedicas.Servicio,
	CostoServicios.Costos, 
	CostoServicios.Descuentos

FROM
   Citas_Medicas 
  inner JOIN
   pacientes ON pacientes.ID_PACIENTE = Citas_Medicas.IDPaciente
   inner JOIN
   Medico ON Medico.ID_medico=Citas_Medicas.IDMedico
 inner JOIN
   MotivosCitasMedicas ON Citas_Medicas.Motivo = MotivosCitasMedicas.IDMotivo
 inner JOIN
    CostoServicios ON CostoServicios.IDMCM = MotivosCitasMedicas.IDMotivo



create table MotivosCitasMedicas(
IDMotivo INT PRIMARY KEY identity (0001,1),
IDMedico INT not null,
Servicio varchar(150),
constraint medicfkk2 FOREIGN KEY (IDMedico) REFERENCES Medico(ID_Medico)
);
select*from Medico where Especialidad='Ginecólogo'
select*from MotivosCitasMedicas
INSERT INTO MotivosCitasMedicas (IDMedico ,Servicio) 
VALUES 
( 53, ' Consulta ginecológica'),
( 53, ' Pruebas de Papanicolaou (Pap) '),
( 53, 'Exámenes de mama '),
( 53, 'Prescripción y gestión de anticonceptivos '),
( 53, 'Colocación o retiro de dispositivos intrauterinos (DIU)'),
( 53, 'Exámenes de ITS (infecciones de transmisión sexual'),
( 53, 'Ultrasonido pélvico');

INSERT INTO MotivosCitasMedicas (IDMedico ,Servicio) 
VALUES 
( 24, 'Consulta neurológica'),
( 24, 'Electroencefalograma (EEG)'),
( 24, 'Tomografía computarizada (TC) y resonancia magnética (RM)'),
( 24, 'Tratamiento de la epilepsia'),
( 24, 'Tratamiento de dolores de cabeza y migrañas');


create table CostoServicios(
IDCostServi INT PRIMARY KEY identity (001,1),
IDMCM INT,
Costos Float,
Descuentos Float,
constraint Motivosfk FOREIGN KEY (IDMCM) REFERENCES MotivosCitasMedicas(IDMotivo)

);
select*from CostoServicios
INSERT INTO CostoServicios (IDMCM  ,Costos,Descuentos) 
VALUES 
( 1,15.00,0 ),
( 2,35.00,0 ),
( 3,20.50,0.05 ),
( 4,70.35,0 ),
( 5,30.00,0 ),
( 6,15.00,0.1 ),
( 7,48.20,0.07 );

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





-----------DATOS CITAS MEDICAS-------------


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
select*from Medico
insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(19,1,'12/11/23 16:30','S'),(20,2,'15/11/23 11:30','S'),(21,4,'19/11/23 13:00','S')
,(22,5,'22/11/23 11:00','S'),(23,3,'18/11/23 10:30','S');

insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(24,1,'20/11/23 07:30','S'),(24,1,'20/11/23 16:30','S')
,(24,1,'12/11/23 16:30','S'),
(25,2,'15/11/23 11:30','S'),(26,4,'19/11/23 13:00','S')
,(27,5,'22/11/23 11:00','S');



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
select*from factura

create table Factura(
 ID_Factura INT PRIMARY KEY identity (1200,1),
 ID_Paciente INT,
 ID_Medico INT,
FechaVisita INT,
Motivo int,
 Costo int,
 Iva int ,
 Subtotal float,
 Total float,
 constraint pcientefk2 FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente),
 constraint mediccofk2 FOREIGN KEY (ID_Medico) REFERENCES Medico(ID_Medico),
 constraint Citafk2 FOREIGN KEY (FechaVisita) REFERENCES HorariosCitas(ID_HORARIO),
 constraint Motivofk FOREIGN KEY (motivo) REFERENCES MotivosCitasMedicas(IDMotivo),
 constraint Costofk FOREIGN KEY (Costo) REFERENCES CostoServicios(IDCostServi)
);
delete from Factura
alter table factura add Iva float
select *from Factura
select*from HorariosCitas
select*from Citas_Medicas
select*from CostoServicios
insert into Factura (ID_Paciente,ID_Medico,FechaVisita,Motivo,Costo,Iva ,Subtotal,Total)
values(17,19,1,1,1,0.12,1.8,16.8);
select*from Medico

SELECT
pacientes.Nombres,
   pacientes.Apellidos,
   pacientes.Cedula,
   pacientes.Fecha_nacimiento,
   pacientes.Provincia,
   pacientes.Direccion,
   pacientes.canton,
   pacientes.Telefono,
   pacientes.NumCelular,
   Medico.Nombres as NombreDoctor,
   Medico.Apellidos as ApellidoDoctor,
   Medico.Especialidad,
    MotivosCitasMedicas.Servicio as Motivo_de_Cita,
	CostoServicios.Costos, 
	CostoServicios.Descuentos,
	Factura.Iva,
	Factura.Subtotal,
	Factura.Total
FROM
  Factura
  inner JOIN
   pacientes ON pacientes.ID_PACIENTE = Factura.ID_Paciente
   inner JOIN
   Medico ON Medico.ID_medico=Factura.ID_Medico
 inner JOIN
   MotivosCitasMedicas ON Factura.Motivo = MotivosCitasMedicas.IDMotivo
 inner JOIN
  CostoServicios ON CostoServicios.IDMCM = Factura.Motivo 
  WHERE pacientes.Cedula=0946584566;
	
