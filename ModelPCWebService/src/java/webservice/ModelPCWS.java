/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import despliegue.CatalogoManagerRemote;
import dominio.Configuracionpc;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sergio
 */
@WebService(serviceName = "ModelPCWS")
@Stateless()
public class ModelPCWS {

    @EJB
    private CatalogoManagerRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getCatalogo")
    public List<Configuracionpc> getCatalogo() {
        return ejbRef.getCatalogo();
    }

    @WebMethod(operationName = "addConfiguracion")
    @Oneway
    public void addConfiguracion(@WebParam(name = "velCPU") double velCPU, @WebParam(name = "capRAM") int capRAM, @WebParam(name = "capDD") int capDD, @WebParam(name = "velTarGraf") double velTarGraf, @WebParam(name = "memTarGraf") int memTarGraf, @WebParam(name = "idTipoCPU") short idTipoCPU, @WebParam(name = "idsDescrComp") List<Integer> idsDescrComp) {
        ejbRef.addConfiguracion(velCPU, capRAM, capDD, velTarGraf, memTarGraf, idTipoCPU, idsDescrComp);
    }

    @WebMethod(operationName = "getConfiguracion")
    public Configuracionpc getConfiguracion(@WebParam(name = "idConfiguracion") int idConfiguracion) {
        return ejbRef.getConfiguracion(idConfiguracion);
    }
    
}
