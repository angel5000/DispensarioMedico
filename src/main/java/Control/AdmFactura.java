/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.Doctor;
import Model.Factura;
import Model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angeldvvp
 */
public class AdmFactura {
    
      
     public List<Factura> listarClientes(String cedulaPaciente) throws SQLException {
       List<Factura> factura = new ArrayList<>();
        String query = "{CALL FacturaPaciente(?)}";
//cambiar consulta segun el modo a mostrar
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareCall(query);
            ) {
           stmt.setString(1, cedulaPaciente);
            Factura ft = new Factura();
           // Paciente pc = new Paciente();
           // Doctor mc = new Doctor();
              //GestorUsuarios gu= new GestorUsuarios();
 ResultSet rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
                ft.setCodigoFactura(1201);
               ft.setNombres(rs.getString("Nombres"));
               ft.setApellidos(rs.getString("Apellidos"));
              ft.setCedula(rs.getString("Cedula"));
                ft.setFechaNacimiento(rs.getString("Fecha_Nacimiento"));
               ft.setProvincia(rs.getString("Provincia"));
                ft.setDireccion(rs.getString("Direccion"));
                 ft.setCanton(rs.getString("Canton"));
                   ft.setTelefono(rs.getString("Telefono"));
                 ft.setNumCelular(rs.getString("NumCelular"));
                 ft.setEspecialidad(rs.getString("Especialidad"));
                 ft.setMotivos(rs.getString("Motivo_de_Cita"));
              //  mc.setNombres("NombreDoctor");
              ft.setCosto(rs.getFloat("Costos"));
              ft.setIva(rs.getFloat("Iva"));
              ft.setApellidoDoc(rs.getString("ApellidoDoctor"));
              ft.setTotal(rs.getFloat("Total"));
              ft.setSubtotal(rs.getFloat("Subtotal"));
              ft.setDescuento(rs.getFloat("Descuentos"));
              //  gu.obtenerUsuarioDesdeDoctor(mc);
                //gu.obtenerUsuarioDesdePaciente(pc);
                  
            }
            
            factura.add(ft);
           
            }catch(SQLException e){
                e.getStackTrace();
                System.out.println(e.getMessage());
            }
        return factura;
     }
    
}
