package com.app.saad.vista.beans;

import com.app.saad.entidades.AnimalesDomesticos;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import static org.ocpsoft.rewrite.config.Not.any;

/**
 *
 * @author richy
 */
@ManagedBean(name = "AnamilitosUI")
@ViewScoped

public class AnimalitosDomesticosUI implements Serializable{
    
    private List<AnimalesDomesticos> animales;
    
    AnimalitosDomesticosUI()
    {
    }

    public List<AnimalesDomesticos> getAnimales() {
        return animales;
    }

    public void setAnimales(List<AnimalesDomesticos> animales) {
        this.animales = animales;
    }

    
}
