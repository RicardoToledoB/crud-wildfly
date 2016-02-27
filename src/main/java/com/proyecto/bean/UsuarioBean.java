package com.proyecto.bean;
import com.proyecto.model.Usuario;

import com.proyecto.service.UsuarioServiceImpl;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
@Named(value = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
    private Usuario user;
    private List<Usuario> lista;
    @Inject
    private UsuarioServiceImpl uService;
    @PostConstruct
    public void init(){
        user=new Usuario();
    }
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Usuario> getLista() {
        return uService.list();
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    public void save(){
        uService.save(user);
        limpiar();
    }
    
    public void limpiar(){
        user=new Usuario();
    }
    
}
