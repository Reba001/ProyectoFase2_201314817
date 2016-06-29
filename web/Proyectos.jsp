<%-- 
    Document   : Proyectos
    Created on : 22/06/2016, 05:11:44 PM
    Author     : aaper
--%>

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
    <div class="menu">
      <ul>
        <li><a href="creador.jsp">Inicio</a></li>
        <li><a href="">About</a></li>
        <li><a href="Blog.jsp">Blog</a> </li>
        <li> <a href="Proyectos.jsp" class="active">Proyectos</a> </li>
        <li><a href="Iniciativa.jsp">Iniciativa</a></li>
        <li><a href="">Contact</a></li>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
      
        <div>
            <div class="clear"></div>
        <div class="search">
            <form action="busqueda.jsp" method="post">
            <table border = "0" >
                <tr>
                    <td>
                    <div class="title">
                        <h1>Ingresa el nombre de La iniciativa</h1>
                        
                    </div>
                    </td>
                    <td>
                        <input type="text" class="text-field" name="buscar"/>
                    </td>
                    <td>
                        <input type="submit" value="Buscar" class="buttons" />
                    </td>

                </tr>
            </table>
            <div class="clear"></div>
            </form>
        </div>
        <div class="clear"></div>
        <div class="clear"></div>
      </div>
    <div class="portfolio">
      <div class="title">
        <h1>Proyectos</h1>
        <h2>A continuacion presentamos todas las iniciativas, que necesitan de tu aporte.</h2>
      </div>
        <%
            DetalleIniciativa di = new DetalleIniciativa();
            String user="";
            ArrayList<Iniciativa> iniciativas = di.getlistaIniciativa();
            if(iniciativas != null){
                for(Iniciativa ini : iniciativas ){
                    user = ini.getIdUsuario();
                
        %>
      <form action="proyecto-usuariodiferente.jsp" method ="post">
        <div class="panel marRight30">
            <div class="content"> <img src="images/img4.jpg" />
            <p><span> <%out.print(ini.getNombre());%></span></p>
            <input type="hidden" name="hnombre" value="<%out.print(ini.getNombre());%>"/>
            <input type="hidden" name="husuario" value="<%out.print(ini.getIdUsuario());%>"/>
            <input type="hidden" name="hidiniciativa" value="<%out.print(ini.getIdiniciativa());%>"/>
            <p>Phasellus ultrices nulla quis nibh. Quisque a lectus. Donec consectetuer ligula vulputate sem tristique cursus.</p>
            <%if (usuario != user){%>
            <input class ="buttons" value="Ir ahora" type="submit"/> 
            <%}else{%>
            <a href="iniciativa.jsp">ve hacia la luz </a>
            <%}%>
            </div>
        </div>
     </form>
      <%  
                }
            }
      %>
    </div>
    <div class="clear"></div>
    
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
