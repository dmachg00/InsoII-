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
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mtrasl
 */
@Embeddable
@Table(name = "organizadores")
public class Organizador implements Serializable {

    @EmbeddedId
    private OrganizadorEventoId id;
    
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
    
    @ManyToOne
    @JoinColumn(name = "IdRol", referencedColumnName = "IdRol", updatable = false, foreignKey = @ForeignKey(name = "FK_Organizador_IdRol"))
    private Rol idRol;

    @ManyToOne
    @JoinColumn(name = "IdPersona", referencedColumnName = "IdPersona", updatable = false, foreignKey = @ForeignKey(name = "FK_Organizador_IdPersona"))
    private Persona persona;

    public OrganizadorEventoId getIdOrganizador() {
        return id;
    }

    public void setIdOrganizador(OrganizadorEventoId id) {
        this.id = id;
    }

    public Rol getRol() {
        return idRol;
    }

    public void setRol(Rol rol) {
        this.idRol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public static class OrganizadorEventoId implements Serializable {

        @Column(name = "IdOrganizador")
        private int idOrganizador;

        public int getIdOrganizador() {
            return idOrganizador;
        }

        public void setIdOrganizador(int idOrganizador) {
            this.idOrganizador = idOrganizador;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + this.idOrganizador;
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
            final OrganizadorEventoId other = (OrganizadorEventoId) obj;
            if (this.idOrganizador != other.idOrganizador) {
                return false;
            }
            return true;
        }
    }
}
