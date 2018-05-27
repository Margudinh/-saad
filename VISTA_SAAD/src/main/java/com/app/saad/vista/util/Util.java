/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.util;

import com.app.saad.entidades.Adopcion;
import com.app.saad.integracion.ServiceLocator;
import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mario
 */
public class Util {
    
    
    public static void descargar(int folio) throws IOException{
        File f = generarReportePDF(folio);
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        
        ec.responseReset();
        //ec.setResponseContentType(ec.getMimeType(f.getName()));
        ec.setResponseContentType("application/octet-stream");
        ec.setResponseContentLength((int) f.length());
        ec.setResponseHeader("Content-Disposition", "attachment;filename=\"reporte.pdf\"");
        
        OutputStream out = ec.getResponseOutputStream();
        FileInputStream fis = new FileInputStream(f);
        byte[] buffer = new byte[1024];
        int i = 0;
        while((i = fis.read(buffer)) >0){
            out.write(buffer);
            out.flush();
        }
        
        fis.close();
        fc.responseComplete();
        
        
        
        System.out.println("descarga terminada\n mymetipe:  " + ec.getMimeType(f.getName()));
    }
    
    private static File generarReportePDF(int folio){
        String res  = Util.class.getResource(".").getPath();
        File f = new File(res + "/reporte.pdf");
        
        Adopcion adopcion = ServiceFacadeLocator.getAdopcionFacade().findAdopcionById(folio);
        Document doc = new Document();
        Font font = new Font(Font.FontFamily.COURIER, 12);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(f);
            PdfWriter.getInstance(doc, fos);
            doc.open();
            
            doc.add(new Paragraph("Adoptante: " + adopcion.getIdAdoptante().getNombre(),font));
            doc.add(new Paragraph("Animal Domestico: "+ adopcion.getIdAnimal().getNombre(), font));
            doc.add(new Paragraph("Fecha: " + adopcion.getFecha().toString(), font));
            doc.close();
            System.out.println("pdf creado en: " +  f.getAbsolutePath());
            
            return f;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
