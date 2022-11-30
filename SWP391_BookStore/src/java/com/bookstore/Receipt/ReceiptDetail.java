/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Receipt;

/**
 *
 * @author tramy
 */
public class ReceiptDetail {
    private int rdID;
    private long bookcode;
    private String bookName ;
    private int qty;
    private int price;

    public ReceiptDetail() {
    }

    public ReceiptDetail(int rdID) {
        this.rdID = rdID;
    }
    

    public ReceiptDetail(int rdID, long bookcode, String bookName, int qty, int price) {
        this.rdID = rdID;
        this.bookcode = bookcode;
        this.bookName = bookName;
        this.qty = qty;
        this.price = price;
    }

    public ReceiptDetail(long bookcode, String bookName, int qty, int price) {
        this.bookcode = bookcode;
        this.bookName = bookName;
        this.qty = qty;
        this.price = price;
    }
    

    public int getRdID() {
        return rdID;
    }

    public void setRdID(int rdID) {
        this.rdID = rdID;
    }

    public long getBookcode() {
        return bookcode;
    }

    public void setBookcode(long bookcode) {
        this.bookcode = bookcode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ReceiptDetail{" + "rdID=" + rdID + ", bookcode=" + bookcode + ", bookName=" + bookName + ", qty=" + qty + ", price=" + price + '}';
    }
    
    
}
