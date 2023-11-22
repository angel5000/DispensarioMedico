/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.HorariosCitas;
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
public class AdmCitasMedicas {
    
    public void IngresarCita(int idpaciente,int idmedico,int idhorario, int motivo) throws SQLException, Excepciones {
     
        String query = "{CALL IngresarCitaMedica(?,?,?,?)}";
          
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             CallableStatement stmt = conn.prepareCall(query);
             ) {
            
           stmt.setInt(1, idpaciente);
                stmt.setInt(2, idmedico);
                stmt.setInt(3, idhorario);
            if(motivo==0){
               stmt.setNull(4, Types.INTEGER);
                }else{
                     stmt.setInt(4, motivo);
                }     
            stmt.execute();
        
         

         
              }catch(SQLException e){
                e.getStackTrace();
            } 
      
     }
    
    
}
