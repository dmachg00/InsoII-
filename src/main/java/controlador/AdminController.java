/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.UsuarioFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import modelo.Organizador;
import modelo.Usuario;
/**
 *
 * @author mtras
 */
@Named
@ViewScoped
public class AdminController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private List<Usuario> listaDeUsuarios;
    private Usuario usuario;
    private String accion;

    @PostConstruct
    public void init() {
        listaDeUsuarios = usuarioEJB.findAll();
        usuario = new Usuario();
    }

    public void setAccion(String accion) {
        this.accion = accion;
        if (accion.equals("A") || accion.equals("M")) {
            String pagina = (accion.equals("A")) ? "publico/agregarUsuario.xhtml" : "publico/modificarUsuario.xhtml";       // Redireccionar a esas páginas
            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, pagina);
        }
    }
    
    public String getAccion() {
        return accion;
    }

    public void eliminarUsuario() {
        usuarioEJB.remove(usuario);
        listaDeUsuarios = usuarioEJB.findAll();
        usuario = new Usuario();
        accion = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado de labase de datos", "El usuario se eliminó de manera correcta."));
    }

    public void establecerEliminarUsuario(Usuario usuario) {
        this.usuario = usuario;
        accion = "E";
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }
    
    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }
    
    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }
    
    public void modificarPerfil() {
        System.out.println("Usarios " + usuario.getPersona().getNombre());
        try {
            if (usuario != null) {
                usuarioEJB.edit(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil actualizado", "Los cambios se han guardado correctamente."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error modificarndo el perfil", "No ha seleccionado un usuario."));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error modificando el perfil", "Ha ocurrido un error al modificar el perfil. Por favor, inténtelo de nuevo5."));
        }
    }
}
