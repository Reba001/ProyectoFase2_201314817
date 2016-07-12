/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexiones.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aaper
 */
public class baja_altainiciativa extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String baja = request.getParameter("baja");
            String alta = request.getParameter("alta");
            String txtPorcentaje = request.getParameter("txtPorcentaje");
            String porcentaje = request.getParameter("porcentaje");
            String usuario = request.getParameter("idiniciativa");
            if (baja != null){
                if(usuario !=null){
                    
                    int id = Integer.parseInt(usuario);
                    eliminarIniciativa(id, "no");
                    response.sendRedirect("Iniciativas.jsp");
                }
            }else if (alta != null){
                
                    int id = Integer.parseInt(usuario);
                    eliminarIniciativa(id, "Si");
                    response.sendRedirect("Iniciativas.jsp");
            }else if (porcentaje != null){
                if(usuario != null){
                    if(txtPorcentaje != null){
                        float po = Float.parseFloat(txtPorcentaje) / 100;
                        int idin = Integer.parseInt(usuario);
                        setGanancia(idin, po);
                        response.sendRedirect("Iniciativas.jsp");
                    }
                }
            }
        }catch (Exception e){
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

    private static boolean eliminarIniciativa(int idiniciativa, java.lang.String publicado) {
        wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
        wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
        return port.eliminarIniciativa(idiniciativa, publicado);
    }

    private static boolean setGanancia(int idiniciativa, float porcentajeiniciativa) {
        wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
        wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
        return port.setGanancia(idiniciativa, porcentajeiniciativa);
    }




}
