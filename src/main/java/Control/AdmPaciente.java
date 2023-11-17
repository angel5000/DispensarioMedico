/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.Paciente;
import java.sql.*;

import java.util.*;

/**
 *
 * @author angeldvvp
 */
public class AdmPaciente {
    
     public List<Paciente> listarClientes() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String query = "SELECT * FROM Pacientes";//cambiar consulta segun el modo a mostrar
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            
            while (rs.next()) {//RECORRIDO DE DATOS
            }
            
            
           
            
            }catch(SQLException e){
                e.getStackTrace();
            }
        return pacientes;
     }
    
}
