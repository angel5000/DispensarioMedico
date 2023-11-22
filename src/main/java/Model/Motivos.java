/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angeldvvp
 */
public class Motivos {
 int id ; String motivos;float Costo=0f;
    public Motivos(){
        
    }
    public Motivos(int id , String motivos, float Costo){
        this.id=id;
        this.motivos=motivos;
        this.Costo= Costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }

   

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }

    @Override
    public String toString() {
        return motivos;
    }
    
}
