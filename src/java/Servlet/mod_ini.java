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
public class mod_ini extends HttpServlet {

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
            HttpSession sessionOk = request.getSession();
            int idini = (int) sessionOk.getAttribute("identificador") ;
            
            String nombreini = request.getParameter("nombreini");
            String usuario = request.getParameter("usuario");
            String descripcionnueva = request.getParameter("txtDescripcion");
            String nombrenuevo = request.getParameter("txttitulo");
            DetalleIniciativa di = new DetalleIniciativa();
            if("".equals(descripcionnueva) && !"".equals(nombrenuevo)){
                if(di.modificarIniciativaNombre(idini, nombrenuevo)){
                    response.sendRedirect("Modini.jsp?error=iniciativa modificada");
                }else{
                    response.sendRedirect("Modini.jsp?error=Error no modificada");
                }
                
            }else if(!"".equals(descripcionnueva) && "".equals(nombrenuevo)){
                if(di.modificarIniciativaDescripcion(idini, descripcionnueva)){
                    response.sendRedirect("Modini.jsp?error=iniciativa modificada");
                }else{
                    
                    response.sendRedirect("Modini.jsp?error=Error no modificada");
                }
            }else if(!"".equals(descripcionnueva) && !"".equals(nombrenuevo)){
                if(di.modificarIniciativaDescripcion(idini, descripcionnueva) && di.modificarIniciativaNombre(idini, nombreini)){
                    response.sendRedirect("Modini.jsp?error=iniciativa modificada");
                }else{
                    
                    response.sendRedirect("Modini.jsp?error=Error no modificada");
                }
            }else {
                response.sendRedirect("Modini.jsp?error=Campos vacios");
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

}
