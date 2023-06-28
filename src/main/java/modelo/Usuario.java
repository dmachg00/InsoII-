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
 * @author mtrasl
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
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
    
    @OneToMany(mappedBy = "usuario")
    private List<GustoUsuario> gustoUsuarios;

    @OneToMany(mappedBy = "usuario")
    private List<GustoEvento> gustoEventos;

    @ManyToMany
    @JoinTable(name = "EventosUuario",
            joinColumns = @JoinColumn(name = "idEvento"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario"))
    private List<Evento> eventos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gusto> gustos;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }
    
    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Rol getRol() {
        return rol;
    }
    
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public List<Evento> getEventos() {
        return eventos;
    }
    
    public void setGustoUsuario(List<GustoUsuario> gustoUsuario) {
        this.gustoUsuarios = gustoUsuario;
    }

    public List<GustoUsuario> getGustoUsuario() {
        return gustoUsuarios;
    }
    
    public void setGustoEventos(List<GustoEvento> gustoEvento) {
        this.gustoEventos = gustoEvento;
    }
    
    public List<GustoEvento> getGustoEventos() {
        return gustoEventos;
    }

    public void setGusto(List<Gusto> gusto) {
        this.gustos = gusto;
    }
    
    public List<Gusto> getGusto() {
        return gustos;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idUsuario;
        hash = 71 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.ultimaConexion);
        hash = 71 * hash + Objects.hashCode(this.persona);
        hash = 71 * hash + Objects.hashCode(this.rol);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
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
