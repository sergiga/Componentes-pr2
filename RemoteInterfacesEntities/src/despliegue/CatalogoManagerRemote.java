/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Configuracionpc;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sergio
 */
@Remote
public interface CatalogoManagerRemote {
    
    public List<Configuracionpc> getCatalogo();
    
    public void addConfiguracion(double velCPU, int capRAM, int capDD, double velTarGraf, 
            int memTarGraf, short idTipoCPU, List<Integer> idsDescrComp);
    
    public Configuracionpc getConfiguracion(int idConfiguracion);
}
