/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Company;

/**
 *
 * @author Admin
 */
public class Company {
    private int companyID;
    private String companyName;
    private String comAddress;
    private  String phone;
    private String comEmail;
    private int title;

    public Company() {
    }

    public Company(int companyID, String companyName, String comAddress, String phone, String comEmail) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.comAddress = comAddress;
        this.phone = phone;
        this.comEmail = comEmail;
    }

    public Company(int companyID, String companyName, String comAddress, String phone, String comEmail, int title) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.comAddress = comAddress;
        this.phone = phone;
        this.comEmail = comEmail;
        this.title = title;
    }
    
    
    

    
    public Company(int companyID, String companyName) {
        this.companyID = companyID;
        this.companyName = companyName;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Company{" + "companyID=" + companyID + ", companyName=" + companyName + ", comAddress=" + comAddress + ", phone=" + phone + ", comEmail=" + comEmail + ", title=" + title + '}';
    }
    
    
    

    
    
    
}
