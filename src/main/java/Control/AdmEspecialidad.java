/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ConexionBD;
import Model.Especialidad;
import Model.Motivos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author angeldvvp
 */
public class AdmEspecialidad {
     public  JComboBox getEspecialidad(JComboBox combo){
        DefaultComboBoxModel value = null;
         String query = "{CALL ListaEspecialidad}";
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
            CallableStatement stmt = conn.prepareCall(query);
            ) {
            ResultSet resultSet = stmt.executeQuery();
           value =new DefaultComboBoxModel();
         
            combo.setModel(value);
            while (resultSet.next()) {
                 Especialidad sp = new Especialidad();
               sp.setId( resultSet.getInt("IDEspecialidad"));
                sp.setEspecialidad( resultSet.getString("Especialidad"));
             value.addElement(sp);
            }
            
               
           }catch(SQLException e){
                e.getStackTrace();
                System.out.println(e.getMessage());
            }
        return combo;
    }
}
