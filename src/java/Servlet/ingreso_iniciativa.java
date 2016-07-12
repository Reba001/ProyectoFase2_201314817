/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexiones.DetalleIniciativa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author aaper
 */
public class ingreso_iniciativa extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            /**codigo para recompensa*/
            HttpSession sessionok = request.getSession();
            
            
            String nombre = request.getParameter("txtNombreIni");
            String guardarReco = request.getParameter("btnGuardarReco");
            
            /* aqui termina el codigo */
            Calendar fecha = new GregorianCalendar();
            HttpSession sessionIn = request.getSession();
            String usuario =(String) sessionIn.getAttribute("Usuario");
            String fechainicio = ""+fecha.get(Calendar.DAY_OF_MONTH)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
            String fechalimite = request.getParameter("txtFechaLimite");
            String descripcion = request.getParameter("txtDescripcion");
            String meta = request.getParameter("txtMetaEconomica");
            double m = Double.parseDouble(meta);
            String guardar = request.getParameter("btnGuardar");
            String publicar = request.getParameter("btnPublicar");
            String subcategoria = request.getParameter("cbSubC");
            int s = Integer.parseInt(subcategoria);
            sessionIn.setAttribute("nombreInis1", nombre);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ingreso_iniciativa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ingreso_iniciativa at " + request.getContextPath() + "</h1>");
            if(guardar != null && subcategoria != null){
                
                    setIniciativa(nombre, fechainicio, fechalimite, usuario,descripcion, m, s,"no");
                    response.sendRedirect("proceso-creacion-proyecto.jsp?error=Proyecto Guardado");
                
            }else if(publicar != null && subcategoria != null){
                setIniciativa(nombre, fechainicio, fechalimite, usuario,descripcion, m, s,"si");
                response.sendRedirect("proceso-creacion-proyecto.jsp?error=Proyecto Publicado");
            }
            
            
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static boolean setIniciativa(java.lang.String nombre, java.lang.String fechainicio, java.lang.String fechafinal, java.lang.String idusuario, java.lang.String descripcion, double metaeconomica, int idSubcategoria, java.lang.String publicada) {
        wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
        wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
        return port.setIniciativa(nombre, fechainicio, fechafinal, idusuario, descripcion, metaeconomica, idSubcategoria, publicada);
    }

    private static boolean setRecompensa(java.lang.String paquete, int idiniciativa, java.lang.String tipo, int limitada, java.lang.String nombre, float montominimo) {
        wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
        wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
        return port.setRecompensa(paquete, idiniciativa, tipo, limitada, nombre, montominimo);
    }

    private static int getIdRecompensa(java.lang.String nombreIniciativa, java.lang.String usuario) {
        wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
        wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
        return port.getIdRecompensa(nombreIniciativa, usuario);
    }
}
