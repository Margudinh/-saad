/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.beans;

import com.app.saad.entidades.Adopcion;
import com.app.saad.vista.helpers.AdopcionHelper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mario
 */
@ManagedBean(name = "adopcionUI")
@ViewScoped
public class AdopcionUI implements Serializable{
    
    private List<Adopcion> adopciones;
    private Adopcion selectedAdopcion;
    private AdopcionHelper helper;
    
    public AdopcionUI(){
        
    }
    
    @PostConstruct
    public void init(){
        helper = new AdopcionHelper();
        adopciones = helper.findTodasLasAdopciones();
    }

    public List<Adopcion> getAdopciones() {
        return adopciones;
    }

    public void setAdopciones(List<Adopcion> adopciones) {
        this.adopciones = adopciones;
    }

    public Adopcion getSelectedAdopcion() {
        return selectedAdopcion;
    }

    public void setSelectedAdopcion(Adopcion selectedAdopcion) {
        this.selectedAdopcion = selectedAdopcion;
    }
    
    
    
}
