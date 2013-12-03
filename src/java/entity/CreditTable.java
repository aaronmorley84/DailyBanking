/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author Andrew
 */
@Entity
@Table(name = "CREDIT_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditTable.findAll", query = "SELECT c FROM CreditTable c"),
    @NamedQuery(name = "CreditTable.findByUserIdentification", query = "SELECT c FROM CreditTable c WHERE c.userIdentification = :userIdentification"),
    @NamedQuery(name = "CreditTable.findByCreditRating", query = "SELECT c FROM CreditTable c WHERE c.creditRating = :creditRating")})
public class CreditTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_IDENTIFICATION")
    private String userIdentification;
    @Column(name = "CREDIT_RATING")
    private BigInteger creditRating;

    public CreditTable() {
    }

    public CreditTable(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public BigInteger getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(BigInteger creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIdentification != null ? userIdentification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditTable)) {
            return false;
        }
        CreditTable other = (CreditTable) object;
        if ((this.userIdentification == null && other.userIdentification != null) || (this.userIdentification != null && !this.userIdentification.equals(other.userIdentification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.CreditTable[ userIdentification=" + userIdentification + " ]";
    }
    
}
