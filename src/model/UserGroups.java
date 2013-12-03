/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Aaron
 */
public class UserGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String userEmail;
    private String userRoll;

    public UserGroups() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRole() {
        return userRoll;
    }

    public void setRole(String userRoll) {
        this.userRoll = userRoll;
    }
    
    
}
