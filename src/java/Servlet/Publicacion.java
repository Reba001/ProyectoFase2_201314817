/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexiones.DetalleIniciativa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aaper
 */
public class Publicacion extends HttpServlet {

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
            String publicar = request.getParameter("btnPublicar");
            HttpSession sessionIn = request.getSession();
            String usuario = (String) sessionIn.getAttribute("Usuario");
            String eliminar = request.getParameter("btnEliminar");
            DetalleIniciativa di = new DetalleIniciativa();
            String radio = request.getParameter("dish");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Publicacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Publicacion at " + request.getContextPath() + "</h1>");
            if(publicar != null){
                if(radio != null){
                    di.publicarIniciativa(usuario,radio,"si");
                    response.sendRedirect("Iniciativa.jsp");
                }else{
                    response.sendRedirect("Iniciativa.jsp?error=No posee ningun proyecto en borrador");
                }
            }else if(eliminar != null){
                if(radio != null){
                    di.borrarIniciativa(usuario, radio);
                    response.sendRedirect("Iniciativa.jsp");
                }else{
                    response.sendRedirect("Iniciativa.jsp?error=No posee ningun proyecto en borrador");
                }
                
            }
            out.println("</body>");
            out.println("</html>");
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

}
