/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Gusto;

/**
 *
 * @author Diego
 */
@Local
public interface GustoFacadeLocal {

    void create(Gusto gusto);

    void edit(Gusto gusto);

    void remove(Gusto gusto);

    Gusto find(Object id);

    List<Gusto> findAll();

    List<Gusto> findRange(int[] range);

    int count();
    
}
