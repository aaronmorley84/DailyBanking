/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.Serializable;

/**
 *
 * @author Andrew
 */
public class CreditModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String userIdentification;
    private String creditRating;

    public CreditModel() {
    }

    public CreditModel(String userIdentification, String creditRating) {
        this.userIdentification = userIdentification;
        this.creditRating = creditRating;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    
   

   
    
}
