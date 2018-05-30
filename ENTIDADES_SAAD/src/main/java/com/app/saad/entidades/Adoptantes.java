/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Erik
 */
@Entity
@Table(name = "adoptantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adoptantes.findAll", query = "SELECT a FROM Adoptantes a")
    , @NamedQuery(name = "Adoptantes.findByIdAdoptante", query = "SELECT a FROM Adoptantes a WHERE a.idAdoptante = :idAdoptante")
    , @NamedQuery(name = "Adoptantes.findByNombreCompleto", query = "SELECT a FROM Adoptantes a WHERE a.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Adoptantes.findByTelefono", query = "SELECT a FROM Adoptantes a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Adoptantes.findByCorreo", query = "SELECT a FROM Adoptantes a WHERE a.correo = :correo")})
public class Adoptantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adoptante")
    private Integer idAdoptante;
    @Basic(optional = false)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdoptante")
    private List<Adopcion> adopcionList;

    public Adoptantes() {
    }

    public Adoptantes(Integer idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public Adoptantes(Integer idAdoptante, String nombreCompleto, String telefono, String correo, String password) {
        this.idAdoptante = idAdoptante;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
    }

    public Integer getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(Integer idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    @XmlTransient
    public List<Adopcion> getAdopcionList() {
        return adopcionList;
    }

    public void setAdopcionList(List<Adopcion> adopcionList) {
        this.adopcionList = adopcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdoptante != null ? idAdoptante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adoptantes)) {
            return false;
        }
        Adoptantes other = (Adoptantes) object;
        if ((this.idAdoptante == null && other.idAdoptante != null) || (this.idAdoptante != null && !this.idAdoptante.equals(other.idAdoptante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.saad.entidades.Adoptantes[ idAdoptante=" + idAdoptante + " ]";
    }
    
}
