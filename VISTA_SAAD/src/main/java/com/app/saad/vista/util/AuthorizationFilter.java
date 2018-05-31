/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.vista.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mario
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter{

    public AuthorizationFilter(){
        
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //chain.doFilter(request, response);
       try{
            HttpServletRequest httpreq = (HttpServletRequest) request;
            HttpServletResponse httpres = (HttpServletResponse) response;
            HttpSession ses = httpreq.getSession(false);
            String reqURI = httpreq.getRequestURI();

            if(!reqURI.contains("/login")&& (ses == null)){
                httpres.sendRedirect("/VISTA_SAAD/login");
            }
            else if(reqURI.contains("/login") && (ses != null && ses.getAttribute("user") != null)){
                if(Util.getSessionMap().get("user").toString().equals("admin")){
                    httpres.sendRedirect("/VISTA_SAAD/animalitos");
                }else{
                    httpres.sendRedirect("/VISTA_SAAD/home");
                }
            
            }
            
            else if(reqURI.contains("/login") || 
                    (ses != null && ses.getAttribute("user") != null)||
                    reqURI.contains("/public/") ||
                    reqURI.contains("javax.faces.resource"))
            {    
                chain.doFilter(request, response);
            }
            else if(reqURI.contains("/home") && Util.getSessionMap().get("user").toString().equals("admin")){
                httpres.sendRedirect("/VISTA_SAAD/animalitos");
                //si el usuario no es admin y quiere entrar a paginas de admin
            }else if((!reqURI.contains("/home") && !Util.getSessionMap().get("user").toString().equals("admin") && (ses != null && ses.getAttribute("user") != null))){
                httpres.sendRedirect("/VISTA_SAAD/home");
            }
            
            else{
                httpres.sendRedirect("/VISTA_SAAD/login");
            }
       }catch(Exception e){
           e.printStackTrace();
       }
       
    }

    @Override
    public void destroy() {
        
    }
    
}
