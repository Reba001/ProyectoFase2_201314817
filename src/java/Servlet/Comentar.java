/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aaper
 */
public class Comentar extends HttpServlet {

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
        String usuario = request.getParameter("usuario");
        String nombre = request.getParameter("nombre");
        String idiniciativa = request.getParameter("idiniciativa");
        try  {
            HttpSession sessionOk = request.getSession();
            String usuarioC = (String) sessionOk.getAttribute("Usuario");
            String comentario = request.getParameter("txtAComent");
            
            if(!"".equals(comentario)){
                Calendar fecha = new GregorianCalendar();
                String f = ""+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR);
                String h = ""+fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND);
                int id = Integer.parseInt(idiniciativa);
                if(setComentario(comentario, f, id, usuarioC,h)){
                    request.getSession().setAttribute("husuario", usuario);
                    request.getSession().setAttribute("hnombre", nombre);
                    request.getSession().setAttribute("hidiniciativa", idiniciativa);
                    response.sendRedirect("proyecto-usuariodiferente2.jsp");
                }
            }else{
                response.sendRedirect("proyecto-usuariodiferente.jsp");
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

    private static boolean setComentario(java.lang.String descripcion, java.lang.String fecha, int idiniciativa, java.lang.String idusuario, java.lang.String hora) {
        wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
        wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
        return port.setComentario(descripcion, fecha, idiniciativa, idusuario, hora);
    }



}
