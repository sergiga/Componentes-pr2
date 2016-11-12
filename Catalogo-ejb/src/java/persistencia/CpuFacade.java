/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Cpu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio Garcia Villanueva
 * @author Carlos Gutierrez Casado
 */
@Stateless
public class CpuFacade extends AbstractFacade<Cpu> implements CpuFacadeLocal {

    @PersistenceContext(unitName = "Catalogo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CpuFacade() {
        super(Cpu.class);
    }
    
}
