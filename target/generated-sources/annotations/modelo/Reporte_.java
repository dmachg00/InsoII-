package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Evento;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-24T18:02:33")
@StaticMetamodel(Reporte.class)
public class Reporte_ { 

    public static volatile SingularAttribute<Reporte, Evento> evento;
    public static volatile SingularAttribute<Reporte, Usuario> usuario;
    public static volatile SingularAttribute<Reporte, Integer> idReporte;

}