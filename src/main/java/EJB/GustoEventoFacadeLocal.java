/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.GustoEvento;

/**
 *
 * @author mtras
 */
@Local
public interface GustoEventoFacadeLocal {

    void create(GustoEvento gustoEvento);

    void edit(GustoEvento gustoEvento);

    void remove(GustoEvento gustoEvento);

    GustoEvento find(Object id);

    List<GustoEvento> findAll();

    List<GustoEvento> findRange(int[] range);

    int count();
    
}
