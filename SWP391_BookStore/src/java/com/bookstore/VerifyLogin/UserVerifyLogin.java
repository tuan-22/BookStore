/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.VerifyLogin;

/**
 *
 * @author tramy
 */
public class UserVerifyLogin {
    private String email;
    private String password;
    private String code;

    public UserVerifyLogin() {
    }

    

    public UserVerifyLogin(String code) {
        this.code = code;
    }

    public UserVerifyLogin(String email, String password, String code) {
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public UserVerifyLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserVerifyLogin{" + "email=" + email + ", password=" + password + ", code=" + code + '}';
    }
    
    
   
    
}
