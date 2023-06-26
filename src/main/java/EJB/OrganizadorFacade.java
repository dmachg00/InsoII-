/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.persistence.PersistenceContext;
import modelo.Rol;
import modelo.Organizador;

/**
 *
 * @author mtrasl
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

    @EJB
    private RolFacadeLocal rolEJB;

    @Override
    public List<Organizador> findOrganizadorType(char rol) {
        Rol aux = rolEJB.findRol(rol);
        String consulta = "FROM organizadores o WHERE o.rol.idRol=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", aux.getIdRol());
        List<Organizador> resultado = query.getResultList();
        return resultado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organizador findOrganizador(int id) {
        String consulta = "FROM organizadores o WHERE o.idOrganizador = :param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", id);
        List<Organizador> resultado = query.getResultList();
        return resultado.get(0); //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    public Organizador verificarOrganizador(Organizador organizador) {
        String consulta = "FROM organizadores o WHERE o.user=:param1 and o.password=:param2";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", organizador.getNombreUsuario());
        query.setParameter("param2", organizador.getPassword());
        List<Organizador> resultado = query.getResultList();
        if (resultado != null && !resultado.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("organizador", resultado.get(0));
            return resultado.get(0); // Devuelve el primer resultado encontrado
        } else {
            return null; // Devuelve null si no hay coincidencia en base de datos
        } //To change body of generated methods, choose Tools | Templates.
    } 

    @Override
    public Organizador obtenerOrganizadorActual() {
        Organizador organizador = (Organizador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("organizador");
        return organizador;    
    }

}
