/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.negocios.delegate;

import com.app.saad.entidades.Adopcion;
import com.app.saad.integracion.ServiceLocator;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author Erik
 */
public class AdopcionDelegate {
    
    public List<Adopcion> findTodasLasAdopciones(){
        return ServiceLocator.getAdopcionDAO().findAll();
    }
    
    public Adopcion findAdopcionById(int id){
        return ServiceLocator.getAdopcionDAO().find(id);
    }
    
    public boolean borrarAdopcion(Adopcion adopcion){
        try{
            ServiceLocator.getAdopcionDAO().delete(adopcion);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registrarAdopcion(Adopcion adopcion){
        try{
            ServiceLocator.getAdopcionDAO().save(adopcion);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modificarAdopcion(Adopcion adopcion){
        try{
            ServiceLocator.getAdopcionDAO().update(adopcion);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public String generarPDFById(int id){
        Adopcion adopcion = ServiceLocator.getAdopcionDAO().find(id);
        Document doc = new Document();
        File file = new File("reporte.pdf");
        Font font = new Font(Font.FontFamily.COURIER, 12);
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            PdfWriter.getInstance(doc, fos);
            doc.open();
            
            doc.add(new Paragraph("Adoptante: " + adopcion.getIdAdoptante().getNombre(),font));
            doc.add(new Paragraph("Animal Domestico: "+ adopcion.getIdAnimal().getNombre(), font));
            doc.add(new Paragraph("Fecha: " + adopcion.getFecha().toString(), font));
            doc.close();
            System.out.println("pdf creado en: " + file.getAbsolutePath() + "---------");
            
            return file.getAbsolutePath();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
}
