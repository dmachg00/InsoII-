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
    public void remove(Rol rol) {
        em.remove(em.merge(rol)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Rol rol) {
         em.merge(rol);
    } //To change body of generated methods, choose Tools | Templates.
 

    @Override
    public void create(Rol rol) {
        em.merge(rol); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol findRol(char tipo) {
        Query query = em.createQuery("SELECT r FROM Rol r WHERE r.tipoUsuario = :tipo");
        query.setParameter("tipo", tipo);
        List<Rol> roles = query.getResultList();
        if (!roles.isEmpty()) {
            return roles.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<Rol> findAllRoles() {
        String consulta = "SELECT r FROM Rol r";
        Query query = em.createQuery(consulta);
        List<Rol> resultado = query.getResultList();
        return resultado;
    }

}
