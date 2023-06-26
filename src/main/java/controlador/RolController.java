/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import EJB.RolFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import modelo.Rol;
/**
 *
 * @author mtras
 */
public class RolController implements Serializable{
    @EJB
    private RolFacadeLocal rolEJB;
    private List<Rol> listaRoles;
    private Rol rol;
    private String accion;

    @PostConstruct
    public void init() {
        listaRoles = rolEJB.findAllRoles();
        rol = new Rol();
    }

    public void setAccion(String accion) {
        this.accion = accion;
        if (accion.equals("R")) {
            rol = new Rol();
        }
    }

    public void insertarRol() {
        rolEJB.create(rol);
        listaRoles = rolEJB.findAllRoles();
        rol = new Rol();
    }

    public void establecerRolModificar(Rol rol) {
        this.rol = rol;
        accion = "M";
    }
    
        public void modificarRol() {
        rolEJB.edit(rol);
        listaRoles = rolEJB.findAllRoles();
        rol = new Rol();
        accion = null;
    }

    public void eliminarRol() {
        rolEJB.remove(rol);
        listaRoles = rolEJB.findAllRoles();
        rol = new Rol();
        accion = null;
    }
    
    public void establecerRolEliminar(Rol rol) {
        this.rol = rol;
        accion = "E";
    }

    // Getters y setters Rol

    public List<Rol> getListaDeRoles() {
        return listaRoles;
    }

    public Rol getRol() {
        return rol;
    }

    public String getAccion() {
        return accion;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    public void setListaDeRoles(List<Rol> listaDeRoles) {
        this.listaRoles = listaDeRoles;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
