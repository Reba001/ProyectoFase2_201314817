<%-- 
    Document   : creador
    Created on : 18/06/2016, 07:49:05 PM
    Author     : aaper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Perfil Usuario</title>
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
        <h1><a href="creador.jsp">COPERACHA S.A</a></h1>
    </div>
    <div class="menu">
      <ul>
        <li><a href="creador.jsp" class = "active">Inicio</a></li>
        <li><a href="Denuncias.jsp">Denuncias</a></li>
        <li><a href="Blog.jsp">Services</a> </li>
        <li> <a href="Proyectos.jsp">Proyectos</a> </li>
        <li><a href="Iniciativa.jsp">Iniciativa</a></li>
        <li><a href="Donaciones.jsp">Donaciones</a></li>
      </ul>
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
          <h1>Coperacha S.A.<br />
            Bienvenido</h1>
        </div>
        <div class="content">
          <p>Una nueva forma <br />
            de iniciar tus proyectos</p>
        </div>
        <div class="banner-button"><a href="proceso-creacion-proyecto.jsp">!Crea tu proyecto ahora mismo¡</a></div>
      </div>
      
    </div>
  </div>
</div>
<!-- end of BANNER WRAPPER -->
<div class="page">
  <div class="boxs1">
    <div class="panel">
      <div class="title">
        <h1>CRAS EGET ERAT</h1>
        <h2>Vestibulum ante ipsum primis</h2>
      </div>
      <div class="panel-img"><img src="images/img1.jpg" alt="" /></div>
      <div class="content">
        <p>Tongue condimentum ipsum. Integer et enim a massa dictum congue urabit.</p>
      </div>
      <div class="controller">
        <div class="buttons">
          <h2><a href="#">MORE</a></h2>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
  <div class="boxs2">
    <div class="panel">
      <div class="title">
        <h1>MORBI MI DIAMSUS</h1>
        <h2>Nullam non ligula risus lorem</h2>
      </div>
      <div class="panel-img"><img src="images/img2.jpg" alt="" /></div>
      <div class="content">
        <p>Aliquam cursus ultrices gravida. Maecenas nisl leo, lobortis nec egestas sodales.</p>
      </div>
      <div class="controller">
        <div class="buttons">
          <h2><a href="#">MORE</a></h2>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
  <div class="boxs3">
    <div class="panel">
      <div class="title">
        <h1>PRAESENT SEMPER</h1>
        <h2>Quisque tincidunt adipiscing</h2>
      </div>
      <div class="panel-img"><img src="images/img3.jpg" alt="" /></div>
      <div class="content">
        <p> Vestibulum et justo massa. Pellentesque habitant morbi tristique senectus.</p>
      </div>
      <div class="controller">
        <div class="buttons">
          <h2><a href="#">MORE</a></h2>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of BOX WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="left-panel">
      <div class="panel">
        <div class="title">
          <div class="icons"><img src="images/arrow-icons.png" alt="" /></div>
          <h1>PRAESENT VEHICULA PURUS IRIN</h1>
          <h2>Aenean facilisis lorem ut metus</h2>
        </div>
        <div class="content">
          <p>Donec a nulla erat. Fusce molestie pellentesque est eget tincidunt. Pellentesque at arcu a arcu bibendum mattis at suscipit nunc. Maecenas neque ante,  congue condimentum ipsum. Integer et enim a massa dictum congue. Curabitur tempor massa ac lectus aliquet vitae hendrerit leo semper lorem ipsum dolor. </p>
        </div>
        <div class="controller">
          <div class="buttons">
            <h2><a href="#">MORE</a></h2>
          </div>
          <div class="clear"></div>
        </div>
      </div>
      <div class="clear"></div>
      <div class="panel">
        <div class="title">
          <div class="icons"><img src="images/arrow-icons.png" alt="" /></div>
          <h1>DONCE SED NEQUE NON FELIS AUCTOR</h1>
          <h2>Ut feugiat dui sit amet nulla posuer</h2>
        </div>
        <div class="content">
          <p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula. Integer adipiscing risus a sem. Nullam quis massa sit amet nibh viverra malesuada. Nunc sem lacus, accumsan quis, faucibus non, congue vel, arcu. Ut scelerisque hendrerit tellus. Integer sagittis. </p>
        </div>
        <div class="controller">
          <div class="buttons">
            <h2><a href="#">MORE</a></h2>
          </div>
          <div class="clear"></div>
        </div>
      </div>
      <div class="clear"></div>
      <div class="panel">
        <div class="title">
          <div class="icons"><img src="images/arrow-icons.png" alt="" /></div>
          <h1>ENIAN FEUGIAT BLANDIT NEQUE</h1>
          <h2>Vivamus et augue sed orci auctor</h2>
        </div>
        <div class="content">
          <p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna a ullamcorper laoreet, lectus arcu pulvinar risus, vitae facilisis libero dolor a purus. Sed vel lacus. Mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse ac urna. Etiam pellentesque mauris ut lectus. Nunc tellus ante, mattis eget. ed ac risus. Phasellus lacinia, magna Ut aliquam sollicitudin leo.Cras iaculis ultricies nulla.</p>
        </div>
        <div class="controller">
          <div class="buttons">
            <h2><a href="#">MORE</a></h2>
          </div>
          <div class="clear"></div>
        </div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="right-panel">
      <div class="contact-panel">
        <div class="title">
          <h1>PROIN A RISUS</h1>
          <h2>Vestibulum suscipit nib</h2>
        </div>
        <div class="form">
          <ul>
            <li>
              <input type="text"  class="text-field" value="your name here"/>
            </li>
            <li>
              <input name="" type="text"  class="text-field" value="your email  here"/>
            </li>
            <li>
              <textarea name="" cols="" rows="" class="textarea">your message  here
</textarea>
            </li>
          </ul>
          <div class="clear"></div>
        </div>
        <div class="controller">
          <div class="buttons">
            <h2><a href="#">SUBMIT</a></h2>
          </div>
          <div class="clear"></div>
        </div>
        <div class="clear"></div>
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
          <h2>Suspendisse ut urna enim</h2>
        </div>
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
