/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.beans;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.vista.helpers.AnimalitosHelper;
import com.app.saad.vista.util.Util;
import java.io.Serializable;
import java.nio.file.Files;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author Erik
 */

@ManagedBean(name = "registroAD")
@ViewScoped
public class RegistroADUI implements Serializable{
    
    private UploadedFile imagen;
    private AnimalesDomesticos registro;
    private AnimalitosHelper helper;
    
    public RegistroADUI(){
        
    }
    
    @PostConstruct
    public void init(){
        System.out.println("se inicio el registroADUI");
        registro = new AnimalesDomesticos();
        helper = new AnimalitosHelper();
    }
    
    public void upload(){
        if(imagen== null){
            if(helper.registrarAnimalDomestico(registro, imagen)){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro exitoso!",null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }else{
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "WTF?",null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }else if(imagen.getContentType().contains("image")){
            if(helper.registrarAnimalDomestico(registro, imagen)){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso!",null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }else{
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "WTF?",null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solo se aceptan archivos de imagen",null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        }
       
         
    }

    public UploadedFile getImagen() {
        return imagen;
    }

    public void setImagen(UploadedFile imagen) {
        this.imagen = imagen;
    }

    public AnimalesDomesticos getRegistro() {
        return registro;
    }

    public void setRegistro(AnimalesDomesticos registro) {
        this.registro = registro;
    }

}
