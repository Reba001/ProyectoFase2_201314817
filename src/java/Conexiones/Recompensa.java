/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

/**
 *
 * @author aaper
 */
public class Recompensa {
    private int codrecompensa;
    private String paquete;
    private int idiniciativa;
    private String tipo;
    private String nombre;
    private int limitada;
    private float montominimo;

    public float getMontominimo() {
        return montominimo;
    }

    public void setMontominimo(float montominimo) {
        this.montominimo = montominimo;
    }
    

    public int getCodrecompensa() {
        return codrecompensa;
    }

    public void setCodrecompensa(int codrecompensa) {
        this.codrecompensa = codrecompensa;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public int getIdiniciativa() {
        return idiniciativa;
    }

    public void setIdiniciativa(int idiniciativa) {
        this.idiniciativa = idiniciativa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLimitada() {
        return limitada;
    }

    public void setLimitada(int limitada) {
        this.limitada = limitada;
    }
    
    
    
}
