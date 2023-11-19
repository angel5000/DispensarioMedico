/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 *
 * @author angeldvvp
 */
public interface DatosFacturacion {
    
   interface DatosPaciente{
          public String getNombres();
        public String getApellidos();
       
    public String getCedula();
       
    public String getFechaNacimiento() ;
     
    public String getProvincia();
       
    public String getDireccion();
       
    public String getTelefono();
        

    public String getNumCelular();
        
    public String getCanton();
      
   }
    
     interface DatosDoctor {
        String getApellidosdoc();
        String getNombresdoc();
        String getEspecialidad();
        // Otros métodos para acceder a datos del doctor si es necesario
    }
    
    
}
