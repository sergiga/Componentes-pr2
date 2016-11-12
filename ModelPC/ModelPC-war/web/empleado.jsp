<%-- 
    Document   : empleado
    Created on : 12-nov-2016, 14:15:26
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ModelPC | Empleado</title>
    </head>
    <body>
        <h1>Página de empleados</h1>
        <h2>Añadir nueva configuracion de pc</h2>
        <form action="empleado" name="pedido-form" method="post">
            Velocidad CPU: <br><input type="text" name="velCPU"><br>
            Capacidad RAM: <br><input type="text" name="capRAM"><br>
            Capacidad Disco Duro: <br><input type="text" name="capDD"><br>
            Velocidad Grafica: <br><input type="text" name="velTarGraf"><br>
            Memoria Grafica: <br><input type="text" name="memTarGraf"><br>
            Tipo CPU: <br><select name="idTipoCPU">
                <option value="1" selected>AMD</option>
                <option value="2">Intel</option>
            </select><br>
            Targeta Grafica: <br><select name="grafica">
                <option value="1" selected>AMD-Radeon R9</option>
                <option value="2">AMD-Radeon R7</option>
            </select><br>
            Disco Duro: <br><select name="discoDuro">
                <option value="3" selected>Samsung 850-EVO</option>
                <option value="4">Samsung 750-EVO</option>
            </select><br>
            Procesador: <br><select name="procesador">
                <option value="5" selected>MSI A68HM-E33 V2</option>
                <option value="6">MSI H81M-E33</option>
            </select><br>
            Caja: <br><select name="caja">
                <option value="7" selected>Nox Pax USB 3.0</option>
                <option value="8">Nox Coolbay SX</option>
            </select><br>
            Chipset: <br><select name="chipset">
                <option value="9" selected>AMD A10-7850K</option>
                <option value="10">Intel i5-4460</option>
            </select><br>
            RAM: <br><select name="ram">
                <option value="11" selected>G.Skill Ripjaws V Red</option>
                <option value="12">HyperX Fury</option>
            </select><br>
            <input type="submit" name="accion" value="Add configuracion">
        </form>
    </body>
</html>
