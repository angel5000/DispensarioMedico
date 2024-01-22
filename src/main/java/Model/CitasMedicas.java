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
public class CitasMedicas extends Paciente implements HorariosInterface,MotivosInterfaces{
    int CodigCita,id;
    float Costo;
             String motivos, Medico,  Horario;
             String Doctor; String Especialidad;String Area,  Direccion; Date FechaHora; String  Disponible;
    int idHorario=0; int idMedico=0;
    public CitasMedicas(){
        
    }
     public CitasMedicas(int CodigCita,int idPaciente,String Nombres, String Apellidos,String Cedula,
             String Medico, String Horario,int id , String motivos, float Costo,int idHorario,int idMedico,String Doctor,String Especialidad,
            String Area, Date FechaHora, String Direccion,String Disponible){
         
        super(idPaciente, Nombres,  Apellidos, Cedula);
        this.id=id;
        this.motivos=motivos;
        this.Costo= Costo;
        
            this.idHorario= idHorario;
       this.idHorario=idHorario;
        this.Doctor=Doctor;
        this.Especialidad=Especialidad;
        this.Area=Area;
        this.FechaHora=FechaHora;
        this.Disponible=Disponible;
        this.Direccion=Direccion;
    }


    public int getCodigCita() {
       return CodigCita;
    }

    /* public CitasMedicas(String CodigCita,String Motivo,String Ubicacion,String Doctor,String DetallesMotv, String Horario){
    }*/
    public void setCodigCita(int CodigCita) {
        this.CodigCita = CodigCita;
    }

    @Override
    public int getIdHorario() {
        return idHorario;
    }

    @Override
    public int getIdMedico() {
         return idMedico;
    }

    @Override
    public String getDoctor() {
        return Doctor;
    }

    @Override
    public String getSpecialidad() {
        return Especialidad;
    }

    @Override
    public String getArea() {
        return Area;
    }

    @Override
    public Date getFechaHora() {
       return FechaHora;
    }

    @Override
    public String getDisponible() {
       return Disponible;
    }

   
    @Override
    public String getMotivos() {
     return motivos;
    }

    @Override
    public void setIdHorario(int idHorario) {
       this.idHorario=idHorario;
    }

    @Override
    public void setIdMedico(int idMedico) {
    this.idMedico=idMedico;
    }

    @Override
    public void setDisponible(String Disponible) {
    this.Disponible=Disponible;
    }

    @Override
    public void setFechaHora(Date FechaHora) {
       this.FechaHora=FechaHora;
    }

    @Override
    public void setMotivos(String motivos) {
    this.motivos=motivos;
    }
    
    
}
