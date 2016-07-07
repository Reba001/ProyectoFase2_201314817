/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author aaper
 */
public class Blog {
    private String publicacion;
    private Date fecha;
    private Time hora;
    private int idiniciativa;
    private int idblog;

    public int getIdblog() {
        return idblog;
    }

    public void setIdblog(int idblog) {
        this.idblog = idblog;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getIdiniciativa() {
        return idiniciativa;
    }

    public void setIdiniciativa(int idiniciativa) {
        this.idiniciativa = idiniciativa;
    }
    
}
