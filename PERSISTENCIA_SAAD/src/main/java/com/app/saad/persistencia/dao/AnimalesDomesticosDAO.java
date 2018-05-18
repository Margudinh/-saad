/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.persistencia.dao;

import com.app.saad.entidades.AnimalesDomesticos;
import com.app.saad.persistencia.AbstractDAO;
import java.util.List;

/**
 *
 * @author Mario
 */
public class AnimalesDomesticosDAO extends AbstractDAO<Integer,AnimalesDomesticos>{
    /**
     * @autor Mario
     * @return Lista de Animales Domesticos Disponibles (No estan en adopcion)
     */
    public List<AnimalesDomesticos> findAnimalesDomesticosDisponibles(){
        String query = "SELECT * FROM animales_domesticos a WHERE a.id_animal NOT IN ("
                        + "SELECT b.id_animal FROM adopcion b)";
        return this.executeQuery(query);
    }
    
    
}
