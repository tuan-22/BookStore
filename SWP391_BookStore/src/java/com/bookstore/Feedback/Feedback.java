/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Feedback;

/**
 *
 * @author tramy
 */
public class Feedback {
    private int feedID;
    private long bookcode;
    private int accID;
    private String accName;
    private String detail;
    private int starID;
    private int oDetailID;

    public Feedback() {
    }

    public Feedback(int feedID, long bookcode, int accID, String accName, String detail, int starID) {
        this.feedID = feedID;
        this.bookcode = bookcode;
        this.accID = accID;
        this.accName = accName;
        this.detail = detail;
        this.starID = starID;
    }

    public Feedback(int feedID, long bookcode, int accID, String detail, int starID) {
        this.feedID = feedID;
        this.bookcode = bookcode;
        this.accID = accID;
        this.detail = detail;
        this.starID = starID;
    }

    public Feedback(int feedID, long bookcode, int accID, String detail, int starID, int oDetailID) {
        this.feedID = feedID;
        this.bookcode = bookcode;
        this.accID = accID;
        this.detail = detail;
        this.starID = starID;
        this.oDetailID = oDetailID;
    }
    
    public Feedback(String accName, String detail, int starID) {
        this.accName = accName;
        this.detail = detail;
        this.starID = starID;
    }

    public int getoDetailID() {
        return oDetailID;
    }

    public void setoDetailID(int oDetailID) {
        this.oDetailID = oDetailID;
    }
    

    public int getFeedID() {
        return feedID;
    }

    public void setFeedID(int feedID) {
        this.feedID = feedID;
    }

    public long getBookcode() {
        return bookcode;
    }

    public void setBookcode(long bookcode) {
        this.bookcode = bookcode;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStarID() {
        return starID;
    }

    public void setStarID(int starID) {
        this.starID = starID;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedID=" + feedID + ", bookcode=" + bookcode + ", accID=" + accID + ", accName=" + accName + ", detail=" + detail + ", starID=" + starID + ", oDetailID=" + oDetailID + '}';
    }


    
    
    
    
}
