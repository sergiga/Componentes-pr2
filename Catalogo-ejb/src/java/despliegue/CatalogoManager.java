/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Configuracionpc;
import dominio.Descripcioncomponente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.ConfiguracionpcFacadeLocal;
import persistencia.CpuFacadeLocal;
import persistencia.DescripcioncomponenteFacadeLocal;

/**
 *
 * @author Sergio Garcia Villanueva
 * @author Carlos Gutierrez Casado
 */
@Stateless
public class CatalogoManager implements CatalogoManagerRemote {

    @EJB
    private ConfiguracionpcFacadeLocal configuracionFacade;
    
    @EJB
    private CpuFacadeLocal cpuFacade;
    
    @EJB
    private DescripcioncomponenteFacadeLocal descripcionFacade;
    
    /**
     * 
     * @return todas la configuraciones de la DB 
     */
    @Override
    public List<Configuracionpc> getCatalogo() {
        return configuracionFacade.findAll();
    }

    /**
     * Aniade una nueva configuracion de pc a la base de datos.
     * 
     * @param velCPU velocidad de procesador
     * @param capRAM capacidad RAM
     * @param capDD capacidad de Disco Duro
     * @param velTarGraf velocidad de la tarjeta grafica
     * @param memTarGraf memoria de la tarjeta grafica
     * @param idTipoCPU PK referenciando al tipo de CPU en la DB
     * @param idsDescrComp PKs referenciando a los componentes de la configuracion
     */
    @Override
    public void addConfiguracion(double velCPU, int capRAM, int capDD, double velTarGraf, 
            int memTarGraf, short idTipoCPU, List<Integer> idsDescrComp) {
        Configuracionpc configuracion = new Configuracionpc();
        List<Descripcioncomponente> descripciones = new ArrayList<>();
        Descripcioncomponente descripcion;
                
        configuracion.setVelocidadcpu(velCPU);
        configuracion.setCapacidadram(capRAM);
        configuracion.setCapacidaddd(capDD);
        configuracion.setVelocidadtarjetagrafica(velTarGraf);
        configuracion.setMemoriatarjetagrafica(memTarGraf);
        configuracion.setTipocpu(cpuFacade.find(idTipoCPU));
        
        for(int idDesc : idsDescrComp) {
            descripciones.add(descripcionFacade.find(idDesc));
        }
        
        configuracion.setDescripcioncomponenteList(descripciones);
        configuracion.setIdconfiguracion(getNextPK());
        configuracionFacade.create(configuracion);
    }

    /**
     * 
     * @param idConfiguracion identificador de la configuracion
     * @return la configuracion cuya PK es idConfiguracion
     */
    @Override
    public Configuracionpc getConfiguracion(int idConfiguracion) {
        return configuracionFacade.find(idConfiguracion);
    }
    
    /**
     * 
     * @return La siguiente PK libre para la creacion de una nueva configuracion
     */
    private Integer getNextPK() {
        int nextPK = 0;
        for(Configuracionpc conf : configuracionFacade.findAll()) {
            int currentPK = conf.getIdconfiguracion();
            nextPK = currentPK > nextPK ? currentPK : nextPK;
        }
        return nextPK + 1;
    }

    
}
