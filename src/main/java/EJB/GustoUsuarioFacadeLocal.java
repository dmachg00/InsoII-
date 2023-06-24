/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.GustoUsuario;

/**
 *
 * @author Diego
 */
@Local
public interface GustoUsuarioFacadeLocal {

    void create(GustoUsuario gustoUsuario);

    void edit(GustoUsuario gustoUsuario);

    void remove(GustoUsuario gustoUsuario);

    GustoUsuario find(Object id);

    List<GustoUsuario> findAll();

    List<GustoUsuario> findRange(int[] range);

    int count();
    
}
