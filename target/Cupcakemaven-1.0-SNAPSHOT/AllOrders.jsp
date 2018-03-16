<%-- 
    Document   : AllOrders
    Created on : 08-03-2018, 15:47:26
    Author     : Morten
--%>
<%@page import="datamapper.DataMapper"%>
<%@page import="datasource.DataSource1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CupcakeCSS.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Orders</h1>
        <%  DataMapper dm;
            dm = new DataMapper(new DataSource1().getDataSource());
            for (int i = 0; i < dm.getOrders().size(); i++) {
                out.print(dm.getOrders().get(i)+"<br>");}%>
            
    </body>
</html>
