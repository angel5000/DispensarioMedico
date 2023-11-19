
package Model;

import Model.DatosFacturacion.DatosPaciente;

/**
 *
 * @author angeldvvp
 */
public class Factura implements DatosPaciente {
    
    String Nombres="", Apellidos="", Cedula="",
            FechaNacimiento="", Provincia="",Direccion="",Telefono="",NumCelular="",Canton="",
            MotivoCita="", Diagnostico="";
    float Subtotal=0, Total=0, Descuento=0,Iva=0;
    int CodigoFactura=0;
    public Factura(){
        
    }
    
    public Factura(int CodigoFactura, float Subtotal, float Total,float Descuento,float Iva){
        this.CodigoFactura= CodigoFactura;
        this.Subtotal = Subtotal;
        this.Total = Total;
        this.Descuento = Descuento;
        this.Iva = Iva;
        
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }

    public float getIva() {
        return Iva;
    }

    public void setIva(float Iva) {
        this.Iva = Iva;
    }

    @Override
    public String getApellidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCedula() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFechaNacimiento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getProvincia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDireccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTelefono() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getNumCelular() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCanton() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

   
    
    
    
}
