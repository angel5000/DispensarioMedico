/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @authorr angeldvvp
 */
public class Paciente extends Usuario {
    
    int idPaciente, idHisotiralmedico, idFactura;
    String Usuario="", Contraseña="";
    
    public Paciente(){
        
            }
    
    public Paciente(int idPaciente,String Nombres, String Apellidos,String Cedula,String FechaNacimiento, String Provincia,String Direccion,
   String Telefono,String NumCelular,String Canton, char Genero,String CorreoElectronico,int idHistorialMedico, String Usuario, String Contraseña){
       super( Nombres, Apellidos, Cedula, FechaNacimiento,  Provincia, Direccion, Telefono, NumCelular, Canton
       , Genero,CorreoElectronico);
        this.idPaciente=idPaciente;
        this.idHisotiralmedico=idHistorialMedico;
        //this.idFactura=idFacturas;
        this.Usuario=Usuario;
        this.Contraseña=Contraseña;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdHisotiralmedico() {
        return idHisotiralmedico;
    }

    public void setIdHisotiralmedico(int idHisotiralmedico) {
        this.idHisotiralmedico = idHisotiralmedico;
    }
/*
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }*/

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
