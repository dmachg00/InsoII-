package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Persona;
import modelo.Rol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-24T18:02:33")
@StaticMetamodel(Organizador.class)
public class Organizador_ { 

    public static volatile SingularAttribute<Organizador, Date> ultimaConexion;
    public static volatile SingularAttribute<Organizador, String> password;
    public static volatile SingularAttribute<Organizador, Persona> persona;
    public static volatile SingularAttribute<Organizador, String> nombreUsuario;
    public static volatile SingularAttribute<Organizador, Integer> idOrganizador;
    public static volatile SingularAttribute<Organizador, String> email;
    public static volatile SingularAttribute<Organizador, Rol> rol;

}