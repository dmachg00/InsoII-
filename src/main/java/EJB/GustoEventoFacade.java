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
import modelo.Gusto;
import modelo.Evento;
import modelo.GustoEvento;

/**
 *
 * @author mtras
 */
@Stateless
public class GustoEventoFacade extends AbstractFacade<GustoEvento> implements GustoEventoFacadeLocal {

    @PersistenceContext(unitName = "PublicacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GustoEventoFacade() {
        super(GustoEvento.class);
    }
    
    @Override
    public void edit(GustoEvento gustoEvento) {
        em.merge(gustoEvento);
    }

    @Override
    public void remove(GustoEvento gustoEvento) {
        em.remove(em.merge(gustoEvento));
    }
    
    public GustoEvento findGustoEvento(char tipo) {
        String consulta = "SELECT ge FROM gustosevento ge WHERE ge.nombre=:param1";      //nombre o idGusto???
        Query query = em.createQuery(consulta);
        query.setParameter("param1", tipo);
        List<GustoEvento> resultado = query.getResultList();
        return resultado.get(0); 
    }
    
    @Override
    public List<GustoEvento> findAll() {
        String consulta = "SELECT ge FROM gustosevento ge";
        Query query = em.createQuery(consulta);
        List<GustoEvento> resultado = query.getResultList();
        return resultado; 
    }
    
    
    public List<GustoEvento> findAllGustosEvento(Evento evento) {
        String consulta = "SELECT g FROM gustosevento g WHERE g.idGustosEvento = :idGustosEvento "
                + "AND g.idEventos = :idEventos AND g.idGustos = :idGustos";
        Query query = em.createQuery(consulta);
        query.setParameter("eventos", evento);
        List<GustoEvento> resultado = query.getResultList();
        return resultado;
    }

    
    public List<GustoEvento> findAllTareasUsuario(Evento evento, Gusto gusto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
