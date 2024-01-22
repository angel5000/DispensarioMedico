/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author angeldvvp
 */
public class AdmSesion {
     int userID;
    public int IniciarSesion(String Usuario, String Contraseña){
        
         String query = "{CALL VerificarUsuario(?,?,?)}";
          
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
            CallableStatement stmt = conn.prepareCall(query);
             ) {
            stmt.setString(1,  Usuario); // Reemplaza con el nombre de usuario
                stmt.setString(2, Contraseña);
           stmt.registerOutParameter(3, Types.INTEGER);

                stmt.execute();

               
                userID = stmt.getInt(3);
          ResultSet rs = stmt.executeQuery();
            if (userID > 0) {
                    System.out.println("Usuario autenticado. ID del Usuario: " + userID);
                } else {
                    System.out.println("Usuario o contraseña incorrectos");
                }
        
        }catch(SQLException e){
                e.getStackTrace();
            }
        return userID;
    }
    
      public int IniciarSesionMed(String Usuario, String Contraseña){
        
         String query = "{CALL VerificarUsuarioMed(?,?,?)}";
          
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
            CallableStatement stmt = conn.prepareCall(query);
             ) {
            stmt.setString(1,  Usuario); // Reemplaza con el nombre de usuario
                stmt.setString(2, Contraseña);
           stmt.registerOutParameter(3, Types.INTEGER);

                stmt.execute();

               
                userID = stmt.getInt(3);
          ResultSet rs = stmt.executeQuery();
            if (userID > 0) {
                    System.out.println("Usuario autenticado. ID del Usuario: " + userID);
                } else {
                    System.out.println("Usuario o contraseña incorrectos");
                }
        
        }catch(SQLException e){
                e.getStackTrace();
            }
        return userID;
    }
    
}
