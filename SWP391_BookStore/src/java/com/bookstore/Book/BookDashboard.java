/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Book;

/**
 *
 * @author tramy
 */
public class BookDashboard {
    private String book;
    private int qty;

    public BookDashboard() {
    }

    public BookDashboard(String book, int qty) {
        this.book = book;
        this.qty = qty;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "BookDashboard{" + "book=" + book + ", qty=" + qty + '}';
    }
    
    
    

    
}
