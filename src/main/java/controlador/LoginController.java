/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.UsuarioFacadeLocal;
import javax.ejb.EJB;
import modelo.Usuario;

/**
 *
 * @author Diego
 */
public class LoginController {
     
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private String nombreUsuario;
    private String contraseña;

    public String verificarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUser(nombreUsuario);
        usuario.setPassword(contraseña);
        Usuario usuarioExistente = usuarioEJB.verificarUsuario(usuario);
        System.out.println("Contraseña"+ contraseña);
        if (usuarioExistente != null) {
            // Usuario existe en base de datos, navegar a "privado/inicio.xhtml"
            
            return "privado/perfilUsuario.xhtml?faces-redirect=true";
        }else{
            
            return "privado/perfilOrganizador.xhtml?faces-redirect=true";
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


