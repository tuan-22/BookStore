/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Discount;

import java.sql.Date;

/**
 *
 * @author tramy
 */
public class Discount {
    private int discountID;
    private long bookCode;
    private String bName;
    private Date startDate;
    private Date endDate;
    private int percent;
    private String status;
    private String img;

    public Discount() {
    }

    public Discount(int discountID) {
        this.discountID = discountID;
    }
    

    public Discount(int discountID, long bookCode, Date startDate, Date endDate, int percent) {
        this.discountID = discountID;
        this.bookCode = bookCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percent = percent;
    }

    public Discount(int discountID, String status) {
        this.discountID = discountID;
        this.status = status;
    }

    
    public Discount(int discountID, long bookCode, String bName, Date startDate, Date endDate, int percent, String status, String img) {
        this.discountID = discountID;
        this.bookCode = bookCode;
        this.bName = bName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percent = percent;
        this.status = status;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public long getBookCode() {
        return bookCode;
    }

    public void setBookCode(long bookCode) {
        this.bookCode = bookCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Discount{" + "discountID=" + discountID + ", bookCode=" + bookCode + ", bName=" + bName + ", startDate=" + startDate + ", endDate=" + endDate + ", percent=" + percent + ", status=" + status + '}';
    }

    
    
    
    
}


