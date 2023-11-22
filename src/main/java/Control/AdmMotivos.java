/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.Motivos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author angeldvvp
 */
public class AdmMotivos {
    
    public  JComboBox getmotivos(JComboBox combo, int id){
        DefaultComboBoxModel value = null;
         String query = "{CALL ConsultarMotivos(?)}";
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
            CallableStatement stmt = conn.prepareCall(query);
            ) {
            
           value =new DefaultComboBoxModel();
          stmt.setInt(1, id);
            combo.setModel(value);
            stmt.execute();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                  Motivos mv = new Motivos();
               mv.setId( resultSet.getInt("IDMotivo"));
                mv.setMotivos( resultSet.getString("Servicio"));
                mv.setCosto(resultSet.getFloat("Costos"));
             value.addElement(mv);
            }
            
               
           }catch(SQLException e){
                e.getStackTrace();
                System.out.println(e.getMessage());
            }
        return combo;
    }
    
    
    
}
