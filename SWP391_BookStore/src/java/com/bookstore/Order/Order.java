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
public class Order {

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
    private int oDetailQty;
    private int buyPrice;
    private int oDetailID;
    private long bookCode;
    private String bookName;
    private String statusFeed;
    private Date receivedDate;
    private Date requestDate;
    private String returnReason;
    private Date approveDate;

    public Order() {
    }

    public Order(int orderID, int accountID, Date orderDate, String address, int total, String Note, String status) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.orderDate = orderDate;
        this.address = address;
        this.total = total;
        this.Note = Note;
        this.status = status;
    }

    public Order(int orderID, int accountID, Date orderDate, String address, int total, String Note, String status, String accName, String email, String phone) {
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
    }

    public Order(int oDetailID, long bookCode, int oDetailQty, int buyPrice, int orderID, String statusFeed) {
        this.oDetailID = oDetailID;
        this.bookCode = bookCode;
        this.oDetailQty = oDetailQty;
        this.buyPrice = buyPrice;
        this.orderID = orderID;
        this.statusFeed = statusFeed;
    }

    public Order(int orderID, Date orderDate, String address, String status, Date receivedDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.address = address;
        this.status = status;
        this.receivedDate = receivedDate;
    }
    
    public Order(int orderID, Date orderDate, String address, String status, Date receivedDate, Date requestDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.address = address;
        this.status = status;
        this.receivedDate = receivedDate;
        this.requestDate = requestDate;
    }
    
    
    public Order(int orderID, Date orderDate, String address, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.address = address;
        this.status = status;
    }

    public Order(int total, String Note, int oDetailQty, int buyPrice, String bookName, long bookCode, int orderID, int oDetailID) {
        this.total = total;
        this.Note = Note;
        this.oDetailQty = oDetailQty;
        this.buyPrice = buyPrice;
        this.bookName = bookName;
        this.bookCode = bookCode;
        this.orderID = orderID;
        this.oDetailID = oDetailID;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }
    

    public Order(String status) {
        this.status = status;
    }

    public Order(int oDetailQty, long bookCode) {
        this.oDetailQty = oDetailQty;
        this.bookCode = bookCode;
    }

    public String getStatusFeed() {
        return statusFeed;
    }

    public void setStatusFeed(String statusFeed) {
        this.statusFeed = statusFeed;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getoDetailQty() {
        return oDetailQty;
    }

    public void setoDetailQty(int oDetailQty) {
        this.oDetailQty = oDetailQty;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getoDetailID() {
        return oDetailID;
    }

    public void setoDetailID(int oDetailID) {
        this.oDetailID = oDetailID;
    }

    public long getBookCode() {
        return bookCode;
    }

    public void setBookCode(long bookCode) {
        this.bookCode = bookCode;
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

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", accountID=" + accountID + ", orderDate=" + orderDate + ", address=" + address + ", total=" + total + ", Note=" + Note + ", status=" + status + ", accName=" + accName + ", email=" + email + ", phone=" + phone + ", oDetailQty=" + oDetailQty + ", buyPrice=" + buyPrice + ", oDetailID=" + oDetailID + ", bookCode=" + bookCode + ", bookName=" + bookName + ", statusFeed=" + statusFeed + ", receivedDate=" + receivedDate + ", requestDate=" + requestDate + ", returnReason=" + returnReason + ", approveDate=" + approveDate + '}';
    }
    
    
    

}
