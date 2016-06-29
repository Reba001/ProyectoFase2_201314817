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
public class Usuario {
    private String nickname;
    private String nombre;
    private Date fechanac;
    private String direccion;
    private int telefono;
    private String contasenia;
    private String correo;
    private String nuncuenta;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContasenia() {
        return contasenia;
    }

    public void setContasenia(String contasenia) {
        this.contasenia = contasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNuncuenta() {
        return nuncuenta;
    }

    public void setNuncuenta(String nuncuenta) {
        this.nuncuenta = nuncuenta;
    }
    
    
}
