/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.*;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "valoracion")
public class Valoracion implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idValoracion;

    @Column(name = "Estrellas")
    private int estrellas;
    
    @Column(name = "Comentario")
    private String comentario;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_valoracion_usuarios"))
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "idEventos", foreignKey = @ForeignKey(name = "FK_valoracion_eventos"))
    private Evento evento;


   public int getIdValoracion(){
       return idValoracion;
   } 
   
   public void setIdValoracion(int idValoracion){
       
       this.idValoracion=idValoracion;
   }
   
   public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idValoracion;
        hash = 53 * hash + this.estrellas;
        hash = 53 * hash + Objects.hashCode(this.comentario);
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + Objects.hashCode(this.evento);
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
        final Valoracion other = (Valoracion) obj;
        if (this.idValoracion != other.idValoracion) {
            return false;
        }
        if (this.estrellas != other.estrellas) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        return true;
    }

   
}
