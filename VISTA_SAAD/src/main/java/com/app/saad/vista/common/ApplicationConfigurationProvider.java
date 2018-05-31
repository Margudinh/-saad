package com.app.saad.vista.common;

import javax.servlet.ServletContext;
import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario
 */
@RewriteConfiguration
public class ApplicationConfigurationProvider extends HttpConfigurationProvider{
    
    public ApplicationConfigurationProvider(){
        
    }
    
    @Override
    public Configuration getConfiguration(ServletContext t) {
       return ConfigurationBuilder.begin()
               .addRule(Join.path("/").to("/index.xhtml"))
               .addRule(Join.path("/adopciones").to("/adopciones.xhtml"))
               .addRule(Join.path("/login").to("/login.xhtml"))
               .addRule(Join.path("/animalitos").to("/animalitos.xhtml"))
               .addRule(Join.path("/registroad").to("/registroad.xhtml"))
               .addRule(Join.path("/adoptantes").to("adoptantes.xhtml"))
               ;
    }

    @Override
    public int priority() {
        return 0;
    }
    
}
