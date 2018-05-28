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
@Table(name = "animales_domesticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnimalesDomesticos.findAll", query = "SELECT a FROM AnimalesDomesticos a")
    , @NamedQuery(name = "AnimalesDomesticos.findByIdAnimal", query = "SELECT a FROM AnimalesDomesticos a WHERE a.idAnimal = :idAnimal")
    , @NamedQuery(name = "AnimalesDomesticos.findByNombre", query = "SELECT a FROM AnimalesDomesticos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AnimalesDomesticos.findByEspecie", query = "SELECT a FROM AnimalesDomesticos a WHERE a.especie = :especie")
    , @NamedQuery(name = "AnimalesDomesticos.findBySexo", query = "SELECT a FROM AnimalesDomesticos a WHERE a.sexo = :sexo")
    , @NamedQuery(name = "AnimalesDomesticos.findByUrlImagen", query = "SELECT a FROM AnimalesDomesticos a WHERE a.urlImagen = :urlImagen")
    , @NamedQuery(name = "AnimalesDomesticos.findByUrlVideo", query = "SELECT a FROM AnimalesDomesticos a WHERE a.urlVideo = :urlVideo")
    , @NamedQuery(name = "AnimalesDomesticos.findByColor", query = "SELECT a FROM AnimalesDomesticos a WHERE a.color = :color")})
public class AnimalesDomesticos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_animal")
    private Integer idAnimal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "especie")
    private String especie;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "url_imagen")
    private String urlImagen;
    @Column(name = "url_video")
    private String urlVideo;
    @Column(name = "color")
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnimal")
    private List<Adopcion> adopcionList;

    public AnimalesDomesticos() {
    }

    public AnimalesDomesticos(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public AnimalesDomesticos(Integer idAnimal, String nombre, String especie, String sexo) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.especie = especie;
        this.sexo = sexo;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimalesDomesticos)) {
            return false;
        }
        AnimalesDomesticos other = (AnimalesDomesticos) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.saad.entidades.AnimalesDomesticos[ idAnimal=" + idAnimal + " ]";
    }
    
}
