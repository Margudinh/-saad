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
import javax.servlet.http.Part;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author richy
 */
@ManagedBean(name = "AnimalitosUI")
@ViewScoped
public class AnimalitosDomesticosUI implements Serializable {

    private List<AnimalesDomesticos> animales;
    private AnimalesDomesticos registroAnimal,selectedAnimal;
    private AnimalitosHelper helper;
    private Part imagen;
    private boolean visibleRegistro;

    public AnimalitosDomesticosUI() {
    }

    @PostConstruct
    public void init() {
        helper = new AnimalitosHelper();
        animales = helper.findAnimalesDomesticosDisponibles();
        registroAnimal = new AnimalesDomesticos();
        visibleRegistro = false;

    }

    public void registrarAnimal() {
        if (registroAnimal != null) {
            helper.registrarAnimalDomestico(registroAnimal,imagen);
            animales = helper.findAnimalesDomesticosDisponibles();
        }
        visibleRegistro = !visibleRegistro;
    }
    
    public void eliminarAD(){
        if(selectedAnimal != null){
            helper.eliminarAnimalDomestico(selectedAnimal);
            animales.remove(selectedAnimal);
        }
    }
    
    public void toggleRegistro(){
        visibleRegistro = !visibleRegistro;
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
    
    public void setVisibleRegistro(boolean visibleRegistro){
        this.visibleRegistro = visibleRegistro;
    }
    
    public boolean getVisibleRegistro(){
        return visibleRegistro;
    }

    public AnimalesDomesticos getSelectedAnimal() {
        return selectedAnimal;
    }

    public void setSelectedAnimal(AnimalesDomesticos selectedAnimal) {
        this.selectedAnimal = selectedAnimal;
    }
    
    

}
