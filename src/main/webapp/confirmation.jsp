<%-- 
    Document   : confirmation
    Created on : 08-03-2018, 15:40:01
    Author     : Morten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CupcakeCSS.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your order has been received!</h1>
        <form method="GET" action="AllOrders.jsp">
            <input type="submit" name="btn1" value="All orders"/>
        </form>
    </body>
</html>
