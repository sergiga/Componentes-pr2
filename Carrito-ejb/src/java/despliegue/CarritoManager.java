/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Configuracionpc;
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
public class CarritoManager implements CarritoManagerLocal {

    private String userId;
    private Map<Configuracionpc, Integer> listaCompra;
    
    @PostConstruct
    private void create(){
        listaCompra = new HashMap<>();
    }

    @Override
    public void addPedido(Configuracionpc configuracion, int cantidad) {
        if(listaCompra.containsKey(configuracion)) {
            int cantidadOld = listaCompra.get(configuracion);
            listaCompra.put(configuracion, cantidad + cantidadOld);
        }
    }

    @Override
    public void removePedido(Configuracionpc configuracion) {
        listaCompra.remove(configuracion);
    }

    @Override
    public Map<Configuracionpc, Integer> getItems() {
        return listaCompra;
    }
    
    @Remove
    public void remove() {
        listaCompra = null;
    }
}
