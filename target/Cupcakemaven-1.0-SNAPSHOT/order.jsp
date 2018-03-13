<%-- 
    Document   : order
    Created on : 01-03-2018, 13:37:11
    Author     : Morten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Users.User"%>
<%@page import="datamapper.DataMapper"%>
<%@page import="datasource.DataSource1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CupcakeCSS.css" type="text/css">
    </head>
    <body>
        <%            
            DataMapper dm;
            dm = new DataMapper(new DataSource1().getDataSource());
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = dm.validateUser(username, password);

            User user2 = (User) session.getAttribute("user");
            
            if (user != null)
            {
                out.print("Login worked");
            }
            else
            {
                out.print("Login failed");
                
                user = new User("Guest", "none");
            }
        %>
        <h1>
            Logged in as: <%= user %>          
                    
        </h1>
        <form method="GET" action="Input.html">
           <input type="submit" name="btn1" value="Continue"/>  
        </form> 
    </body>
</html>
