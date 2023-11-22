/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angeldvvp
 */
public class Especialidad {
    int id ; String Especialidad;
    public Especialidad(){
        
    }
    public Especialidad(int id , String Especialidad){
        this.id=id;
        this.Especialidad=Especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

  
    @Override
    public String toString() {
        return Especialidad;
    }
}
