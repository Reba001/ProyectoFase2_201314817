<%@page import="Conexiones.DetalleIniciativa"%>
<%@page import="java.io.File"%>
<%@page import="javax.xml.transform.Source"%>
<%@page import="com.csvreader.CsvReader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
    import="org.apache.commons.fileupload.*"
    import="org.apache.commons.fileupload.servlet.*"
    import="org.apache.commons.fileupload.disk.*"
    import="java.io.*"
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            try{
		//Ruta donde se guardara el fichero
		File destino = new File("C:\\Devtroce\\Uploads\\");
		ServletRequestContext src = new ServletRequestContext(request);
 
		if(ServletFileUpload.isMultipartContent(src)){
			DiskFileItemFactory factory = new DiskFileItemFactory((1024*1024),destino);
			ServletFileUpload upload = new  ServletFileUpload(factory);
 
			java.util.List lista = upload.parseRequest(src);
			File file = null;
			java.util.Iterator it = lista.iterator();
 
			while(it.hasNext()){
				FileItem item=(FileItem)it.next();
				if(item.isFormField())
					out.println(item.getFieldName()+"<br>");
				else
				{
					file=new File(item.getName());
					item.write(new File(destino,file.getName()));
					out.print(item.getName());
                                        out.println("Fichero subido");
                                        CsvReader r = new CsvReader("C:\\Devtroce\\Uploads\\"+item.getName());
                                        String aux= "";
                                        int i = 0;
                                        int j = -1 ;
                                        DetalleIniciativa di = new DetalleIniciativa();
                                        while(r.readRecord()){
                                            String categoria = r.get(0);
                                            String subcategoria = r.get(1);
                                            
                                            wspersona.DetalleIniciativa_Service service = new wspersona.DetalleIniciativa_Service();
                                            wspersona.DetalleIniciativa port = service.getDetalleIniciativaPort();
                                        	 // TODO initialize WS operation arguments here
	
                                                // TODO process result here
                                            if( !aux.equals(categoria) ){
                                                boolean result = port.setCategoria(categoria);
                                                i = di.getIdCategoria(categoria);
                                            }
                                            wspersona.DetalleIniciativa_Service service2 = new wspersona.DetalleIniciativa_Service();
                                            wspersona.DetalleIniciativa port2 = service.getDetalleIniciativaPort();
                                                // TODO initialize WS operation arguments here
                                            java.lang.String nombre = "";
	// TODO process result here         
                                            if(i != 0){
                                                boolean result2 = port2.setSubcategoria(subcategoria, i);
                                            }
                                            
                                            out.print("<h1>"+ categoria + "--" + subcategoria +"</h1>");
                                            aux = categoria;
                                        }
                                        response.sendRedirect("subirArchivo.jsp");
                                        
				} // end if
			} // end while
		}
            }catch(Exception e){
                
            }// end if
	%>
    </body>
</html>    
