/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author mtrasl
 */
@Entity
@Table(name = "gustosusuario")
public class GustoUsuario implements Serializable {
    
    @EmbeddedId
    private GustoUsuarioId idGustosUsuario;
    
    @ManyToOne
    @MapsId("idUsuario") // Utiliza la propiedad idUsuario de GustoUsuarioId como parte de la clave primaria y clave externa
    @JoinColumn(name = "idUsuario", referencedColumnName = "IdUsuario", foreignKey = @ForeignKey(name = "FK_gustosusuario_usuarios"))
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @MapsId("idGusto")
    @JoinColumn(name = "idGusto", referencedColumnName = "idGusto", foreignKey = @ForeignKey(name = "FK_gustosusuario_gustos"))
    private Gusto gusto;
    
    //@Column(name = "gustoUsuario")
    private String gustoUsuario;

    public String getgustoUsuario() {
        return gustoUsuario;
    }

    public void setgustoUsuario(String gustoUsuario) {
        this.gustoUsuario = gustoUsuario;
    }
    
    public GustoUsuarioId getIdGustosUsuario() {
        return idGustosUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Gusto getGusto() {
        return gusto;
    }

    public void setIdGustosUsuario(GustoUsuarioId idGustosUsuario) {
        this.idGustosUsuario = idGustosUsuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setGusto(Gusto gusto) {
        this.gusto = gusto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.gusto);
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
        final GustoUsuario other = (GustoUsuario) obj;
        if (this.idGustosUsuario != other.idGustosUsuario) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.gusto, other.gusto)) {
            return false;
        }
        return true;
    }
    
    @Embeddable
    public static class GustoUsuarioId implements Serializable {

        @Column(name = "idGustosEvento")
        private int idGustosEvento;

        @Column(name = "idGustos")
        private int idGusto;

        public int getIdGustoEventos() {
            return idGustosEvento;
        }

        public void setIdGustoEventos(int idGustosEvento) {
            this.idGustosEvento = idGustosEvento;
        }

        public int getIdGusto() {
            return idGusto;
        }

        public void setIdExamen(int idGusto) {
            this.idGusto = idGusto;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + this.idGustosEvento;
            hash = 59 * hash + this.idGusto;
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
            final GustoUsuarioId other = (GustoUsuarioId) obj;
            if (this.idGustosEvento != other.idGustosEvento) {
                return false;
            }
            if (this.idGusto != other.idGusto) {
                return false;
            }
            return true;
        }
    }
}
