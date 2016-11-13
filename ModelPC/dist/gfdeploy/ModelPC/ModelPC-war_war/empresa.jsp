<%-- 
    Document   : empresa
    Created on : 12-nov-2016, 14:14:42
    Author     : sergio
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
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
                <th>Cantidad a pedir</th>
                <th>Accion</th>
            </tr>
            <% for(Configuracionpc configuracion : catalogo) { %>
            <tr>
                <form action="empresa" name="pedido-form" method="post">
                    <input type="hidden" name="configuracion" value="<%= configuracion.getIdconfiguracion() %>">
                    <td><%= configuracion.getIdconfiguracion() %></td>
                    <td><%= configuracion.getTipocpu().getNombretipocpu() %></td>
                    <td><%= configuracion.getVelocidadcpu() %></td>
                    <td><%= configuracion.getCapacidadram() %></td>
                    <td><%= configuracion.getCapacidaddd() %></td>
                    <td><%= configuracion.getVelocidadtarjetagrafica() %></td>
                    <td><%= configuracion.getMemoriatarjetagrafica() %></td>
                    <td><input type="text" name="cantidad"></td>
                    <td><input type="submit" name="accion" value="Al carro"></td>
                </form>
            </tr>
            <% } %>
        </table>
        <% } %>
        <h1>Carrito de la compra</h1>
        <% HashMap<Configuracionpc, Integer> carrito = (HashMap<Configuracionpc, Integer>) request.getAttribute("configuracionCarrito");
        if(carrito != null) { %>
        <table style="margin: 20px 0px;">
            <tr>
                <th>ID</th>
                <th>Tipo CPU</th>
                <th>Velocidad CPU</th>
                <th>Capacidad RAM</th>
                <th>Capacidad DD</th>
                <th>Velocidad Grafica</th>
                <th>Memoria Grafica</th>
                <th>Cantidad solicitada</th>
                <th>Accion</th>
            </tr>
            <% Iterator it = carrito.keySet().iterator();
                while(it.hasNext()){
                    Configuracionpc configuracion = (Configuracionpc) it.next(); %>
                    <tr>
                        <form action="empresa" name="pedido-form" method="post">
                            <input type="hidden" name="configuracion" value="<%= configuracion.getIdconfiguracion() %>">
                            <td><%= configuracion.getIdconfiguracion() %></td>
                            <td><%= configuracion.getTipocpu().getNombretipocpu() %></td>
                            <td><%= configuracion.getVelocidadcpu() %></td>
                            <td><%= configuracion.getCapacidadram() %></td>
                            <td><%= configuracion.getCapacidaddd() %></td>
                            <td><%= configuracion.getVelocidadtarjetagrafica() %></td>
                            <td><%= configuracion.getMemoriatarjetagrafica() %></td>
                            <td><%= carrito.get(configuracion) %></td>
                            <td><input type="submit" name="accion" value="Quitar del carro"></td>
                        </form>
                    </tr>
                <% } %>
        </table>
        <form action="empresa" name="pedido-complete-form" method="post">
            <td><input type="submit" name="accion" value="Tramitar pedido"></td>
        </form>
        <% } %>
    </body>
</html>
