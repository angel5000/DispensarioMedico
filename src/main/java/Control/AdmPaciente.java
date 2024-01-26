/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.Paciente;
import Model.Factura;
import java.sql.*;

import java.util.*;

/**
 *
 * @author angeldvvp
 */
public class AdmPaciente {
     Paciente pct;
     public List<Paciente> DatoPaciente(int id) throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String query = "{CALL DatoPaciente(?)}";
          char genero=' ';
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
              CallableStatement stmt = conn.prepareCall(query);
             ) {
            stmt.setInt(1, id);
           stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
               pct = new Paciente();
                pct.setNombres(rs.getString("Nombres"));
               pct.setApellidos(rs.getString("Apellidos"));
             pct.setCedula(rs.getString("Cedula"));
                pct.setFechaNacimiento(rs.getString("Fecha_nacimiento"));
               pct.setProvincia(rs.getString("Provincia"));
                pct.setDireccion(rs.getString("Direccion"));
                 pct.setCanton(rs.getString("Canton"));
                
                  genero=rs.getString("Genero").charAt(0);
                  pct.setGenero(genero);
                  pct.setCorreoElectronico(rs.getString("CorreoElectronico"));
                  
                 pct.setNumCelular(rs.getString("NumCelular"));
               
                
                
            }
            
            pacientes.add(pct);
           
            }catch(SQLException e){
           
                System.out.println(e.getMessage()+e.getStackTrace());
            }
        return pacientes;
     }
    public List<Paciente> TelefonPaciente(int id) throws SQLException {
        List<Paciente> TLpaciente = new ArrayList<>();
        String query = "{CALL TelefonoPaciente(?)}";
       
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
              CallableStatement stmt = conn.prepareCall(query);
             ) {
            stmt.setInt(1, id);
           stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
               pct = new Paciente();
                
                  pct.setTelefono(rs.getString("NumeroTelefono"));
                 TLpaciente.add(pct);
            }
            
           
           
            }catch(SQLException e){
              
                System.out.println(e.getMessage());
            }
        return TLpaciente;
     }
    public boolean updpaciente(int idpaciente, String Nombres, String Apellidos,String FechaNacimiento, String Provincia,String Direccion,
   String Canton, char Genero){
        
       String query="{CALL ActualizarPaciente(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
              CallableStatement stmt = conn.prepareCall(query);
             ) {
          
            stmt.setInt(1, idpaciente);
             stmt.setString(2, Nombres);
           stmt.setString(3, Apellidos);
           stmt.setString(4, FechaNacimiento);
            stmt.setString(5, Provincia);
            stmt.setString(6,  Canton);
              stmt.setString(7,Direccion);
                stmt.setString(8, String.valueOf(Genero));
          stmt.execute();
            }catch(SQLException e){
              
               
                System.out.println(e.getMessage()+e.getStackTrace());
            }
        
        
        
        return true;
    }
    
    
    
    
}
