/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author angeldvvp
 */
public class HorariosCitas {
    String Doctor; String Especialidad;String Area,  Direccion; Date FechaHora; char Disponible;
    int idHorario=0; int idMedico=0;
    public HorariosCitas(){
        
    }
    
    public HorariosCitas(int idHorario,int idMedico,String Doctor,String Especialidad,String Area, Date FechaHora, String Direccion,char Disponible){
       this.idHorario= idHorario;
       this.idHorario=idHorario;
        this.Doctor=Doctor;
        this.Especialidad=Especialidad;
        this.Area=Area;
        this.FechaHora=FechaHora;
        this.Disponible=Disponible;
        this.Direccion=Direccion;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    public String getSpecialidad() {
        return Especialidad;
    }

    public void setSpecialidad(String Specialidad) {
        this.Especialidad = Specialidad;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date FechaHora) {
        this.FechaHora = FechaHora;
    }

    public char getDisponible() {
        return Disponible;
    }

    public void setDisponible(char Disponible) {
        this.Disponible = Disponible;
    }
    
}
