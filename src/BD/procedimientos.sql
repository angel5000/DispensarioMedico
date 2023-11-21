use SQLADV
create PROCEDURE FacturaPaciente
    @cedulaPaciente VARCHAR(20)
AS
BEGIN
    SELECT
        pacientes.Nombres,
        pacientes.Apellidos,
        pacientes.Cedula,
        pacientes.Fecha_nacimiento,
        pacientes.Provincia,
        pacientes.Direccion,
        pacientes.Canton,
        pacientes.Telefono,
        pacientes.NumCelular,
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
        pacientes.Cedula = @cedulaPaciente;
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
