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
import modelo.Usuario;
/**
 *
 * @author mtras
 */
public class ModifyUserController implements Serializable{
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private List<Usuario> listaUsuarios;
    private Usuario usuario;
    private String accion;

    @PostConstruct
    public void init() {
        listaUsuarios = usuarioEJB.findAll();
        usuario = new Usuario();

    }

    public void setAccion(String accion) {
        this.accion = accion;
        if (accion.equals("A") || accion.equals("M")) {
            // Redireccionar a otra página
            String pagina = (accion.equals("A")) ? "agregar_usuario.xhtml" : "modificar_usuario.xhtml";
            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, pagina);
        }
    }

    public void eliminarUsuario() {
        usuarioEJB.remove(usuario);
        listaUsuarios = usuarioEJB.findAll();
        usuario = new Usuario();
        accion = null;

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado", "El usuario se eliminó correctamente."));
    }

    public void establecerUsuarioEliminar(Usuario usuario) {
        this.usuario = usuario;
        accion = "E";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public void modificarPerfil() {
        System.out.println("Usarios" + usuario.getPersona().getNombre());
        try {
            // Validar los datos del usuario antes de guardar los cambios
            if (usuario != null) {

                // Actualizar los datos del usuario en la base de datos
                usuarioEJB.edit(usuario);
                // Mostrar mensaje de éxito
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil actualizado", "Los cambios en el perfil se han guardado correctamente."));
            } else {
                // Mostrar mensaje de error si no se ha seleccionado un usuario
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar perfil", "No se ha seleccionado un usuario."));
            }
        } catch (Exception e) {
            // Mostrar mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar perfil", "Ha ocurrido un error al modificar el perfil. Por favor, intenta nuevamente."));
        }
    }

    // Getters y setters
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public String getAccion() {
        return accion;
    }

    public void setListaDeUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
