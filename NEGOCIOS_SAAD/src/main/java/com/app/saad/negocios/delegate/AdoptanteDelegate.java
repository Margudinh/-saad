/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.delegate;

import com.app.saad.entidades.Adoptantes;
import com.app.saad.integracion.ServiceLocator;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AdoptanteDelegate {
    
    public List<Adoptantes> findTodosLosAdoptantes(){
        return ServiceLocator.getAdoptanteDAO().findAll();
    }
    
    public Adoptantes findAdoptanteByTelefono(String telefono){
        return ServiceLocator.getAdoptanteDAO().findByOneParameterUnique(telefono, "telefono");
    }
    
    public Adoptantes findAdoptanteByCorreo(String correo){
        return ServiceLocator.getAdoptanteDAO().findByOneParameterUnique(correo, "correo");    
    }
    
    public boolean login(String correo, String password){
        Adoptantes adoptante = ServiceLocator.getAdoptanteDAO().findByOneParameterUnique(correo, "correo");
        return adoptante.getPassword().equals(password);
    }
    
    public boolean registrarAdoptante(Adoptantes adoptante){
        try {
            ServiceLocator.getAdoptanteDAO().save(adoptante);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modificarAdoptante(Adoptantes adoptante){
        try {
            ServiceLocator.getAdoptanteDAO().update(adoptante);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarAdoptante(Adoptantes adoptante){
        try {
            ServiceLocator.getAdoptanteDAO().delete(adoptante);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
