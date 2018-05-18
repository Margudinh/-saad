/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.integracion;

import com.app.saad.negocios.facade.AdopcionFacade;
import com.app.saad.negocios.facade.AdoptanteFacade;
import com.app.saad.negocios.facade.AnimalesDomesticosFacade;

/**
 *
 * @author Erik
 */
public class ServiceFacadeLocator {
    private static AdopcionFacade adopcionFacade;
    private static AdoptanteFacade adoptanteFacade;
    private static AnimalesDomesticosFacade animalesDomesticosFacade;
        
    public static AdopcionFacade getAdopcionFacade(){
        if(adopcionFacade == null){
            adopcionFacade = new AdopcionFacade();
            return adopcionFacade;
        }else{
            return adopcionFacade;
        }
    }
    
    public static AdoptanteFacade getAdoptanteFacade(){
        if(adoptanteFacade == null){
            adoptanteFacade = new AdoptanteFacade();
            return adoptanteFacade;
        }else{
            return adoptanteFacade;
        }
    }
    
    public static AnimalesDomesticosFacade getAnimalesDomesticosFacade(){
        if(animalesDomesticosFacade == null){
            animalesDomesticosFacade = new AnimalesDomesticosFacade();
            return animalesDomesticosFacade;
        }else{
            return animalesDomesticosFacade;
        }
    }
}
