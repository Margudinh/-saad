/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.app.saad.entidades.Adopcion;
import com.app.saad.entidades.Adoptantes;
import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.integracion.ServiceLocator;

/**
 *
 * @author Erik
 */
public class Test {

    public static void main(String[] args) {
        
        
        
        for(Adoptantes adoptante: ServiceLocator.getAdoptanteDAO().findAll()){
            System.out.println(adoptante.getPassword());
        }
    }
}
