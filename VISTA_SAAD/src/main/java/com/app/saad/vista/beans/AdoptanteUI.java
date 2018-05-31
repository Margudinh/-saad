/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.beans;

import com.app.saad.entidades.Adoptantes;
import com.app.saad.vista.helpers.AdoptanteHelper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Erik
 */
@ManagedBean(name = "adoptanteUI")
@ViewScoped
public class AdoptanteUI implements Serializable{
    
    private List<Adoptantes> listaDeAdoptantes;
    private Adoptantes selectedAdoptantes;
    private AdoptanteHelper helper;
    
    public AdoptanteUI(){
        
    }
    
    @PostConstruct
    public void init(){
        helper = new AdoptanteHelper();
        listaDeAdoptantes = helper.buscarTodosLosAdoptantes();
    }
    
    public void onCellEdit(CellEditEvent event) {
        
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            int id = Integer.parseInt(event.getRowKey());
            Adoptantes adoptante = findById(id);
            FacesMessage msg;
            if(helper.modificarAdoptante(adoptante)){
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Se ha modificado el dato", null);
            }else{
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ese dato es unico y ya existe uno con ese valor", null);
            }
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    private Adoptantes findById(int id){
        for(Adoptantes a: listaDeAdoptantes){
            if(id == a.getIdAdoptante()){
                return a;
            }
        }
        return null;
    }
    
    public void eliminarAdoptante(){
        if(helper.eliminarAdoptante(selectedAdoptantes)){
            listaDeAdoptantes.remove(selectedAdoptantes);
        }else{
            
        }
    }
    
    public List<Adoptantes> getListaDeAdoptantes() {
        return listaDeAdoptantes;
    }

    public void setListaDeAdoptantes(List<Adoptantes> listaDeAdoptantes) {
        this.listaDeAdoptantes = listaDeAdoptantes;
    }

    public Adoptantes getSelectedAdoptantes() {
        return selectedAdoptantes;
    }

    public void setSelectedAdoptantes(Adoptantes selectedAdoptantes) {
        this.selectedAdoptantes = selectedAdoptantes;
    }
    
    
    
}
