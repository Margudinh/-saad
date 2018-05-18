/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.integracion;

import com.app.saad.persistencia.dao.AdopcionDAO;
import com.app.saad.persistencia.dao.AdoptanteDAO;
import com.app.saad.persistencia.dao.AnimalesDomesticosDAO;

/**
 *
 * @author Mario
 */
public class ServiceLocator {
    private static AdopcionDAO adopcionDAO;
    private static AdoptanteDAO adoptanteDAO;
    private static AnimalesDomesticosDAO animalesDomesticosDAO;
    
    public static AdopcionDAO getAdopcionDAO(){
        if(adopcionDAO == null){
            adopcionDAO = new AdopcionDAO();
            return adopcionDAO;
        }else{
            return adopcionDAO;
        }
    }
    
    public static AnimalesDomesticosDAO getAnimalesDomesticosDAO(){
        if(animalesDomesticosDAO == null){
            animalesDomesticosDAO = new AnimalesDomesticosDAO();
            return animalesDomesticosDAO;
        }else{
            return animalesDomesticosDAO;
        }
    }
    
    public static AdoptanteDAO getAdoptanteDAO(){
        if(adoptanteDAO == null){
            adoptanteDAO = new AdoptanteDAO();
            return adoptanteDAO;
        }else{
            return adoptanteDAO;
        }
    }
    
}
