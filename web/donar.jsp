<%-- 
    Document   : registro
    Created on : 20/06/2016, 10:25:35 AM
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
      <a href="index.jsp"><h1>COPERACHA S.A.</h1></a>
    </div>
  </div>
  <div class="clear"></div>
</div>
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
        <div class="banner-button"><a href="#">Registrate ahora</a></div>
      </div>
    </div>
  </div>
</div>
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
            <% HttpSession sessionOk =  request.getSession();
                String u = (String) sessionOk.getAttribute("Usuario");
                
                    %>
            
            <form  action="donacionU" method = post class ="form">
                
                <table border = "0">
                    <ul>
                        <div class="title">
                    <h1><%=u%></h1>
            </div>
                            
                        <tr>
                            <td>
                                <a><h3>Numero de cuenta</h3></a>
                            </td>
                            <td>
                                <a>
                                    <%-- start web service invocation --%><hr/>
    <%
    try {
	ServiciosWeb.Persona_Service service = new ServiciosWeb.Persona_Service();
	ServiciosWeb.Persona port = service.getPersonaPort();
	 // TODO initialize WS operation arguments here
	
	// TODO process result here
	java.lang.String result = port.getCuenta(u);
	out.println(result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/></a>

                            </td>
                            <td>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a><h3>Monto</h3></a>
                            </td>
                            <td>
                                <input name = "txtMonto" type="text"  class="text-field" />
                            </td>
                            <td>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                
                            </td>
                            <td>
                                <input name = "btnMonto" type="submit" value="Donar Ahora"/>
                            </td>
                            <td>
                                
                            </td>
                        </tr>
                        
                    </ul>
                </table>
          
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

