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
public class Iniciativa {
    private String idiniciativa;
    private String nombre;
    private String fechainicio;
    private String fechafinal;
    private String idUsuario;
    private String descripcion;
    private String metaEconomica;
    public Iniciativa(String idiniciativa, String nombre, String fechainicio, String fechafinal, String idUsuario, String descripcion, String metaEconomica) {
        this.idiniciativa = idiniciativa;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.metaEconomica = metaEconomica;
    }

    public String getIdiniciativa() {
        return idiniciativa;
    }

    public void setIdiniciativa(String idiniciativa) {
        this.idiniciativa = idiniciativa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
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

    public String getMetaEconomica() {
        return metaEconomica;
    }

    public void setMetaEconomica(String metaEconomica) {
        this.metaEconomica = metaEconomica;
    }

    
    
}
