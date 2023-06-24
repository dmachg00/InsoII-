/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gustosusuario")
public class GustoUsuario implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGustosUsuario;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_gustosusuario_usuarios"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "IdGusto", foreignKey = @ForeignKey(name = "FK_gustosusuario_gustos"))
    private Gusto gusto;

    public int getIdGustosUsuario() {
        return idGustosUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Gusto getGusto() {
        return gusto;
    }

    public void setIdGustosUsuario(int idGustosUsuario) {
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
        hash = 67 * hash + this.idGustosUsuario;
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

   
    
}
