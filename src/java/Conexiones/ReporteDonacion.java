/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Date;

/**
 *
 * @author aaper
 */
public class ReporteDonacion {
    private int iddonacion;
    private String nombreiniciativa;
    private float monto;
    private Date fechadonacion;
    private String nombrerecompensa;
    private String paquete;

    public String getNombrerecompensa() {
        return nombrerecompensa;
    }

    public void setNombrerecompensa(String nombrerecompensa) {
        this.nombrerecompensa = nombrerecompensa;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public int getIddonacion() {
        return iddonacion;
    }

    public void setIddonacion(int iddonacion) {
        this.iddonacion = iddonacion;
    }

    public String getNombreiniciativa() {
        return nombreiniciativa;
    }

    public void setNombreiniciativa(String nombreiniciativa) {
        this.nombreiniciativa = nombreiniciativa;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFechadonacion() {
        return fechadonacion;
    }

    public void setFechadonacion(Date fechadonacion) {
        this.fechadonacion = fechadonacion;
    }
    
}
