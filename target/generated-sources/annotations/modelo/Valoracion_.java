package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Evento;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-24T18:02:33")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, Integer> idValoracion;
    public static volatile SingularAttribute<Valoracion, Evento> evento;
    public static volatile SingularAttribute<Valoracion, Usuario> usuario;
    public static volatile SingularAttribute<Valoracion, String> comentario;
    public static volatile SingularAttribute<Valoracion, Integer> estrellas;

}