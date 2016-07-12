<%-- 
    Document   : administrador
    Created on : 21/06/2016, 05:01:12 PM
    Author     : aaper
--%>

<%@page import="Conexiones.Iniciativa"%>
<%@page import="Conexiones.DetalleIniciativa"%>
<%@page import="Conexiones.GestiondeUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Conexiones.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                HttpSession sessionA = request.getSession();
                String usuario =(String) sessionA.getAttribute("Administrador");
                if( usuario == null ){
                    response.sendRedirect("index.jsp");
                }else {
                    out.print("<h2>"+sessionA.getAttribute("Administrador")+"</h2>");
                }  
            %></a></li>
      <li><a><form action ="Salir" method="post" class = "">
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
      <h1>Coperacha S.A</h1>
      
    </div>
    <div class="menu">
      <ul>
        <li><a href="Iniciativas.jsp" class="active">Iniciativas</a></li>
        <li><a href="consultaadminusuario.jsp">Consulta Usuario</a></li>
        <li><a href="administrador.jsp" >Alta/Baja</a> </li>
        <li> <a href="DenunciasAdmin.jsp">Denuncias</a> </li>
        <li><a href="subirArchivo.jsp">Archivos</a></li>
        <li><a href="Reportes.jsp">Reportes</a></li>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="left-panel">
      <div class="title">
          <center>
              <table border="0">
                  <tr>
                      <td>
                          <div class="title">
                              <h1> Id Iniciativa</h1>
                          </div>
                      </td>
                      <td>
                          <div class="title">
                              <h1>Nombre</h1>
                          </div>
                      </td>
                      <td>
                          <div class="title">
                              <h1>Fecha de creacion</h1>
                          </div>
                      </td>
                      <td>
                          <div class="title">
                              <h1>Fecha de Finalizacion</h1>
                          </div>
                      </td>
                      <td>
                          <div class="title">
                              <h1>Meta Economica</h1>
                          </div>
                      </td>
                      <td>
                          <div class="title">
                              <h1>Porcentaje Ganancia</h1>
                          </div>
                      </td>
                  </tr>
                  <%
                      DetalleIniciativa di = new DetalleIniciativa();
                      ArrayList<Iniciativa> iniciativas = di.getlistaIniciativa();
                      if(iniciativas != null){
                        for(Iniciativa i : iniciativas){
                      
                  %>
                  <tr>
                      <td>
                          <%out.print(i.getIdiniciativa());%>
                      </td>
                      <td>
                          <%out.print(i.getNombre());%>
                      </td>
                      <td>
                          <%out.print(i.getFechainicio());%>
                      </td>
                      <td>
                          <%out.print(i.getFechafinal());%>
                      </td>
                      <td>
                          <%out.print(i.getMetaEconomica());%>
                      </td>
                      <td>
                          <%out.print(i.getPorcentaje());%>
                      </td>
                  </tr>
                  <%        }
                    }   
                  %>
              </table>
          </center>
      </div>
    </div>
    <div class="right-panel">
      <div class="contact-panel">
        <div class="title">
          <h1>Gestionar Usuario</h1>
          <span>Vestibulum suscipit nib</span></div>
          <form action="baja_altainiciativa" method="post">
          <div class="form">
          <tr>
            <td>
                <h3>Ingrese Id de Iniciativa</h3>
            </td>
          </tr>
              <tr>
            <td>
              <input name="idiniciativa" type="text"  class="text-field" />
            </td>
              </tr>
              <tr>
            <td>
                <h3>Ingrese Porcentaje de ganancia</h3>
            </td>
          </tr>
              <tr>
              <td>
                  <input type="text" class="text-field"  name="txtPorcentaje"/>
              </td>
              </tr>
              <tr>
              <td>
                  <input type="submit" class="buttons" value="Dar de Baja" name="baja"/>
              </td>
              </tr>
              <tr>
              <td>
                  <input type="submit" class="buttons" value="Dar de Alta" name="alta"/>
              </td>
                  </tr>
              <tr>
              <td>
                  <input type="submit" class="buttons" value="Ingresar porcentaje" name="porcentaje"/>
              </td>
          </tr>
          <div class="clear"></div>
        </div>
        
        </form>
      </div>
      <div class="clear"></div>
      <div class="panel martop">
        <div class="title">
          <h1>DUIS AT LACUS</h1>
          <h2>Sed sagittis mi scelerisque</h2>
        </div>
        <div class="content">
          <ul>
            <li><a href="#">Posuere justo velitet laotinoc us</a></li>
            <li><a href="#">Donec egestas diam sed odiotio</a></li>
            <li><a href="#">Integer eu nibh vitae massa kun</a></li>
            <li><a href="#">Lorem ipsum dolor sit amet, con</a></li>
          </ul>
        </div>
        <div class="clear"></div>
      </div>
      <div class="clear"></div>
      <div class="contact-panel padding-bottm">
        <div class="title">
          <h1>ALIQUAM ADIPIS</h1>
          <span>Suspendisse ut urna enim</span></div>
        <div class="search">
          <ul>
            <li class="libg">
              <input type="text" class="search-filed" value="search here..."/>
            </li>
            <li><img src="images/search-bt.jpg" alt="" /></li>
          </ul>
        </div>
        <div class="clear"></div>
      </div>
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
