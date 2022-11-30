/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Author;

/**
 *
 * @author tramy
 */
public class Author {
    private int compid;
    private long bookcode;
    private int auID;
    private String name ;

    public Author() {
    }
    
    public Author(int auID, String name) {
        this.auID = auID;
        this.name = name;
    }

    public Author(int auID) {
        this.auID = auID;
    }

    public Author(int compid, long bookcode, int auID, String name) {
        this.compid = compid;
        this.bookcode = bookcode;
        this.auID = auID;
        this.name = name;
    }

    public int getCompid() {
        return compid;
    }

    public void setCompid(int compid) {
        this.compid = compid;
    }

    public long getBookcode() {
        return bookcode;
    }

    public void setBookcode(long bookcode) {
        this.bookcode = bookcode;
    }

    public int getAuID() {
        return auID;
    }

    public void setAuID(int auID) {
        this.auID = auID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + "compid=" + compid + ", bookcode=" + bookcode + ", auID=" + auID + ", name=" + name + '}';
    }
    
    
    
    
    
}
