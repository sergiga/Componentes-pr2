/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Tipocomponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio Garcia Villanueva
 * @author Carlos Gutierrez Casado
 */
@Local
public interface TipocomponenteFacadeLocal {

    void create(Tipocomponente tipocomponente);

    void edit(Tipocomponente tipocomponente);

    void remove(Tipocomponente tipocomponente);

    Tipocomponente find(Object id);

    List<Tipocomponente> findAll();

    List<Tipocomponente> findRange(int[] range);

    int count();
    
}
