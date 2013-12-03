
package model;

import java.io.Serializable;

/**
 *
 * @author Aaron
 */
public class User implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    
    private String userId;
    private String userEmail;
    private String userPw;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    
    

}