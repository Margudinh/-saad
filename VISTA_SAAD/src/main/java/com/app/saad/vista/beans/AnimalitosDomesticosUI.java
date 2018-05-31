package com.app.saad.vista.beans;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.vista.helpers.AnimalitosHelper;
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
 * @author richy
 */
@ManagedBean(name = "AnimalitosUI")
@ViewScoped
public class AnimalitosDomesticosUI implements Serializable {

    private List<AnimalesDomesticos> animales;
    private AnimalesDomesticos selectedAnimal;
    private AnimalitosHelper helper;

    

    public AnimalitosDomesticosUI() {
    
    }

    @PostConstruct
    public void init() {
        helper = new AnimalitosHelper();
        animales = helper.findAnimalesDomesticosDisponibles();
        System.out.println("hola me inicie");
       
    }
    
    

    /*public void fileUpload(FileUploadEvent event) {
       imagen = event.getFile();
       System.out.println(imagen.getFileName());
    }*/
    
    
    
    public void eliminarAD(){
        if(selectedAnimal != null){
            helper.eliminarAnimalDomestico(selectedAnimal);
            animales.remove(selectedAnimal);
        }
    }
    
    public void adoptar(AnimalesDomesticos animal){
        
        if(helper.adoptar(animal)){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se adopto a la mascota", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            animales.remove(animal);
        } 
            
    }
    
    
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            int id = Integer.parseInt(event.getRowKey());
            AnimalesDomesticos ad = findById(id);
            if(helper.modificarAnimalDomestico(ad)){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha modificado el dato", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    private AnimalesDomesticos findById(int id){
        for(AnimalesDomesticos ad: animales){
            if(ad.getIdAnimal() == id){
                return ad;
            }
        }
        return null;
    }
    
    public List<AnimalesDomesticos> getAnimales() {
        return animales;
    }

    

    public AnimalesDomesticos getSelectedAnimal() {
        return selectedAnimal;
    }

    public void setSelectedAnimal(AnimalesDomesticos selectedAnimal) {
        this.selectedAnimal = selectedAnimal;
    }

    
}
