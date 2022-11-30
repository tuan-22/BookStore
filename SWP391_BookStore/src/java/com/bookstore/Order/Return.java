/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Order;

import java.sql.Date;

/**
 *
 * @author tramy
 */
public class Return {
    private int orderID;
    private int accountID;
    private Date orderDate;
    private String address;
    private int total;
    private String Note;
    private String status;
    private String accName;
    private String email;
    private String phone;
    private Date receivedDate;
    private Date requestDate;
    private String returnReason;
    private Date approveDate;
    private Long checkDate;

    public Return() {
    }

    public Return(int orderID, int accountID, Date orderDate, String address, int total, String Note, String status, String accName, String email, String phone, Date receivedDate, Date requestDate, String returnReason, Date approveDate) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.orderDate = orderDate;
        this.address = address;
        this.total = total;
        this.Note = Note;
        this.status = status;
        this.accName = accName;
        this.email = email;
        this.phone = phone;
        this.receivedDate = receivedDate;
        this.requestDate = requestDate;
        this.returnReason = returnReason;
        this.approveDate = approveDate;
    }

    

    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Long getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Long checkDate) {
        this.checkDate = checkDate;
    }

    

    @Override
    public String toString() {
        return "Return{" + "orderID=" + orderID + ", accountID=" + accountID + ", orderDate=" + orderDate + ", address=" + address + ", total=" + total + ", Note=" + Note + ", status=" + status + ", accName=" + accName + ", email=" + email + ", phone=" + phone + ", receivedDate=" + receivedDate + ", requestDate=" + requestDate + ", returnReason=" + returnReason + ", approveDate=" + approveDate + ", checkDate=" + checkDate + '}';
    }

    
    
}
