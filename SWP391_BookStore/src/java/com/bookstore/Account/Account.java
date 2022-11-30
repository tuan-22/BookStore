/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Account;

/**
 *
 * @author tramy
 */
public class Account {
    private int accID;
    private String username;
    private String phone;
    private String email;
    private String password;
    private int roleID;
    private String roleName;
    private int actionID;
    private String actionName;
    
    private int canceled;

    public Account() {
    }

    public Account(int accID, String username, String phone, String email, String password, int roleID, String roleName, int actionID, String actionName) {
        this.accID = accID;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.roleName = roleName;
        this.actionID = actionID;
        this.actionName = actionName;
    }

    public Account(int accID, String username, String phone, String email, String password, int roleID, int actionID) {
        this.accID = accID;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.actionID = actionID;
    }

    public Account(int accID, String username, String phone, String email, int roleID, String roleName, int actionID, String actionName) {
        this.accID = accID;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.roleID = roleID;
        this.roleName = roleName;
        this.actionID = actionID;
        this.actionName = actionName;
    }

    public Account(int accID, String username, String phone, String email, String password, int roleID, String roleName, int actionID, String actionName, int canceled) {
        this.accID = accID;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.roleName = roleName;
        this.actionID = actionID;
        this.actionName = actionName;
        this.canceled = canceled;
    }
    
    

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
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

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getActionID() {
        return actionID;
    }

    public void setActionID(int actionID) {
        this.actionID = actionID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public int getCanceled() {
        return canceled;
    }

    public void setCanceled(int canceled) {
        this.canceled = canceled;
    }
    

    @Override
    public String toString() {
        return "Account{" + "accID=" + accID + ", username=" + username + ", phone=" + phone + ", email=" + email + ", password=" + password + ", roleID=" + roleID + ", roleName=" + roleName + ", actionID=" + actionID + ", actionName=" + actionName + '}';
    }
    
    
    
    
    
}
