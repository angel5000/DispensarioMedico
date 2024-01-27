use SQLADV

create PROCEDURE DatoPaciente
    @id varchar(10)
AS
BEGIN
    SELECT *
    FROM pacientes
    WHERE ID_PACIENTE = @id;
END;



create PROCEDURE TelefonoPaciente
    @Numtele varchar(10)
AS
BEGIN
 SELECT TelefonosPacientes.NumeroTelefono
    FROM TelefonosPacientes 
	join pacientes on TelefonosPacientes.ID_Paciente=pacientes.ID_PACIENTE
    WHERE pacientes.ID_PACIENTE = @Numtele;
END;




create PROCEDURE ObtenerHorariosCitas
AS
BEGIN
    SELECT 
        ID_HORARIO,
        ID_Doctor,
        Areas,
        FechaHora,
		Disponibeid,
        CASE WHEN FechaFin IS NULL THEN 'NO ASIGNADO' ELSE CAST( FechaFin AS VARCHAR(255)) END AS FechaFin 
       
    FROM 
        HorariosCitas;
END;







CREATE PROCEDURE ActualizarPaciente
    @IDPaciente INT,
    @Nombres VARCHAR(50),
    @Apellidos VARCHAR(50),
    @FechaNacimiento VARCHAR(10),
    @Provincia VARCHAR(50),
    @Canton VARCHAR(50),
    @Direccion VARCHAR(50),
    @Genero VARCHAR(100)

AS
BEGIN
    UPDATE pacientes
    SET
        Nombres = @Nombres,
        Apellidos = @Apellidos,
        Fecha_nacimiento = @FechaNacimiento,
        Provincia = @Provincia,
        Canton = @Canton,
        Direccion = @Direccion,
        Genero = @Genero
    WHERE
        ID_PACIENTE = @IDPaciente;
END;





create PROCEDURE ListaEspecialidad
   
AS
BEGIN
    SELECT *
    FROM Especialidad;
    
END;

create PROCEDURE MostrarHistorial
     @IDPaciente INT
AS
BEGIN
    SET NOCOUNT ON;

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
    INNER JOIN
        HorariosCitas ON HorariosCitas.ID_HORARIO = Historial_Medico.FechaVisita
    WHERE
        Historial_Medico.ID_Paciente = @IDPaciente;
END;

select*from pacientes
DECLARE @PacienteID INT;
SET @PacienteID = 37;  
EXEC MostrarHistorial @IDPaciente = @PacienteID;





create PROCEDURE VerificarUsuario
    @Usuario VARCHAR(50),
    @Contrasena VARCHAR(50),
	@IDUsuario INT OUTPUT

AS
BEGIN
    SET NOCOUNT ON;

   set @IDUsuario=null;

    SELECT @IDUsuario=ID_DatosUsuario
    FROM UsuariosPaciente
    WHERE  Usuario =@Usuario and HashedContrasena =  HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), Salt) + @Contrasena);


    IF @Contrasena IS NOT NULL
        SELECT @IDUsuario AS 'ID del Usuario';
    ELSE
        PRINT 'Usuario o contraseña incorrectos';

END;
create PROCEDURE VerificarUsuarioMed
    @Usuario VARCHAR(50),
    @Contrasena VARCHAR(50),
	@IDUsuario INT OUTPUT,
	@nombdoc varchar(100) OUTPUT

AS
BEGIN
    SET NOCOUNT ON;

   set @IDUsuario=null;
    set @nombdoc=null;

    SELECT @IDUsuario=um.ID_DatosUsuario,@nombdoc=md.Apellidos
    FROM  UsuariosMedico um 
	join Medico md on um.ID_DatosUsuario=md.ID_medico
    WHERE  Usuario =@Usuario and HashedContrasena =  HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), Salt) + @Contrasena);


  
    IF @Contrasena IS NOT NULL
        SELECT @IDUsuario AS 'ID del Usuario', @nombdoc AS 'doctor';
	
    ELSE
        PRINT 'Usuario o contraseña incorrectos';

END;



-- Ejecutar el procedimiento almacenado
DECLARE @IDUsuario INT;
DECLARE @Usuario VARCHAR(50) = 'Luis1587'; -- Asigna valores a las variables de entrada
DECLARE @Contrasena VARCHAR(50) = '123456';
DECLARE @nombdoc VARCHAR(100);

EXEC VerificarUsuarioMed
    @Usuario = @Usuario,
    @Contrasena = @Contrasena,
    @IDUsuario = @IDUsuario OUTPUT,
    @nombdoc = @nombdoc OUTPUT;



create PROCEDURE GenerarFactura
    @ID_Paciente INT,
    @ID_Medico INT,
    @FechaVisita INT,
    @Motivo INT,
      @Subtotal FLOAT,
	   @Total FLOAT,
    @Iva FLOAT,
	 @Costo Float
AS
BEGIN
    SET NOCOUNT ON;

  
    INSERT INTO Factura (ID_Paciente, ID_Medico, FechaVisita, Motivo, Subtotal ,Total,Iva ,Costo)
    VALUES (@ID_Paciente, @ID_Medico, @FechaVisita, @Motivo,  @Subtotal, @Total,@Iva, @Costo);

  
END;


create PROCEDURE ConsultarMotivos
 @ID_Espe INT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT IDMotivo, Servicio, CostoServicios.Costos
    FROM MotivosCitasMedicas
	inner join CostoServicios on MotivosCitasMedicas.IDMotivo=CostoServicios.IDMCM
	where especialiMed=@ID_Espe;
END;





create PROCEDURE FacturaPaciente
    @idPaciente int
AS
BEGIN
    SELECT
	Factura.ID_Factura,
        pacientes.Nombres,
        pacientes.Apellidos,
        pacientes.Cedula,
        pacientes.Provincia,
        pacientes.Direccion,
        pacientes.Canton,
        Medico.Nombres AS NombreDoctor,
        Medico.Apellidos AS ApellidoDoctor,
        Medico.Especialidad,
        MotivosCitasMedicas.Servicio AS Motivo_de_Cita,
        CostoServicios.Costos, 
        CostoServicios.Descuentos,
        Factura.Iva,
        Factura.Subtotal,
        Factura.Total,
		Citas_Medicas.
    FROM
        Factura
    INNER JOIN
        pacientes ON pacientes.ID_PACIENTE = Factura.ID_Paciente
    INNER JOIN
        Medico ON Medico.ID_medico = Factura.ID_Medico
    INNER JOIN
        MotivosCitasMedicas ON Factura.Motivo = MotivosCitasMedicas.IDMotivo
    INNER JOIN
        CostoServicios ON CostoServicios.IDMCM = Factura.Motivo 
		  INNER JOIN 
    WHERE pacientes.ID_PACIENTE = @idPaciente;
END;



create PROCEDURE ConsultaCitasMedicas
@Disponibili int,
@Ubicacion varchar(10) ,
@Especialidad varchar(50)
AS
BEGIN
    SET NOCOUNT ON;
	
    SELECT 
	hc.ID_HORARIO,
	m.ID_medico,
        m.Nombres + ' ' + m.Apellidos AS Doctor,
		m.Especialidad,
        HC.FechaHora,
       e.Disponibilidad,
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
        Ubicacion U ON M.UbicacionDisp = U.IDUbicacion
		INNER JOIN 
        EstadoHoraCitas e ON hc.Disponibeid = e.ID_Estadhocita
    WHERE 
        HC.Disponibeid = @Disponibili AND U.Sector = @Ubicacion  AND M.Especialidad =@Especialidad 
END;

CREATE PROCEDURE IngresarCitaMedica
    @IDPaciente INT,
    @IDMedico INT,
    @IDHorarioCitas INT,
    @Motivo INT
AS
BEGIN
    SET NOCOUNT ON;
	
    INSERT INTO Citas_Medicas (IDPaciente, IDMedico, IDHorarioCitas, Motivo)
    VALUES (@IDPaciente, @IDMedico, @IDHorarioCitas, @Motivo);

END;






create PROCEDURE IngresarPago
    @IdPaciente INT,
  
    @IdMetodoPago INT
AS
BEGIN
    SET NOCOUNT ON;


    INSERT INTO PagosRealizados (IdPaciente, idMetodoPago)
    VALUES (@IdPaciente,  @IdMetodoPago);

    
END;




create PROCEDURE CitasMedicasIngresadas
   @IdMedico INT
AS
BEGIN

SELECT 
ct.IDHorarioCitas,
ct.IDCita,
md.ID_medico,
ct.IDPaciente,
pc.Nombres,
pc.Apellidos,
hr.FechaHora,
mt.Servicio as MotivoCita,
sh.Disponibilidad,
  CASE WHEN hr.FechaFin IS NULL THEN 'NO ASIGNADO' ELSE CAST( hr.FechaFin AS VARCHAR(255)) END AS FechaFin 
from Citas_Medicas ct
join pacientes pc on ct.IDPaciente=pc.ID_PACIENTE
join Medico md on ct.IDMedico=md.ID_medico
join MotivosCitasMedicas mt on ct.Motivo=mt.IDMotivo
join HorariosCitas hr on  ct.IDHorarioCitas= hr.ID_HORARIO
join EstadoHoraCitas sh on  hr.Disponibeid=sh.ID_Estadhocita

where md.ID_medico= @IdMedico;
END;


update Citas_Medicas set IDHorarioCitas =15 where IDPaciente=37
select*from Citas_Medicas
select*from HorariosCitas where ID_Doctor =135

create PROCEDURE RegCitasMedicas
   @Idmedi INT,
    @Iddispo INT
AS
BEGIN 
SELECT 
ct.IDPaciente,
ct.IDCita,
ct.IDHorarioCitas,
sh.Disponibilidad,
md.ID_medico,
pc.Nombres,
pc.Apellidos,
pc.Cedula,
pc.Direccion,
md.Apellidos as Apedoc,
md.Nombres as Nombdoc,
md.Especialidad,
hr.FechaHora as FechaCita,
mt.Servicio as MotivoCita,
cs.Costos,
 CASE WHEN hr.FechaFin IS NULL THEN 'NO ASIGNADO' ELSE CAST( hr.FechaFin AS VARCHAR(255)) END AS FechaFin 

from Citas_Medicas ct
join pacientes pc on ct.IDPaciente=pc.ID_PACIENTE
join HorariosCitas hr on ct.IDHorarioCitas=hr.ID_HORARIO
join MotivosCitasMedicas mt on ct.Motivo=mt.IDMotivo
join Medico md on ct.IDMedico=md.ID_medico
join EstadoHoraCitas sh on  hr.Disponibeid=sh.ID_Estadhocita
join CostoServicios cs on ct.Motivo =cs.IDMCM
where ct.IDMedico=@Idmedi and hr.Disponibeid=@Iddispo ;

END;

select*from Citas_Medicas
select*from HorariosCitas



create PROCEDURE DettlCitasMedicas
   @Idcita INT
AS
BEGIN 
SELECT 
ct.IDPaciente,
ct.IDCita,
ct.IDHorarioCitas,
md.ID_medico,
pc.Nombres,
pc.Apellidos,
pc.Cedula,
pc.Direccion,
md.Apellidos as Apedoc,
md.Nombres as Nombdoc,
md.Especialidad,
hr.FechaHora as FechaCita

from Citas_Medicas ct
join pacientes pc on ct.IDPaciente=pc.ID_PACIENTE
join HorariosCitas hr on ct.IDHorarioCitas=hr.ID_HORARIO
join MotivosCitasMedicas mt on ct.Motivo=mt.IDMotivo
join Medico md on ct.IDMedico=md.ID_medico

where ct.IDCita= @Idcita;

END;

create PROCEDURE CitasMedicasPaciente
   @IdPACIENTE INT,
   @IdDoctor INT
AS
BEGIN 

SELECT 
ct.IDPaciente,
ct.IDCita,
ct.IDHorarioCitas,
sh.Disponibilidad,
md.ID_medico,
pc.Nombres,
pc.Apellidos,
pc.Cedula,
pc.Direccion,
md.Apellidos as Apedoc,
md.Nombres as Nombdoc,
md.Especialidad,
hr.FechaHora as FechaCita,
mt.Servicio as MotivoCita,
cs.Costos,
 CASE WHEN hr.FechaFin IS NULL THEN 'NO ASIGNADO' ELSE CAST( hr.FechaFin AS VARCHAR(255)) END AS FechaFin 

from Citas_Medicas ct
join pacientes pc on ct.IDPaciente=pc.ID_PACIENTE
join HorariosCitas hr on ct.IDHorarioCitas=hr.ID_HORARIO
join MotivosCitasMedicas mt on ct.Motivo=mt.IDMotivo
join Medico md on ct.IDMedico=md.ID_medico
join EstadoHoraCitas sh on  hr.Disponibeid=sh.ID_Estadhocita
join CostoServicios cs on ct.Motivo =cs.IDMCM
where ct.IDMedico=  @IdDoctor
    and ct.IDPaciente=@IdPACIENTE ;
	
END;



create PROCEDURE MostrarHistorialreg
     @IDPaciente INT,
	   @IdDoctor INT
AS
BEGIN
    SET NOCOUNT ON;

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
    INNER JOIN
        HorariosCitas ON HorariosCitas.ID_HORARIO = Historial_Medico.FechaVisita
    WHERE
        Historial_Medico.ID_Paciente = @IDPaciente and Historial_Medico.ID_Medico= @IdDoctor;
END;







create PROCEDURE IngresarHistorial_Medico
    @iD_Paciente INT,
    @iD_Medico INT,
    @fechaVisita int,
    @sintomas VARCHAR(255),
    @diagnostico VARCHAR(255),
    @tratamiento VARCHAR(255),
    @receta VARCHAR(255)
AS
BEGIN
    SET NOCOUNT ON;

  
    INSERT INTO Historial_Medico ( ID_Paciente,ID_Medico,FechaVisita,Sintomas, Diagnostico,Tratamiento,Receta)
    VALUES ( @iD_Paciente , @iD_Medico, @fechaVisita ,@sintomas,@diagnostico,@tratamiento,@receta);

    
END;


create PROCEDURE ConfirmaEstadoHorario
   
    @Disponibeid INT,
	@IDHORARI INT
AS
BEGIN
   

    UPDATE HorariosCitas SET Disponibeid=@Disponibeid, FechaFin=GETDATE() WHERE ID_HORARIO=@IDHORARI
  
END;
select *from EstadoHoraCitas






















create PROCEDURE AutenticarUsuario
    @ID_DatosUsuario INT,
    @Usuario NVARCHAR(50),
    @Rol INT,
    @Activa CHAR(1),
    @Contraseña NVARCHAR(MAX)
AS
BEGIN
    SET NOCOUNT ON;

    -- Generar un salt aleatorio
    DECLARE @Salt VARBINARY(32);
    SET @Salt = CRYPT_GEN_RANDOM(32);

    -- Calcular el hash de la contraseña con el salt
    DECLARE @HashedPassword VARBINARY(64);
    SET @HashedPassword = HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), @Salt) + @Contraseña);

    -- Insertar el nuevo usuario en la tabla
    INSERT INTO UsuariosPaciente (ID_DatosUsuario, Usuario, Rol, Activa, Salt, HashedContrasena)
    VALUES (@ID_DatosUsuario, @Usuario, @Rol, @Activa, @Salt, @HashedPassword);
END;


DECLARE @ID_DatosUsuari INT = 37;
DECLARE @Usuari NVARCHAR(50) = 'Ang5000';
DECLARE @Roll INT = 100;
DECLARE @Activ CHAR(1) = 'A';
DECLARE @Contrasena NVARCHAR(MAX) = 'Angel123456';

-- Ejecutar el procedimiento almacenado
EXEC AutenticarUsuario
    @ID_DatosUsuario = 37,
    @Usuario = 'Ang5000',
    @Rol = 100,
    @Activa = 'A',
    @Contraseña = 'Angel123456';
