/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Cart;

import com.bookstore.Book.Book;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Cart {

    private Book book;
    private int qty;
    private int buyPrice;

    public Cart() {
    }

    public Cart(Book book, int qty) {
        this.book = book;
        this.qty = qty;
    }

    public Cart(Book book, int qty, int buyPrice) {
        this.book = book;
        this.qty = qty;
        this.buyPrice =buyPrice;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }  

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "Cart{" + "book=" + book + ", qty=" + qty + ", buyPrice=" + buyPrice + '}';
    }   
}
