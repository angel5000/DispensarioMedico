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
public class HistorialMedico {
    String Paciente; String medico;Date FechaVisita; String Sintomas; String Diagnostico; 
           String Tratamiento; String Receta;
    
    public void HistorialMedico(){
        
    }
   public void HistorialMedico(String Paciente,String medico,Date FechaVisita, String Sintomas, String Diagnostico, 
           String Tratamiento, String Receta){
        
          this.Paciente=Paciente;
          this.medico=medico;
          this.FechaVisita=FechaVisita;
          this.Sintomas=Sintomas;
          this.Diagnostico=Diagnostico;
          this.Tratamiento=Tratamiento;
          this.Receta=Receta;
    }

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

 

    public Date getFechaVisita() {
        return FechaVisita;
    }

    public void setFechaVisita(Date FechaVisita) {
        this.FechaVisita = FechaVisita;
    }

    public String getSintomas() {
        return Sintomas;
    }

    public void setSintomas(String Sintomas) {
        this.Sintomas = Sintomas;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public String getReceta() {
        return Receta;
    }

    public void setReceta(String Receta) {
        this.Receta = Receta;
    }
      
      
}
