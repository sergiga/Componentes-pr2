/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Pedidopc;
import java.util.List;

/**
 *
 * @author sergio
 */
public interface PedidoManagerRemote {
    
    public List<Pedidopc> getPedidos();

    public List<Pedidopc> getPedidos(String nifcif);

    public List<Pedidopc> getPedidos(String nifcif, int estadoVenta);

    public void addPedido(int cantidad, int configuracion, String nifcif);
}
