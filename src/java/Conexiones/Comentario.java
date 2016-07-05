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
public class Comentario {
    private int idComentario;
    private String usuario;
    private String comentario;
    private Date fecha;
    private int idiniciativa;
    private Time hora;

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdiniciativa() {
        return idiniciativa;
    }

    public void setIdiniciativa(int idiniciativa) {
        this.idiniciativa = idiniciativa;
    }
    
}
