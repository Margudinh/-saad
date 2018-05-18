/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.facade;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.negocios.delegate.AnimalesDomesticosDelegate;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AnimalesDomesticosFacade {
    private final AnimalesDomesticosDelegate delegate;
    
    public AnimalesDomesticosFacade(){
        delegate = new AnimalesDomesticosDelegate();
    }
    
    public boolean registrarAnimalDomestico(AnimalesDomesticos animalDomestico){
        return delegate.registrarAnimalDomestico(animalDomestico);
    }
    
    public boolean modificarAnimalDomestico(AnimalesDomesticos animalDomestico){
        return delegate.modificarAnimalDomestico(animalDomestico);
    }
    
    public boolean eliminarAnimalDomestico(AnimalesDomesticos animalDomestico){
        return delegate.eliminarAnimalDomestico(animalDomestico);
    }
    
    public List<AnimalesDomesticos> findTodosLosAnimalesDomesticos(){
        return delegate.findTodosLosAnimalesDomesticos();
    }
    
    public List<AnimalesDomesticos> findAnimalesDomesticosDisponibles(){
        return delegate.findAnimalesDomesticosDisponibles();
    }
        
}
