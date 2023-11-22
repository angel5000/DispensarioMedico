/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author angeldvvp
 */
public class AdmPagos {
  boolean realizado=false;
    public boolean ingresarPago(int idpaciente, int MetodoPago) throws Excepciones{
       
        String query = "{CALL IngresarPago(?,?)}";
          
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             CallableStatement stmt = conn.prepareCall(query);
             ) {
            
           stmt.setInt(1, idpaciente);
                stmt.setInt(2, MetodoPago);
        
             stmt.execute();
             realizado=true;
         
         

         
              }catch(SQLException e){
                e.getStackTrace();
            } 
      return realizado;
        
    }
    
    
    
}
