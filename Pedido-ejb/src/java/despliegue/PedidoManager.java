/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Pedidopc;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.EstadoventapcsFacadeLocal;
import persistencia.PedidopcFacadeLocal;

/**
 *
 * @author Sergio Garcia Villanueva
 * @author Carlos Gutierrez Casado
 */
@Stateless
public class PedidoManager implements PedidoManagerRemote {

    @EJB
    private CatalogoManagerRemote catalogoManager;

    @EJB
    private UsuarioManagerRemote usuarioManager;

    @EJB
    private PedidopcFacadeLocal pedidoFacade;
    
    @EJB
    private EstadoventapcsFacadeLocal estadoVentaFacade;
    
    /**
     * 
     * @return todos los pedidos
     */
    @Override
    public List<Pedidopc> getPedidos() {
        return pedidoFacade.findAll();
    }

    /**
     * 
     * @param nifcif identificador del usuario
     * @return todos los pedidos pertenecientes a un usuario
     */
    @Override
    public List<Pedidopc> getPedidos(String nifcif) {
        return pedidoFacade.getPedidosByNif(nifcif);
    }

    /**
     * 
     * @param nifcif identificador de usuario
     * @param estadoVenta identificador del estado de venta
     * @return todos los pedidos de un usuario con el estado de venta especificado
     */
    @Override
    public List<Pedidopc> getPedidos(String nifcif, int estadoVenta) {
        return pedidoFacade.getPedidosByNifEstado(nifcif, estadoVenta);
    }

    /**
     * Crea un nuevo pedido y lo aniade a la DB
     * 
     * @param cantidad cantidad de configuraciones a solicitar 
     * @param configuracion identificador de la configuracion solicitada
     * @param nifcif empresa que solicita el pedido
     */
    @Override
    public void addPedido(int cantidad, int configuracion, String nifcif) {
        Pedidopc pedido = new Pedidopc();
        
        pedido.setIdpedido(getNextPK());
        pedido.setCantidadsolicitada(cantidad);
        pedido.setEncargadopor(usuarioManager.getEmpresa(nifcif));
        pedido.setConfiguracionsolicitada(catalogoManager.getConfiguracion(configuracion));
        pedido.setEstado(estadoVentaFacade.find((short) 1));
        
        pedidoFacade.create(pedido);
    }
    
    /**
     * 
     * @return la siguiente PK disponible para la creacion de un nuevo pedido
     */
    private Integer getNextPK() {
        int nextPK = 0;
        for(Pedidopc pedido : pedidoFacade.findAll()) {
            int currentPK = pedido.getIdpedido();
            nextPK = currentPK > nextPK ? currentPK : nextPK;
        }
        return nextPK + 1;
    }
}
