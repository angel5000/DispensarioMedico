/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.Doctor;
import Model.Factura;
import Model.Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angeldvvp
 */
public class AdmFactura {
    
      public void CrearFactura(int idpaciente, int idmedico,int fechavisita, int motivo,
              float iva ,float subtotal,float Total,float costo){
          String query = "{CALL GenerarFactura(?,?,?,?,?,?,?,?)}";
//cambiar consulta segun el modo a mostrar
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
            CallableStatement stmt = conn.prepareCall(query);
            ) {
           stmt.setInt(1, idpaciente);
            stmt.setInt(2, idmedico);
             stmt.setInt(3, fechavisita);
             
                stmt.setInt(4, motivo);
                
              
                stmt.setFloat(5, subtotal);
           stmt.setFloat(6, Total);
            stmt.setFloat(7,iva );
             stmt.setFloat(8, costo);
            stmt.execute();
               
           }catch(SQLException e){
                e.getStackTrace();
                System.out.println(e.getMessage());
            }
      }
      
     public List<Factura> listarFacturas(int idpaciente) throws SQLException,Excepciones {
       List<Factura> factura = new ArrayList<>();
        String query = "{CALL FacturaPaciente(?)}";
//cambiar consulta segun el modo a mostrar
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareCall(query);
            ) {
           stmt.setInt(1, idpaciente);
          
           // Paciente pc = new Paciente();
           // Doctor mc = new Doctor();
              //GestorUsuarios gu= new GestorUsuarios();
              
 ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {//RECORRIDO DE DATOS
               Factura  ft = new Factura();
                ft.setCodigoFactura(rs.getInt("ID_Factura"));
               ft.setNombres(rs.getString("Nombres"));
               ft.setApellidos(rs.getString("Apellidos"));
              ft.setCedula(rs.getString("Cedula"));
               ft.setProvincia(rs.getString("Provincia"));
                ft.setDireccion(rs.getString("Direccion"));
                 ft.setCanton(rs.getString("Canton"));
                 ft.setEspecialidad(rs.getString("Especialidad"));
                 ft.setMotivos(rs.getString("Motivo_de_Cita"));
                
              ft.setCosto(rs.getFloat("Costos"));
              ft.setIva(rs.getFloat("Iva"));
              ft.setApellidoDoc(rs.getString("ApellidoDoctor"));
              ft.setTotal(rs.getFloat("Total"));
              ft.setSubtotal(rs.getFloat("Subtotal"));
              ft.setDescuento(rs.getFloat("Descuentos"));
              factura.add(ft);
            }
            
             
            
           
            }catch(SQLException e){
                e.getStackTrace();
                System.out.println(e.getMessage());
            }
        return factura;
     }
    
}
