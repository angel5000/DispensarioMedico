
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
drop table paciente
create table paciente(
identificacion varchar(10) NOT NULL,
nombres varchar(50),
apellidos varchar(50),
fecha_nacimiento varchar(10),
provincia varchar(50),
codigo_postal varchar(5),
direccion varchar(50),
telefono varchar(10)
);



----INGRESO DE DATOS PACIENTE
insert into  paciente (identificacion,nombres,apellidos, fecha_nacimiento,provincia,codigo_postal,direccion,telefono )
values('0946584566','Angel','Vergara','31/01/2000','Guayas','09465','xxxxxx','0984659455');
insert into  paciente (identificacion,nombres,apellidos, fecha_nacimiento,provincia,codigo_postal,direccion,telefono )
values('0985694588','David','Paredes','24/04/1999','Guayas','0945','xxxxx','0954685666');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('1718593209','Lucía','García','08/09/1992','Pichincha','17010','Calle A No.23-45','0987456321');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('0914761293','Pedro','Martínez','12/05/1985','Manabí','13010','Avenida B No.34-12','0987123456');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('1301876512','María','Paz','03/12/1976','Azuay','01010','Calle C No.12-34','0998456789');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('1718645203','Andrés','Alvarado','25/06/1990','Esmeraldas','08010','Avenida D No.45-67','0967452314');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('0913758294','Sofía','Vásquez','14/10/1987','Los Ríos','12010','Calle E No.56-78','0987321567');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('1314768295','Juan','Flores','28/02/1986','Imbabura','10010','Avenida F No.67-89','0997456321');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('1314968210','Carla','Barrera','16/07/1983','El Oro','07010','Calle G No.78-90','0967452314');
insert into paciente (identificacion,nombres,apellidos,fecha_nacimiento,provincia,codigo_postal,direccion,telefono) 
values('1114768215','Fernando','Gómez','29/11/1991','Santa Elena','24010','Avenida H No.89-12','0987321567');


commit;
select*from paciente;


-------TABLAS MEDICO-------
drop table Medico(
Codigo_med INT PRIMARY KEY identity (0001,1),
Nombres varchar(50),
Apellidos varchar(50),
Especialidad varchar(100),
Telefono varchar(10),
Direccion varchar(100)
);





------INGRESO USUARIO MEDICO----
insert into  medico (codigo_med,Nombres,Apellidos, Especialidad,Telefono,Direccion )
values(1500,'Jose','Aguilera','Ginecologo','0946854558','Prosperina'),
values(1501,'Sofía','López','Cardióloga','0987456321','Prosperina');
values(1502,'Andrés','García','Pediatra','0987123456','Prosperina');
values(1503,'María','Paz','Dermatóloga','0998456789','Prosperina'); 
values(1504,'Carlos','Mora','Oncólogo','0967452314','Prosperina');
values(1505,'Ana','Salazar','Neuróloga','0987321567','Prosperina');
values(1506,'Juan','Flores','Endocrinólogo','0997456321','Prosperina');
values(1507,'Carla','Barrera','Gastroenteróloga','0967452314','Prosperina');
values(1508,'Fernando','Gómez','Traumatólogo','0987321567','Prosperina');
commit;
select*from medico;


---------TABLA CITAS MEDICAS------
create table Citas_Medicas (
Codigo_cita  INT PRIMARY KEY identity (0001,1),
IDPaciente INT  not null,
Cod_medico INT not null,
Num_habitacion INT,
Fecha varchar(10),
Hora varchar(10),
Motivo varchar(10)

);

INSERT INTO Pacientes (Codigo_cita,IDPaciente,Cod_medico, Num_habitacion, Fecha, Hora, Motivo) 
VALUES 
( 1001, 0001, 1500, 5, '10/10/2023', '15:00', 'Me Enferme'),
( 1002, 0002, 1501, 7, '12/10/2023', '12:00', 'Me Enferme'),
( 1003, 0003, 1502, 3, '20/10/2023', '11:00', 'Me Enferme'),
( 1004, 0004, 1503, 2, '25/11/2023', '07:00', 'Me Enferme'),
( 1005, 0005, 1504, 5, '27/11/2023', '07:00', 'Me Enferme'),
( 1006, 0006, 1505, 6, '28/11/2023', '10:00', 'Me Enferme'),

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


create table Horarios(
ID_HORARIO  INT PRIMARY KEY identity (0001,1),
Codigo_Cita varchar(4) not null,
Fecha varchar(4),
Hora varchar(10),
Disponibilidad char(1)
);



create table Areas(
ID_Areas INT PRIMARY KEY identity (0001,1),
Codigo_Medico varchar(4) not null,
Horario varchar(4),
Hora_Entrada varchar(10),
Hora_Salida varchar(10),
Disponibilidad char(1)
);
create table Horario_Medicos(
ID_HorMedico INT PRIMARY KEY identity (0001,1),
Codigo_Medico varchar(4) not null,
Area varchar(4),
Habitacion varchar(10)

);



-- Crear tabla de Historial Medico
CREATE TABLE Historial_Medico (
    ID_Historial INT PRIMARY KEY identity (0001,1),
    ID_Paciente INT,
    ID_Medico INT,
    Fecha_de_Visita DATE,
    Sintomas NVARCHAR(255),
    Diagnostico NVARCHAR(255),
    Tratamiento NVARCHAR(255),
    Receta NVARCHAR(255),
    FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente),
    FOREIGN KEY (ID_Medico) REFERENCES Medicos(ID_Medico)
);
-- Ingresar datos en la tabla de Pacientes
INSERT INTO Pacientes ( Nombre, Apellido, Fecha_de_nacimiento, Genero, Direccion, Numero_telefonico, Correo_electronico) 
VALUES 
( 'Juan', 'Pérez', '1980-05-12', 'Masculino', 'Kennedy Norte', '123456789', 'juan.perez@email.com'),
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


------------CLAVES PRIMARIAS---------------
alter table paciente
add constraint paciente_pk primary key(identificacion);



alter table medico
add constraint medico_pk primary key(codigo_med);


alter table ingresos
add constraint ingresos_pk primary key (codigo_ingreso);


-------claves foraneas------------
alter table ingresos
add constraint ingresos_fk foreign key(identificacion) references paciente (identificacion);
alter table ingresos
add constraint ingresos_fk2 foreign key(cod_medico) references medico (codigo_med);

