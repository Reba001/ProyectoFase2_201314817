<%-- 
    Document   : GraficaCategoria
    Created on : 11/07/2016, 05:43:26 PM
    Author     : aaper
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="org.jfree.data.general.DefaultPieDataset"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DataBase.Conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.category.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            Connection dbConection2 = null;
            PreparedStatement ps2 = null;
            Connection dbConection = null;
            PreparedStatement ps = null;
            try{
                
                String consulta2 = "select sum(d.monto) as Recaudado, c.nombre from donacion d, iniciativa i, subcategoria s, categoria c where  (s.idsubcategoria = i.idsubcategoria) and (d.idiniciativa = i.idinciativa) and (c.idcategoria = s.idcategoria) group by  c.idcategoria";
                dbConection2 = new Conexion().getDBConnection();
                ps2 = dbConection2.prepareStatement(consulta2);
                ResultSet rs2;
                rs2 = ps2.executeQuery();
                String consulta = "select sum(d.monto) as Recaudado, s.nombre from donacion d, iniciativa i, subcategoria s where  (s.idsubcategoria = i.idsubcategoria) and (d.idiniciativa = i.idinciativa)   group by  s.idsubcategoria";
                dbConection = new Conexion().getDBConnection();
                ps = dbConection.prepareStatement(consulta);
                ResultSet rs;
                rs = ps.executeQuery();
                DefaultPieDataset data = new DefaultPieDataset();
                while(rs.next()){
                    data.setValue("Subcategoria " + rs.getString(2), rs.getFloat(1));
                }
                while(rs2.next()){
                    data.setValue("Categoria " + rs2.getString(2), rs2.getFloat(1));
                }
                JFreeChart grafico = ChartFactory.createPieChart("Ingresos Financieros", data, true,true,true);
                response.setContentType("image/JPEG");
                OutputStream sa = response.getOutputStream();
                ChartUtilities.writeChartAsJPEG(sa, grafico, 500, 500);
                dbConection2.close();
                ps2.close();
                rs2.close();
                dbConection.close();
                ps.close();
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            
            
        %>
        <h1>Hello World!</h1>
    </body>
</html>
