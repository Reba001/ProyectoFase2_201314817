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
public class WSR extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WSR</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WSR at " + request.getContextPath() + "</h1>");
            
            Persona p = new Persona();
            String nick = request.getParameter("txtUsuario");
            String nombre = request.getParameter("txtNombre");
            String fechanac = request.getParameter("txtFechaNac");
            String direccion = request.getParameter("txtDireccion");
            String telefono = request.getParameter("txtTelefono");
            String contrasenia = request.getParameter("txtContrasenia");
            String correo = request.getParameter("txtCorreo");
            String numcuenta = request.getParameter("txtNumCuenta");
            if(!"".equals(nick) && !"".equals(nombre) && !"".equals(contrasenia)){
                if(p.setPersona(nick, nombre, fechanac, direccion, telefono, contrasenia, correo, numcuenta) ){ 
                    if(p.setRol(nick, 1)){
                        out.print("<h1>Ingresado</h2>");
                    }
                }
            }
            
        }/**catch(){
        }catch(){
        }**/finally{
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

}
