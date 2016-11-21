/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author sergio
 */
@Stateful
public class CarritoManager implements CarritoManagerRemote {

    private String userId;
    private Map<Integer, Integer> listaCompra;
    
    @PostConstruct
    private void create(){
        listaCompra = new HashMap<>();
    }

    @Override
    public void addUser(String user) {
        userId = user;
    }
    
    @Override
    public void addPedido(int configuracion, int cantidad) {
        int cantidadTotal = cantidad;
        if(listaCompra.containsKey(configuracion)) {
            cantidadTotal += listaCompra.get(configuracion);
        }
        listaCompra.put(configuracion, cantidadTotal);
    }

    @Override
    public void removePedido(int configuracion) {
        listaCompra.remove(configuracion);
    }

    @Override
    public void removeAll() {
        listaCompra.clear();
    }
    
    @Override
    public String getUser() {
        return userId;
    }
    
    @Override
    public Map<Integer, Integer> getItems() {
        return listaCompra;
    }
    
    @Remove
    public void remove() {
        listaCompra = null;
    }
}
