/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Evento;
import modelo.Gusto;
import modelo.Usuario;

/**
 *
 * @author mtrasl
 */
@Local
public interface EventoFacadeLocal {

    void create(Evento evento);

    void edit(Evento evento);

    void remove(Evento evento);

    Evento find(Object id);
    
    List<Evento> findAllEventsOfOrganizer(Usuario u);
    
    List<Gusto> findAllGustosEvento(Evento evento);

    List<Evento> findAll();

    List<Evento> findRange(int[] range);

    int count();
    
}
