
package com.github.jordane_quincy.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.10
 * Tue May 16 08:25:44 CEST 2017
 * Generated source version: 3.1.10
 */

@XmlRootElement(name = "remboursement", namespace = "http://com.github.jordane_quincy")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remboursement", namespace = "http://com.github.jordane_quincy", propOrder = {"idCompteACrediter", "montant"})

public class Remboursement {

    @XmlElement(name = "idCompteACrediter")
    private java.lang.String idCompteACrediter;
    @XmlElement(name = "montant")
    private java.lang.String montant;

    public java.lang.String getIdCompteACrediter() {
        return this.idCompteACrediter;
    }

    public void setIdCompteACrediter(java.lang.String newIdCompteACrediter)  {
        this.idCompteACrediter = newIdCompteACrediter;
    }

    public java.lang.String getMontant() {
        return this.montant;
    }

    public void setMontant(java.lang.String newMontant)  {
        this.montant = newMontant;
    }

}

