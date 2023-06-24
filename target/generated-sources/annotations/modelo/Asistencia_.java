package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Asistencia.AsistenciaID;
import modelo.Evento;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-21T19:46:11")
@StaticMetamodel(Asistencia.class)
public class Asistencia_ { 

    public static volatile SingularAttribute<Asistencia, Evento> evento;
    public static volatile SingularAttribute<Asistencia, AsistenciaID> id;
    public static volatile SingularAttribute<Asistencia, Usuario> usuarios;

}