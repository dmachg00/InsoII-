/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.MenuFacadeLocal;
import EJB.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Menu;
import modelo.Menu.TipoMenu;
import modelo.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
/**
 *
 * @author mtras
 */
@Named
@SessionScoped
public class MenuController implements Serializable {
    private MenuModel modelo;
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private MenuFacadeLocal menuEJB;
    @PostConstruct
    public void init() {
        // Aquí puedes inicializar el modelo con los menús correspondientes al usuario
        // Puedes utilizar el método obtenerMenusUsuario() de MenuFacade mencionado anteriormente
        // y construir el objeto MenuModel adecuadamente
        modelo = new DefaultMenuModel();
        // Inicializar el modelo con los menús obtenidos
        obtenerMenu();
    }
public MenuModel obtenerMenu() {
     
    modelo = new DefaultMenuModel();
    Usuario usuario = usuarioEJB.obtenerUsuarioActual(); // Reemplaza para obtener el usuario actual
    
    // Obtienes los menús de la base de datos dependiendo del usuario
    List<Menu> menus = menuEJB.obtenerMenusUsuario(usuario);
    /*
       for (Menu menu : menus) {
            if (menu.getTipo() == TipoMenu.S) {
                //Submenú
                DefaultSubMenu subMenu = DefaultSubMenu.builder().label(menu.getNombre()).build();
                for(Menu j:menus){
                    if(j.getTipo()==TipoMenu.I){
                        if(j.getMenuPadre().getIdMenu()== menu.getIdMenu()){
                        DefaultMenuItem menuItem = DefaultMenuItem.builder()
                        .value(j.getNombre())
                        .url(j.getUrl())
                        .build();
                            subMenu.getElements().add(menuItem);
                        }
                    }
                }
                modelo.getElements().add(subMenu);
            } 
        }*/
       return modelo;
    }

    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }
    public String destruirSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";

    }
    public void getSubMenuItems(Menu menu){
        Usuario usuario = usuarioEJB.obtenerUsuarioActual(); // Reemplaza para obtener el usuario actual
        //Obtienes los menús de la base de datos dependiendo del usuario
        List<Menu> menus = menuEJB.obtenerMenusUsuario(usuario);
    }
}
