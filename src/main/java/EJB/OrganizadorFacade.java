/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public List<Organizador> findOrganizadorType(char rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organizador findOrganizador(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organizador verificarOrganizador(Organizador organizador) {
        String consulta = "FROM Organizador u WHERE o.organizador=:param1 and u.password=:param2";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", organizador.getNombreUsuario());
        query.setParameter("param2", organizador.getPassword());
        List<Organizador> resultado = query.getResultList();
        if (resultado != null && !resultado.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("organizador", resultado.get(0));
            return resultado.get(0); // Devuelve el primer resultado encontrado
        } else {
            return null; // Devuelve null si no hay coincidencia en base de datos
        } 
    } 

    @Override
    public Organizador obtenerOrganizadorActual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
