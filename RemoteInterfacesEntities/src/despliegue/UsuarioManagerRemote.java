/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Empresa;
import javax.ejb.Remote;
import utils.TipoUser;

/**
 *
 * @author sergio
 */
@Remote
public interface UsuarioManagerRemote {
    
    public boolean isUser(String nifcif, String passwd);
    
    public TipoUser tipoUser(String nifcif);
    
    public Empresa getEmpresa(String nifcif);
}
