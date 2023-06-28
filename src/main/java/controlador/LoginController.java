/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import EJB.UsuarioFacadeLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Usuario;

/**
 *
 * @author mtrasl
 */
@Named
@RequestScoped
public class LoginController implements Serializable {
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private String nombreUsuario;
    private String contraseña;

    public String verificarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(contraseña);
        Usuario usuarioExistente = usuarioEJB.verificarUsuario(usuario);
        if (usuarioExistente != null) {
            // Usuario existe en base de datos, navegar a "privado/inicio.xhtml"
            if(usuarioExistente.getRol().getTipoUsuario()=='U'){
            return "privado/altaBajaModificacionUsuario.xhtml?faces-redirect=true";
            }else if (usuarioExistente.getRol().getTipoUsuario()=='O'){
                return "privado/altaBajaModificacionOrganizador.xhtml?faces-redirect=true";
            }else if (usuarioExistente.getRol().getTipoUsuario()=='E'){
                return "privado/altaBajaModificacionEventos.xhtml?faces-redirect=true";
            }else{
            return null;    
            }
        } else {
            // Usuario no existe en base de datos, navegar a "permisosinsuficientes.xhtml"
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña incorrectos."));
            return null;        
        }
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
