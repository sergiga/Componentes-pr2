<%-- 
    Document   : index
    Created on : 12-nov-2016, 13:50:58
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ModelPC</title>
    </head>
    <body style="width: 100%; height: 100%;">
        <h1>Login ModelPC</h1>
        <form style="width: 100%; height: 100%; margin: auto;" action="login" name="empresa-form" method="post">
            Usuario: <br><input type="text" name="nifcif"><br>
            Password:<br><input type="text" name="passwd"><br>
            <input type="submit" name="accion" value="Login">
        </form>
    </body>
</html>
