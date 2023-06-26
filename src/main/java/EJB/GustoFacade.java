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

/**
 *
 * @author mtrasl
 */
@Stateless
public class GustoFacade extends AbstractFacade<Gusto> implements GustoFacadeLocal {

    @PersistenceContext(unitName = "PublicacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GustoFacade() {
        super(Gusto.class);
    }
    
    @Override
    public void edit(Gusto gusto) {
        em.merge(gusto);
    }

    @Override
    public void remove(Gusto gusto) {
        em.remove(em.merge(gusto));
    }
    
    public Gusto findGusto(char tipo) {
        String consulta = "SELECT g FROM gustos g WHERE g.nombre=:param1";      //nombre o idGusto???
        Query query = em.createQuery(consulta);
        query.setParameter("param1", tipo);
        List<Gusto> resultado = query.getResultList();
        return resultado.get(0); 
    }
    
    @Override
    public List<Gusto> findAll() {
        String consulta = "SELECT g FROM gustos g";
        Query query = em.createQuery(consulta);
        List<Gusto> resultado = query.getResultList();
        return resultado; 
    }
}
