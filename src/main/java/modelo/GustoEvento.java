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
 * @author mtras
 */
@Entity
@Table(name = "gustosevento")
public class GustoEvento implements Serializable{
    
    @EmbeddedId
    private GustoEventoId idGustosEvento;
    
    @ManyToOne
    @MapsId("idEventos") // Utiliza la propiedad idEventos de GustoEvento como parte de la clave primaria y clave externa
    @JoinColumn(name = "idEventos", referencedColumnName = "idEventos", foreignKey = @ForeignKey(name = "FK_gustosevento_eventos"))
    private Evento evento;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @MapsId("idGusto")
    @JoinColumn(name = "idGusto", referencedColumnName = "idGusto", foreignKey = @ForeignKey(name = "FK_gustosevento_gustos"))
    private Gusto gusto;
    
    //@Column(name = "gustoEvento")
    private String gustoEvento;

    public String getgustoEvento() {
        return gustoEvento;
    }

    public void setgustoEvento(String gustoEvento) {
        this.gustoEvento = gustoEvento;
    }
    
    public GustoEventoId getIdGustosEvento() {
        return idGustosEvento;
    }
    
    public void setIdGustosEvento(GustoEventoId idGustosEvento) {
        this.idGustosEvento = idGustosEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public Gusto getGusto() {
        return gusto;
    }

    public void setGusto(Gusto gusto) {
        this.gusto = gusto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.evento);
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
        final GustoEvento other = (GustoEvento) obj;
        if (this.idGustosEvento != other.idGustosEvento) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        if (!Objects.equals(this.gusto, other.gusto)) {
            return false;
        }
        return true;
    }
    
    @Embeddable
    public static class GustoEventoId implements Serializable {

        @Column(name = "idGustosEvento")
        private int idEventos;

        @Column(name = "idGustos")
        private int idGusto;

        public int getIdEventos() {
            return idEventos;
        }

        public void setIdEventos(int idEvento) {
            this.idEventos = idEvento;
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
            hash = 59 * hash + this.idEventos;
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
            final GustoEventoId other = (GustoEventoId) obj;
            if (this.idEventos != other.idEventos) {
                return false;
            }
            if (this.idGusto != other.idGusto) {
                return false;
            }
            return true;
        }
    }
}
