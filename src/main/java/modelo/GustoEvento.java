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
 * @author mtras
 */
@Entity
@Table(name = "gustosevento")
public class GustoEvento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGustoEvento;
    
    @ManyToOne
    @JoinColumn(name = "idEventos", foreignKey = @ForeignKey(name = "FK_gustosevento_eventos"))
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "idGusto", foreignKey = @ForeignKey(name = "FK_gustosevento_gustos"))
    private Gusto gusto;

    public int getIdGustosEvento() {
        return idGustoEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public Gusto getGusto() {
        return gusto;
    }

    public void setIdGustosEvento(int idGustosEvento) {
        this.idGustoEvento = idGustosEvento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setGusto(Gusto gusto) {
        this.gusto = gusto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idGustoEvento;
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
        if (this.idGustoEvento != other.idGustoEvento) {
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
}
