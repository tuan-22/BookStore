/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.VerifyEmail;

/**
 *
 * @author tramy
 */
public class UserVerify {
    private String username;
    private String phone;
    private String email;
    private String password;
    private String code;

    public UserVerify() {
    }

    public UserVerify(String email) {
        this.email = email;
    }

    public UserVerify(String email, String code) {
        this.email = email;
        this.code = code;
    }
    

    public UserVerify( String username, String phone, String email, String password, String code) {

        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public UserVerify(String username, String phone, String email, String password) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "UserVerify{" + "username=" + username + ", phone=" + phone + ", email=" + email + ", password=" + password + ", code=" + code + '}';
    }
    
    
}

