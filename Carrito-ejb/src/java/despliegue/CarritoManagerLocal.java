/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Configuracionpc;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface CarritoManagerLocal {
    public void addPedido(Configuracionpc configuracion, int cantidad);
    public void removePedido(Configuracionpc configuracion);
    public Map<Configuracionpc, Integer> getItems();
}
