<%-- 
    Document   : Modini
    Created on : 25/06/2016, 05:35:28 PM
    Author     : aaper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><a href="creador.jsp">Coperacha S.A.</a></title>
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
      <a href="creador.jsp"><h1>COPERACHA S.A.</h1></a>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->

<!-- end of BANNER WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap" >
    
        
        <div class="contact-panel">
        
            <div class="title">
          
                <h1>Inicio de Registro</h1>
        <%
                        if(request.getParameter("error") != null){
                            out.print("<h3>"+request.getParameter("error")+"</h3>");
                        }else{
                            out.print("");
                        }
        %>
            </div>
            <span>
                    <%
                        if(request.getParameter("error") != null){
                            out.print("<h3>"+request.getParameter("error")+"</h3>");
                        }else{
                            out.print("");
                        }
                    %>
                </span>
            
            <form  action="mod_ini" method = post class ="form">
                <table border = "0">
                    
                        <tr>
                            <td>
                                <a><h3>Titulo</h3></a>
                            </td>
                            <td>
                                <input name = "txttitulo" type="text"  class="text-field" />
                            </td>
                            
                        </tr>    
                        <tr>
                            <td>
                                <a><h3>Descripcion</h3></a>
                            </td>
                            <td>
                                <textarea class="textarea" name="txtDescripcion">
                                    
                                </textarea>
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                
                            </td>
                            <td>
                                
                                <div class="controller">
                                    <input type="submit"  class="boton" value="Modificar"/>
                                <div class="clear"></div>
                                </div>
                            </td>
                            
                        </tr>
                    
                </table>
          
          <div class="clear"></div>
        
        </form>        
        
      </div>
     
      <div class="clear"></div>

      <div class="clear"></div>
     
    
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
