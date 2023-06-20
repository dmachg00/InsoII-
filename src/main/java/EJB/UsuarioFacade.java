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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author Diego
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "PublicacionesPU")
    private EntityManager em;
    
    @EJB
    private RolFacade rolFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
     @Override
    public List<Usuario> findUsuarioType(int rol) {
        Rol aux = rolFacade.findRol(rol);
        String consulta = "FROM Usuario u WHERE u.rol.idRol=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", aux.getIdRol());
        List<Usuario> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public Usuario verificarUsuario(Usuario us) {
        String consulta = "FROM Usuario u WHERE u.user=:param1 and u.password=:param2";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", us.getUser());
        query.setParameter("param2", us.getPassword());
        List<Usuario> resultado = query.getResultList();
        if (resultado != null && !resultado.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", resultado.get(0));
            return resultado.get(0); // Devuelve el primer resultado encontrado
        } else {
            return null; // Devuelve null si no hay coincidencia en base de datos
        }
    }

    @Override
    public Usuario findUsuario(int id) {
        String consulta = "FROM Usuario u WHERE u.idUsuario = :param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", id);
        List<Usuario> resultado = query.getResultList();
        return resultado.get(0);
    }

    @Override
    public Usuario obtenerUsuarioActual() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        return us;
    }
}
