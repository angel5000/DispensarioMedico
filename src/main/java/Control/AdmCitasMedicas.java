/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.CitasMedicas;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angeldvvp
 */
public class AdmCitasMedicas {
     CitasMedicas cm;
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
    public List <CitasMedicas> MostrarCitasMedicas(int idmedico){
        String query = "{CALL CitasMedicasIngresadas(?)}";
           List<CitasMedicas> ctm= new ArrayList<>();
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             CallableStatement stmt = conn.prepareCall(query);
             ) {
            
           stmt.setInt(1, idmedico);
           
                stmt.execute();
             ResultSet rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
               cm = new CitasMedicas();
               cm.setIdPaciente(rs.getInt("IDPaciente"));
               cm.setIdMedico(rs.getInt("ID_medico"));
               cm.setIdHorario(rs.getInt("IDHorarioCitas"));
                 cm.setNombres(rs.getString("Nombres"));
                cm.setApellidos(rs.getString("Apellidos"));
                cm.setCodigCita(rs.getInt("IDCita"));
                cm.setFechaHora(rs.getTimestamp("FechaHora"));
                cm.setDisponible(rs.getString("Disponibilidad"));
                cm.setMotivos(rs.getString("MotivoCita"));
                
            
                ctm.add(cm);
                
            }

        
         

         
              }catch(SQLException e){
                e.getStackTrace();
                System.out.println(e.getMessage());
            } catch (Exception ex) { 
            Logger.getLogger(AdmCitasMedicas.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return ctm;
    }
    
     public List <CitasMedicas> MostrarDetCitas(int idcita){
        String query = "{CALL DettlCitasMedicas(?)}";
           List<CitasMedicas> ctm= new ArrayList<>();
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             CallableStatement stmt = conn.prepareCall(query);
             ) {
            
           stmt.setInt(1, idcita);
           
                stmt.execute();
             ResultSet rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
               cm = new CitasMedicas();
            cm.setIdPaciente(rs.getInt("IDPaciente"));
                 cm.setNombres(rs.getString("Nombres"));
                 cm.setCedula(rs.getString("Cedula"));
                 cm.setDireccion(rs.getString("Direccion"));
                cm.setApellidos(rs.getString("Apellidos"));
                cm.setCodigCita(rs.getInt("IDCita"));
                cm.setNombresdoc(rs.getString("Nombdoc"));
                cm.setIdHorario(rs.getInt("IDHorarioCitas"));
                cm.setIdMedico(rs.getInt("ID_medico"));
                cm.setEspecialidad(rs.getString("Especialidad"));
                cm.setFechaHora(rs.getTimestamp("FechaCita"));
                cm.setMotivos(rs.getString("MotivoCita"));
                
                System.out.println(cm.getApellidos()+" asd");
                ctm.add(cm);
                
            }

        
         

         
              }catch(SQLException e){
                e.getStackTrace();
                System.out.println(e.getMessage());
            } catch (Exception ex) { 
            Logger.getLogger(AdmCitasMedicas.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return ctm;
    }
    
}
