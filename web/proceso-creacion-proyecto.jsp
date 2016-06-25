<%-- 
    Document   : proceso-creacion-proyecto
    Created on : 22/06/2016, 05:40:47 PM
    Author     : aaper
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Conexiones.DetalleIniciativa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TMPH00028</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
    function cbSub(){
        alert("cambiar a select dependiente");
        $("#f_opc").val("1");
            $post("comboD.jsp",$("#data").serialize(),function(data){("#idcbSubC").html(data);});
    }
</script>
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
      <h1><a href="creador.jsp">Coperacha</a></h1>
    </div>
  </div>
  <div class="clear"></div>
</div>
<div class="header">
  <div class="row">
    <div class="logo">
      <h1><a href="creador.jsp">S.A.</a></h1>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="right-panel">
      <!--div class="panel"-->
          <div class ="contact-panel">
                <form action ="" method = "post" id="data">
                <table border ="0">
                    <tr>
                        <td>
                            <h3>Nombre Proyecto</h3>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name ="txtNombreIni" type="text" class="text-field"/>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>Fecha Limite</h3>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name ="txtFechaLimite" type="text" class="text-field" value ="dd/MM/yyyy"/>
                        </td>
                        <td>
                            <br />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>Meta Economica</h3>
                        </td>
                        <td>
                            <br />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name ="txtMetaEconomica" type="text" class="text-field" value ="Valor en Quetzales"/>
                            <input type="hidden" name="i_opc" id="i_opc"/>
                        </td>
                        <td>
                            <br />
                        </td>
                    </tr>
                    <tr>
                        
                        <td>
                            <h3>Seleccione una categoria</h3>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            
                            <%
                                DetalleIniciativa di = new DetalleIniciativa();
                                ArrayList<String> categorias = di.listaCategoria();
                                
                            %>
                            
                            <select name="cbCategoria" class="selec-field" id="cbCategoria" onchange="cbSub">
                                <% for(String categoria : categorias){%>
                                <option value="<%out.print(di.getIdCategoria(categoria));%>"><%out.print(categoria);%></option>
                                <%
                                    }
                                %>
                            </select>
                            
                            
                         
                        </td>
                            
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>Seleccione una subcategoria</h3>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <%
                            
                        %>
                        <td>
                            <select name="cbSubC" id="idcbSubC" class="selec-field">
                                <option ></option>
                            </select>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>Descripcion</h3>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <textarea class = "textarea" rows="15" cols = "20" name ="txtDescripcion">
                                
                            </textarea>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            
                            <div class="controller">
                                <input type ="submit" value ="Guardar" name ="btnGuardar"/>
                                <div class="clear"></div>
                            </div>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                           
                            <div class="controller">
                                <input type="submit" name="btnPublicar" value="Publicar"/>
                                <div class="clear"></div>
                            </div>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                </table
            </form>
        
      <div class="clear"></div>
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