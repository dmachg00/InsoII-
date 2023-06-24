/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Organizador;

/**
 *
 * @author Diego
 */
@Stateless
public class OrganizadorFacade extends AbstractFacade<Organizador> implements OrganizadorFacadeLocal {

    @PersistenceContext(unitName = "PublicacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganizadorFacade() {
        super(Organizador.class);
    }
    
}
