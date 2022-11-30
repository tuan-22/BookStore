/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Profit;

import java.sql.Date;

/**
 *
 * @author tramy
 */
public class Profit {
    private int profitEarn;
    private String tempDate;
    
    public Profit() {
    }

    public Profit(int profitEarn, String tempDate) {
        this.profitEarn = profitEarn;
        this.tempDate = tempDate;
    }

    public int getProfitEarn() {
        return profitEarn;
    }

    public void setProfitEarn(int profitEarn) {
        this.profitEarn = profitEarn;
    }

    public String getTempDate() {
        return tempDate;
    }

    public void setTempDate(String tempDate) {
        this.tempDate = tempDate;
    }
    

    @Override
    public String toString() {
        return "Profit{" + "profitEarn=" + profitEarn + ", tempDate=" + tempDate + '}';
    }

    
    
    
    
}
