/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.helpers;

import com.app.saad.entidades.Adopcion;
import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mario
 * 
 * */
public class AdopcionHelper implements Serializable{
    
    public List<Adopcion> findTodasLasAdopciones(){
       return ServiceFacadeLocator.getAdopcionFacade().findTodasLasAdopciones();
    }
    
}
