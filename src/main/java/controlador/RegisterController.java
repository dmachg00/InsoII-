/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.OrganizadorFacadeLocal;
import EJB.RolFacadeLocal;
import EJB.UsuarioFacadeLocal;
import java.util.Date;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.*;
import javax.inject.Named;
import modelo.Organizador;
import modelo.Persona;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author mtrasl
 */
@Named
@ViewScoped
public class RegisterController implements Serializable{
       
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private OrganizadorFacadeLocal organizadorEJB;
    private Persona persona;
    private Organizador organizador;
    private Usuario usuario;
    private String descripcion;
    private String password1;
    private List<Rol> roles;
    @EJB
    private RolFacadeLocal rolEJB;
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        organizador = new Organizador();
        persona = new Persona();
        roles = rolEJB.findAllRoles();
        descripcion = "";
        usuario.setPersona(persona);
    }
    
    public String insertar() {
        System.out.println("Hola");
        String aux = "";
        try {
            // Obtener IdRol correspondiente a tipo de usuario "U"
            roles = rolEJB.findAllRoles();

            for (int i = 0; i < roles.size(); i++) {
                if (roles.get(i).getDescripcion().toString().equals("Usuario")) {
                    usuario.setRol(roles.get(i));
                }
            }
            System.out.println("Contraseñas:"+password1);
            System.out.println(persona.getNombre());
            
            if (password1 == null){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña no es correcta", null);
                FacesContext.getCurrentInstance().addMessage("form:confirmPassword", message);
            } else {
                usuario.setPassword(password1);
                usuarioEJB.create(usuario);
                /*
                Usuario usuarioExistente = usuarioEJB.verificarUsuario(usuario);
                
                if (usuarioExistente != null) {
                    // Usuario existe en base de datos, navegar a "privado/inicio.xhtml"
                    aux = "publico/registroExitoso.html?faces-redirect=true";
                } else {
                    // Usuario no existe en base de datos, navegar a "registroUsuario.html"
                    aux = "publico/registroFallido.html?faces-redirect=true";
                }
                */
            }
        } catch (Exception e) {
            System.out.println("Error al insertar el usuario: " + e.getMessage());
        }
        return aux;
    }
    
    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public OrganizadorFacadeLocal getOrganizadorEJB() {
        return organizadorEJB;
    }

    public void setOrganizadorEJB(OrganizadorFacadeLocal organizadorEJB) {
        this.organizadorEJB = organizadorEJB;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 67 * hash + Objects.hashCode(this.organizadorEJB);
        hash = 67 * hash + Objects.hashCode(this.organizador);
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.persona);
        hash = 67 * hash + Objects.hashCode(this.descripcion);
        hash = 67 * hash + Objects.hashCode(this.password1);
        hash = 67 * hash + Objects.hashCode(this.roles);
        hash = 67 * hash + Objects.hashCode(this.rolEJB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegisterController other = (RegisterController) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.password1, other.password1)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        if (!Objects.equals(this.organizadorEJB, other.organizadorEJB)) {
            return false;
        }
        if (!Objects.equals(this.organizador, other.organizador)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
            return false;
        }
        return true;
    }
    
    
}
