package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Menu;
import modelo.Menu.TipoMenu;
import modelo.Rol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-24T18:02:33")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, TipoMenu> tipo;
    public static volatile SingularAttribute<Menu, Menu> menu_Padre;
    public static volatile SingularAttribute<Menu, Integer> idMenu;
    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, Rol> rol;
    public static volatile SingularAttribute<Menu, String> url;

}