<%@page import="Conexiones.Iniciativa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Conexiones.DetalleIniciativa"%>
<% String categoria = request.getParameter("cbCategoria");
DetalleIniciativa di = new DetalleIniciativa();
int id = Integer.parseInt(categoria);
ArrayList<String> ini = di.listaSubcategoria(id);
%>
<select name="cbSubC">
    <option value="">--Seleccione--</option>
    <%for(String subcategoria: ini){%>
    <option><%=subcategoria%></option>
    <%}%>
</select>
