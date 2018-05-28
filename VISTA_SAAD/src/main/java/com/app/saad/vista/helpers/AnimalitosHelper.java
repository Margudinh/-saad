/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.helpers;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AnimalitosHelper implements Serializable{
    
    public List<AnimalesDomesticos> findAnimalesDomesticosDisponibles(){
        return ServiceFacadeLocator.getAnimalesDomesticosFacade().findAnimalesDomesticosDisponibles();
    }
    
}
