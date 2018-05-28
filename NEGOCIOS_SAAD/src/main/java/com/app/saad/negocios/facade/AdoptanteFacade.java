/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.facade;

import com.app.saad.entidades.Adoptantes;
import com.app.saad.negocios.delegate.AdoptanteDelegate;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AdoptanteFacade {
    private final AdoptanteDelegate delegate;
    
    public AdoptanteFacade(){
        delegate = new AdoptanteDelegate();
    }
    
    public List<Adoptantes> findTodosLosAdoptantes(){
        return delegate.findTodosLosAdoptantes();
    }
    
    public Adoptantes findAdoptanteByTelefono(String telefono){
        return delegate.findAdoptanteByTelefono(telefono);
    }
    
    public Adoptantes findAdoptanteByCorreo(String correo){
        return delegate.findAdoptanteByCorreo(correo);
    }
    
    public boolean eliminarAdoptante(Adoptantes adoptante){
        return delegate.eliminarAdoptante(adoptante);
    }
    
    public boolean modificarAdoptante(Adoptantes adoptante){
        return delegate.modificarAdoptante(adoptante);
    }
    
    public boolean registrarAdoptante(Adoptantes adoptante){
        return delegate.registrarAdoptante(adoptante);
    }
}
