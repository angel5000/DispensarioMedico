--ejecutar primero para crear usuario y crear permisos, etc.
alter session set "_ORACLE_SCRIPT"=true;

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
create table paciente(
identificacion varchar2(10),
nombres varchar2(50),
apellidos varchar2(50),
fecha_nacimiento varchar2(10),
provincia varchar2(50),
codigo_postal varchar2(5),
direccion varchar2(50),
telefono varchar2(10)
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
create table medico(
codigo_med  varchar2(4),
nombres varchar2(50),
apellidos varchar2(50),
especialidad varchar2(100),
telefono varchar2(10)
);





------INGRESO USUARIO MEDICO----
insert into  medico (codigo_med,nombres,apellidos, especialidad,telefono )
values('A123','Jose','Aguilera','Ginecologo','0946854558');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('B456','Sofía','López','Cardióloga','0987456321');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('C789','Andrés','García','Pediatra','0987123456');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('D012','María','Paz','Dermatóloga','0998456789');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('E345','Carlos','Mora','Oncólogo','0967452314');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('F678','Ana','Salazar','Neuróloga','0987321567');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('G901','Juan','Flores','Endocrinólogo','0997456321');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('H234','Carla','Barrera','Gastroenteróloga','0967452314');
insert into medico (codigo_med,nombres,apellidos,especialidad,telefono) 
values('I567','Fernando','Gómez','Traumatólogo','0987321567');
commit;
select*from medico;


---------TABLA INGRESOS------
create table ingresos (
codigo_ingreso varchar2(4),
identificacion varchar2(10),
cod_medico varchar2(4),
num_cam varchar2(4),
fecha_ingreso varchar2(10),
num_habitacion varchar2(4)

);
---RESTRINCCION DE DOCTOR UNICO---------
alter table ingresos add constraint verificacion UNIQUE(identificacion, cod_medico);


-----------DATOS INGRESOS------------

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

select*from ingresos;

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
alter table ingresos
