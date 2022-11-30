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
public class FeedbackTitle {
    private long bookcode;
    private String bookName;
    private int cateID;
    private String cateName;
    private int totalFeed;
    private float aveStar;

    public FeedbackTitle() {
    }

    public FeedbackTitle(long bookcode, String bookName, int cateID, String cateName, int totalFeed, float aveStar) {
        this.bookcode = bookcode;
        this.bookName = bookName;
        this.cateID = cateID;
        this.cateName = cateName;
        this.totalFeed = totalFeed;
        this.aveStar = aveStar;
    }

    public FeedbackTitle(long bookcode, String bookName, int cateID, String cateName) {
        this.bookcode = bookcode;
        this.bookName = bookName;
        this.cateID = cateID;
        this.cateName = cateName;
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

    public int getTotalFeed() {
        return totalFeed;
    }

    public void setTotalFeed(int totalFeed) {
        this.totalFeed = totalFeed;
    }

    public float getAveStar() {
        return aveStar;
    }

    public void setAveStar(float aveStar) {
        this.aveStar = aveStar;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "FeedbackTitle{" + "bookcode=" + bookcode + ", bookName=" + bookName + ", cateID=" + cateID + ", cateName=" + cateName + ", totalFeed=" + totalFeed + ", aveStar=" + aveStar + '}';
    }

    
    
    
}
