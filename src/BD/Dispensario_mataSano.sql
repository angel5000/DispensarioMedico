
use SQLADV

/*
---CREACION DE USUARIOS---
CREATE USER doctor1 IDENTIFIED BY 123456 default tablespace users;
CREATE USER paciente1 IDENTIFIED BY 123456 default tablespace users;*/

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
grant select,insert on citas_medicas to paciente1;
grant select,insert on paciente to paciente1;
grant select on medico to doctor1;
grant select on citas_medicas to doctor1;

----------------------------------------------


-------TABLAS------------


---------USUARIOS---------

create table Rol(
IDRol int PRIMARY KEY identity (100,1),
Rol varchar(50)

);
select *from Rol
insert into Rol(Rol) values('PACIENTE'),('MEDICO');


create table UsuariosMedico(
IDMedUsuario int PRIMARY KEY identity (1000,1),
ID_DatosUsuario int,
Usuario varchar(50)unique,
Rol int,
Activa char(1),
 Salt VARBINARY(32) NOT NULL,
 HashedContrasena VARBINARY(64) NOT NULL,
constraint Rolfkk2 FOREIGN KEY (Rol) REFERENCES Rol(IDRol),
 constraint Usuariomedfk FOREIGN KEY (ID_DatosUsuario) REFERENCES Medico(ID_medico)
);
DECLARE @Salt VARBINARY(32);
SET @Salt = CRYPT_GEN_RANDOM(32); 
DECLARE @Contraseña NVARCHAR(MAX);
SET @Contraseña = '123456';

INSERT INTO UsuariosMedico (ID_DatosUsuario, Usuario,Rol , Activa,Salt, HashedContrasena)
VALUES (
    135,
    'Luis1587',101,'A',
    @Salt,
    HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), @Salt) + @Contraseña)
);


SELECT*FROM Medico
select*from Rol
select*from  UsuariosMedico
create table UsuariosPaciente(
IDUsuario int PRIMARY KEY identity (100,1),
ID_DatosUsuario int,
Usuario varchar(50)unique,
Rol int,
Activa char(1),
 Salt VARBINARY(32) NOT NULL,
 HashedContrasena VARBINARY(64) NOT NULL,
constraint Rolfk FOREIGN KEY (Rol) REFERENCES Rol(IDRol),
constraint UsuarioPCTfk FOREIGN KEY (ID_DatosUsuario) REFERENCES pacientes(ID_PACIENTE)
);
delete from UsuariosMedico
DECLARE @Contraseña NVARCHAR(MAX);
SET @Contraseña = 'Angel123456';
 SELECT ID_DatosUsuario
    FROM UsuariosPaciente
    WHERE   HashedContrasena = HASHBYTES('SHA2_512', @Contraseña + CONVERT(nvarchar(32), Salt));

select *from UsuariosPaciente
delete from UsuariosPaciente

select *from HorariosCitas



DECLARE @Salt VARBINARY(32);
SET @Salt = CRYPT_GEN_RANDOM(32); 
DECLARE @Contraseña NVARCHAR(MAX);
SET @Contraseña = 'Angel123456';

INSERT INTO UsuariosPaciente (ID_DatosUsuario, Usuario,Rol , Activa,Salt, HashedContrasena)
VALUES (
    37,
    'Ang5000',100,'A',
    @Salt,
    HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), @Salt) + @Contraseña)
);

DECLARE @Contraseña NVARCHAR(MAX);
SET @Contraseña = 'Angel123456';

SELECT ID_DatosUsuario
FROM UsuariosPaciente
WHERE HashedContrasena = HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), Salt) + @Contraseña);





select*from Medico
select *from Rol
select*from Citas_Medicas
select*from UsuariosMedicos



select *from pacientes
select*from Rol
select*from UsuariosPaciente

DECLARE @Salt VARBINARY(32);
SET @Salt = CRYPT_GEN_RANDOM(32); 
DECLARE @Contraseña NVARCHAR(MAX);
SET @Contraseña = '123456';

INSERT INTO UsuariosPaciente (ID_DatosUsuario, Usuario,Rol , Activa,Salt, HashedContrasena)
VALUEs(46,'Fernangmz111',100,'A',
    @Salt,
    HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), @Salt) + @Contraseña));
	select*from Citas_Medicas
	select*from pacientes
	select*from HorariosCitas
	select*from Factura
	select*from PagosRealizados
	delete from PagosRealizados WHERE IdPaciente =37
	delete from Citas_Medicas where IDPaciente=37
	delete from Factura where ID_Paciente=37
insert into UsuariosPaciente(ID_DatosUsuario,Usuario,Contraseña,Rol,Activa ) 
values(38,,'123456',100,'S'),
(39,,'123456',100,'S'),
(40,,'123456',100,'S'),
(41,'123456',100,'S'),
(42,,'123456',100,'S'),
(43,'123456',100,'S'),
(44,'123456',100,'S'),
(45,'123456',100,'S'),
(46,'123456',100,'S');

-----------PACIENTES----------
drop table pacientes
create table pacientes(
ID_PACIENTE int PRIMARY KEY identity (001,1),
Cedula varchar(10) NOT NULL,
Nombres varchar(50)NOT NULL,
Apellidos varchar(50)NOT NULL,
Fecha_nacimiento varchar(10)NOT NULL,
Provincia varchar(50)NOT NULL,
canton varchar(50)NOT NULL,
Direccion varchar(50)NOT NULL,
NumCelular varchar(10)NOT NULL,
Genero varchar(100)NOT NULL,
CorreoElectronico varchar(100)NOT NULL,
Telefonoid int NOT NULL
);
/*alter table pacientes
add canton varchar(50);

select*from pacientes
alter table pacientes add Genero varchar(100)
alter table pacientes add CorreoElectronico varchar(100)
update pacientes set Direccion='Los vergeles, Coop. los vergeles Mz M s3' where ID_PACIENTE=38*/

----INGRESO DE DATOS PACIENTE
DELETE FROM pacientes
update pacientes set Telefonoid=1 where ID_PACIENTE =37
update pacientes set Telefonoid=2 where ID_PACIENTE =38
update pacientes set Telefonoid=3 where ID_PACIENTE =39
update pacientes set Telefonoid=4 where ID_PACIENTE =40
update pacientes set Telefonoid=5 where ID_PACIENTE =41

update pacientes set Telefonoid=6 where ID_PACIENTE =42
update pacientes set Telefonoid=7 where ID_PACIENTE =43
update pacientes set Telefonoid=8 where ID_PACIENTE =44
update pacientes set Telefonoid=9 where ID_PACIENTE =45
update pacientes set Telefonoid=10 where ID_PACIENTE =46
select*from Especialidad
ALTER TABLE Medico
add Especialidadid INT;

select *from Medico
-- Actualizar la nueva columna con los datos de la columna original
UPDATE Medico
SET Especialidadid = CAST(Especialidad AS INT);

-- Eliminar la columna original
update Medico SET Especialidadid=402 where ID_medico=126 

ALTER TABLE pacientes
DROP COLUMN Telefono;


alter table pacientes 
select*from pacientes
insert into  pacientes(Cedula,Nombres,Apellidos ,Fecha_nacimiento,Provincia,Direccion,NumCelular,canton, Genero, CorreoElectronico,Telefonoid )
values('0946584566', 'Angel David ', 'Vergara Paredes', '31/01/2000', 'Guayas', 'Prosperina, Mercado de la Prosperina', '0984659455', 'Guayaquil', 'M', 'angel.vergara@gmail.com',1),
    ('0985694588', 'David Alberto ', 'Paredes Perez', '24/04/1999', 'Guayas', 'Los vergeles, Coop. los vergeles Mz M s3',  '0954685666', 'Guayaquil', 'M', 'david.paredes@gmail.com',2),
    ('1718593209', 'Lucia Beatriz', 'Garcia Herrera', '08/09/1992', 'Guayas', 'Calle A No.23-45', '0987456321', 'Guayaquil', 'F', 'lucia.garcia@gmail.com',3),
    ('0914761293', 'Pedro Andres', 'Martinez Sanchez', '12/05/1985', 'Guayas', 'Avenida B No.34-12',  '0987123456', 'Guayaquil', 'M', 'pedro.martinez@gmail.com',4),
    ('1301876512', 'Maria Raquel ', 'Paz Torres', '03/12/1976', 'Guayas', 'Calle C No.12-34',  '0998456789', 'Guayaquil', 'F', 'maria.paz@gmail.com',5),
    ('1718645203', 'Andres Javier', 'Alvarado Lopez', '25/06/1990', 'Guayas', 'Avenida D No.45-67',  '0967452314', 'Guayaquil', 'M', 'andres.alvarado@gmail.com',6),
    ('0913758294', 'Sofia Julia', 'Vasquez Jimenez', '14/10/1987', 'Santa Elena', 'Calle E No.56-78',  '0987321567', 'Salinas', 'F', 'sofia.vasquez@gmail.com',7),
    ('0996548265', 'Juan Daniel', 'Flores Garcia', '28/02/1986', 'Santa Elena', 'Avenida F No.67-89', '0997456321', 'La libertad', 'M', 'juan.flores@gmail.com',8),
    ('0986554852', 'Carla Silvia', 'Barrera Vargas', '16/07/1983', 'Santa Elena', 'Calle G No.78-90',  '0967452314', 'Santa Elena', 'F', 'carla.barrera@gmail.com',9),
    ('0956842548', 'Fernando Pedro', 'Gomez Torres', '29/11/1991', 'Santa Elena', 'Avenida H No.89-12',  '0987321567', 'La libertad', 'M', 'fernando.gomez@gmail.com',10);

	select*from TelefonosPacientes
	create TABLE TelefonosPacientes (
    ID_Telefono INT PRIMARY KEY  identity (1,1),
    ID_Paciente INT,
    NumeroTelefono VARCHAR(14),
    constraint numpcfk FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente)
);
insert into TelefonosPacientes(ID_Paciente ,NumeroTelefono)
values(37,'044541268'),
    (38,'041236845'),
    ( 39,'049685748'),
    (40,'049996874'),
    ( 41,'041368588'),
    (42,'0248695522'),
    (43,'027496684'),
    (44,'024856987'),
    ( 45,'0478863548'),
    (46,'045568135');
	insert into TelefonosPacientes(ID_Paciente ,NumeroTelefono)
values(46,'026338777');
insert into TelefonosPacientes(ID_Paciente ,NumeroTelefono)
values(47,'026985977');

-------TABLAS MEDICO-------

create table Medico(
ID_medico INT PRIMARY KEY identity (0001,1),
CodigoMedico varchar(100) NOT NULL,
Cedula varchar(10)NOT NULL,
Nombres varchar(50)NOT NULL,
Apellidos varchar(50)NOT NULL,
Especialidad varchar(100)NOT NULL,
Telefono varchar(10)NOT NULL,
NumCelular varchar(10)NOT NULL,
DireccionDomicilio varchar(100)NOT NULL,
UbicacionDisp int NOT NULL,
Genero char(1)NOT NULL,
CorreoElectronico varchar(100)NOT NULL,
constraint Ubicafk FOREIGN KEY (UbicacionDisp) REFERENCES Ubicacion(IDUbicacion)
);
/*
alter table Medico add CorreoElectronico varchar(100)
select*from Medico
delete from Medico
select*from Ubicacion*/
/*delete from Medico*/
select*from medico

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
INSERT INTO citas_medicas (IDPaciente,IDMedico,IDHorarioCitas,Motivo) 
VALUES 
( 40, 135,  19, null);
select*from Citas_Medicas
delete from Citas_Medicas where IDCita=8

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

select *from MotivosCitasMedicas
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

INSERT INTO MotivosCitasMedicas (especialiMed ,Servicio) 
VALUES 
( 402, 'Consulta General'),
( 402, 'Examenes Ginecologicos'),
( 402, 'Control y Asesoramientos'),
( 402, 'Colocación y Retiro de Dispositivos Intrauterinos (DIU)'),
( 402, 'Evaluacion de la Infertilidad'),
( 402, 'Prevención y Detección del Cancer de Mama:');

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
Sector varchar(20) not null,
Direccion varchar(150) not null

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
select*from MotivosCitasMedicas
select *from Areas
INSERT INTO citas_medicas (IDPaciente,IDMedico,IDHorarioCitas,Motivo) 
VALUES 
( 37, 135,  15, 71),
(38, 136,  17, 72);
update Citas_Medicas set Motivo=81 where IDCita=6

SELECT*FROM pacientes
INSERT INTO citas_medicas (IDPaciente,IDMedico,IDHorarioCitas,Motivo) 
VALUES 
( 39, 137,  19, 71),
(40, 136,  20, 71),
( 41, 135,  18, 71);




-----------DATOS CITAS MEDICAS-------------


select*from Citas_Medicas;

create table EstadoHoraCitas(
ID_Estadhocita INT PRIMARY KEY identity (001,1),
Disponibilidad varchar(50)

);
insert into EstadoHoraCitas (Disponibilidad) 
values('Disponible'),
('Ocupado'),
('Terminado')
create table HorariosCitas(
ID_HORARIO  INT PRIMARY KEY identity (0001,1),
ID_Doctor int,
Areas int,
FechaHora datetime,
Disponibeid int,
 constraint MEDICoFK FOREIGN KEY (ID_Doctor) REFERENCES Medico(ID_Medico),
constraint Areahfk FOREIGN KEY (Areas) REFERENCES Areas(ID_Areas)
alter table HorariosCitas add constraint Disponifk FOREIGN KEY (Disponibeid) REFERENCES EstadoHoraCitas(ID_Estadhocita)
);

select*from MotivosCitasMedicas
select*from HorariosCitas 



select*from EstadoHoraCitas
select*from HorariosCitas
update HorariosCitas set Disponibeid=1 where Disponibilidad='S';
		SELECT 
        m.Nombres+' '+ m.Apellidos as Doctor,
		m.Especialidad,
        HC.FechaHora,
        HC.Disponibilidad,
       A.Habitacion,
       U.Sector,
       U.Direccion
    FROM 
        HorariosCitas HC
    INNER JOIN 
       Areas A ON HC.Areas = A.ID_Areas
	    INNER JOIN 
       Medico m ON HC.ID_Doctor = m.ID_medico
    INNER JOIN 
      Ubicacion U ON M.UbicacionDisp=U.IDUbicacion
	 
    WHERE 
        HC.Disponibilidad ='S'and u.Sector='NORTE' AND M.Especialidad='Medicina General';

		select * FROM Medico
		select*from MotivosCitasMedicas
/*
delete from HorariosCitas
SELECT*FROM HorariosCitas
select*from Medico*/
/*
insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(19,1,'12/11/23 16:30','S'),(20,2,'15/11/23 11:30','S'),(21,4,'19/11/23 13:00','S')
,(22,5,'22/11/23 11:00','S'),(23,3,'18/11/23 10:30','S');*/
select*from HorariosCitas
select*from EstadoHoraCitas
select*from Citas_Medicas
update HorariosCitas set Disponibeid=1 WHERE ID_HORARIO=18
insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(126,28,'21/11/23 07:30','S'),(127,29,'21/11/23 16:30','S')
,(130,32,'22/11/23 16:30','S'),
(135,33,'22/11/23 11:30','S'),(132,35,'22/11/23 13:00','S')
,(136,34,'23/11/23 11:00','S');


insert into HorariosCitas (ID_Doctor,Areas ,FechaHora,Disponibilidad) 
values(135,33,'22/11/23 13:00','S'),(137,35,'22/11/23 15:00','S')
,(136,37,'22/11/23 9:00','S');


delete from HorariosCitas where ID_HORARIO =11

create table Areas(
ID_Areas INT PRIMARY KEY identity (0001,1),
ID_Doctor int not null,
Habitacion varchar(10),
Ubicacionarea  int,
 constraint MEDICoFK2 FOREIGN KEY (ID_Doctor) REFERENCES Medico(ID_Medico)
 constraint areaubifk FOREIGN KEY (Ubicacionarea) REFERENCES Ubicacion(IDUbicacion)
);
ALTER TABLE 
/*
select*from Medico
delete from Areas
SELECT*FROM Areas*/
select*from Ubicacion

insert into Areas (ID_Doctor ,Habitacion, Ubicacionarea ) 
values(126,'A12',200),(127,'A13',201),(128,'B14',202),(129,'A15',200),(130,'D16',203),(135,'A17',200),
(136,'C18',201),(132,'B19',202),(131,'C20',201);
update Areas set Habitacion ='D16'where ID_Areas =32

insert into Areas (ID_Doctor ,Habitacion, Ubicacionarea ) 
values(137,'D18',203);

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
   alter table Historial_Medico add constraint Citafk FOREIGN KEY (FechaVisita) REFERENCES HorariosCitas(ID_Horario)
);
delete from Historial_Medico
SELECT*FROM Historial_Medico
-- Ingresar datos en la tabla de Pacientes

SELECT
 pacientes.Apellidos+''+pacientes.Nombres AS NombreCompleto,
    Medico.Apellidos+' '+Medico.Nombres AS Medico,
    Historial_Medico.Sintomas,
    Historial_Medico.Diagnostico,
    Historial_Medico.Tratamiento,
    Historial_Medico.Receta,
	HorariosCitas.FechaHora AS FechaCitaMedica

FROM
    Historial_Medico
INNER JOIN
    Pacientes ON Historial_Medico.ID_Paciente = Pacientes.ID_Paciente
INNER JOIN
    Medico ON Historial_Medico.ID_Medico = Medico.ID_Medico
	
inner join HorariosCitas on HorariosCitas.ID_HORARIO=Historial_Medico.FechaVisita
where Historial_Medico.ID_Paciente=37

SELECT*FROM HorariosCitas
SELECT*FROM Citas_Medicas
select*from Medico
select*from pacientes
delete from Citas_Medicas where IDPaciente=40
INSERT INTO Historial_Medico (   ID_Paciente,ID_Medico,FechaVisita,Sintomas, Diagnostico,Tratamiento,Receta) 
VALUES 
( 37, 135, 15, 'LE DUELE EL ESTOMAGO', 'DIARREA', 'CUIDADO ESTOMACAL', 'SUERO ORAL');


INSERT INTO Historial_Medico (   ID_Paciente,ID_Medico,FechaVisita,Sintomas, Diagnostico,Tratamiento,Receta) 
VALUES 
( 38, 136, 17, 'DOLOR DE GARGANTA, ESTORNUDO, TOS, LAGRIMEO', 'RESFRIADO COMUN', 
'USO DE ANTIBIOTICOS, ANTIGRIPALES', 'PARACETAMOL, LEMONFLU, TUSOLVINA FORTE');

INSERT INTO Historial_Medico (ID_Paciente, ID_Medico, FechaVisita, Sintomas, Diagnostico, Tratamiento, Receta)
VALUES
(39, 137, 19, 'FIEBRE, DOLOR DE CABEZA, FATIGA', 'GRIPE', 'REPOSO, HIDRATACIÓN', 'IBUPROFENO, VITAMINA C'),
(40, 136, 20, 'MAREOS, NAUSEAS, VOMITOS', 'GASTROENTERITIS', 'DIETA BLANDA, HIDRATACIÓN', 'DOMPERIDONA, SALES DE REHIDRATACIÓN'),
(41, 135, 18, 'DOLOR ABDOMINAL, DIARREA', 'INFECCIÓN INTESTINAL', 'ANTIBIÓTICOS, REPOSO', 'CIPROFLOXACINO, PROBIÓTICOS');
(42, 140, 21, 'DOLOR EN EL PECHO, PALPITACIONES', 'ARRITMIA CARDÍACA', 'MEDICACIÓN ANTIARRÍTMICA', 'DIGOXINA, AMIODARONA'),
(43, 141, 22, 'DOLOR ARTICULAR, HINCHAZÓN', 'ARTROSIS', 'FISIOTERAPIA, ANALGÉSICOS', 'PARACETAMOL, DICLOFENACO');












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
 ID_Paciente INT NOT NULL,
 ID_Medico INT NOT NULL,
FechaVisita INT NOT NULL,
Motivo int NOT NULL,
 Iva float NOT NULL,
 Subtotal float NOT NULL,
 Total float NOT NULL,
 costo float,
 constraint pcientefk2 FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente),
 constraint mediccofk2 FOREIGN KEY (ID_Medico) REFERENCES Medico(ID_Medico),
 constraint Citafk2 FOREIGN KEY (FechaVisita) REFERENCES HorariosCitas(ID_HORARIO),
 constraint Motivofk FOREIGN KEY (motivo) REFERENCES MotivosCitasMedicas(IDMotivo),
 
);
alter tablE Factura  add 
/*delete from Factura
alter table factura add Iva float
select *from Factura
select*from HorariosCitas
select*from Citas_Medicas
select*from CostoServicios*/
insert into Factura (ID_Paciente,ID_Medico,FechaVisita,Motivo,Costo,Iva ,Subtotal,Total)
values(37,135,15,71,8,0,5.00,5.00);

insert into Factura (ID_Paciente,ID_Medico,FechaVisita,Motivo,Costo,Iva ,Subtotal,Total)
values(38,136,17,71,8,0,5.00,5.00);

insert into Factura (ID_Paciente,ID_Medico,FechaVisita,Motivo,Costo,Iva ,Subtotal,Total)
values(39,137,19,71,8,0,5.00,5.00);

insert into Factura (ID_Paciente,ID_Medico,FechaVisita,Motivo,Costo,Iva ,Subtotal,Total)
values(40,136,20,71,8,0,5.00,5.00);

insert into Factura (ID_Paciente,ID_Medico,FechaVisita,Motivo,Costo,Iva ,Subtotal,Total)
values(41,135,18,71,8,0,5.00,5.00);
select*from Medico

SELECT
pacientes.Nombres,
   pacientes.Apellidos,
   pacientes.Cedula,
   pacientes.Fecha_nacimiento,
   pacientes.Provincia,
   pacientes.Direccion,
   pacientes.canton,
   pacientes.NumCelular,
   Medico.Nombres as NombreDoctor,
   Medico.Apellidos as ApellidoDoctor,
   Medico.Especialidad,
    MotivosCitasMedicas.Servicio as Motivo_de_Cita,
	CostoServicios.Costos, 
	CostoServicios.Descuentos,
	Factura.Iva,
	Factura.Subtotal,
	Factura.Total,
	Factura.ID_Factura
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
  WHERE pacientes.ID_PACIENTE=37;

  select*from MetodoPago
	create table MetodoPago(
	ID_MetPago INT PRIMARY KEY identity (0300,1),
	Metodo varchar(60)
	);
	insert into MetodoPago (Metodo) 
	values('Tarjeta de Debito'),
	('PayPal'),
	('Transferencia Bancaria'),
   ('Tarjeta de Credito');
   select*from MetodoPago
	create table PagosRealizados(
	ID_MetPago INT PRIMARY KEY identity (4000,1),
	IdPaciente int,
	idMotivo int,
	idMetodoPago int ,
	 constraint pcintefk2 FOREIGN KEY (IdPaciente) REFERENCES Pacientes(ID_Paciente),
  constraint Metodopg FOREIGN KEY (idMetodoPago) REFERENCES MetodoPago(ID_MetPago)
	);
	insert into PagosRealizados (IdPaciente,idMetodoPago)
values(37,300);
DELETE FROM PagosRealizados WHERE ID_MetPago=4000
select*from PagosRealizados