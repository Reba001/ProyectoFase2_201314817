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
        <li> <a href="DenunciasAdmin.jsp"class="active">Denuncias</a> </li>
        <li><a href="pages.html">Pages</a></li>
        <li><a href="subirArchivo.jsp">Archivo</a></li>
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
            <form action="DeleteComent" method="post">
            <table border = "0" >
                <tr>
                    <td>
                    <div class="title">
                        <h1>Ingresa el Id del comentario para eliminar</h1>
                        
                    </div>
                    </td>
                    <td>
                        <input type="text" class="text-field" name="eliminar"/>
                    </td>
                    <td>
                        <input type="submit" value="Eliminar" class="buttons" />
                    </td>

                </tr>
            </table>
            <div class="clear"></div>
            </form>
        </div>
        <div class="clear"></div>
        <div class="clear"></div>
      </div>

    <div class="clear"></div>
    <div class="panel">
        <%
            DetalleIniciativa di = new DetalleIniciativa();
            ArrayList<DenunciaComentario> denuncias = di.getListaDenuncia();
            
        %>
        <form>
            <table border="0" width="900" >
                <tr>
                    <td>
                        <h1>ID Comentario</h1>
                    
                    </td>
                    <td>
                        <h1>Comentario</h1>
                    </td>
                    <td>
                        <h1>Iniciativa</h1>
                    </td>    
                </tr>
                <%
                    if(denuncias != null){
                        for(DenunciaComentario dc: denuncias){
                %>
                <tr>
                    <td>
                        <h2><%out.print(dc.getIdcomentario());%></h2>
                    
                    </td>
                    <td>
                        <h2><%out.print(dc.getComentario());%></h2>
                    </td>    
                    <td>
                        <h2><%out.print(dc.getIniciativa());%></h2>
                    </td>    
                </tr>
                <%      }
                    }
                %>
            </table>
        </form>
        
    </div>
            
            <div class="panel">
                <div>
            <div class="clear"></div>
        <div class="search">
            <form action="DeleteIniciativa" method="post">
            <table border = "0" >
                <tr>
                    <td>
                    <div class="title">
                        <h1>Ingresa el Id de la iniciativa para eliminar</h1>
                        
                    </div>
                    </td>
                    <td>
                        <input type="text" class="text-field" name="eliminariniciativa"/>
                    </td>
                    <td>
                        <input type="submit" value="Eliminar" class="buttons" />
                    </td>

                </tr>
            </table>
            <div class="clear"></div>
            </form>
        </div>
        <div class="clear"></div>
        <div class="clear"></div>
      </div>
        <%
            ArrayList<DenunciaComentario> denunciasI = di.getListaDenunciaIniciativa();
            
        %>
        <form>
            <table border="0" width="900">
                <tr>
                    <td>
                        <h1>ID Iniciativa</h1>
                    
                    </td>
                    <td>
                        <h1>Usuario denunciante</h1>
                    </td>
                    <td>
                        <h1>Iniciativa</h1>
                    </td>    
                </tr>
                <%
                    if(denuncias != null){
                        for(DenunciaComentario dc: denunciasI){
                %>
                <tr>
                    <td>
                        <h2><%out.print(dc.getIdcomentario());%></h2>
                    
                    </td>
                    <td>
                        <h2><%out.print(dc.getUsuario());%></h2>
                    </td>    
                    <td>
                        <h2><%out.print(dc.getIniciativa());%></h2>
                    </td>    
                </tr>
                <%      }
                    }
                %>
            </table>
        </form>
        
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