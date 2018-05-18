/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import com.app.saad.negocios.integracion.ServiceFacadeLocator;

/**
 *
 * @author Erik
 */
public class Test {
    public static void main(String[] args) {
        int id = 1;
        ServiceFacadeLocator.getAdopcionFacade().generarPDFById(id);
        
    }
}
