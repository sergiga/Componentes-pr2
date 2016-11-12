/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Pedidopc;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sergio Garcia Villanueva
 * @author Carlos Gutierrez Casado
 */
@Stateless
public class PedidopcFacade extends AbstractFacade<Pedidopc> implements PedidopcFacadeLocal {

    @PersistenceContext(unitName = "Pedido-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidopcFacade() {
        super(Pedidopc.class);
    }
    
    public List<Pedidopc> getPedidosByNif(String nifcif) {
        Query query = em.createNamedQuery("Pedidopc.findByEmpresa")
                .setParameter("nifcif", nifcif);
        return query.getResultList();
    }

    @Override
    public List<Pedidopc> getPedidosByNifEstado(String nifcif, int estadoVenta) {
        Query query = em.createNamedQuery("Pedidopc.findByEmpresaEstado")
                .setParameter("nifcif", nifcif)
                .setParameter("estadoVenta", estadoVenta);
        return query.getResultList();
    }
}
