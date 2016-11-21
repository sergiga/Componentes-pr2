/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author sergio
 */
@Remote
public interface CarritoManagerRemote {
    public void addUser(String user);
    public void addPedido(int configuracion, int cantidad);
    public void removePedido(int configuracion);
    public void removeAll();
    public String getUser();
    public Map<Integer, Integer> getItems();
}
