/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Diego
 */


@Embeddable
@Table(name = "asistencia")
public class Asistencia implements Serializable {
    
    @EmbeddedId
    private AsistenciaID id;
    
    @ManyToOne
    @JoinColumn (name ="idEvento", referencedColumnName = "idEvento", foreignKey=@ForeignKey(name = "FK_eventos"))
    
    private Evento evento;
    
    @ManyToOne
    @JoinColumn (name ="idUsuario", referencedColumnName = "idUsuario", foreignKey=@ForeignKey(name = "FK_asistencia_usuarios"))
    
    private Usuario usuarios;
    
    
    public AsistenciaID getId(){
        return id;
        
    }
        
    public void setId(AsistenciaID id){
        this.id=id;
    }
    
    public Evento getEvento(){
        
        return evento;
    }
    
    public void setEvento (Evento evento){
        
       this.evento=evento;
    }
    
    public Usuario getUsuario(){
        return usuarios;
    }
    
    public void setUsuario(Usuario usuario){
     
        this.usuarios=usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.evento);
        hash = 29 * hash + Objects.hashCode(this.usuarios);
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
        final Asistencia other = (Asistencia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        return true;
    }
    
    
    

    public static class AsistenciaID implements Serializable {

        @Column(name = "idEvento")
        private int idEvento;

        @Column(name = "idUsuario")
        private int idUsuario;

        public int getIdEvento() {
            return idEvento;
        }

        public void setIdEvento(int idEvento) {
            this.idEvento = idEvento;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        @Override
        public int hashCode() {
            int hash = 5;
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
            final AsistenciaID other = (AsistenciaID) obj;
            if (this.idEvento != other.idEvento) {
                return false;
            }
            if (this.idUsuario != other.idUsuario) {
                return false;
            }
            return true;
        }

    }
}
    

