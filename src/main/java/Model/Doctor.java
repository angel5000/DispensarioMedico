/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angeldvvp
 */
public class Doctor extends Usuario {
 String Especialidad, Titulacion,  Experiencia;
 int idDoctor=0;
 String Usuario="", Contraseña="";
    public  Doctor(){
        
    }
    
    public  Doctor(int idDoctor,String Nombres, String Apellidos,String Cedula,String FechaNacimiento, String Provincia,String Direccion,
   String Telefono,String NumCelular,String Canton, char Genero,String CorreoElectronico,String Especialidad,String Titulacion, String Experiencia,String Usuario, String Contraseña){
        super( Nombres, Apellidos, Cedula, FechaNacimiento,  Provincia, Direccion, Telefono, NumCelular, Canton
        , Genero, CorreoElectronico);
        
        this.Especialidad=Especialidad;
        this.Titulacion=Titulacion;
        this.Experiencia=Experiencia;
         this.Usuario=Usuario;
        this.Contraseña=Contraseña;
        
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getTitulacion() {
        return Titulacion;
    }

    public void setTitulacion(String Titulacion) {
        this.Titulacion = Titulacion;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String Experiencia) {
        this.Experiencia = Experiencia;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
}
