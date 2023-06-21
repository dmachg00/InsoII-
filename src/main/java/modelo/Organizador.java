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
@Table(name = "organizadores")
public class Organizador {
    
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrganizador;
    @Column(name = "NombreUsuario", unique = true)
    private String nombreUsuario;
    @Column(name = "Email", unique = true)
    private String email;
    @Column(name = "Contraseña")
    private String password;
    @Column(name = "UltimaConexion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaConexion;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "IdPersona")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "IdRol")
    private Rol rol;
    

    public int getIdUsuario() {
        return idOrganizador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }


    public Persona getPersona() {
        return persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setIdUsuario(int idUsuario) {
        this.idOrganizador = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }


    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idOrganizador;
        hash = 17 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.password);
        hash = 17 * hash + Objects.hashCode(this.ultimaConexion);
        hash = 17 * hash + Objects.hashCode(this.persona);
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
        final Organizador other = (Organizador) obj;
        if (this.idOrganizador != other.idOrganizador) {
            return false;
        }
     
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.ultimaConexion, other.ultimaConexion)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }
    
}
