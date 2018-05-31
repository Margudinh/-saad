package com.app.saad.vista.beans;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.vista.helpers.AnimalitosHelper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author richy
 */
@ManagedBean(name = "AnimalitosUI")
@SessionScoped
public class AnimalitosDomesticosUI implements Serializable {

    private List<AnimalesDomesticos> animales;
    private AnimalesDomesticos registroAnimal,selectedAnimal;
    private AnimalitosHelper helper;
    private Part imagen;
    

    public AnimalitosDomesticosUI() {
    }

    @PostConstruct
    public void init() {
        helper = new AnimalitosHelper();
        animales = helper.findAnimalesDomesticosDisponibles();
        registroAnimal = new AnimalesDomesticos();
       
    }

    public void registrarAnimal() {
        System.out.println("porfa dime que registroAnimal no es nulo");
        if (registroAnimal != null) {
            helper.registrarAnimalDomestico(registroAnimal,imagen);
            animales = helper.findAnimalesDomesticosDisponibles();
        }
       
    }
    
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
        } 
            
    }
    
    
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            helper.modificarAnimalDomestico(selectedAnimal);
        }
    }

    public List<AnimalesDomesticos> getAnimales() {
        return animales;
    }

    public void setAnimales(List<AnimalesDomesticos> animales) {
        this.animales = animales;
    }

    public AnimalesDomesticos getRegistroAnimal() {
        return registroAnimal;
    }

    public void setRegistroAnimal(AnimalesDomesticos registroAnimal) {
        this.registroAnimal = registroAnimal;
    }


    public Part getImagen() {
        return imagen;
    }

    public void setImagen(Part imagen) {
        this.imagen = imagen;
    }
    

    public AnimalesDomesticos getSelectedAnimal() {
        return selectedAnimal;
    }

    public void setSelectedAnimal(AnimalesDomesticos selectedAnimal) {
        this.selectedAnimal = selectedAnimal;
    }
    
    

}
