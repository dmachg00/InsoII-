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
import modelo.Rol;


/**
 *
 * @author Diego
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "PublicacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    
       @Override
    public void edit(Rol rol) {
        em.merge(rol);
    }

    @Override
    public void remove(Rol rol) {
        em.remove(em.merge(rol));
    }
    
    @Override
    public Rol findRol(int tipo) {
        String consulta = "SELECT r FROM Rol r WHERE r.TipoUsuario=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", tipo);
        List<Rol> resultado = query.getResultList();
        return resultado.get(0); 
    }
    
    @Override
    public List<Rol> findAll() {
        String consulta = "SELECT r FROM Rol r";
        Query query = em.createQuery(consulta);
        List<Rol> resultado = query.getResultList();
        return resultado; 
    }
    
}
