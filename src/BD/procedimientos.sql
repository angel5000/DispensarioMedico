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
