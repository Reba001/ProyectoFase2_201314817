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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaper
 */
public class DetalleIniciativa {
    public DetalleIniciativa(){
        
    }
    public ArrayList<ReporteDonacion> getListaDonaciones(String usuario){
        Connection dbConeciton = null;
        PreparedStatement ps = null;
        String ScriptSQL = "select d.iddonacion, i.nombre, d.monto, d.fechadonacion, r.nombre, r.paquete from donacion d, iniciativa i, recompensa r where (d.idiniciativa = i.idinciativa and d.idusuario = ?) and d.monto = r.montominimo" ;
        try{
            ArrayList<ReporteDonacion> reportesD = new ArrayList<ReporteDonacion>() ;
            dbConeciton = new Conexion().getDBConnection();
            ps = dbConeciton.prepareStatement(ScriptSQL);
            ps.setString(1, usuario);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                ReporteDonacion rd = new ReporteDonacion();
                rd.setIddonacion(rs.getInt(1));
                rd.setNombreiniciativa(rs.getString(2));
                rd.setMonto(rs.getFloat(3));
                rd.setFechadonacion(rs.getDate(4));
                rd.setNombrerecompensa(rs.getString(5));
                rd.setPaquete(rs.getString(6));
                reportesD.add(rd);
            }
            dbConeciton.close();
            ps.close();
            rs.close();
            return reportesD;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Blog> getListaBlog(int idiniciativa){
        Connection dbConeciton = null;
        PreparedStatement ps = null;
        String ScriptSQL = "select * from blog where idiniciativa = ?";
        try{
            ArrayList<Blog> blogss = new ArrayList<Blog>() ;
            dbConeciton = new Conexion().getDBConnection();
            ps = dbConeciton.prepareStatement(ScriptSQL);
            ps.setInt(1, idiniciativa);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Blog b = new Blog();
                b.setIdblog(rs.getInt("idblog"));
                b.setPublicacion(rs.getString("publicacion"));
                b.setFecha(rs.getDate("fecha"));
                b.setHora(rs.getTime("hora"));
                b.setIdiniciativa(rs.getInt("idiniciativa"));
                blogss.add(b);
            }
            dbConeciton.close();
            ps.close();
            rs.close();
            return blogss;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<DenunciaComentario> getListaDenunciaIniciativa(){
                Connection dbConection = null;
        PreparedStatement ps = null;
        String SQLScript = "select denuncia.iddenuncia, denuncia.idperfil, denuncia.tipo, denuncia.usuario, iniciativa.nombre"+
                " from  denuncia, iniciativa where (iniciativa.idinciativa = denuncia.idperfil)";
        try{
            ArrayList<DenunciaComentario> comentarios = new ArrayList<DenunciaComentario>();
            dbConection = new Conexion().getDBConnection();
            ps = dbConection.prepareStatement(SQLScript);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                DenunciaComentario dc = new DenunciaComentario();
                dc.setIddenuncia(rs.getInt(1));
                dc.setIdcomentario(rs.getInt(2));
                dc.setTipo(rs.getInt(3));
                dc.setUsuario(rs.getString(4));
                
                dc.setIniciativa(rs.getString(5));
                comentarios.add(dc);
            }
            dbConection.close();
            ps.close();
            rs.close();
            return comentarios;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<DenunciaComentario> getListaDenuncia(){
                Connection dbConection = null;
        PreparedStatement ps = null;
        String SQLScript = "select denuncia.iddenuncia, denuncia.idcomentario, denuncia.tipo, denuncia.usuario, comentario.descripcion, iniciativa.nombre"+
                " from comentario, denuncia, iniciativa where (comentario.idcomentario = denuncia.idcomentario) and (iniciativa.idinciativa = comentario.idiniciativa)";
        try{
            ArrayList<DenunciaComentario> comentarios = new ArrayList<DenunciaComentario>();
            dbConection = new Conexion().getDBConnection();
            ps = dbConection.prepareStatement(SQLScript);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                DenunciaComentario dc = new DenunciaComentario();
                dc.setIddenuncia(rs.getInt(1));
                dc.setIdcomentario(rs.getInt(2));
                dc.setTipo(rs.getInt(3));
                dc.setUsuario(rs.getString(4));
                dc.setComentario(rs.getString(5));
                dc.setIniciativa(rs.getString(6));
                comentarios.add(dc);
            }
            dbConection.close();
            ps.close();
            rs.close();
            return comentarios;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<DenunciaComentario> getListaDenuncia(String usuario){
                Connection dbConection = null;
        PreparedStatement ps = null;
        String SQLScript = "select denuncia.iddenuncia, denuncia.idcomentario, denuncia.tipo, denuncia.usuario, comentario.descripcion, iniciativa.nombre"+
                " from comentario, denuncia, iniciativa where (comentario.idcomentario = denuncia.idcomentario) and (iniciativa.idusuario = ?)";
        try{
            ArrayList<DenunciaComentario> comentarios = new ArrayList<DenunciaComentario>();
            dbConection = new Conexion().getDBConnection();
            ps = dbConection.prepareStatement(SQLScript);
            ps.setString(1, usuario);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                DenunciaComentario dc = new DenunciaComentario();
                dc.setIddenuncia(rs.getInt(1));
                dc.setIdcomentario(rs.getInt(2));
                dc.setTipo(rs.getInt(3));
                dc.setUsuario(rs.getString(4));
                dc.setComentario(rs.getString(5));
                dc.setIniciativa(rs.getString(6));
                comentarios.add(dc);
            }
            dbConection.close();
            ps.close();
            rs.close();
            return comentarios;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Comentario> getListaComentario( int idiniciativa){
                Connection dbC = null;
        PreparedStatement ps = null;
        String scriptSQL = "select * from comentario where idiniciativa = ? ";
        try{
            ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(scriptSQL);
            
            ps.setInt(1, idiniciativa);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Comentario c = new Comentario();
                c.setIdComentario(rs.getInt("idcomentario"));
                c.setComentario(rs.getString("descripcion"));
                c.setFecha(rs.getDate("fecha"));
                c.setIdiniciativa(rs.getInt("idiniciativa"));
                c.setUsuario(rs.getString("idusuario"));
                c.setHora(rs.getTime("hora"));
                comentarios.add(c);
            }
            dbC.close();
            
            ps.close();
            
            rs.close();
            
            return comentarios;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Comentario> getListaComentarioBlog( int idblog){
                Connection dbC = null;
        PreparedStatement ps = null;
        String scriptSQL = "select * from comentario where idblog = ? ";
        try{
            ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(scriptSQL);
            
            ps.setInt(1, idblog);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Comentario c = new Comentario();
                c.setIdComentario(rs.getInt("idcomentario"));
                c.setComentario(rs.getString("descripcion"));
                c.setFecha(rs.getDate("fecha"));
                c.setIdiniciativa(rs.getInt("idblog"));
                c.setUsuario(rs.getString("idusuario"));
                c.setHora(rs.getTime("hora"));
                comentarios.add(c);
            }
            dbC.close();
            
            ps.close();
            
            rs.close();
            
            return comentarios;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Recompensa> getListaRecompensa( int idiniciativa){
                Connection dbC = null;
        PreparedStatement ps = null;
        String scriptSQL = "select * from recompensa where idiniciativa = ? ";
        try{
            ArrayList<Recompensa> recompensas = new ArrayList<Recompensa>();
            dbC = new Conexion().getDBConnection();
            ps = dbC.prepareStatement(scriptSQL);
            
            ps.setInt(1, idiniciativa);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Recompensa r = new Recompensa();
                r.setCodrecompensa(rs.getInt("codrecompensa"));
                r.setPaquete(rs.getString("paquete"));
                r.setIdiniciativa(idiniciativa);
                r.setTipo(rs.getString("tipo"));
                r.setNombre(rs.getString("nombre"));
                r.setLimitada(rs.getInt("limitada"));
                r.setMontominimo(rs.getFloat("montominimo"));
                recompensas.add(r);
            }
            dbC.close();
            
            ps.close();
            
            rs.close();
            
            return recompensas;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean modificarIniciativaDescripcion(int idiniciativa, String descripcion){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "update iniciativa set descripcion = ? where idinciativa = ?";
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, descripcion);
            
            
            ps.setInt(2, idiniciativa);
            ps.executeUpdate();
            cn.close();
            ps.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean modificarIniciativaNombre(int idiniciativa, String nuevonombre){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "update iniciativa set nombre = ? where idinciativa = ?";
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, nuevonombre);
            ps.setInt(2, idiniciativa);
            
            ps.executeUpdate();
            cn.close();
            ps.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
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
    public ArrayList<Iniciativa> getIniciativa(int idIniciativa){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select * from iniciativa where idinciativa = ? ";
        try{
            ArrayList<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setInt(1, idIniciativa);
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
    public ArrayList<Iniciativa> getListaNombre(String nombre){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select * from iniciativa where nombre = ? order by nombre";
        try{
            ArrayList<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, nombre);
            
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
    
    public int getIdCategoria (String nombre){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "select idcategoria from categoria where nombre = ?";
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.setString(1, nombre);
            ResultSet rs ;
            rs = ps.executeQuery();
            int id = 0;
            while(rs.next()){
                id = rs.getInt("idcategoria");
            }
            
            cn.close();
            ps.close();
            rs.close();
            return id;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public boolean setCategoria(String ruta){
        Connection cn = null;
        PreparedStatement ps = null;
        String SQLScript = "COPY categoria, subcategoria FROM "+ruta+" USING DELIMITERS ','";
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(SQLScript);
            ps.executeUpdate();
            cn.close();
            ps.close();
            
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
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
                in.setPorcentaje(rs.getFloat("porcentajeganancia"));
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
    public ArrayList<String> listaSubcategoria(){
        Connection cn = null;
        PreparedStatement ps = null;
        String selectSQL = "select nombre from subcategoria";
        ArrayList<String> subcategorias = new ArrayList();
        try{
            
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(selectSQL);
            
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
    public ArrayList<Integer> getIdSubCategoriaS(){
        Connection cn = null;
        PreparedStatement ps = null;
        String insertScript ="select idsubcategoria from subcategoria ";
        try{
            ArrayList<Integer> subcategoriasId = new ArrayList<Integer>();
            
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(insertScript);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                int id;
                id = rs.getInt("idsubcategoria");
                subcategoriasId.add(id);
            }
            rs.close();
            ps.close();
            cn.close();
            return subcategoriasId;
        }catch(SQLException e){
            System.err.print("Error: "+ e.getMessage());
            return null;
        }catch(Exception e){
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
    
    public ArrayList<Integer> getIdCategorias(){
        Connection cn = null;
        PreparedStatement ps = null;
        String insertScript ="select idcategoria from categoria";
        try{
            ArrayList<Integer> identificadores = new ArrayList<Integer> ();
            
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(insertScript);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                int id = 0;
                id = rs.getInt("idcategoria");
                identificadores.add(id);
            }
            rs.close();
            ps.close();
            cn.close();
            return identificadores;
        }catch(SQLException e){
            System.err.print("Error: "+ e.getMessage());
            return null;
        }catch(Exception e){
            System.err.print("Error: "+ e.getMessage());
            return null;
        }
        
    }
    public ArrayList<Categoria> listaSubCategorias(){
        Connection cn = null;
        PreparedStatement ps = null;
        String insertSQL = "select * from subcategoria";
        ArrayList<Categoria> categorias = new ArrayList();
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(insertSQL);
            ResultSet rs;
            rs = ps.executeQuery();
            
            while(rs.next()){
                Categoria c = new Categoria();
                c.setIdcategoria(rs.getInt("idsubcategoria"));
                c.setNombre(rs.getString("nombre"));
                categorias.add(c);
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
    public ArrayList<Categoria> listaCategorias(){
        Connection cn = null;
        PreparedStatement ps = null;
        String insertSQL = "select * from categoria";
        ArrayList<Categoria> categorias = new ArrayList();
        try{
            cn = new Conexion().getDBConnection();
            ps = cn.prepareStatement(insertSQL);
            ResultSet rs;
            rs = ps.executeQuery();
            
            while(rs.next()){
                Categoria c = new Categoria();
                c.setIdcategoria(rs.getInt("idcategoria"));
                c.setNombre(rs.getString("nombre"));
                categorias.add(c);
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
