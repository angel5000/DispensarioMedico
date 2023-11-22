/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angeldvvp
 */
public class Usuario  {
    String Nombres="", Apellidos="", Cedula="",
            FechaNacimiento="", Provincia="",Direccion="",Telefono="",NumCelular="",Canton="",CorreoElectronico="";
    char genero=' ';
    public  Usuario(){
        
        
    }
    
    public Usuario(String Nombres, String Apellidos,String Cedula,String FechaNacimiento, String Provincia,String Direccion,
   String Telefono,String NumCelular,String Canton, char Genero,String CorreoElectronico){
          this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Cedula = Cedula;
        this.FechaNacimiento = FechaNacimiento;
        this.Provincia = Provincia;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.NumCelular = NumCelular;
        this.Canton = Canton;
        this.genero=Genero;
        this.CorreoElectronico=CorreoElectronico;
    }

 
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }


    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

  
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }


    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

 
    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }


    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }


    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    
    public String getNumCelular() {
        return NumCelular;
    }

    public void setNumCelular(String NumCelular) {
        this.NumCelular = NumCelular;
    }

  
    public String getCanton() {
        return Canton;
    }

    public void setCanton(String Canton) {
        this.Canton = Canton;
    }
    
    
}
