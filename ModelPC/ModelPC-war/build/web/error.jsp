<%-- 
    Document   : error
    Created on : 12-nov-2016, 22:16:23
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ModelPC error</title>
    </head>
    <body>
        <h1>Ups...!Algo ha fallado</h1>
        <p><%= request.getAttribute("type") %></p>
    </body>
</html>
