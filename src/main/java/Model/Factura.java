
package Model;

/**
 *
 * @author angeldvvp
 */
public class Factura {
    
    String Nombres="", Apellidos="", Cedula="",
            FechaNacimiento="", Provincia="",Direccion="",Telefono="",NumCelular="",Canton="",
            MotivoCita="", Diagnostico="";
    float Subtotal=0, Total=0, Descuento=0,Iva=0;
    int CodigoPaciente=0;
    public Factura(){
        
    }
    
    public Factura(int CodigoPaciente,String Nombres, String Apellidos,String Cedula,String FechaNacimiento, String Provincia,String Direccion,
   String Telefono,String NumCelular,String Canton,String MotivoCita,String Diagnostico, float Subtotal, float Total,float Descuento
    ,float Iva){
        this.CodigoPaciente= CodigoPaciente;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Cedula = Cedula;
        this.FechaNacimiento = FechaNacimiento;
        this.Provincia = Provincia;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.NumCelular = NumCelular;
        this.Canton = Canton;
        this.MotivoCita = MotivoCita;
        this.Diagnostico = Diagnostico;
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

    

   
    
    
    
}
