/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.saad.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erik
 */
@Entity
@Table(name = "adopcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adopcion.findAll", query = "SELECT a FROM Adopcion a")
    , @NamedQuery(name = "Adopcion.findByFolio", query = "SELECT a FROM Adopcion a WHERE a.folio = :folio")
    , @NamedQuery(name = "Adopcion.findByFecha", query = "SELECT a FROM Adopcion a WHERE a.fecha = :fecha")})
public class Adopcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "folio")
    private Integer folio;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_adoptante", referencedColumnName = "id_adoptante")
    @ManyToOne(optional = false)
    private Adoptantes idAdoptante;
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal")
    @ManyToOne(optional = false)
    private AnimalesDomesticos idAnimal;

    public Adopcion() {
    }

    public Adopcion(Integer folio) {
        this.folio = folio;
    }

    public Adopcion(Integer folio, Date fecha) {
        this.folio = folio;
        this.fecha = fecha;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Adoptantes getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(Adoptantes idAdoptante) {
        this.idAdoptante = idAdoptante;
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
        hash += (folio != null ? folio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adopcion)) {
            return false;
        }
        Adopcion other = (Adopcion) object;
        if ((this.folio == null && other.folio != null) || (this.folio != null && !this.folio.equals(other.folio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.saad.entidades.Adopcion[ folio=" + folio + " ]";
    }
    
}
