/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.util.Date;

/**
 *
 * @author aaper
 */
public class Iniciativa {
    private int idiniciativa;
    private String nombre;
    private Date fechainicio;
    private Date fechafinal;
    private String idUsuario;
    private String descripcion;
    private double metaEconomica;
    private int idSubcategoria;

    public int getIdiniciativa() {
        return idiniciativa;
    }

    public void setIdiniciativa(int idiniciativa) {
        this.idiniciativa = idiniciativa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMetaEconomica() {
        return metaEconomica;
    }

    public void setMetaEconomica(double metaEconomica) {
        this.metaEconomica = metaEconomica;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }
    
    
    
    
}
