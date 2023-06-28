/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mtrasl
 */
@Entity
@Table(name = "eventos")   
public class Evento implements Serializable{
    
    @Id
    @Column(name = "IdEvento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvento;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Column(name = "Direccion")
    private String direccion;
    
    @Column(name = "Telefono")
    private int telefono;
    
    @ManyToMany(mappedBy = "eventos")
    private List<Usuario> usuarios;
    
    @OneToMany(mappedBy = "gustos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gusto> gustos;
    
    @ManyToOne
    @JoinColumn(name = "IdOrganizador", referencedColumnName = "IdEvento", foreignKey = @ForeignKey(name = "FK_Evento_Usuario"))
    private Usuario organizador;

    public int getIdEvento() {
        return idEvento;
    }

    public void setidEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public int getTelefono() {
        return telefono;
    }

    public void setOrganizador (Usuario organizador){
       this.organizador = organizador;
   }
    
   public Usuario getOrganizador(){
       return organizador;
   }
   
   public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
   
   public List<Usuario> getUsuarios() {
        return usuarios;
    }

   public void setGusto(List<Gusto> gusto) {
        this.gustos = gusto;
    }
   
   public List<Gusto> getGusto() {
        return gustos;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.idEvento;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.direccion);
        hash = 61 * hash + this.telefono;
        hash = 61 * hash + Objects.hashCode(this.organizador);
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
        final Evento other = (Evento) obj;
        if (this.idEvento != other.idEvento) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.organizador, other.organizador)) {
            return false;
        }
        return true;
    }
   

   
    
}