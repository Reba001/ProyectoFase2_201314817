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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaper
 */
public class DetalleIniciativa {
    public DetalleIniciativa(){
        
    }
    public void borrarIniciativa(String idusuario,String nombre){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "DELETE FROM iniciativa WHERE idusuario = ? and nombre = ?";
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            
            ps.setString(1, idusuario);
            ps.setString(2, nombre);
            ps.executeUpdate();
            cn.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void publicarIniciativa(String idusuario,String nombre ,String publicado){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "UPDATE iniciativa SET publicado = ? WHERE idusuario = ? and nombre = ?";
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, publicado);
            ps.setString(2, idusuario);
            ps.setString(3, nombre);
            ps.executeUpdate();
            cn.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean getPublicacion(String usuario){
        Connection cn  = null;
        PreparedStatement ps = null;
        String SQLScript = "select publicado from iniciativa where idusuario = ?";
        String publicado ="";
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, usuario);
            ResultSet rs;
            rs = ps.executeQuery();
            
            while(rs.next()){
                publicado = rs.getString("publicado");
            }
        }catch(SQLException e){
            e.printStackTrace();
            
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
            if(publicado == "si"){
                return true;
            }else 
                return false;
    }
    public ArrayList<Iniciativa> getIniciativasBorrador(String usuario){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select * from iniciativa where idusuario = ? and publicado ='no'";
        try{
            ArrayList<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, usuario);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Iniciativa in = new Iniciativa();
                in.setIdiniciativa(rs.getInt("idinciativa"));
                in.setNombre(rs.getString("nombre"));
                in.setFechainicio(rs.getDate("fechainicio"));
                in.setFechafinal(rs.getDate("fechafinal"));
                in.setIdUsuario(rs.getString("idusuario"));
                in.setMetaEconomica(rs.getDouble("metaeconomica"));
                in.setIdSubcategoria(rs.getInt("idsubcategoria"));
                in.setDescripcion(rs.getString("descripcion"));
                iniciativas.add(in);
            }
            cn.close();
            ps.close();
            rs.close();
            return iniciativas;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Iniciativa> getIniciativa(int idIniciativa, String usuario, String nombre ){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select * from iniciativa where idinciativa = ? and idusuario = ? and nombre = ? ";
        try{
            ArrayList<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setInt(1, idIniciativa);
            ps.setString(2, usuario);
            ps.setString(3, nombre);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Iniciativa in = new Iniciativa();
                in.setIdiniciativa(rs.getInt("idinciativa"));
                in.setNombre(rs.getString("nombre"));
                in.setFechainicio(rs.getDate("fechainicio"));
                in.setFechafinal(rs.getDate("fechafinal"));
                in.setIdUsuario(rs.getString("idusuario"));
                in.setMetaEconomica(rs.getDouble("metaeconomica"));
                in.setIdSubcategoria(rs.getInt("idsubcategoria"));
                in.setDescripcion(rs.getString("descripcion"));
                iniciativas.add(in);
            }
            cn.close();
            ps.close();
            rs.close();
            return iniciativas;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Iniciativa> getIniciativa(String usuario){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select * from iniciativa where idusuario = ? and publicado ='si'";
        try{
            ArrayList<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, usuario);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Iniciativa in = new Iniciativa();
                in.setIdiniciativa(rs.getInt("idinciativa"));
                in.setNombre(rs.getString("nombre"));
                in.setFechainicio(rs.getDate("fechainicio"));
                in.setFechafinal(rs.getDate("fechafinal"));
                in.setIdUsuario(rs.getString("idusuario"));
                in.setMetaEconomica(rs.getDouble("metaeconomica"));
                in.setIdSubcategoria(rs.getInt("idsubcategoria"));
                in.setDescripcion(rs.getString("descripcion"));
                iniciativas.add(in);
            }
            cn.close();
            ps.close();
            rs.close();
            return iniciativas;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Iniciativa> getlistaIniciativa(String nombre){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select * from iniciativa where nombre = ? order by nombre";
        try{
            ArrayList<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Iniciativa in = new Iniciativa();
                in.setIdiniciativa(rs.getInt("idinciativa"));
                in.setNombre(rs.getString("nombre"));
                in.setFechainicio(rs.getDate("fechainicio"));
                in.setFechafinal(rs.getDate("fechafinal"));
                in.setIdUsuario(rs.getString("idusuario"));
                in.setMetaEconomica(rs.getDouble("metaeconomica"));
                in.setIdSubcategoria(rs.getInt("idsubcategoria"));
                in.setDescripcion(rs.getString("descripcion"));
                iniciativas.add(in);
            }
            cn.close();
            ps.close();
            rs.close();
            return iniciativas;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Iniciativa> getlistaIniciativa(){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select * from iniciativa where publicado = 'si' order by nombre";
        try{
            ArrayList<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Iniciativa in = new Iniciativa();
                in.setIdiniciativa(rs.getInt("idinciativa"));
                in.setNombre(rs.getString("nombre"));
                in.setFechainicio(rs.getDate("fechainicio"));
                in.setFechafinal(rs.getDate("fechafinal"));
                in.setIdUsuario(rs.getString("idusuario"));
                in.setMetaEconomica(rs.getDouble("metaeconomica"));
                in.setIdSubcategoria(rs.getInt("idsubcategoria"));
                in.setDescripcion(rs.getString("descripcion"));
                iniciativas.add(in);
            }
            cn.close();
            ps.close();
            rs.close();
            return iniciativas;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> listaSubcategoria(int idcategoria){
        Connection cn = null;
        PreparedStatement ps = null;
        String selectSQL = "select nombre from subcategoria where idcategoria = ?";
        ArrayList<String> subcategorias = new ArrayList();
        try{
            
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(selectSQL);
            ps.setInt(1,idcategoria);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                String subcategoria = rs.getString("nombre");
                subcategorias.add(subcategoria);
            }
            rs.close();
            cn.close();
            ps.close();
            return subcategorias;
        }catch(SQLException e){
            System.err.print("Error: "+ e.getMessage());
            return null;
        }catch (Exception e){
            
            System.err.print("Error: "+ e.getMessage());
            return null;
        }
    }
    public int getIdSubCategoria(String nombre){
        Connection cn = null;
        PreparedStatement ps = null;
        String insertScript ="select idsubcategoria from subcategoria where nombre = ?";
        try{
            int id = 0;
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(insertScript);
            ps.setString(1, nombre);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("idsubcategoria");
            }
            rs.close();
            ps.close();
            cn.close();
            return id;
        }catch(SQLException e){
            System.err.print("Error: "+ e.getMessage());
        }catch(Exception e){
            System.err.print("Error: "+ e.getMessage());
        }
        return -1;
    }
    
    public int getIdCategoria(String nombre){
        Connection cn = null;
        PreparedStatement ps = null;
        String insertScript ="select idcategoria from categoria where nombre = ?";
        try{
            int id = 0;
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(insertScript);
            ps.setString(1, nombre);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("idcategoria");
            }
            rs.close();
            ps.close();
            cn.close();
            return id;
        }catch(SQLException e){
            System.err.print("Error: "+ e.getMessage());
        }catch(Exception e){
            System.err.print("Error: "+ e.getMessage());
        }
        return -1;
    }
    
    public ArrayList<String> listaCategoria(){
        Connection cn = null;
        PreparedStatement ps = null;
        String insertSQL = "select nombre from categoria";
        ArrayList<String> categorias = new ArrayList();
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(insertSQL);
            ResultSet rs;
            rs = ps.executeQuery();
            String categoria ="";
            while(rs.next()){
                categoria = rs.getString("nombre");
                categorias.add(categoria);
            }
            cn.close();
            ps.close();
            rs.close();
            return categorias;
            
        }catch(SQLException e){
            System.err.print("Error: "+ e.getMessage());
        }catch(Exception e){
            System.err.print("Error: "+ e.getMessage());
        }
        return null;
    }
    
    public boolean setIniciativa(String nombre, String fechainicio, String fechafinal, String idusuario, 
            String descripcion, double metaeconomica, int idSubcategoria, String publicada){
        Connection dbC = null;
        PreparedStatement ps = null;
        String insertTableSQL = "insert into iniciativa"+
                " (nombre, fechainicio, fechafinal, idusuario, descripcion, metaeconomica, idsubcategoria, publicado)"+
                " values (?,?,?,?,?,?,?,?)";
         try {
            SimpleDateFormat sdffinal = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfinicio = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date sqDfinal = sdffinal.parse(fechafinal);
            java.util.Date sqDinicio = sdfinicio.parse(fechainicio);
            java.sql.Date sqlDatefinal = new java.sql.Date(sqDfinal.getTime());
            java.sql.Date sqlDateinicio = new java.sql.Date(sqDinicio.getTime());
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(insertTableSQL);
            ps.setString(1, nombre);
            ps.setDate(2, sqlDateinicio);
            ps.setDate(3, sqlDatefinal);
            ps.setString(4, idusuario);
            ps.setString(5, descripcion);
            ps.setDouble(6, metaeconomica);
            ps.setInt(7, idSubcategoria);
            ps.setString(8, publicada);

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
   
    
}
