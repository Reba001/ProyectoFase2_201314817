<%-- 
    Document   : index
    Created on : 16/06/2016, 05:24:11 PM
    Author     : aaper
--%>


<%@page import="java.sql.Time"%>
<%@page import="ServiciosWeb.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Coperacha S.A.</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Oswald|Open+Sans' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/carouselScript.js"></script>
<link href="css/carousel.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="clear"></div>
<!-- end of SOCIAL ICONS -->
<div class="header">
  <div class="row">
    <div class="logo">
      <h1>¡Bienvenidos!</h1>
    </div>
  </div>
  <div class="clear"></div>
</div>
<%
    HttpSession sessionOut = request.getSession();
            
            String usuario = (String) sessionOut.getAttribute("Usuario");
            if(usuario != null)
                sessionOut.invalidate();
            else{
                String usuarioAdmin =(String) sessionOut.getAttribute("Administrador");
                if(usuarioAdmin != null){
                    sessionOut.invalidate();
                }
            }
%>
<!-- end of MENU WRAPPER -->
<div class="banner-wrapper">
  <div class="row">
    
  </div>
  <div class="clear"></div>
  <div class="banner">
    <div class="banner-bg">
      <div class="panel">
        <div class="title">
          <h1>Bienvenido<br />
            Coperacha S.A.</h1>
        </div>
        <div class="content">
          <p>Una nueva forma de iniciar el Proyecto <br />
            que tanto deseabas.</p>
        </div>
        <div class="banner-button"><a href="registro.jsp">Registrate ahora</a></div>
      </div>
    </div>
  </div>
</div>
<!-- end of BANNER WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="right-panel">
        
        <div class="contact-panel">
        <div class="title">
          <h1>Iniciar Sesion</h1>
        </div>
            
            <form  action="WSI" method = post class ="form">
            <div class = "title">
                <span>
                    <%
                        if(request.getParameter("error") != null){
                            out.print("<h3>"+request.getParameter("error")+"</h3>");
                        }else{
                            out.print("");
                        }
                    %>
                </span>
            </div>     
          <ul>
              <li>
                  <a><h3>Usuario</h3></a>
              </li>
            <li>
              <input name = "txtUsuario" type="text"  class="text-field" />
            </li>
              <li>
                  <a><h3>Contraseña</h3></a>
              </li>
            <li>
              <input name="txtContrasenia" type="password"  class="text-field" />
            </li>
            
          </ul>
          <div class="clear"></div>
        
        <div class="controller">
          <input type="submit"  class="buttons" value="Log-In"/>
          <div class="clear"></div>
        </div>
        <div class="clear"></div>
            </form>        
        
      </div>
     
      <div class="clear"></div>

      <div class="clear"></div>
     
    </div>
    <div class="clear"></div>
  </div>
  <!-- end of BOX WRAPPER -->
  <div class="clear"></div>
</div>
<div class="footer-wrapper">
  <div class="footer">

    
    
  </div>
  <div class="clear"></div>
</div>
<!----footer-wrapper-------->
<!-- end of WRAPPER -->
</body>
</html>

