/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erik
 */
@Entity
@Table(name = "detalles_ad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallesAd.findAll", query = "SELECT d FROM DetallesAd d")
    , @NamedQuery(name = "DetallesAd.findByIdDetallesAd", query = "SELECT d FROM DetallesAd d WHERE d.idDetallesAd = :idDetallesAd")
    , @NamedQuery(name = "DetallesAd.findByColor", query = "SELECT d FROM DetallesAd d WHERE d.color = :color")
    , @NamedQuery(name = "DetallesAd.findByTipoDePelo", query = "SELECT d FROM DetallesAd d WHERE d.tipoDePelo = :tipoDePelo")
    , @NamedQuery(name = "DetallesAd.findByUrlImagen", query = "SELECT d FROM DetallesAd d WHERE d.urlImagen = :urlImagen")
    , @NamedQuery(name = "DetallesAd.findByUrlVideo", query = "SELECT d FROM DetallesAd d WHERE d.urlVideo = :urlVideo")
    , @NamedQuery(name = "DetallesAd.findByDescripcion", query = "SELECT d FROM DetallesAd d WHERE d.descripcion = :descripcion")})
public class DetallesAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalles_ad")
    private Integer idDetallesAd;
    @Column(name = "color")
    private String color;
    @Column(name = "tipo_de_pelo")
    private String tipoDePelo;
    @Column(name = "url_imagen")
    private String urlImagen;
    @Column(name = "url_video")
    private String urlVideo;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal")
    @ManyToOne(optional = false)
    private AnimalesDomesticos idAnimal;

    public DetallesAd() {
    }

    public DetallesAd(Integer idDetallesAd) {
        this.idDetallesAd = idDetallesAd;
    }

    public Integer getIdDetallesAd() {
        return idDetallesAd;
    }

    public void setIdDetallesAd(Integer idDetallesAd) {
        this.idDetallesAd = idDetallesAd;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoDePelo() {
        return tipoDePelo;
    }

    public void setTipoDePelo(String tipoDePelo) {
        this.tipoDePelo = tipoDePelo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public AnimalesDomesticos getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalesDomesticos idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallesAd != null ? idDetallesAd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesAd)) {
            return false;
        }
        DetallesAd other = (DetallesAd) object;
        if ((this.idDetallesAd == null && other.idDetallesAd != null) || (this.idDetallesAd != null && !this.idDetallesAd.equals(other.idDetallesAd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.saad.entidades.DetallesAd[ idDetallesAd=" + idDetallesAd + " ]";
    }
    
}
