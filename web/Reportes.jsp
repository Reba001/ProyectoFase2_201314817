<%-- 
    Document   : Proyectos
    Created on : 22/06/2016, 05:11:44 PM
    Author     : aaper
--%>

<%@page import="Conexiones.DenunciaComentario"%>
<%@page import="Conexiones.Iniciativa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Conexiones.DetalleIniciativa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TMPH00028</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Oswald|Open+Sans' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="social-wrapper">
  <div class="row">
    <ul>
        <li><a href="#"><img src="images/th.jpg" alt="" /></a></li>
        <li><a><%
                HttpSession sessionIn = request.getSession();
                String usuario =(String) sessionIn.getAttribute("Administrador");
                if( usuario == null ){
                    response.sendRedirect("index.jsp");
                }else {
                    out.print("<h2>"+sessionIn.getAttribute("Administrador")+"</h2>");
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
    <div class="menu">
      <ul>
        <li><a href="Iniciativas.jsp">Iniciativas</a></li>
        <li><a href="consultaadminusuario.jsp">Consulta Usuario</a></li>
        <li><a href="administrador.jsp" >Alta/Baja</a> </li>
        <li> <a href="DenunciasAdmin.jsp">Denuncias</a> </li>
        <li><a href="pages.html">Pages</a></li>
        <li><a href="Reportes.jsp" class="active">Reportes</a></li>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
      <div class="left-panel">
          <div class="form">
              <div class="contact-panel">
      <table border="0" width="900" height="200">
          <tr>
             <td>
                 
                 <div class="banner-button">
          
              <a href="reportesubcategoria.jsp"> Reporte Financiero Subcategoria</a>
          </div>
      
      <div class="clear"></div>
                 </td>
              
             <td>
                 
          
                 <div class="banner-button">
              <a href="reportecategoria.jsp"> Reporte Financiero categoria</a>
              </div >
      
      <div class="clear"></div>
                 </td>
              </tr>
          <tr>
             <td>
                 
                 <div class="banner-button">
          
              <a href="ReporteDenuncia.jsp"> Reporte Denuncia Iniciativa</a>
          </div>
      
      <div class="clear"></div>
                 </td>
              
             <td>
                 <div class="banner-button">
          
              <a href="GraficaCategoria.jsp">Grafica de Pastel Finaciamiento</a>
          </div>
      
      <div class="clear"></div>
      
                 </td>
              </tr>
          <tr>
             <td>
                 
                 <div class="banner-button">
          
              <a href="ReporteHistorial.jsp"> Reporte Denuncia Iniciativa</a>
          </div>
      
      <div class="clear"></div>
                 </td>
              
             <td>
                 <div class="banner-button">
          
              <a href="GraficaCategoria.jsp">Grafica de Pastel Finaciamiento</a>
          </div>
      
      <div class="clear"></div>
      
                 </td>
              </tr>
      </table>
                  </div>
              </div>
          </div>
  </div>
  <!-- end of BOX WRAPPER -->
  <div class="clear"></div>
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