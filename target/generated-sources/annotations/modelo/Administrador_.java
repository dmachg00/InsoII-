package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Rol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-24T18:02:33")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Integer> idAdministrador;
    public static volatile SingularAttribute<Administrador, String> password;
    public static volatile SingularAttribute<Administrador, String> usuario;
    public static volatile SingularAttribute<Administrador, Rol> rol;

}