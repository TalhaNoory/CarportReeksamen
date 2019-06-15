<%-- 
    Document   : Select
    Created on : Jun 15, 2019, 3:59:19 PM
    Author     : Dhono
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <style>
            .container {
                width: 500px;
                clear: both;
            }

            .container input {
                width: 100%;
                clear: both;
            }
        </style>

        <div class="container">
            <h1>Login</h1>
            <form action="FrontController" method="POST">
                Email:<input type="text" name="email"/><br/><br/>
                Password:<input type="password" name="password"/><br/><br/>
                <input type="hidden" name="command" value="login">
                <input type="submit" value="login"/>
            </form>
        </div>
    </body>
</html>