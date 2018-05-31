/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.helpers;

import com.app.saad.entidades.Adoptantes;
import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AdoptanteHelper implements Serializable{
    
    public List<Adoptantes> buscarTodosLosAdoptantes(){
        return ServiceFacadeLocator.getAdoptanteFacade().findTodosLosAdoptantes();
    }
    
    public boolean modificarAdoptante(Adoptantes adoptante){
        return ServiceFacadeLocator.getAdoptanteFacade().modificarAdoptante(adoptante);
    }
    
    public boolean eliminarAdoptante(Adoptantes adoptante){
        return ServiceFacadeLocator.getAdoptanteFacade().eliminarAdoptante(adoptante);
    }
    
}
