<%-- 
    Document   : empresa
    Created on : 12-nov-2016, 14:14:42
    Author     : sergio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="webservice.Configuracionpc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ModelPC | Empresa</title>
    </head>
    <body>
        <h1>Catalogo de ModelPC</h1>
        <% List<Configuracionpc> catalogo = (ArrayList<Configuracionpc>) request.getAttribute("catalogo");
        if(catalogo != null) { %>
        <table style="margin: 20px 0px;">
            <tr>
                <th>ID</th>
                <th>Tipo CPU</th>
                <th>Velocidad CPU</th>
                <th>Capacidad RAM</th>
                <th>Capacidad DD</th>
                <th>Velocidad Grafica</th>
                <th>Memoria Grafica</th>
            </tr>
            <% for(Configuracionpc configuracion : catalogo) { %>
            <tr>
                <td><%= configuracion.getIdconfiguracion() %></td>
                <td><%= configuracion.getTipocpu().getNombretipocpu() %></td>
                <td><%= configuracion.getVelocidadcpu() %></td>
                <td><%= configuracion.getCapacidadram() %></td>
                <td><%= configuracion.getCapacidaddd() %></td>
                <td><%= configuracion.getVelocidadtarjetagrafica() %></td>
                <td><%= configuracion.getMemoriatarjetagrafica() %></td>
            </tr>
            <% } %>
        </table>
        <% } %>
    </body>
</html>
