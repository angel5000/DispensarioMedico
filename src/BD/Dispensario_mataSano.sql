
use SQLADV

/*
---CREACION DE USUARIOS---
CREATE USER doctor1 IDENTIFIED BY 123456 default tablespace users;
CREATE USER paciente1 IDENTIFIED BY 123456 default tablespace users;*/

--CREACION DE ROLES----
/*create role medicos;
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
grant select on paciente to doctor1;*/
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
Direccion varchar(50),
Telefono varchar(10),
NumCelular varchar(10),
Genero varchar(100),
CorreoElectronico varchar(100),
);
/*alter table pacientes
add canton varchar(50);

select*from pacientes
alter table pacientes add Genero varchar(100)
alter table pacientes add CorreoElectronico varchar(100)
update pacientes set Direccion='Los vergeles, Coop. los vergeles Mz M s3' where ID_PACIENTE=38*/

----INGRESO DE DATOS PACIENTE
insert into  pacientes(Cedula,Nombres,Apellidos ,Fecha_nacimiento,Provincia,Direccion,Telefono,NumCelular,canton, Genero, CorreoElectronico )
values('0946584566', 'Angel David ', 'Vergara Paredes', '31/01/2000', 'Guayas', 'Prosperina, Mercado de la Prosperina', '044541268', '0984659455', 'Guayaquil', 'M', 'angel.vergara@gmail.com'),
    ('0985694588', 'David Alberto ', 'Paredes Perez', '24/04/1999', 'Guayas', 'Los vergeles, Coop. los vergeles Mz M s3', '041236845', '0954685666', 'Guayaquil', 'M', 'david.paredes@gmail.com'),
    ('1718593209', 'Lucia Beatriz', 'Garcia Herrera', '08/09/1992', 'Guayas', 'Calle A No.23-45', '049685748', '0987456321', 'Guayaquil', 'F', 'lucia.garcia@gmail.com'),
    ('0914761293', 'Pedro Andres', 'Martinez Sanchez', '12/05/1985', 'Guayas', 'Avenida B No.34-12', '049996874', '0987123456', 'Guayaquil', 'M', 'pedro.martinez@gmail.com'),
    ('1301876512', 'Maria Raquel ', 'Paz Torres', '03/12/1976', 'Guayas', 'Calle C No.12-34', '041368588', '0998456789', 'Guayaquil', 'F', 'maria.paz@gmail.com'),
    ('1718645203', 'Andres Javier', 'Alvarado Lopez', '25/06/1990', 'Guayas', 'Avenida D No.45-67', '0248695522', '0967452314', 'Guayaquil', 'M', 'andres.alvarado@gmail.com'),
    ('0913758294', 'Sofia Julia', 'Vasquez Jimenez', '14/10/1987', 'Santa Elena', 'Calle E No.56-78', '027496684', '0987321567', 'Salinas', 'F', 'sofia.vasquez@gmail.com'),
    ('0996548265', 'Juan Daniel', 'Flores Garcia', '28/02/1986', 'Santa Elena', 'Avenida F No.67-89', '024856987', '0997456321', 'La libertad', 'M', 'juan.flores@gmail.com'),
    ('0986554852', 'Carla Silvia', 'Barrera Vargas', '16/07/1983', 'Santa Elena', 'Calle G No.78-90', '0478863548', '0967452314', 'Santa Elena', 'F', 'carla.barrera@gmail.com'),
    ('0956842548', 'Fernando Pedro', 'Gomez Torres', '29/11/1991', 'Santa Elena', 'Avenida H No.89-12', '045568135', '0987321567', 'La libertad', 'M', 'fernando.gomez@gmail.com');




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
DireccionDomicilio varchar(100),
UbicacionDisp int,
Genero char(1),
CorreoElectronico varchar(100),
constraint Ubicafk FOREIGN KEY (UbicacionDisp) REFERENCES Ubicacion(IDUbicacion)
);
/*
alter table Medico add CorreoElectronico varchar(100)
select*from Medico
delete from Medico
select*from Ubicacion*/
/*delete from Medico*/

------INGRESO USUARIO MEDICO----
insert into  medico (CodigoMedico,Cedula,Nombres,Apellidos, Especialidad,NumCelular,Telefono,DireccionDomicilio,UbicacionDisp,Genero,CorreoElectronico )
values('DCG1500', '0948654881', 'Jose Carlos', 'Aguilera Ramirez', 'Ginecologo', '0946854558', '046958455', 'Prosperina, la 38 Mz 1 s4', 200, 'M', 'jose.carlos@gmail.com'),
    ('DCFS501', '0984685540', 'Sofia Ana', 'Lopez Martinez', 'Cardiologo', '0987456321', '048469522', 'Gallegos Lara, El condor Mz 99 s12', 201, 'F', 'sofia.ana@gmail.com'),
    ('DCR1502', '0978458515', 'Andres Juan', 'Garcia Martinez', 'Pediatra', '0987123456', '045896622', 'Cristo del Consuelo, Callejon H2 A Mz 87 s66', 202, 'M', 'andres.juan@gmail.com'),
    ('DCFS503', '0948556488', 'Maria Laura', 'Paz Garcia', 'Dermatologo', '0998456789', '043336555', 'Juan Montalvo, Calle Juan venitez Mz 44 s2', 200, 'F', 'maria.laura@gmail.com'),
    ('DCE1504', '0948456844', 'Carlos Luis', 'Mora Gonzalez', 'Oncologo', '0967452314', '048974555', 'AV. Ferroviaria, Calle Eloy Alfaro C Mz 10 s13', 203, 'M', 'carlos.luis@gmail.com'),
    ('DCDF505', '0948458666', 'Ana Isabel', 'Salazar Lopez', 'Neurologo', '0987321567', '043364849', '9 de Octubre, Calle principal D Mz 12 s6', 201, 'F', 'ana.isabel@gmail.com'),
    ('DCGT506', '1244685488', 'Juan Alberto', 'Flores Perez', 'Endocrinologo', '0997456321', '047784632', 'Guasmo sur, Calle principal E Mz 34 sA', 202, 'M', 'juan.alberto@gmail.com'),
    ('DCR5784', '0948564855', 'Carla Laura', 'Barrera Garcia', 'Gastroenterologo', '0967452314', '041246977', 'Isla trinitaria, Calle principal A Mz 9 s44', 201, 'F', 'carla.laura@gmail.com'),
    ('DCX1468', '0944485688', 'Fernando Jose', 'Gomez Rodriguez', 'Traumatologo', '0987321567', '041112485', 'Bastion Popular, Bloque 3 A Mz 1 s22', 201, 'M', 'fernando.jose@gmail.com'),
    ('DCX1587', '0944485688', 'Luis Miguel', 'Castro Fernandez', 'Medicina General', '0987321567', '044864885', 'Bastion Popular, Bloque 1B s22', 200, 'M', 'luis.miguel@gmail.com'),
    ('DCX1552', '0944485689', 'Maria Maria', 'Lopez Rodriguez', 'Medicina General', '0987321568', '044582486', 'Flor de Bastion, Bloque 1A s23', 201, 'F', 'maria.maria@gmail.com'),
    ('DCX1548', '0944485690', 'Carlos Andres', 'Perez Sanchez', 'Medicina General', '0987321569', '0448622487', 'Bastion Popular, Bloque 1C s24', 203, 'M', 'carlos.andres@gmail.com');
INSERT INTO medico (CodigoMedico, Cedula, Nombres, Apellidos, Especialidad, NumCelular, Telefono, DireccionDomicilio,UbicacionDisp,Genero,CorreoElectronico)
VALUES
   ('DCG1601', '0948654999', 'Laura Carolina', 'Martinez Perez', 'Ginecologo', '0946001122', '046958400', 'Alborada, la 40 Mz 1 s4', 200, 'F', 'laura.carolina@gmail.com'),
    ('DCFS602', '0984005540', 'Martin Javier', 'Gomez Lopez', 'Cardiologo', '0987485698', '048448569', 'Garzota, El condor Mz 99 s12', 201, 'M', 'martin.javier@gmail.com'),
    ('DCR1623', '0948633299', 'Isabel Paula', 'Garcia Fernandez', 'Pediatra', '0987486855', '0456984552', 'Urb. Kennedy, Callejon H4 A Mz 87 s66', 202, 'F', 'isabel.paula@gmail.com'),
    ('DCFS614', '0948111222', 'Carlos Daniel', 'Ruiz Garcia', 'Dermatologo', '0998987444', '043311144', 'Alborada, Calle Juan venitez Mz 44 s2', 203, 'M', 'carlos.daniel@gmail.com'),
    ('DCE1665', '0946846985', 'Elena Elena', 'Mora Gonzalez', 'Oncologo', '0967369888', '047895632', 'AV. Olmedo, Calle Eloy Alfaro C Mz 10 s13', 200, 'F', 'elena.elena@gmail.com'),
    ('DCDF686', '0945684587', 'Santiago Pedro', 'Salazar Torres', 'Neurologo', '0987854862', '04356845', 'Alborada, Calle principal D Mz 12 s6', 201, 'M', 'santiago.pedro@gmail.com'),
    ('DCGT657', '1216988745', 'Diana Patricia', 'Flores Sanchez', 'Endocrinologa', '0998545866', '047123654', 'Urb. Kennedy, Calle principal z Mz 35 sA2', 203, 'F', 'diana.patricia@gmail.com'),
    ('DCR6280', '0986987455', 'Pedro Pablo', 'Barrera Diaz', 'Gastroenterologo', '0967785881', '041223695', 'Alborada, Calle principal b Mz 10 s44', 202, 'M', 'pedro.pablo@gmail.com'),
    ('DCX1659', '0913666840', 'Gabriela Clara', 'Gomez Ramirez', 'Traumatologa', '0984785692', '041489874', 'AV. Olmedo, Mz 2 s1', 202, 'F', 'gabriela.clara@gmail.com');

  INSERT INTO medico (CodigoMedico, Cedula, Nombres, Apellidos, Especialidad, NumCelular, Telefono, DireccionDomicilio,UbicacionDisp,Genero,CorreoElectronico)
VALUES

 ('DCG1701', '0968654999', 'Laura Sandra', 'Martinez Diaz', 'Ginecologo', '0946001122', '046958400', 'Alborada, la 38 Mz 1 s4', 203, 'F', 'laura.sandra@gmail.com'),
    ('DCG1702', '0948654881', 'Jose Ricardo', 'Aguilera Herrera', 'Ginecologo', '0946854558', '046958455', 'Prosperina, la 38 Mz 1 s4', 201, 'M', 'jose.ricardo@gmail.com'),
    ('DCG1703', '0978663599', 'Gabriela Adriana', 'Ramirez Castro', 'Ginecologo', '0999697111', '043548966', 'Sauces, Calle principal G Mz 5 s19', 200, 'F', 'gabriela.adriana@gmail.com'),

    ('DCFS702', '0984005540', 'Martin Fernando', 'Gomez Jimenez', 'Odontologo', '0987468566', '044685966', 'Garzota, El condor Mz 99 s12', 202, 'M', 'martin.fernando@gmail.com'),
    ('DCFS703', '0948556488', 'Maria Raquel', 'Paz Torres', 'Odontologo', '0998456789', '043336555', 'Juan Montalvo, Calle Juan venitez Mz 44 s2', 203, 'F', 'maria.raquel@gmail.com'),
    ('DCFS704', '0996364486', 'Carlos Alejandro', 'Ruiz Vargas', 'Odontologo', '0998987458', '043311148', 'Alborada, Calle Juan venitez Mz 44 s2', 200, 'M', 'carlos.alejandro@gmail.com'),

    ('DCR1802', '0978458515', 'Andres Sergio', 'Garcia Medina', 'Odontologo', '0987123456', '045896622', 'Cristo del Consuelo, Callejon H2 A Mz 87 s66', 201, 'M', 'andres.sergio@gmail.com'),
    ('DCR1803', '0978000000', 'Isabel Julia', 'Garcia Jimenez', 'Odontologo', '0987135221', '049684477', 'Urb. Kennedy, Callejon H2 A Mz 87 s66', 201, 'F', 'isabel.julia@gmail.com'),
    ('DCR1804', '0948456844', 'Carlos Diego', 'Mora Ruiz', 'Odontologo', '0967452314', '048974555', 'AV. Ferroviaria, Calle Eloy Alfaro C Mz 10 s13', 202, 'M', 'carlos.diego@gmail.com'),

    ('DCFS904', '0948453222', 'Carlos Pedro', 'Ruiz Torres', 'Dermatologo', '0998984666', '043313189', 'Alborada, Calle Juan venitez Mz 44 s2', 203, 'M', 'carlos.pedro@gmail.com'),
    ('DCFS903', '0948512488', 'Maria Silvia', 'Paz Vargas', 'Medicina Genral', '0998456789', '049485555', 'Juan Montalvo, Calle Juan venitez Mz 44 s2', 200, 'F', 'maria.silvia@gmail.com'),
    ('DCFS905', '0948369777', 'Raul Alejandro', 'Fernandez Vargas', 'Medicina General', '0988111222', '049684555', 'Samborondón, Calle principal D Mz 8 s32', 200, 'M', 'raul.alejandro@gmail.com'),
    ('DCE1224', '0948456844', 'Carlos Francisco', 'Mora Molina', 'Medicina General', '0967452314', '048974555', 'AV. Ferroviaria, Calle Eloy Alfaro C Mz 10 s13', 200, 'M', 'carlos.francisco@gmail.com'),
    ('DCE1225', '0948456333', 'Elena Alejandra', 'Mora Ortiz', 'Medicina General', '0967631485', '048964788', 'AV. Olmedo, Calle Eloy Alfaro C Mz 10 s13', 201, 'F', 'elena.alejandra@gmail.com'),
    ('DCE1226', '0948639888', 'Juan Raul', 'Cruz Ortiz', 'Odontologo', '0998487664', '044685555', 'Urdesa, Calle principal E Mz 30 s14', 203, 'M', 'juan.raul@gmail.com'),
 
    ('DCDF335', '0988458666', 'Ana Natalia', 'Salazar Ruiz', 'Neurologo', '0987321567', '043364849', '9 de Octubre, Calle principal D Mz 12 s6', 203, 'F', 'ana.natalia@gmail.com'),
    ('DCDF336', '0958125444', 'Santiago Antonio', 'Salazar Castro', 'Neurologo', '0987139582', '043322200', 'Alborada, Calle principal D Mz 12 s6', 203, 'M', 'santiago.antonio@gmail.com'),
    ('DCDF337', '0968788999', 'Eva Rosa', 'Gomez Molina', 'Neurologo', '0968698744', '049684586', 'Ceibos, Calle principal F Mz 15 s9', 200, 'F', 'eva.rosa@gmail.com'),

    ('DCR507', '0948564855', 'Carla Patricia', 'Barrera González', 'Gastroenterologo', '0967452314', '041246977', 'Isla trinitaria, Calle principal F Mz 10 s2', 202, 'F', 'carla.patricia@gmail.com'),
    ('DCR508', '0948123555', 'Pedro Guillermo', 'Barrera Lopez', 'Gastroenterologo', '0967964851', '046987777', 'Alborada, Calle principal x Mz 10 s4', 200, 'M', 'pedro.guillermo@gmail.com'),
    ('DCR509', '0948136988', 'Monica Veronica', 'Lopez Medina', 'Gastroenterologa', '0998111666', '041211122', 'Ceibos, Calle principal D Mz 2 s20', 200, 'F', 'monica.veronica@gmail.com');



---------TABLA CITAS MEDICAS------
create table Citas_Medicas (
IDCita  INT PRIMARY KEY identity (0001,1),
IDPaciente INT  not null,
IDMedico INT not null,
IDHorarioCitas INT not null,
Motivo int,
 constraint pcientffk FOREIGN KEY (IDPaciente) REFERENCES pacientes(ID_Paciente),
 constraint medicfk FOREIGN KEY (IDMedico) REFERENCES Medico(ID_Medico),
 constraint motivfk FOREIGN KEY (Motivo) REFERENCES MotivosCitasMedicas(IDMotivo),
constraint horariocitafk FOREIGN KEY (IDHorarioCitas) REFERENCES HorariosCitas(ID_HORARIO)
);
/*delete from Citas_Medicas
select*from MotivosCitasMedicas

alter table Citas_Medicas add  Motivo int
update Citas_Medicas set Motivo=2 where IDCita=2*/
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


create table Especialidad(
IDEspecialidad INT PRIMARY KEY identity (0400,1),
Especialidad varchar(150)

);
INSERT INTO Especialidad (Especialidad) 
VALUES 
('Medicina General'),
('Odontologia'),
('Ginecologo'),
('Pediatra'),
('Gastroenterologo');

create table MotivosCitasMedicas(
IDMotivo INT PRIMARY KEY identity (0001,1),
Servicio varchar(150),
especialiMed int,
constraint espicalfk FOREIGN KEY (especialiMed) REFERENCES Especialidad(IDEspecialidad)
);


/*
alter table MotivosCitasMedicas drop column IDMedico
delete from MotivosCitasMedicas
select*from Especialidad
select*from Medico where Especialidad='Medicina General'
select*from MotivosCitasMedicas*/
INSERT INTO MotivosCitasMedicas (especialiMed ,Servicio) 
VALUES 
( 401, ' Consulta General'),
( 401, 'Exámenes y Diagnóstico'),
( 401, 'Limpiezas Dentales'),
( 401, 'Extracciones Dentales'),
( 401, 'Procedimientos de Endodoncia'),
( 401, 'Prótesis Dentales');



create table CostoServicios(
IDCostServi INT PRIMARY KEY identity (001,1),
IDMCM INT,
Costos Float,
Descuentos Float,
constraint Motivosfk FOREIGN KEY (IDMCM) REFERENCES MotivosCitasMedicas(IDMotivo)

);
/*delete from CostoServicios
select*from CostoServicios
select*from MotivosCitasMedicas*/
INSERT INTO CostoServicios (IDMCM  ,Costos,Descuentos) 
VALUES 
( 71,5.00,0 ),
( 72,7.00,0 ),
( 73,30.00,0.05 ),
( 74,15.00,0 ),
( 75,7.00,0 ),
( 76,15.00,0.1 ),
( 77,20.00,0.07 );

create table Ubicacion(
IDUbicacion INT PRIMARY KEY identity (0200,1),
Sector varchar(20),
Direccion varchar(150)

);

INSERT INTO Ubicacion (Sector,Direccion) 
VALUES 
( 'Norte','UDERDESA, AV. Victor Emilio Estrada 707 y Ficus'),
( 'Norte','KENNEDY, AV. Orellana SN'),

( 'SUR','URDANETA, Garay Medardo Angel Silva 723 y Victor'),
( 'SUR','Guasmo sur, Coop. Reina del Quinche 2');
/*
alter table citas_medicas
alter table citas_medicas drop column CodigoCita
SELECT*FROM pacientes
SELECT*FROM Medico
select*from MotivosCitasMedicas
SELECT*FROM Citas_Medicas
select*from HorariosCitas*/
INSERT INTO citas_medicas (IDPaciente,IDMedico,IDHorarioCitas,Motivo) 
VALUES 
( 37, 135,  9, 71),
(38, 136,  11, 72);


-----------DATOS CITAS MEDICAS-------------


select*from Citas_Medicas;


create table HorariosCitas(
ID_HORARIO  INT PRIMARY KEY identity (0001,1),
ID_Doctor int,
Areas int,
FechaHora datetime,
Disponibilidad char(1),
 constraint MEDICoFK FOREIGN KEY (ID_Doctor) REFERENCES Medico(ID_Medico)

);/*
delete from HorariosCitas
SELECT*FROM HorariosCitas
select*from Medico*/
/*
insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(19,1,'12/11/23 16:30','S'),(20,2,'15/11/23 11:30','S'),(21,4,'19/11/23 13:00','S')
,(22,5,'22/11/23 11:00','S'),(23,3,'18/11/23 10:30','S');*/

insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(126,10,'21/11/23 07:30','S'),(127,11,'21/11/23 16:30','S')
,(130,14,'22/11/23 16:30','S'),
(135,15,'22/11/23 11:30','S'),(132,17,'22/11/23 13:00','S')
,(136,16,'23/11/23 11:00','S');



create table Areas(
ID_Areas INT PRIMARY KEY identity (0001,1),
ID_Doctor int not null,
Habitacion varchar(10),
 constraint MEDICoFK2 FOREIGN KEY (ID_Doctor) REFERENCES Medico(ID_Medico)
);
/*
select*from Medico
delete from Areas
SELECT*FROM Areas*/
insert into Areas (ID_Doctor ,Habitacion ) 
values(126,'A12'),(127,'A13'),(128,'A14'),(129,'A15'),(130,'A16'),(135,'A17'),
(136,'A18'),(132,'A19'),(131,'A20');



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
delete from Historial_Medico
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
select*from Medico


INSERT INTO Historial_Medico (   ID_Paciente,ID_Medico,FechaVisita,Sintomas, Diagnostico,Tratamiento,Receta) 
VALUES 
( 37, 135, 3, 'LE DUELE EL ESTOMAGO', 'DIARREA', 'CUIDADO ESTOMACAL', 'SUERO ORAL');
/*( 'Ana', 'García', '1990-08-15', 'Femenino', 'Urdesa Central', '234567890', 'ana.garcia@email.com'),
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
('Camila', 'Molina', '1995-07-18', 'Femenino', 'Urdesa Central', '012345678', 'camila.molina@email.com');*/
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
/*delete from Factura
alter table factura add Iva float
select *from Factura
select*from HorariosCitas
select*from Citas_Medicas
select*from CostoServicios*/
insert into Factura (ID_Paciente,ID_Medico,FechaVisita,Motivo,Costo,Iva ,Subtotal,Total)
values(37,135,9,71,8,0,5.00,5.00);
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
	
