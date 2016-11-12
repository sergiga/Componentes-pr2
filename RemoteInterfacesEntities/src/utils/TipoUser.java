/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author sergio
 */
public enum TipoUser {
    
    CLIENTE(11, "Empresa", "Cliente"),
    PROVEEDOR(12, "Empresa", "Proveedor"),
    ENCARGADO(21, "Empleado", "Encargado de almacen"),
    TECNICO(22, "Empleado", "Tecnico de taller"),
    GERENTE(23, "Empleado", "Gerente de ventas");
    
    private int id;
    private String tipo;
    private String rol;
    
    private TipoUser(int id, String tipo, String rol) {
        this.id = id;
        this.tipo = tipo;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRol() {
        return rol;
    }
    
    @Override
    public String toString() {
        return "Usario tipo: " + this.tipo + ", Rol: " + this.rol;
    }
}
