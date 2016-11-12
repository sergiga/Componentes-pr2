/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import dominio.Empleado;
import dominio.Empresa;
import dominio.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.UsuarioFacadeLocal;
import utils.TipoUser;

/**
 *
 * @author Sergio Garcia Villanueva
 * @author Carlos Gutierrez Casado
 */
@Stateless
public class UsuarioManager implements UsuarioManagerRemote {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    /**
     * 
     * @param nifcif identificador de usuario
     * @param passwd contrasenia de usuario
     * @return TRUE si el login es correcto. FALSE en caso contrario
     */
    @Override
    public boolean isUser(String nifcif, String passwd) {
        Usuario usuario = usuarioFacade.find(nifcif);
        
        if(usuario == null) { return false; }
        return usuario.getPassword().equals(passwd);
    }

    /**
     * 
     * @param nifcif identificador de usuario
     * @return el tipo de usuario y su rol en la aplicacion
     */
    @Override
    public TipoUser tipoUser(String nifcif) {
        Usuario usuario = usuarioFacade.find(nifcif);
        Empresa empresa;
        Empleado empleado;
        
        if(usuario == null) { return null; }
        else if ((empresa = usuario.getEmpresa()) != null) {
            return empresa.getEscliente() == 1 ? TipoUser.CLIENTE : TipoUser.PROVEEDOR;
        }
        else if ((empleado = usuario.getEmpleado()) != null) {
            switch(empleado.getRol().getIdrol()) {
                case 1:
                    return TipoUser.ENCARGADO;
                case 2: 
                    return TipoUser.TECNICO;
                case 3:
                    return TipoUser.GERENTE;
                default:
                    return null;
            }
        }
        return null;
    }

    /**
     * 
     * @param nifcif identificador de usuario
     * @return la empresa del usuario especificado
     */
    @Override
    public Empresa getEmpresa(String nifcif) {
        Usuario usuario = usuarioFacade.find(nifcif);
        
        if(usuario == null) { return null; }
        return usuario.getEmpresa();
    } 
}
