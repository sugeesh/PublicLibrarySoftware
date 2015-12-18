/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class User {
    private String uId;
    private String userName;
    private String password;
    private int privilege;

    public User() {
    }

    public User(String uId, String userName, String password, int privilege) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.privilege = privilege;
    }
    
    public User(String uId, String userName, int privilege) {
        this.uId = uId;
        this.userName = userName;
        this.privilege = privilege;
    }
    
     public User(String uId, String userName, String password ) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
    }
    
     public User(String uId , String password) {
        this.uId = uId;
        this.password = password;
    }

    public User(int privilege ,String userName, String password ) {
        this.password = password;
        this.userName = userName;
        this.privilege = privilege;
    }
    /**
     * @return the uId
     */
    public String getuId() {
        return uId;
    }

    /**
     * @param uId the uId to set
     */
    public void setuId(String uId) {
        this.uId = uId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the privilege
     */
    public int getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege the privilege to set
     */
    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

   
    
}
