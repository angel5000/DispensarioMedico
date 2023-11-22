/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angeldvvp
 */
public class MetodoPago {
    int idpaciente; int idmotivo; int MetodoPago;
    public MetodoPago(){
        
    }
    
    public MetodoPago(int idpaciente, int idmotivo, int MetodoPago){
        this.idpaciente=idpaciente;
        this.idmotivo=idmotivo;
        this.MetodoPago=MetodoPago;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(int idmotivo) {
        this.idmotivo = idmotivo;
    }

    public int getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(int MetodoPago) {
        this.MetodoPago = MetodoPago;
    }
    
    
    
}
