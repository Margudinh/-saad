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
@Table(name = "adoptante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adoptante.findAll", query = "SELECT a FROM Adoptante a")
    , @NamedQuery(name = "Adoptante.findByIdAdoptante", query = "SELECT a FROM Adoptante a WHERE a.idAdoptante = :idAdoptante")
    , @NamedQuery(name = "Adoptante.findByNombre", query = "SELECT a FROM Adoptante a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Adoptante.findByApellidoPaterno", query = "SELECT a FROM Adoptante a WHERE a.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Adoptante.findByApellidoMaterno", query = "SELECT a FROM Adoptante a WHERE a.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Adoptante.findByTelefono", query = "SELECT a FROM Adoptante a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Adoptante.findByCorreo", query = "SELECT a FROM Adoptante a WHERE a.correo = :correo")})
public class Adoptante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adoptante")
    private Integer idAdoptante;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdoptante")
    private List<Adopcion> adopcionList;

    public Adoptante() {
    }

    public Adoptante(Integer idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public Adoptante(Integer idAdoptante, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.idAdoptante = idAdoptante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    public Integer getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(Integer idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
        if (!(object instanceof Adoptante)) {
            return false;
        }
        Adoptante other = (Adoptante) object;
        if ((this.idAdoptante == null && other.idAdoptante != null) || (this.idAdoptante != null && !this.idAdoptante.equals(other.idAdoptante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.saad.entidades.Adoptante[ idAdoptante=" + idAdoptante + " ]";
    }
    
}
