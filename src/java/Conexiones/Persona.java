/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import DataBase.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aaper
 */
public class Persona {
    public String nickname, nombre, contrasenia;
    
    public Persona(){
    }
    
    public Persona(String nickname, String nombre,String contrasenia){
        this.nickname = nickname;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
    
    public String getNickname(){
        return this.nickname;
    }
    
    public String getContraseña(){
        return this.contrasenia;
    }
    public boolean setRol(String nick, int rol){
        Connection dbc = null;
        PreparedStatement ps = null;
        String insertTableSQL = "insert into asignarusuario"+
                " (nickname, rol)"+
                " values (?,?)";
        try{
            dbc = new Conexion().getDBConnection();
            ps = dbc.prepareStatement(insertTableSQL);
            
            ps.setString(1, nick);
            ps.setInt(2, rol);
            
            ps.executeUpdate();
            
            dbc.close();
            ps.close();
            return true;
        }catch(SQLException e){
            System.err.println("Error: "+ e.getMessage());
            
            return false;
        }
        
    }
    public boolean setPersona(String nick,String nom, String fechanac, String direccion, String telefono
    , String contrasenia, String correo, String numcuenta){
        Connection dbC = null;
        PreparedStatement ps = null;
        String insertTableSQL = "insert into usuario"+
                " (nickname, nombre, fechanac, direccion, telefono, contrasenia, correo, numcuenta)"+
                " values (?,?,?,?,?,?,?,?)";
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date sqD = sdf.parse(fechanac);
            java.sql.Date sqlDate = new java.sql.Date(sqD.getTime());
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(insertTableSQL);
            int phone = Integer.parseInt(telefono);
            ps.setString(1, nick);
            ps.setString(2, nom);
            ps.setDate(3, sqlDate);
            ps.setString(4, direccion);
            ps.setInt(5, phone);
            ps.setString(6,contrasenia);
            ps.setString(7, correo);
            ps.setString(8, numcuenta);

            // execute insert SQL stetement
            ps.executeUpdate();
            dbC.close();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        } catch (ParseException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean autenticacion(String usuario, String contraseña){
        Connection dbC = null;
        PreparedStatement pst = null; 
        
        try{
            dbC = new Conexion().getDBConnection();
            String consulta = "select * from usuario where (nickname = ? and contrasenia = ?)";
            pst = dbC.prepareStatement(consulta);
            
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            
            ResultSet rs;
            rs = pst.executeQuery();
            int cont= 0;
            
            while(rs.next()) cont++;
            
            if(cont == 1) return true;
            
            dbC.close();
            rs.close();
            pst.close();
        } catch (SQLException e){
            System.err.println("Error"+ e.getMessage());
        }catch(Exception e){
            System.err.println("Error"+e.getMessage());
        }
        return false;
    }
    public int getRol(String nick) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT rol FROM asignarusuario WHERE nickname = ?";
        try {
            dbConnection = new Conexion().getDBConnection();
            int rol = 0;

            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, nick);
            
            ResultSet rs;
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                rol = rs.getInt("rol");
            }
            rs.close();
            return rol;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
     public ArrayList<Persona> getPersonas() {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ArrayList personas = new ArrayList<Persona>();

        String selectSQL = "SELECT * FROM asignarusuario";
        try {
            dbConnection = new Conexion().getDBConnection();

            preparedStatement = dbConnection.prepareStatement(selectSQL);

            ResultSet rs;
            rs = preparedStatement.executeQuery();
            String i;
            String n;
            int a;
            while (rs.next()) {
                i = rs.getString("numasignado");
                n = rs.getString("nickname");
                a = rs.getInt("rol");                
                
            }
            rs.close();
            return personas;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
     
}
