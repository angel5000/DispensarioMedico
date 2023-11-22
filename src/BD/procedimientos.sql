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


-- Definir valores de ejemplo para Usuario y Contraseña
DECLARE @UsuarioEjempl VARCHAR(50) = 
DECLARE @ContrasenaEjempl VARCHAR(50) = ;

-- Ejecutar el procedimiento almacenado

DECLARE @IDUsuari int ;
EXEC VerificarUsuario
    @Usuario = 'Ang5000',
    @Contrasena = 'Angel123456',
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
        Factura.Total
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
    WHERE
        pacientes.ID_PACIENTE =40 @idPaciente;
END;

create PROCEDURE ConsultaCitasMedicas
@Disponibili CHAR(1),
@Ubicacion varchar(10) ,
@Especialidad VARCHAR(60)
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
	hc.ID_HORARIO,
	m.ID_medico,
        m.Nombres + ' ' + m.Apellidos AS Doctor,
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
        Ubicacion U ON M.UbicacionDisp = U.IDUbicacion
    WHERE 
        HC.Disponibilidad = @Disponibili AND U.Sector = @Ubicacion AND M.Especialidad = @Especialidad;
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

    -- Insertar el pago realizado
    INSERT INTO PagosRealizados (IdPaciente, idMetodoPago)
    VALUES (@IdPaciente,  @IdMetodoPago);

    
END;

























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
