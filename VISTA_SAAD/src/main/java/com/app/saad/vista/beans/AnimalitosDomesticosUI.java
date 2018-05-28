package com.app.saad.vista.beans;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.vista.helpers.AnimalitosHelper;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author richy
 */
@ManagedBean(name = "AnimalitosUI")
@ViewScoped

public class AnimalitosDomesticosUI implements Serializable{
    
    private List<AnimalesDomesticos> animales;
    private AnimalesDomesticos registroAnimal;
    private AnimalitosHelper helper;
    private UploadedFile video, imagen;
    
    public AnimalitosDomesticosUI()
    {
    }
    
    @PostConstruct
    public void init(){
        helper = new AnimalitosHelper();
        animales = helper.findAnimalesDomesticosDisponibles();
        registroAnimal = new AnimalesDomesticos();
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

    public UploadedFile getVideo() {
        return video;
    }

    public void setVideo(UploadedFile video) {
        this.video = video;
    }

    public UploadedFile getImagen() {
        return imagen;
    }

    public void setImagen(UploadedFile imagen) {
        this.imagen = imagen;
    }
    
    

    
}
