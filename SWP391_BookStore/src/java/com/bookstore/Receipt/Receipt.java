/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Receipt;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Receipt {
    private int receiptID;
    private int accountID;
    private String accName;
    private Date orderDate;
    private int totalImportPrice;
    private int companyID;
    private String companyName;

    public Receipt() {
    }

    public Receipt(int receiptID, int accountID, String accName, Date orderDate, int totalImportPrice, int companyID, String companyName) {
        this.receiptID = receiptID;
        this.accountID = accountID;
        this.accName = accName;
        this.orderDate = orderDate;
        this.totalImportPrice = totalImportPrice;
        this.companyID = companyID;
        this.companyName = companyName;
    }
    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalImportPrice() {
        return totalImportPrice;
    }

    public void setTotalImportPrice(int totalImportPrice) {
        this.totalImportPrice = totalImportPrice;
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

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    @Override
    public String toString() {
        return "Receipt{" + "receiptID=" + receiptID + ", accountID=" + accountID + ", accName=" + accName + ", orderDate=" + orderDate + ", totalImportPrice=" + totalImportPrice + ", companyID=" + companyID + ", companyName=" + companyName + '}';
    }

    
    

    
}
