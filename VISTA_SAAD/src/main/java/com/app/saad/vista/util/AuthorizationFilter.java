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

            //si hay alguien logeado
            if(reqURI.contains("/login") && (ses != null && ses.getAttribute("user") != null)){
                //TODO: verificar que tipo de ususario es para redirigirlo respectivamente
                httpres.sendRedirect("/VISTA_SAAD/");
            }
            else if(reqURI.contains("/login") || 
                    (ses != null && ses.getAttribute("user") != null)||
                    reqURI.contains("/public/") ||
                    reqURI.contains("javax.faces.resource"))
            {    
                chain.doFilter(request, response);
            }else{
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
