/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.facade;

import com.app.saad.entidades.Adopcion;
import com.app.saad.negocios.delegate.AdopcionDelegate;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AdopcionFacade {
    private final AdopcionDelegate delegate;
    
    public AdopcionFacade(){
        delegate = new AdopcionDelegate();
    }
    
    public List<Adopcion> findTodasLasAdopciones(){
        return delegate.findTodasLasAdopciones();
    }
    
    public Adopcion findAdopcionById(int id){
        return delegate.findAdopcionById(id);
    }
    
    public boolean registrarAdopcion(Adopcion adopcion){
        return delegate.registrarAdopcion(adopcion);
    }
    
    public boolean eliminarAdopcion(Adopcion adopcion){
        return delegate.borrarAdopcion(adopcion);
    }
    
    public boolean modificarAdopcion(Adopcion adopcion){
        return delegate.modificarAdopcion(adopcion);
    }
    
    public String generarPDFById(int id){
        return delegate.generarPDFById(id);
    }
}
