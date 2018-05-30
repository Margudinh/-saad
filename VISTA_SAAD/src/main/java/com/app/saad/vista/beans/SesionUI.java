/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.beans;

import com.app.saad.entidades.Adoptantes;
import com.app.saad.vista.helpers.SesionHelper;
import com.app.saad.vista.util.Util;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mario
 */
@ManagedBean(name = "sesionUI")
@SessionScoped
public class SesionUI implements Serializable{
    private Adoptantes adoptanteLogIn;
    private Adoptantes adoptanteRegistro;
    private SesionHelper helper;
    private String usuarioEnSesion;
    
    public SesionUI(){
        
    }
    
    @PostConstruct
    public void init(){
        adoptanteRegistro = new Adoptantes();
        adoptanteLogIn = new Adoptantes();
        helper = new SesionHelper();
        Object o = Util.getSessionMap().get("user");
        if(o != null){
            usuarioEnSesion = o.toString();
        }else{
            usuarioEnSesion = "";
        }
        
    }
    
    public void logear(){
        if(helper.login(adoptanteLogIn.getCorreo(), adoptanteLogIn.getPassword())){
            usuarioEnSesion = Util.getSessionMap().get("user").toString();
            System.out.println("Usuario conectado: " + usuarioEnSesion);
            
            try{
                Util.redireccionar("/");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("correo contraseña incorrectos");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "correo/contraseña incorrectos",null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void registrarYLogear(){
        
        if(helper.registrarYLogear(adoptanteRegistro)){
            usuarioEnSesion = Util.getSessionMap().get("user").toString();
            try{
                Util.redireccionar("/");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar",null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    

    public Adoptantes getAdoptanteLogIn() {
        return adoptanteLogIn;
    }

    public void setAdoptanteLogIn(Adoptantes adoptanteLogIn) {
        this.adoptanteLogIn = adoptanteLogIn;
    }

    public Adoptantes getAdoptanteRegistro() {
        return adoptanteRegistro;
    }

    public void setAdoptanteRegistro(Adoptantes adoptanteRegistro) {
        this.adoptanteRegistro = adoptanteRegistro;
    }

    public String getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

    public void setUsuarioEnSesion(String usuarioEnSesion) {
        this.usuarioEnSesion = usuarioEnSesion;
    }
        
    
}
