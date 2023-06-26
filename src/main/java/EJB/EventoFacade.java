/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Evento;

/**
 *
 * @author mtrasl
 */
@Stateless
public class EventoFacade extends AbstractFacade<Evento> implements EventoFacadeLocal {

    @PersistenceContext(unitName = "PublicacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoFacade() {
        super(Evento.class);
    }
    
    @Override
    public void edit(Evento evento) {
        em.merge(evento);
    }

    @Override
    public void remove(Evento evento) {
        em.remove(em.merge(evento));
    }
    
    public Evento findGusto(char tipo) {
        String consulta = "SELECT e FROM eventos e WHERE e.nombre=:param1";     ////nombre o idGusto???
        Query query = em.createQuery(consulta);
        query.setParameter("param1", tipo);
        List<Evento> resultado = query.getResultList();
        return resultado.get(0); 
    }
    
    @Override
    public List<Evento> findAll() {
        String consulta = "SELECT e FROM eventos e";
        Query query = em.createQuery(consulta);
        List<Evento> resultado = query.getResultList();
        return resultado; 
    }
    
}
