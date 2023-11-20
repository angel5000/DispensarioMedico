
package Model;


/**
 *
 * @author angeldvvp
 */
public class Factura extends Paciente  {
    
   /* String Nombres="", Apellidos="", Cedula="",
            FechaNacimiento="", Provincia="",Direccion="",Telefono="",NumCelular="",Canton="",
            MotivoCita="", Diagnostico="",*/
    String ApellidoDoc="", Motivos="", Especialidad="";
    float Subtotal=0, Total=0, Descuento=0,Iva=0,costo=0;
    int CodigoFactura=0;
    public Factura(){
        
    }
    
    public Factura(int idpaciente,String Nombres, String ApellidoDoc,String Apellidos,String Cedula,String FechaNacimiento, String Provincia,String Direccion,
   String Telefono,String NumCelular,String Canton, int idHistorialMedico,  String Usuario, String Contraseña,int CodigoFactura, 
   float Subtotal, float Total,float Descuento,float Iva, String Motivos, String Especialidad,float costo){
        super( idpaciente,Nombres, Apellidos, Cedula, FechaNacimiento,  Provincia, Direccion, Telefono, NumCelular, Canton
           , idHistorialMedico,   Usuario,  Contraseña);
       this.costo=costo;
        this.CodigoFactura= CodigoFactura;
        this.Subtotal = Subtotal;
        this.Total = Total;
        this.Descuento = Descuento;
        this.Iva = Iva;
        this.Motivos=Motivos;
        this.Especialidad=Especialidad;
    }

    public String getMotivos() {
        return Motivos;
    }

    public void setMotivos(String Motivos) {
        this.Motivos = Motivos;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public void setApellidoDoc(String ApellidoDoc) {
        this.ApellidoDoc = ApellidoDoc;
    }

    public String getApellidoDoc() {
        return ApellidoDoc;
    }

    public void setCodigoFactura(int CodigoFactura) {
        this.CodigoFactura = CodigoFactura;
    }

    public int getCodigoFactura() {
        return CodigoFactura;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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
