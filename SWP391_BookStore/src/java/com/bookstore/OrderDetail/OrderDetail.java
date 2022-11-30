/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.OrderDetail;

/**
 *
 * @author tramy
 */
public class OrderDetail {
    public int detailID;
    public int orderID;
    public long bookcode;
    public String bName ;
    public String img;
    public int quantity;
    public int price;
    
    private int total;
    private int oDetailQty;
    private int buyPrice;
    private String bookName; 
    private String Note;

    public OrderDetail() {
    }

    public OrderDetail(int detailID, int orderID, long bookcode, String bName, String img, int quantity, int price) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.bookcode = bookcode;
        this.bName = bName;
        this.img = img;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail(int total, int oDetailQty, int buyPrice, String bookName, String Note) {
        this.total = total;
        this.oDetailQty = oDetailQty;
        this.buyPrice = buyPrice;
        this.bookName = bookName;
        this.Note = Note;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
     
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    
    
    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public long getBookcode() {
        return bookcode;
    }

    public void setBookcode(long bookcode) {
        this.bookcode = bookcode;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "total=" + total + ", oDetailQty=" + oDetailQty + ", buyPrice=" + buyPrice + ", bookName=" + bookName + ", Note=" + Note + '}';
    }

    
    
    
    
}
