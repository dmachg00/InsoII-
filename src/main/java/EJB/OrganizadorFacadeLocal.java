/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Organizador;

/**
 *
 * @author Diego
 */
@Local
public interface OrganizadorFacadeLocal {

    void create(Organizador organizador);

    void edit(Organizador organizador);

    void remove(Organizador organizador);

    Organizador find(Object id);

    List<Organizador> findAll();

    List<Organizador> findRange(int[] range);

    int count();
  
    List<Organizador> findOrganizadorType(char rol);
    
    Organizador findOrganizador(int id);
            
    Organizador verificarOrganizador(Organizador organizador);
    
    Organizador obtenerOrganizadorActual();

    
}
