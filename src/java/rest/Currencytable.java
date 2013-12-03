/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author krismaini
 */
@Entity
@Table(name = "CURRENCYTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currencytable.findAll", query = "SELECT c FROM Currencytable c"),
    @NamedQuery(name = "Currencytable.findByCurrency", query = "SELECT c FROM Currencytable c WHERE c.currency = :currency"),
    @NamedQuery(name = "Currencytable.findByIso", query = "SELECT c FROM Currencytable c WHERE c.iso = :iso"),
    @NamedQuery(name = "Currencytable.findByRate", query = "SELECT c FROM Currencytable c WHERE c.rate = :rate")})
public class Currencytable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CURRENCY")
    private String currency;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ISO")
    private String iso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATE")
    private double rate;

    public Currencytable() {
    }

    public Currencytable(String iso) {
        this.iso = iso;
    }

    public Currencytable(String iso, String currency, double rate) {
        this.iso = iso;
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iso != null ? iso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currencytable)) {
            return false;
        }
        Currencytable other = (Currencytable) object;
        if ((this.iso == null && other.iso != null) || (this.iso != null && !this.iso.equals(other.iso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Currencytable[ iso=" + iso + " ]";
    }
    
}
