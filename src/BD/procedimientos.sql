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

    -- Verificar si el usuario y contraseña existen
    SELECT @IDUsuario=ID_DatosUsuario
    FROM UsuariosPaciente
    WHERE  Usuario =@Usuario and HashedContrasena =  HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), Salt) + @Contrasena);


    -- Devolver el ID del usuario si existe
    IF @Contrasena IS NOT NULL
        SELECT @IDUsuario AS 'ID del Usuario';
    ELSE
        PRINT 'Usuario o contraseña incorrectos';

END;

create PROCEDURE VerificarUsuarioMed
    @Usuario VARCHAR(50),
    @Contrasena VARCHAR(50),
	@IDUsuario INT OUTPUT

AS
BEGIN
    SET NOCOUNT ON;

   set @IDUsuario=null;

    -- Verificar si el usuario y contraseña existen
    SELECT @IDUsuario=IDMedUsuario
    FROM  UsuariosMedico
    WHERE  Usuario =@Usuario and HashedContrasena =  HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), Salt) + @Contrasena);


    -- Devolver el ID del usuario si existe
    IF @Contrasena IS NOT NULL
        SELECT @IDUsuario AS 'ID del Usuario';
    ELSE
        PRINT 'Usuario o contraseña incorrectos';

END;



-- Ejecutar el procedimiento almacenado

DECLARE @IDUsuari int ;
DECLARE  @Usuario int ;
DECLARE  @Contrasena int ;

EXEC VerificarUsuarioMed
    @Usuario = 'Luis1587',
    @Contrasena = '123456',
	 @IDUsuario = @IDUsuari output 
	


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

    -- Insertar la factura
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
DECLARE @ID_Esp INT;
SET @ID_Esp = 400;  
EXEC  ConsultarMotivos @ID_Espe = @ID_Esp;

select*from MotivosCitasMedicas

SELECT *FROM CostoServicios



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

select





create PROCEDURE IngresarPago
    @IdPaciente INT,
  
    @IdMetodoPago INT
AS
BEGIN
    SET NOCOUNT ON;

    -- Insertar el pago realizado
    INSERT INTO PagosRealizados (IdPaciente, idMetodoPago)
    VALUES (@IdPaciente,  @IdMetodoPago);

    
END;
select *from PagosRealizados
DECLARE @PacienteID INT;
DECLARE @MetodoPagoID INT;


SET @PacienteID = 37; 
SET @MetodoPagoID = 303;  


EXEC IngresarPago @IdPaciente = @PacienteID, @IdMetodoPago = @MetodoPagoID;

create PROCEDURE CitasMedicasIngresadas
   @IdMedico INT
AS
BEGIN
SELECT 
ct.IDHorarioCitas,
ct.IDCita,
ct.IDMedico,
ct.IDPaciente,
pc.Nombres,
pc.Apellidos,
hr.FechaHora,
mt.Servicio as MotivoCita,
sh.Disponibilidad

from Citas_Medicas ct
join pacientes pc on ct.IDPaciente=pc.ID_PACIENTE
join HorariosCitas hr on ct.IDHorarioCitas=hr.ID_HORARIO
join MotivosCitasMedicas mt on ct.Motivo=mt.IDMotivo
join EstadoHoraCitas sh on hr.Disponibeid=sh.ID_Estadhocita
where ct.IDMedico=@IdMedico;
END;

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
hr.FechaHora as FechaCita,
mt.Servicio as MotivoCita

from Citas_Medicas ct
join pacientes pc on ct.IDPaciente=pc.ID_PACIENTE
join HorariosCitas hr on ct.IDHorarioCitas=hr.ID_HORARIO
join MotivosCitasMedicas mt on ct.Motivo=mt.IDMotivo
join Medico md on ct.IDMedico=md.ID_medico
where ct.IDCita=@Idcita;

END;
select*from Citas_Medicas


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

    -- Insertar el pago realizado
    INSERT INTO Historial_Medico ( ID_Paciente,ID_Medico,FechaVisita,Sintomas, Diagnostico,Tratamiento,Receta)
    VALUES ( @iD_Paciente , @iD_Medico, @fechaVisita ,@sintomas,@diagnostico,@tratamiento,@receta);

    
END;










create PROCEDURE ConfirmaEstadoHorario
   
    @Disponibeid INT,
	@IDHORARI INT
AS
BEGIN
   

    UPDATE HorariosCitas SET Disponibeid=@Disponibeid WHERE ID_HORARIO=@IDHORARI
  
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
