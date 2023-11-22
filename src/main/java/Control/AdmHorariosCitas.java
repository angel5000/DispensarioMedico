/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.HorariosCitas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angeldvvp
 */
public class AdmHorariosCitas {
    public List<HorariosCitas> HorariosDispo(String disponi, String ubi, String espe) throws SQLException, Excepciones {
        List<HorariosCitas> hct= new ArrayList<>();
        String query = "{CALL ConsultaCitasMedicas(?,?,?)}";
          char especiali=' ';
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareCall(query);
             ) {
            
            stmt.setString(1, disponi);
           stmt.setString(2, ubi);
            stmt.setString(3, espe);
         
          ResultSet rs = stmt.executeQuery();
         
            while (rs.next()) {//RECORRIDO DE DATOS
                 HorariosCitas hrc = new HorariosCitas();
                 hrc.setIdHorario(rs.getInt("ID_Horario"));
                 hrc.setIdMedico(rs.getInt("ID_medico"));
                hrc.setArea(rs.getString("Habitacion"));
                hrc.setDoctor(rs.getString("Doctor"));
                hrc.setFechaHora(rs.getTimestamp("FechaHora"));
                especiali=rs.getString("Disponibilidad").charAt(0);
                  hrc.setDisponible(especiali);
               hrc.setDireccion(rs.getString("Direccion"));
               hrc.setSpecialidad(rs.getString("Especialidad"));
                hct.add(hrc);
           
         }
           if(hct.isEmpty()){
               throw new Excepciones("NO HAY HORARIOS DISPONIBLES");
            }
            }catch(SQLException e){
                e.getStackTrace();
            } 
        return hct;
     }
    public  List<String> ListEspecialida() throws SQLException {
        
     List<String> espe= new ArrayList<>();
        String query = "{CALL ListaEspecialidad}";
         
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareCall(query);
             ) {
           
          ResultSet rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
                 
              espe.add(rs.getString("Especialidad"));
            }
            
            }catch(SQLException e){
                e.getStackTrace();
            }
        return espe;
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
