/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Book;

import java.sql.Date;

/**
 *
 * @author tramy
 */
public class BookShop {
    private long bookCode;
    private String bookName;
    private String image;
    private int importPrice;
    private int buyPrice;
    private String description;
    private int qty;
    private int cateID;
    private String cateName;
    private int postID;
    private String postName;
    private Date postDate;
    private int discountPercent;
    private String author;
    private int authorNum;
    private String publish ;

    public BookShop() {
    }

    public BookShop(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, int cateID, String cateName, int postID, String postName, Date postDate, int discountPercent, String author) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.image = image;
        this.importPrice = importPrice;
        this.buyPrice = buyPrice;
        this.description = description;
        this.qty = qty;
        this.cateID = cateID;
        this.cateName = cateName;
        this.postID = postID;
        this.postName = postName;
        this.postDate = postDate;
        this.discountPercent = discountPercent;
        this.author = author;
    }
    public BookShop(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, int cateID, String cateName, int postID, String postName, Date postDate, int discountPercent, String author, String publish) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.image = image;
        this.importPrice = importPrice;
        this.buyPrice = buyPrice;
        this.description = description;
        this.qty = qty;
        this.cateID = cateID;
        this.cateName = cateName;
        this.postID = postID;
        this.postName = postName;
        this.postDate = postDate;
        this.discountPercent = discountPercent;
        this.author = author;
        this.publish = publish;
    }

    public BookShop(long bookCode, String bookName, int importPrice, int qty, int postID, String postName, String publish) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.qty = qty;
        this.postID = postID;
        this.postName = postName;
        this.publish = publish;
    }
    
    

    public BookShop(long bookCode, String bookName) {
        this.bookCode = bookCode;
        this.bookName = bookName;
    }
    

    public long getBookCode() {
        return bookCode;
    }

    public void setBookCode(long bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }
    

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(int authorNum) {
        this.authorNum = authorNum;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
    
    

    @Override
    public String toString() {
        return "BookShop{" + "bookCode=" + bookCode + ", bookName=" + bookName + ", image=" + image + ", importPrice=" + importPrice + ", buyPrice=" + buyPrice + ", description=" + description + ", qty=" + qty + ", cateID=" + cateID + ", cateName=" + cateName + ", postID=" + postID + ", postName=" + postName + ", postDate=" + postDate + ", discountPercent=" + discountPercent + ", author=" + author + '}';
    }
    
    
}
