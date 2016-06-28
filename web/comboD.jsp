<%@page import="Conexiones.Iniciativa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Conexiones.DetalleIniciativa"%>
<% String categoria = request.getParameter("cbCategoria");
DetalleIniciativa di = new DetalleIniciativa();
int id = Integer.parseInt(categoria);
ArrayList<String> ini = di.listaSubcategoria(id);
%>

    <select name="cbSubC" onchange="f_subcategoria()">
    <%for(String subcategoria: ini){%>
    <option value="<%out.print(di.getIdSubCategoria(subcategoria));%>"><%=subcategoria%></option>
    <%}%>
    </select>


