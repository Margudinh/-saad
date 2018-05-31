/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.helpers;

import com.app.saad.entidades.Adopcion;
import com.app.saad.entidades.Adoptantes;
import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import com.app.saad.vista.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Mario
 */
public class AnimalitosHelper implements Serializable{
    
    public List<AnimalesDomesticos> findAnimalesDomesticosDisponibles(){
        return ServiceFacadeLocator.getAnimalesDomesticosFacade().findAnimalesDomesticosDisponibles();
    }
    
    
    public boolean registrarAnimalDomestico(AnimalesDomesticos animalito,Part imagen){
        if(imagen != null){
            String name = new Date().getTime()+"-"+imagen.getSubmittedFileName();
            name = name.replace(" ", "_"); //remover espacios ya que no se aceptan en las url
            String directory = Util.getResourcePath() + "/img/";
            File f = new File(directory + name);
            
            System.out.println("Path" + f.getAbsolutePath());
            try{
                Files.copy(imagen.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
                animalito.setUrlImagen(name);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        System.out.println("animalito domestico UwU -------");
        System.out.println("urlImagen: "+ animalito.getUrlImagen());
        System.out.println("urlVideo " + animalito.getUrlVideo());
        return ServiceFacadeLocator.getAnimalesDomesticosFacade().registrarAnimalDomestico(animalito);
    }
    
    public boolean registrarAnimalDomestico(AnimalesDomesticos animalito, UploadedFile imagen){
        if(imagen != null){
            String fileName = new Date().getTime()+"-"+imagen.getFileName();
            fileName = fileName.replace(" ", "_");
            String directory = Util.getResourcePath() +"/img/";
            File f = new File(directory + fileName);
            try{
                Files.copy(imagen.getInputstream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
                animalito.setUrlImagen(fileName);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("animalito domestico UwU -------");
        System.out.println("urlImagen: "+ animalito.getUrlImagen());
        
       
        return ServiceFacadeLocator.getAnimalesDomesticosFacade().registrarAnimalDomestico(animalito);
    }
    
    public boolean eliminarAnimalDomestico(AnimalesDomesticos animalito){
        String directory = Util.getResourcePath() + "/img/";
        File f = new File(directory + animalito.getUrlImagen());
        if(ServiceFacadeLocator.getAnimalesDomesticosFacade().eliminarAnimalDomestico(animalito)){
            f.delete();
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean modificarAnimalDomestico(AnimalesDomesticos animalito){
        return ServiceFacadeLocator.getAnimalesDomesticosFacade().modificarAnimalDomestico(animalito);
    }
    
    public boolean adoptar(AnimalesDomesticos animalito){
        Adopcion adopcion = new Adopcion();
        String correo = Util.getSessionMap().get("user").toString();
        Adoptantes adoptante = ServiceFacadeLocator.getAdoptanteFacade().findAdoptanteByCorreo(correo);
        adopcion.setFecha(new Date());
        adopcion.setIdAdoptante(adoptante);
        adopcion.setIdAnimal(animalito);
        
        return ServiceFacadeLocator.getAdopcionFacade().registrarAdopcion(adopcion);
    }
}
