/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author angeldvvp
 */
public interface HorariosInterface {
        public int getIdHorario();
    
    public int getIdMedico();

   
    public String getDoctor();

   
    public String getSpecialidad();

    
    public String getArea();
  
    public String getDireccion();
    

    public Date getFechaHora();
    
    public String  getDisponible();
   
    public void setIdHorario(int idHorario);
    

   
    public void setIdMedico(int idMedico);
    

    public void setDisponible(String   Disponible);
  

    public void setFechaHora(Date FechaHora);
    
  
}
