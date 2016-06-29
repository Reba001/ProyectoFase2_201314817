/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexiones.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aaper
 */
public class WSI extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");

            try{
                
                Persona p = new Persona();
            
                String user = request.getParameter("txtUsuario");
                String contra = request.getParameter("txtContrasenia");
                if (!user.equals("") && !contra.equals("")){
                    if(operation(user, contra)){
                        int rol = getRol(user);
                        switch (rol){
                            case 1 :
                                int altabaja = getAltaBaja(user);
                                if(altabaja == 1){
                                    
                                    HttpSession sessionok = request.getSession();
                                    sessionok.setAttribute("Usuario",user);
                                    response.sendRedirect("creador.jsp");
                                    java.sql.Time horaentrada = new java.sql.Time(sessionok.getCreationTime());
                                    java.sql.Date fechasalida = new java.sql.Date(sessionok.getCreationTime());
                                    p.setGestion(1, user, horaentrada, fechasalida);
                                }else {
                                    response.sendRedirect("index.jsp?error=usuario dado de baja");
                                }
                                break;
                            case 2: 
                                HttpSession sessionA = request.getSession();
                                sessionA.setAttribute("Administrador",user);
                                response.sendRedirect("administrador.jsp");
                                java.sql.Time horaen = new java.sql.Time(sessionA.getCreationTime());
                                java.sql.Date fecha = new java.sql.Date(sessionA.getCreationTime());
                                String hora = horaen.toString();
                                String fech = fecha.toString();
                                p.setGestion(1, user, horaen, fecha);
                                break;
                            default :
                                response.sendRedirect("index.jsp?error=No posee ningun rol");
                        }
                        
                    }else{
                        response.sendRedirect("index.jsp?error=Nombre de Usuario y/o Clave Incorrecto");
                    
                    }
                }else{
                    response.sendRedirect("index.jsp?error=Nombre de Usuario y/o Clave Vacio");
                
                }
            }catch(Exception e){
                response.sendRedirect("index.jsp?error=Nombre de Usuario y/o Clave Error");
            }
  
        }catch(NumberFormatException e){
            out.print("<h2>"+e.getMessage()+"</h2>");
        }catch(Exception e){
            out.print("<h2>"+e.getMessage()+"</h2>");
        }finally{
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

    private static Integer getAltaBaja(java.lang.String nickname) {
        ServiciosWeb.Persona_Service service = new ServiciosWeb.Persona_Service();
        ServiciosWeb.Persona port = service.getPersonaPort();
        return port.getAltaBaja(nickname);
    }

    private static Integer getRol(java.lang.String usuario) {
        ServiciosWeb.Persona_Service service = new ServiciosWeb.Persona_Service();
        ServiciosWeb.Persona port = service.getPersonaPort();
        return port.getRol(usuario);
    }

    private static Boolean operation(java.lang.String usuarios, java.lang.String contrasenia) {
        ServiciosWeb.Persona_Service service = new ServiciosWeb.Persona_Service();
        ServiciosWeb.Persona port = service.getPersonaPort();
        return port.operation(usuarios, contrasenia);
    }

    

}
