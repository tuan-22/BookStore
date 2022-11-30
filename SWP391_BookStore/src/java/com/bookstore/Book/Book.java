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
public class Book {

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
    private int companyID;
    private String companyName;
    private Date postDate;
    private int discountPercent;
    private String author;
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(long bookCode, String author) {
        this.bookCode = bookCode;
        this.author = author;
    }

    public Book(long bookCode, String bookName, String image, String author, String companyName, int qty, String description, int importPrice, int buyPrice, String postName) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.image = image;
        this.importPrice = importPrice;
        this.buyPrice = buyPrice;
        this.description = description;
        this.qty = qty;
        this.companyName = companyName;
        this.author = author;
        this.postName = postName;
    }
//moi
    public Book(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, String postName, String companyName,int cateID, String cateName,String auName) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.image = image;
        this.importPrice = importPrice;
        this.buyPrice = buyPrice;
        this.description = description;
        this.qty = qty;
        this.postName = postName;
        this.companyName = companyName;
        this.cateID= cateID;
        this.cateName= cateName;
        this.authorName= auName;
    }
    
    
    
    
    
    public Book(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, int cateID, String cateName, int postID, String postName, int companyID, String companyName) {
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
        this.companyID = companyID;
        this.companyName = companyName;
    }

    public Book(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, int cateID, String cateName, int postID, String postName, int companyID, String companyName, Date postDate) {
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
        this.companyID = companyID;
        this.companyName = companyName;
        this.postDate = postDate;
    }

    public Book(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, int cateID, String cateName, int postID, String postName, int companyID, String companyName, Date postDate, int discountPercent) {
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
        this.companyID = companyID;
        this.companyName = companyName;
        this.postDate = postDate;
        this.discountPercent = discountPercent;
    }
        public Book(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, int cateID, String cateName, int postID, String postName, int companyID, String companyName, Date postDate, String authorName) {
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
        this.companyID = companyID;
        this.companyName = companyName;
        this.postDate = postDate;
        this.authorName = authorName;
    }

    public Book(long bookCode, String bookName, String image, int importPrice, int buyPrice, String description, int qty, int cateID, String cateName, int postID, String postName, int companyID, String companyName, Date postDate, int discountPercent, String authorName) {
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
        this.companyID = companyID;
        this.companyName = companyName;
        this.postDate = postDate;
        this.discountPercent = discountPercent;
        this.authorName = authorName;
    }

    public Book(int qty) {
        this.qty = qty;
    }
    
    
        
    Book(long aLong, String string, String string0, String string1, String string2, String string3, int aInt, String string4, int aInt0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "bookCode=" + bookCode + ", bookName=" + bookName + ", image=" + image + ", importPrice=" + importPrice + ", buyPrice=" + buyPrice + ", description=" + description + ", qty=" + qty + ", cateID=" + cateID + ", cateName=" + cateName + ", postID=" + postID + ", postName=" + postName + ", companyID=" + companyID + ", companyName=" + companyName + ", postDate=" + postDate + ", discountPercent=" + discountPercent + ", author=" + author + ", authorName=" + authorName + '}';
    }


    

    /**
     * @return the checkActive
     */
    /**
     * @param checkActive the checkActive to set
     */
    /**
     * @return the discountPercent
     */
    public int getDiscountPercent() {
        return discountPercent;
    }

    /**
     * @param discountPercent the discountPercent to set
     */
    /**
     * @param discountPercent the discountPercent to set
     */
    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

}
