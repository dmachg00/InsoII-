package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "NombreUsuario", unique = true)
    private String user;
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
        return idUsuario;
    }

    public String getUser() {
        return user;
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
        this.idUsuario = idUsuario;
    }

    public void setUser(String user) {
        this.user = user;
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
        hash = 17 * hash + this.idUsuario;
        hash = 17 * hash + Objects.hashCode(this.user);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
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
