/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "administrador")
public class Administrador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdministrador;
    @Column(name = "Usuario", unique = true)
    private String usuario;
    @Column(name = "Contraseña")
    private String password;
    @ManyToOne
    @JoinColumn(name = "IdRol")
    private Rol rol;
    
     public int getIdAdmin() {
        return idAdministrador;
    }

    public String getNombreUsuario() {
        return usuario;
    }


    public String getPassword() {
        return password;
  
    }

    public Rol getRol() {
        return rol;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdministrador = idAdministrador;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idAdministrador;
        hash = 17 * hash + Objects.hashCode(this.usuario);
        hash = 17 * hash + Objects.hashCode(this.password);
        hash = 17 * hash + Objects.hashCode(this.rol);
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
        final Administrador other = (Administrador) obj;
        if (this.idAdministrador != other.idAdministrador) {
            return false;
        }
     
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
       
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
       
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }
    
}
