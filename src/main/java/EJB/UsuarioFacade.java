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
import modelo.Usuario;
import modelo.Evento;

/**
 *
 * @author mtrasl
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "PublicacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @EJB
    private RolFacadeLocal rolEJB;
            
    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> findUsuarioType(char rol) {
        Rol aux = rolEJB.findRol(rol);
        String consulta = "FROM Usuario u WHERE u.rol.idRol=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", aux.getIdRol());
        List<Usuario> resultado = query.getResultList();
        return resultado; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Usuario findUsuario(int id) {
        String consulta = "FROM Usuario u WHERE u.idUsuario = :param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", id);
        List<Usuario> resultado = query.getResultList();
        return resultado.get(0); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario verificarUsuario(Usuario usuario) {
        String consulta = "FROM Usuario u WHERE u.user=:param1 and u.password=:param2";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", usuario.getNombreUsuario());
        query.setParameter("param2", usuario.getPassword());
        List<Usuario> resultado = query.getResultList();
        if (resultado != null && !resultado.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", resultado.get(0));
            return resultado.get(0); // Devuelve el primer resultado encontrado
        } else {
            return null; // Devuelve null si no hay coincidencia en base de datos
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtenerUsuarioActual() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return usuario;
    } //To change body of generated methods, choose Tools | Templates.
    
    //@Override
    public void agregarUsuarioEvento(List<Usuario> usuarios, int idEvento) {
        try {
            // Obtener la entidad Evento por su ID
            Evento evento = em.find(Evento.class, idEvento);

            if (evento != null) {
                for (Usuario user : usuarios) {
                    // Obtener la entidad Usuario por su ID
                    Usuario usuario = em.find(Usuario.class, user.getIdUsuario());

                    if (usuario != null) {
                        // Añadir el evento a la lista de eventos del usuario
                        List<Evento> eventosUsuario = usuario.getEventos();
                        eventosUsuario.add(evento);

                        // Añadir el usuario a la lista de usuarios del evento
                        List<Usuario> usuariosEvento = evento.getUsuarios();
                        usuariosEvento.add(usuario);

                        // Actualizar las listas de eventos y usuarios
                        usuario.setEventos(eventosUsuario);
                        evento.setUsuarios(usuariosEvento);

                        // Persistir los cambios en la base de datos
                        em.merge(usuario);
                        em.merge(evento);
                    }
                }
            }
        } catch (Exception e) {
            // Manejar la excepción
            e.printStackTrace();
        }
    }
    
    //@Override
    public void eliminarRelacionUsuarioEvento(int idUsuario, int idEvento) {
        try {
            // Obtener la entidad Usuario por su ID
            Usuario usuario = em.find(Usuario.class, idUsuario);

            // Obtener la entidad Evento por su ID
            Evento evento = em.find(Evento.class, idEvento);

            if (usuario != null && evento != null) {
                // Eliminar el evento de la lista de eventos del usuario
                List<Evento> eventosUsuario = usuario.getEventos();
                eventosUsuario.remove(evento);

                // Eliminar el usuario de la lista de usuarios del evento
                List<Usuario> usuariosEvento = evento.getUsuarios();
                usuariosEvento.remove(usuario);

                // Actualizar las listas de eventos y usuarios
                usuario.setEventos(eventosUsuario);
                evento.setUsuarios(usuariosEvento);

                // Persistir los cambios en la base de datos
                em.merge(usuario);
                em.merge(evento);
            }
        } catch (Exception e) {
            // Manejar la excepción
            e.printStackTrace();
        }
    }
}
    
