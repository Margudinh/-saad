/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.delegate;

import com.app.saad.entidades.Adoptante;
import com.app.saad.integracion.ServiceLocator;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AdoptanteDelegate {
    
    public List<Adoptante> findTodosLosAdoptantes(){
        return ServiceLocator.getAdoptanteDAO().findAll();
    }
    
    public Adoptante findAdoptanteByTelefono(String telefono){
        return ServiceLocator.getAdoptanteDAO().findByOneParameterUnique(telefono, "telefono");
    }
    
    public Adoptante findAdoptanteByCorreo(String correo){
        return ServiceLocator.getAdoptanteDAO().findByOneParameterUnique(correo, "correo");    
    }
    
    public boolean registrarAdoptante(Adoptante adoptante){
        try {
            ServiceLocator.getAdoptanteDAO().save(adoptante);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modificarAdoptante(Adoptante adoptante){
        try {
            ServiceLocator.getAdoptanteDAO().update(adoptante);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarAdoptante(Adoptante adoptante){
        try {
            ServiceLocator.getAdoptanteDAO().delete(adoptante);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
