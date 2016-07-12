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

/**
 *
 * @author aaper
 */
public class DenunciarIniciativa extends HttpServlet {

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
            String nombre = request.getParameter("nombre");
            String idcomentario = request.getParameter("idiniciativa");
            String usuario = request.getParameter("usuario");
            String user = (String) request.getSession().getAttribute("Usuario");
            int id = Integer.parseInt(idcomentario);
            
                    request.getSession().setAttribute("husuario", usuario);
                    request.getSession().setAttribute("hnombre", nombre);
                    request.getSession().setAttribute("hidiniciativa", idcomentario);
            if(setDenunciaIniciativa(id, 2, user)){
               
                response.sendRedirect("proyecto-usuariodiferente2.jsp");
            }
            
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

    private static boolean setDenunciaIniciativa(int idIniciativa, int tipo, java.lang.String usuario) {
        wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
        wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
        return port.setDenunciaIniciativa(idIniciativa, tipo, usuario);
    }

}
