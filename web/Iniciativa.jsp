<%-- 
    Document   : Iniciativa
    Created on : 22/06/2016, 05:12:05 PM
    Author     : aaper
--%>

<%@page import="Conexiones.Comentario"%>
<%@page import="Conexiones.Iniciativa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Conexiones.DetalleIniciativa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <div class="menu">
      <ul>
        <li><a href="creador.jsp">Inicio</a></li>
        <li><a href="Denuncias.jsp">Denuncias</a></li>
        <li><a href="Blog.jsp">Blog</a> </li>
        <li> <a href="Proyectos.jsp">Proyectos</a> </li>
        <li><a href="Iniciativa.jsp"  class="active">Iniciativa</a></li>
        <li><a href="Donaciones.jsp">Donaciones</a></li>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="left-panel">
      <div class="panel">
          <%
              int id = 0;
              DetalleIniciativa di = new DetalleIniciativa();
              ArrayList<Iniciativa> iniciativas = di.getIniciativa(usuario);
              if(iniciativas != null){
                  if(iniciativas.size() <= 1){
                    for(Iniciativa ini : iniciativas){
                      id = ini.getIdiniciativa();
                      String idinis = ""+id;
                      sessionIn.setAttribute("idinis", idinis);
              %>
              <table border="0" width="600">
                  <tr>
                      <td>
                          <div class="title">
                                <h1><%out.print(ini.getNombre());%></h1>
                                <h2><%out.print(ini.getFechainicio()+"---"+ini.getFechafinal());%></h2>
                          </div>
                      </td>
                          <td>
                              <form action="Blog.jsp" method="post">
                                  <input type="hidden" name="idiniciativa" value="<%out.print(ini.getIdiniciativa());%>"/>
                                  <input type="submit" value="Ir al blog"/>
                              </form>
                              </td>
                                  
                  </tr>
                  
        
        </table>
                                  <div class="content">
            <p><% out.print(ini.getDescripcion()); %></p>
        </div>
        <%
            sessionIn.setAttribute("identificador", id);
                    }
                }else{
                    for(Iniciativa ini : iniciativas){
                        id = ini.getIdiniciativa();
        %>
                
        <form action="proyectodelmismo.jsp" method="post">
        <u>
            <a href="">
                
                <%out.print(ini.getNombre());%>
                <input name="idiniciativa" value="<%=id%>" type="hidden"/>
            </a>
            <a>
                <%sessionIn.setAttribute("identificador", id);
%>
                <input value="Ir Ahora" type="submit"/>
            </a>
        </u>
            </form>
                <%
                    }
                }
            }else{
        %>
        <div class="title">
          <h1>Aun debes de Publica tu Proyecto</h1>
          <h2>Vivamus et augue sed orci auctor</h2>
        </div>
        <div class="content">
          <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Sed pretium, ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget blandit nunc tortor eu nibh. Nullam mollis. Ut justo. Suspendisse potenti.</p>
          <p>Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero, faucibus adipiscing, commodo quis, gravida id, est. Sed lectus. Praesent elementum hendrerit tortor. Sed semper lorem at felis. Vestibulum volutpat, lacus a ultrices sagittis, mi neque euismod dui, eu pulvinar nunc sapien ornare nisl. Phasellus pede arcu, dapibus eu, fermentum et, dapibus sed, urna.</p>
          <p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna a ullamcorper laoreet, lectus arcu pulvinar risus, vitae facilisis libero dolor a purus. Sed vel lacus. Mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse ac urna. Etiam pellentesque mauris ut lectus. Nunc tellus ante, mattis eget, gravida vitae, ultricies ac, leo. Integer leo pede, ornare a, lacinia eu, vulputate vel, nisl.</p>
          <p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula. Integer adipiscing risus a sem. Nullam quis massa sit amet nibh viverra malesuada. Nunc sem lacus, accumsan quis, faucibus non, congue vel, arcu. Ut scelerisque hendrerit tellus. Integer sagittis. Vivamus a mauris eget arcu gravida tristique. Nunc iaculis mi in ante. Vivamus imperdiet nibh feugiat est.</p>
          <p>Ut convallis, sem sit amet interdum consectetuer, odio augue aliquam leo, nec dapibus tortor nibh sed augue. Integer eu magna sit amet metus fermentum posuere. Morbi sit amet nulla sed dolor elementum imperdiet. Quisque fermentum. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque adipiscing eros ut libero. Ut condimentum mi vel tellus. Suspendisse laoreet. Fusce ut est sed dolor gravida convallis. Morbi vitae ante. Vivamus ultrices luctus nunc. Suspendisse et dolor. Etiam dignissim. Proin malesuada adipiscing lacus. Donec metus. Curabitur gravida.</p>
          <p>Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, euismod in, pharetra a, ultricies in, diam. Sed arcu. Cras consequat.</p>
          <p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus.Phasellus ultrices nulla quis nibh. Quisque a lectus. Donec consectetuer ligula vulputate sem tristique cursus. Nam nulla quam, gravida non, commodo a, sodales sit amet, nisi.</p>
          <p>Pellentesque fermentum dolor. Aliquam quam lectus, facilisis auctor, ultrices ut, elementum vulputate, nunc.Sed adipiscing ornare risus. Morbi est est, blandit sit amet, sagittis vel, euismod vel, velit.</p>
          <p> Mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse ac urna. Etiam pellentesque mauris ut lectus. Nunc tellus ante, mattis eget, gravida vitae, ultricies ac, leo.</p>
        </div>
        <% 
           } 
        %>
        
                <div class="panel">
            <%
                if(iniciativas.size() < 2){
                ArrayList<Comentario> comentarios = di.getListaComentario(id);
                    if(comentarios != null){
                        for(Comentario c : comentarios){
                
            %>
            <p><%out.print(c.getFecha().toString());%></p>
            <form action="EliminarComentario" method="post">
                <input type="submit" value="Eliminar"/>
                <input type="hidden" name="idComentario" value="<%out.print(c.getIdComentario());%>"/>
            </form>
            <div class="content">
                <p><%out.print(c.getComentario());%></p>
            </div>
            <%          }
                    
                }else{%>
            <div class="content">
                
            </div>
            <%  }
            }%>
        </div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="right-panel">
      <div class="contact-panel">
        <div class="title">
          <h1>Proyectos en borrador</h1>
          <span>publica tu proyecto aqui</span></div>
          
                <span>
                    <%
                        if(request.getParameter("error") != null){
                            out.print("<h3>"+request.getParameter("error")+"</h3>");
                        }else{
                            out.print("");
                        }
                    %>
                </span>
            
          <form action="Publicacion" method="post" class="form">
          
            <ul>
            <%
                
                ArrayList<Iniciativa> listainiciativa = di.getIniciativasBorrador(usuario);
                if(listainiciativa != null){
                    for(Iniciativa ini : listainiciativa)
                    {
            %>
                <li>
              
                    <input type="radio" align="right" class="text-field" value="<%out.print(ini.getNombre());%>" name="dish"><%out.print(ini.getNombre());%></input>
                    <input type="hidden" value="<%out.print(ini.getIdiniciativa());%>" name="idInis"/>
                </li>
          <%
                    }
                }
          %>
            </ul>
          <div class="clear"></div>
          <div class="controller">
              <input type="submit" class="buttons" value="Publicar" name="btnPublicar"/>
          <div class="clear"></div>
        </div>
          
          <div class="controller">
              <input type="submit" class="buttons" value="Eliminar" name="btnEliminar"/>
          <div class="clear"></div>
        </div>
          <div class="controller">
              <input type="submit" class="buttons" value="Agregar Recompensa" name="btnAgregarREcompensa"/>
          <div class="clear"></div>
        </div>
        </form>
        
        <div class="clear"></div>
      </div>
      <div class="clear"></div>
      <div class="panel martop">
        <div class="title">
          <h1>Perfil Iniciativa</h1>
        </div>
        <div class="content">
            <form action="mod_ini" method="post">
                <ul>
                    <li><a href="">Modificar Iniciativa</a></li>
                    <li><a href="">Agregar Moderador</a></li>
                    <li><a href="donar.jsp">Visualizar Recompensa</a></li>
                </ul>
          </form>
        </div>
        <div class="clear"></div>
      </div>
      <div class="clear"></div>
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
