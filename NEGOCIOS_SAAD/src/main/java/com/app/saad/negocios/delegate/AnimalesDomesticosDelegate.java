/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.delegate;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.integracion.ServiceLocator;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AnimalesDomesticosDelegate {
    
    public List<AnimalesDomesticos> findTodosLosAnimalesDomesticos(){
        return ServiceLocator.getAnimalesDomesticosDAO().findAll();
    }
    
    public List<AnimalesDomesticos> findAnimalesDomesticosDisponibles(){
       
        return ServiceLocator.getAnimalesDomesticosDAO().findAnimalesDomesticosDisponibles();
        
    }
    
    public boolean registrarAnimalDomestico(AnimalesDomesticos animalDomestico){
        try{
            ServiceLocator.getAnimalesDomesticosDAO().save(animalDomestico);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarAnimalDomestico(AnimalesDomesticos animalDomestico){
        try{
            ServiceLocator.getAnimalesDomesticosDAO().delete(animalDomestico);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modificarAnimalDomestico(AnimalesDomesticos animalDomestico){
        try{
            ServiceLocator.getAnimalesDomesticosDAO().update(animalDomestico);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
