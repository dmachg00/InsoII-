/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.EventoFacadeLocal;
import EJB.GustoFacadeLocal;
import EJB.UsuarioFacadeLocal;
import EJB.OrganizadorFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import modelo.Gusto;
import modelo.Evento;
import modelo.Usuario;
import modelo.Organizador;


/**
 *
 * @author mtras
 */
@Named
@ViewScoped
public class EventsController implements Serializable{
    @EJB
    private EventoFacadeLocal eventoEJB;
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private OrganizadorFacadeLocal organizadorEJB;
    @EJB
    private GustoFacadeLocal gustoEJB;
    private List<Usuario> usuarios;
    private List<Usuario> organizadores;
    private List<Usuario> usuariosTodos;
    private List<Usuario> usuariosDisponibles;
    private List<Usuario> usuariosSeleccionados;
    private Usuario administrador;
    private Usuario organizador;
    private Usuario usuario;
    private int idUsuario;
    private List<Evento> listaDeEventos;
    private Evento evento;
    private String accion;

    @PostConstruct
    public void init() {
        listaDeEventos = eventoEJB.findAll();
        organizadores = usuarioEJB.findUsuarioType('O');
        usuariosTodos = usuarioEJB.findUsuarioType('U');
    }

    public void setAccion(String accion) {
        this.accion = accion;
        if (accion.equals("E")) {
            evento = new Evento();
        }
    }

    public void abrirDialogoEvento(Evento evento) {
        this.evento = evento;
        this.usuarios = evento.getUsuarios();
    }
    
    public void insertarEvento() {
        try {
            usuario = usuarioEJB.findUsuario(idUsuario);
            evento.setOrganizador(usuario);
            eventoEJB.create(evento);

            listaDeEventos = eventoEJB.findAll();
            evento = new Evento();
        } catch (Exception e) {
            System.out.println("Error al insertar el evento: " + e.getMessage());
        }
    }

    public void establecerEventoModificar(Evento evento) {
        this.evento = evento;
        accion = "M";
    }

    public void modificarEvento() {
        eventoEJB.edit(evento);
        listaDeEventos = eventoEJB.findAll();
        evento = new Evento();
        accion = null;
    }

    public void eliminarEvento() {
        // Obtener todos los eventos
        // Eliminar el evento
        eventoEJB.remove(evento);

        // Actualizar la lista de asignaturas
        listaDeEventos = eventoEJB.findAll();

        // Reiniciar las variables
        evento = new Evento();
        accion = null;
    }

    public void establecerEventoEliminar(Evento evento) {
        this.evento = evento;
        accion = "E";
    }

    public void establecerUsuarioEliminar(Usuario usuario) {
        this.usuario = usuario;
        accion = "E";
    }

    public void cargarUsuariosDisponiblesEvento(Evento evento) {
        this.evento = evento;
        this.usuarios = evento.getUsuarios();
        this.usuariosDisponibles = new ArrayList<Usuario>();
        for (Usuario user : usuariosTodos) {
            if (!usuarios.contains(user)) {
                usuariosDisponibles.add(user);
            }
        }
    }

    public void insertarUsuarios() {
        try {
            usuarioEJB.agregarUsuarioEvento(usuariosSeleccionados, evento.getIdEvento());
            listaDeEventos = eventoEJB.findAll();
            for (int i = 0; i < listaDeEventos.size(); i++) {
                if (evento.getIdEvento() == listaDeEventos.get(i).getIdEvento()) {
                    this.evento = listaDeEventos.get(i);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error al insertar el estudiante: " + e.getMessage());
        }

    }

    public void eliminarUsuario() {
        usuarioEJB.eliminarRelacionUsuarioEvento(usuario.getIdUsuario(), evento.getIdEvento());
        listaDeEventos = eventoEJB.findAll();
        for (int i = 0; i < listaDeEventos.size(); i++) {
            if (evento.getIdEvento() == listaDeEventos.get(i).getIdEvento()) {
                this.evento = listaDeEventos.get(i);
                break;
            }
        }
        this.usuarios = this.evento.getUsuarios();
        accion = null;
    }

    public void setListaDeEventos(List<Evento> listaDeEventos) {
        this.listaDeEventos = listaDeEventos;
    }
    
    public List<Evento> getListaDeEventos() {
        return listaDeEventos;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public Evento getEvento() {
        return evento;
    }

    public String getAccion() {
        return accion;
    }

    public void setEventoEJB(EventoFacadeLocal eventoEJB) {
        this.eventoEJB = eventoEJB;
    }
    
    public EventoFacadeLocal getEventoEJB() {
        return eventoEJB;
    }

    public void setOrganizadores(List<Usuario> organizadores) {
        this.organizadores = organizadores;
    }
    
    public List<Usuario> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }
        
    public Usuario getOrganizador() {
        return organizador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }
    
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
        
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuariosDisponibles(List<Usuario> usuariosDisponibles) {
        this.usuariosDisponibles = usuariosDisponibles;
    }
    public List<Usuario> getUsuariosDisponibles() {
        return usuariosDisponibles;
    }

    public void setUsuariosSeleccionados(List<Usuario> usuariosSeleccionados) {
        this.usuariosSeleccionados = usuariosSeleccionados;
    }
    public List<Usuario> getUsuariosSeleccionados() {
        return usuariosSeleccionados;
    }
}
