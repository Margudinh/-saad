/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.helpers;

import com.app.saad.entidades.Adoptantes;
import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import com.app.saad.vista.util.Util;
import java.io.Serializable;

/**
 *
 * @author Mario
 */
public class SesionHelper implements Serializable{
    
    public boolean login(String correo, String password){
        if(correo.equals("admin") && password.equals("admin")){
            Util.getSessionMap().put("user", "admin");
            return true;
        }else if(ServiceFacadeLocator.getAdoptanteFacade().login(correo, password)){
            Util.getSessionMap().put("user", correo);
            return true;
        }
        return false;
    }
    
    public boolean registrarYLogear(Adoptantes adoptante){
        boolean registro = ServiceFacadeLocator.getAdoptanteFacade().registrarAdoptante(adoptante);
        return registro && login(adoptante.getCorreo(), adoptante.getPassword());
        
    }
    
}
