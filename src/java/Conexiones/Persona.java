/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import DataBase.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    public int getAltaBaja(String nickname){
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT activo FROM gestionusuario WHERE nickname = ?";
        try {
            dbConnection = new Conexion().getDBConnection();
            int rol = -1;

            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, nickname);
            
            ResultSet rs;
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                rol = rs.getInt("activo");
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
    public boolean actualizarActividad(String usuario, int activo){
        Connection dbC = null;
        PreparedStatement ps = null;
        String insertTableSQL = "UPDATE gestionusuario"+
                " SET activo = ?"+
                " WHERE nickname = ?";
         try {
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(insertTableSQL);
            
            ps.setInt(1, activo);
            ps.setString(2, usuario);
            

            // execute insert SQL stetement
            ps.executeUpdate();
            dbC.close();
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<GestiondeUsuario> listaGestion(){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLscript = "SELECT * FROM gestionusuario";
        try{
            ArrayList<GestiondeUsuario> gestiones = new ArrayList<GestiondeUsuario>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLscript);
            ResultSet rs;
            rs = ps.executeQuery();
            
            while(rs.next()){
                GestiondeUsuario gu = new GestiondeUsuario();
                gu.setIdgestion(rs.getInt("idgestion"));
                gu.setActivo(rs.getInt("activo"));
                gu.setNickname(rs.getString("nickname"));
                gu.setHoraentrada(rs.getTime("horaentrada"));
                gu.setHorasalida(rs.getTime("horasalida"));
                gu.setFechaingreso(rs.getDate("fechaingreso"));
                gestiones.add(gu);
            }
            return gestiones;
            
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
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
    public boolean actualizarSalida(String usuario, Time horasalida){
        Connection dbC = null;
        PreparedStatement ps = null;
        String insertTableSQL = "UPDATE gestionusuario"+
                " SET horasalida = ?"+
                " WHERE nickname = ?";
         try {
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(insertTableSQL);
            
            ps.setTime(1, horasalida);
            ps.setString(2, usuario);
            

            // execute insert SQL stetement
            ps.executeUpdate();
            dbC.close();
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean setGestion(int activo, String nickname, Time horaentrada, Date fechaingreso){
        //TODO write your implementation code here:
        Connection dbC = null;
        PreparedStatement ps = null;
        String insertTableSQL = "insert into gestionusuario"+
                " (activo, nickname, horaentrada, fechaingreso)"+
                " values (?,?,?,?)";
         try {
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(insertTableSQL);
            ps.setInt(1, activo);
            ps.setString(2, nickname);
            ps.setTime(3, horaentrada);
            ps.setDate(4, fechaingreso);

            // execute insert SQL stetement
            ps.executeUpdate();
            dbC.close();
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean actualizarRol(String usuario, int rol){
        Connection dbc = null;
        PreparedStatement ps = null;
        String insertTableSQL = "UPDATE usuario SET rol = ? WHERE nickname = ?";
        try{
            dbc = new Conexion().getDBConnection();
            ps = dbc.prepareStatement(insertTableSQL);
            ps.setInt(1, rol);
            ps.setString(2, usuario);
            ps.executeUpdate();
            dbc.close();
            ps.close();
            return true;
        }catch(SQLException e){
            System.err.println("Error: "+ e.getMessage());
                    
            return false;
        }
        catch (Exception e){
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
    public ArrayList<Usuario> listaUsuario(){
        Connection dbC = null;
        PreparedStatement ps = null;
        String consultaSQL = "select * from usuario";
        try{
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(consultaSQL);
            ResultSet rs;
            rs= ps.executeQuery();
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setNickname(rs.getString("nickname"));
                u.setNombre(rs.getString("nombre"));
                u.setFechanac(rs.getDate("fechanac"));
                u.setDireccion(rs.getString("direccion"));
                u.setTelefono(rs.getInt("telefono"));
                u.setContasenia(rs.getString("contrasenia"));
                u.setCorreo(rs.getString("correo"));
                u.setNuncuenta(rs.getString("numcuenta"));
                usuarios.add(u);
            }
            dbC.close();
            ps.close();
            return usuarios;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
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
