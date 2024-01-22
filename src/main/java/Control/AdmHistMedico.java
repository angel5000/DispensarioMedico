/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.HistorialMedico;
import Model.Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angeldvvp
 */
public class AdmHistMedico {
    
   public List<HistorialMedico> getHistorial(int idpaciente) throws SQLException {
        List<HistorialMedico> historial = new ArrayList<>();
       String query = "{CALL MostrarHistorial(?)}";
          
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
            CallableStatement stmt = conn.prepareCall(query);
             ) {
            
             stmt.setInt(1, idpaciente);
                stmt.execute();
             ResultSet rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
               HistorialMedico hm = new HistorialMedico();
               hm.setPaciente(rs.getString("NombreCompleto"));
                hm.setMedico(rs.getString("Medico"));
                hm.setDiagnostico(rs.getString("Diagnostico"));
                hm.setSintomas(rs.getString("Sintomas"));
                hm.setTratamiento(rs.getString("Tratamiento"));
                hm.setReceta(rs.getString("Receta"));
                hm.setFechaVisita(rs.getTimestamp("FechaCitaMedica"));
                historial.add(hm);
                
            }
                
                
                
                
        } catch(SQLException e){
              
                System.out.println(e.getMessage()+e.getStackTrace());
            }
        return historial;
   
   }
    
}
