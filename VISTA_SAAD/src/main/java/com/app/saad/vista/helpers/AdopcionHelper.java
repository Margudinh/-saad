/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.helpers;

import com.app.saad.entidades.Adopcion;
import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import com.app.saad.vista.util.Util;
import java.io.File;
import java.io.IOException;
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
    
    public void obtenerPDF(int folioAdopcion){
        System.out.println("Ejecutando obtener pdf");
        try{
            Util.descargar(folioAdopcion);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
