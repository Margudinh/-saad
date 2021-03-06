/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.util;

import com.app.saad.entidades.Adopcion;

import com.app.saad.negocios.integracion.ServiceFacadeLocator;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgCCITT;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mario
 */
public class Util {
    
    public static Map<String, Object> getSessionMap(){
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().getSessionMap();
    }
    
    public static void redireccionar(String path)throws IOException{
        HttpServletRequest reqt = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        FacesContext.getCurrentInstance().getExternalContext().redirect(reqt.getContextPath() + path);
    }
    
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
            String imagen = adopcion.getIdAnimal().getUrlImagen();
            FileOutputStream fos = new FileOutputStream(f);
            PdfWriter.getInstance(doc, fos);
            doc.open();
            
            doc.add(new Paragraph("Fecha de adopcion: " + adopcion.getFecha().toString(), font));
            doc.add(new Paragraph("Adoptante: " + adopcion.getIdAdoptante().getNombreCompleto(),font));
            doc.add(new Paragraph("Telefono: " + adopcion.getIdAdoptante().getTelefono(),font));
            doc.add(new Paragraph("Correo: " + adopcion.getIdAdoptante().getCorreo(),font));
            doc.add(new Paragraph("Animal Domestico: "+ adopcion.getIdAnimal().getNombre(), font));
            
            try{
                String directory = Util.getResourcePath()+ "/img/";
                File imageFile= new File(directory + imagen);
                BufferedImage image = ImageIO.read(imageFile);
                byte[] data = new byte[(int) imageFile.length()];
                FileInputStream fis = new FileInputStream(imageFile);
                
                fis.read(data);
                System.out.println(directory+imagen);
                Image imagePDF = ImgCCITT.getInstance(directory + imagen);
                
                doc.add(imagePDF);
                
            }catch(IOException | NullPointerException e){
                e.printStackTrace();
            }
            
            doc.close();
            System.out.println("pdf creado en: " +  f.getAbsolutePath());
            
            return f;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getResourcePath(){
        String path = Util.class.getClassLoader().getResource(".").getPath();
        File f = new File(path);
        do{
            String parent = f.getParent();
            f = new File(parent);
        }while(!"VISTA_SAAD".equals(f.getName()));
        System.out.println(f.getAbsolutePath());
        
        File res = new File(f.getAbsolutePath() + "/src/main/webapp/resources/");
        
        return res.getAbsolutePath();
    }
}
