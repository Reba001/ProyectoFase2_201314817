/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import wspersona.DetalleIniciativa;

/**
 *
 * @author aaper
 */
public class proceso_recompensa extends HttpServlet {

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
        
        try  {
            String nombre = request.getParameter("nombreI");
            
            HttpSession sessionOk = request.getSession();
            String usuario = (String) sessionOk.getAttribute("Usuario");
            String nombreReco = request.getParameter("txtNombreReco");
            String nombrePaq = request.getParameter("txtPaquete");
            String tipo = request.getParameter("cbTipo");
            String limite = request.getParameter("cbLimitada");
            String montominimo = request.getParameter("txMontominimo");
            String idiniciativa = (String) sessionOk.getAttribute("idiniR");
            float montomin = Float.parseFloat(montominimo);
            int id = Integer.parseInt(idiniciativa);
            if("Fisica".equals(tipo) && "Limitada".equals(limite)){
                
                setRecompensa(nombrePaq, id, "F", 1, nombreReco, montomin);
                response.sendRedirect("recompensa.jsp?error=Proyecto Guardado");
            }else if ("Fisica".equals(tipo) && "Ilimitada".equals(limite)){
                setRecompensa(nombrePaq, id, "F", 0, nombreReco, montomin);
                response.sendRedirect("recompensa.jsp?error=Proyecto Guardado");
            }else if ("No Fisica".equals(tipo) && "Ilimitada".equals(limite)){
                setRecompensa(nombrePaq, id, "NF", 0, nombreReco, montomin);
                response.sendRedirect("recompensa.jsp?error=Proyecto Guardado");
            }else if ("No Fisica".equals(tipo) && "Limitada".equals(limite)){
                setRecompensa(nombrePaq, id, "NF", 1, nombreReco, montomin);
                response.sendRedirect("recompensa.jsp?error=Proyecto Guardado");
            }
            
            
            
            /* TODO output your page here. You may use following sample code. */
            
        }catch(Exception e){
            e.printStackTrace();
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
