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
public class GestiondeUsuario {
    int idgestion;
    int activo;
    String nickname;
    Time horaentrada;
    Time horasalida;
    Date fechaingreso;

    public int getIdgestion() {
        return idgestion;
    }

    public void setIdgestion(int idgestion) {
        this.idgestion = idgestion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Time getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(Time horaentrada) {
        this.horaentrada = horaentrada;
    }

    public Time getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Time horasalida) {
        this.horasalida = horasalida;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    
    
}
