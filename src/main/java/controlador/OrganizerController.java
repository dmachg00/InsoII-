/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import EJB.EventoFacadeLocal;
import EJB.GustoFacadeLocal;
import EJB.GustoEventoFacadeLocal;
import EJB.GustoUsuarioFacadeLocal;
import EJB.UsuarioFacadeLocal;
import modelo.Evento;
import modelo.GustoEvento;
import modelo.GustoUsuario;
import modelo.Gusto;
import modelo.Usuario;
/**
 *
 * @author mtras
 */
@Named
@ViewScoped
public class OrganizerController implements Serializable{
    
    private List<Evento> eventos;
    private List<Gusto> gustos;
    private List<Usuario> usuarios;
    private Usuario organizadorLoged;
    private Usuario usuarioSeleccionado;
    private Gusto gustoSeleccionado; 
    private Gusto gustoEventoActual;
    private Gusto gustoUsuarioActual;
    private int idUsuario;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private EventoFacadeLocal eventoEJB;
    @EJB
    private GustoFacadeLocal gustoEJB;
    @EJB
    private GustoEventoFacadeLocal gustoEventoEJB;
    @EJB
    private GustoUsuarioFacadeLocal gustoUsuarioEJB;
    @EJB
    private Evento evento;
    private Gusto nuevoGusto;
    List<GustoEvento> gustoEvento;
    List<GustoUsuario> gustoUsuario;

    @PostConstruct
    public void init() {
        organizadorLoged = usuarioEJB.obtenerUsuarioActual();
        eventos = eventoEJB.findAllEventsOfOrganizer(organizadorLoged);
        nuevoGusto = new Gusto();
    }

    public void abrirDialogoGustos(Evento evento) {
        this.evento = evento;
        this.gustos = eventoEJB.findAllGustosEvento(evento);
    }

    public Gusto obtenerGustoEvento(Usuario usuario) {
        for (int i = 0; i < usuario.getGustoEventos().size(); i++) {
            if (usuario.getGustoEventos().get(i).getEvento().getGusto() == usuario.getGustoEventos().get(i).getGusto()) {
                this.gustoEventoActual = usuario.getGustoEventos().get(i).getGusto();
            }
        }
        return this.gustoEventoActual;
    }
    
    public Gusto obtenerGustoUsuario(Usuario usuario) {
        for (int i = 0; i < usuario.getGustoUsuario().size(); i++) {
            if (usuario.getGustoUsuario().get(i).getUsuario().getGusto().equals(gustoSeleccionado) ) {
                this.gustoUsuarioActual = usuario.getGustoUsuario().get(i).getGusto();
            }
        }
        return gustoUsuarioActual;
    }
    
     public void obtenerUsuariosConGusto(Gusto gusto) {
        this.gustoSeleccionado = gusto;
        usuarios = evento.getUsuarios();
    }
    
    public void establecerGustoEventoUsuarioEliminar(Usuario usuario) {
        this.usuarioSeleccionado = usuario;
    }
    
    public void eliminarGustoUsuario() {
        //gustoEJB.eliminarGustoUsuario(usuarioSeleccionado, gustoSeleccionado);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setGustoSeleccionado(Gusto gusto) {
        this.gustoSeleccionado = gusto;
    }

    public Gusto getGustoSeleccionado() {
        return gustoSeleccionado;
    }

    public void setNuevoGusto(Gusto nuevoGusto) {
        this.nuevoGusto = nuevoGusto;
    }
    
    public Gusto getNuevoGusto() {
        return nuevoGusto;
    }

    public void agregarGusto() {
        /*nuevoGusto.setEvento(evento);
        gustoEJB.create(nuevoGusto);
        gustos = gustoEJB.findAllTareasAsignatura(evento);
        nuevoGusto = new Gusto();*/
    }

    public void modificarGusto() {
        gustoEJB.edit(gustoSeleccionado);
    }

    public void eliminarGusto() {
        gustoEJB.remove(gustoSeleccionado);
        //gustos = gustoEJB.findAll(evento);
    }

    public void setGustos(List<Gusto> gustos) {
        this.gustos = gustos;
    }
    
    public List<Gusto> getGustos() {
        return gustos;
    }

    public void setOrganizadorLoged(Usuario organizadorLoged) {
        this.organizadorLoged = organizadorLoged;
    }
    
    public Usuario getProfesorLogeado() {
        return organizadorLoged;
    }
    
    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }
    
    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public EventoFacadeLocal getAsignaturaEJB() {
        return eventoEJB;
    }

    public void setEventoEJB(EventoFacadeLocal eventoEJB) {
        this.eventoEJB = eventoEJB;
    }

    public void setGustoEJB(GustoFacadeLocal gustoEJB) {
        this.gustoEJB = gustoEJB;
    }
    
    public GustoFacadeLocal getTareaEJB() {
        return gustoEJB;
    }

    public void setGustoEventoEJB(GustoEventoFacadeLocal gustoEventoEJB) {
        this.gustoEventoEJB = gustoEventoEJB;
    }
    
    public GustoEventoFacadeLocal getgustoEventoEJB() {
        return gustoEventoEJB;
    }
    
    public void setGustoUsuarioEJB(GustoUsuarioFacadeLocal gustoUsuarioEJB) {
        this.gustoUsuarioEJB = gustoUsuarioEJB;
    }
    
    public GustoUsuarioFacadeLocal getgustoUsuarioEJB() {
        return gustoUsuarioEJB;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }    
    
    public Evento getAsignatura() {
        return evento;
    }

    public void setGustosEvento(List<GustoEvento> gustosEvento) {
        this.gustoEvento = gustosEvento;
    }    
    
    public List<GustoEvento> getGustosEvento() {
        return gustoEvento;
    }
    
    public void setGustosUsuario(List<GustoUsuario> gustosUsuario) {
        this.gustoUsuario = gustosUsuario;
    }    
    
    public List<GustoUsuario> getGustosUsuario() {
        return gustoUsuario;
    }
    
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
        
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }
}
