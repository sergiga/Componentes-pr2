/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Pedidopc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio Garcia Villanueva
 * @author Carlos Gutierrez Casado
 */
@Local
public interface PedidopcFacadeLocal {

    void create(Pedidopc pedidopc);

    void edit(Pedidopc pedidopc);

    void remove(Pedidopc pedidopc);

    Pedidopc find(Object id);

    List<Pedidopc> findAll();

    List<Pedidopc> findRange(int[] range);

    int count();
    
    public List<Pedidopc> getPedidosByNif(String nifcif);
    
    public List<Pedidopc> getPedidosByNifEstado(String nifcif, int estadoVenta);
}
