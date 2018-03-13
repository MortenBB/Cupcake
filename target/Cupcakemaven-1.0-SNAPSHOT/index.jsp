<%-- 
    Document   : Index
    Created on : 27-02-2018, 14:48:46
    Author     : Morten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WelcomeMichael</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="CupcakeCSS.css" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>LOG IN</h1>    
        <form action="Control" method="post">
            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username">
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password">
                <input type="hidden" name="origin" value="login" />
                <input type="submit" value="Log in" />             
            </div>
        </form> 
            <h2>CREATE USER</h2>
            <form id="formCreate" action="Control" method="post">
                <label id="labelUsername" for="username"><b>Username</b></label>
                <input type="text" name="username" />
                <label id="labelPassword" for="password"><b>Password</b></label>
                <input type="text" name="password" />               
                <input type="hidden" name="origin" value="create" />
                <input type="submit" value="CREATE USER" />                       
        </form> 
    </body>   
</html>

