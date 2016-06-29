/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexiones.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                if(setPersona(nick, nombre, fechanac, direccion, telefono, contrasenia, correo, numcuenta) ){ 
                    if(setRol(nick, 1)){
                        Date fecha = new Date();
                        java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
                        Time hora = new Time(fecha.getTime());
                        p.setGestion(1, nick, hora, fechasql);
                        response.sendRedirect("registro.jsp?error=Usted ha sido registrado");
                    }else{
                        response.sendRedirect("registro.jsp?error=Ha ocurrido un error");
                    }
                }else{
                    
                        response.sendRedirect("registro.jsp?error=Ha ocurrido un error");
                }
            }else{
                    
                        response.sendRedirect("registro.jsp?error=Ha ocurrido un error");
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

    private static boolean setRol(java.lang.String nickname, int rol) {
        ServiciosWeb.Persona_Service service = new ServiciosWeb.Persona_Service();
        ServiciosWeb.Persona port = service.getPersonaPort();
        return port.setRol(nickname, rol);
    }

    private static boolean setPersona(java.lang.String nick, java.lang.String nom, java.lang.String fechanac, java.lang.String direccion, java.lang.String telefono, java.lang.String contrasenia, java.lang.String correo, java.lang.String numcuenta) {
        ServiciosWeb.Persona_Service service = new ServiciosWeb.Persona_Service();
        ServiciosWeb.Persona port = service.getPersonaPort();
        return port.setPersona(nick, nom, fechanac, direccion, telefono, contrasenia, correo, numcuenta);
    }

}
