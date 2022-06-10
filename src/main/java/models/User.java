/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author suyao
 */
public class User {
    private String userName;
    private String password;
    private String accountType;
    
    public User(){
        this.userName = "Default";
        this.password = "Default";
        this.accountType = "Customer";
    }
    
    public User (String userName, String password, String accountType){
        this.userName = userName;
        this.password = password;
        this.accountType = accountType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }
   
    
}
