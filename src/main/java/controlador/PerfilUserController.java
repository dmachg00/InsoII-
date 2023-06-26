/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import EJB.UsuarioFacadeLocal;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuario;

/**
 *
 * @author mtras
 */
public class PerfilUserController implements Serializable{
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = usuarioEJB.obtenerUsuarioActual();
    }

    // Getters y setters Usuario

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
        try {
            // Validar los datos del usuario antes de guardar los cambios
            // Actualizar los datos del usuario en la base de datos
            usuarioEJB.edit(usuario);

            // Mostrar mensaje de éxito
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil actualizado", "Los cambios en el perfil se han guardado correctamente."));
        } catch (Exception e) {
            // Mostrar mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar perfil", "Ha ocurrido un error al modificar el perfil. Por favor, intenta nuevamente."));
        }
    }
}
