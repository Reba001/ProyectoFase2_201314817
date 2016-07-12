<%-- 
    Document   : proceso-creacion-proyecto
    Created on : 22/06/2016, 05:40:47 PM
    Author     : aaper
--%>

<%@page import="Conexiones.Iniciativa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Conexiones.DetalleIniciativa"%>
<%@page language ="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TMPH00028</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Oswald|Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>
<div class="social-wrapper">
  <div class="row">
    <ul>
        <li><a href="#"><img src="images/th.jpg" alt="" /></a></li>
        <li><a><%
                HttpSession sessionIn = request.getSession();
                String usuario =(String) sessionIn.getAttribute("Usuario");
                if( usuario == null ){
                    response.sendRedirect("index.jsp");
                }else {
                    out.print("<h2>"+sessionIn.getAttribute("Usuario")+"</h2>");
                }  
            %></a></li>
      <li><a ><form action ="Salir" method="post" class = "">
            <input type="submit" value ="Log-Out"/>    
        </form></a></li>
    </ul>
    <div class="clear"></div>
  </div>
</div>
<div class="clear"></div>
<!-- end of SOCIAL ICONS -->
<div class="header">
  <div class="row">
    <div class="logo">
      <h1><a href="creador.jsp">COPERACHA S.A.</a></h1>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="right-panel">
      <!--div class="panel"-->
          
                        
          </div>
          
                        <div class ="left-panel">
                                      <div class ="contact-panel">
                <form action ="proceso_recompensa" method = "post" id="data">
                <table border ="0">
                    <%
                        String er = request.getParameter("error");
                        if( er != null ){
                            out.print(er);
                        }
                    %>
                    <tr>
                        <td>
                            <h3>Nombre Recompensa</h3>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        
                        <td>
                            <input name ="txtNombreReco" type="text" class="text-field"/>
                            <%
                                String idinis = request.getParameter("idini");
                                if (idinis != null){
                                    %>
                                    <input name="idinis" type="hidden" value="<%=idinis%>"/>
                            <%
                                }
                            %>
                        
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>Paquete</h3>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name ="txtPaquete" type="text" class="text-field"/>
                        </td>
                        <td>
                            <br />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>Tipo</h3>
                        </td>
                        <td>
                            <br />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select name="cbTipo"  id="cbTipo" class="selec-field" >
                                
                                <option value="Fisica">Fisica </option>
                                <option value="No Fisica">No Fisica</option>
                                
                            </select>
                            
                        </td>
                        <td>
                            <br />
                        </td>
                    </tr>
                    <tr>
                        
                        <td>
                            <h3>Seleccione su tipo de Recompensa</h3>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            
                            
                            
                            <select name="cbLimitada"  id="cbLimitada" class="selec-field" >
                                
                                <option value="Limitada">Limitada</option>
                                <option value="Ilimitada">ILimitada</option>
                                
                            </select>
                            
                            
                         
                        </td>
                            
                        <td>
                            
                        </td>
                    </tr>
                        <tr>
                            <td>
                                <h3>Ingrese Monto Minimo de recompensa</h3>
                            </td>
                            <td>
                                
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" class="text-field" name="txMontominimo"/>
                            </td>
                            <td>
                                
                               
                            </td>
                        </tr>
                    <tr>
                        <td>
                            
                            <div class="controller">
                                <input type ="submit" value ="Guardar Recompensa" name ="btnGuardarReco"/>
                                <div class="clear"></div>
                            </div>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    
                </table
            </form>
        
      
    </div>
                        </div>
          
    
  <!-- end of BOX WRAPPER -->
  <div class="clear"></div>
  
</div>
</div>
<div class="footer-wrapper">
  <div class="footer">
    <div class="panel">
      <div class="title">
        <h1>ABOUT US</h1>
        <h2>Aliquam id felis vitae tellus</h2>
        <div class="content">
          <P>Becenas neque ante,  congue condim
            entum ipsum. Integer et enim a massa dictum conguebitur tempor.</P>
        </div>
      </div>
    </div>
    <div class="panel">
      <div class="title">
        <h1>CONTACT US</h1>
        <h2>Ipsum vestibulum non ferme</h2>
        <div class="content">
          <P><a href="info@sitename.com">info@sitename.com</a> </P>
          <h3>( 000 ) 888 8888</h3>
        </div>
      </div>
    </div>
    <div class="panel border-right">
      <div class="title">
        <h1>COPY RIGHT</h1>
        <h2>Ultrices dictum etut urna.</h2>
        <div class="content">
          <p>websitename. All rights reserved. </p>
          <p><a href="www.alltemplateneeds.com" target="_blank" class="active">www.alltemplateneeds.com</a> </p>
          <P>Images by: <a href="www.photorack.net" target="_blank"> www.photorack.net</a></P>
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!----footer-wrapper-------->
<!-- end of WRAPPER -->
</body>
</html>