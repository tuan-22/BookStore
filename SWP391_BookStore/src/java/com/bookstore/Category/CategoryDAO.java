/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Category;

import com.bookstore.Book.Book;
import com.bookstore.Book.BookDAO;
import com.bookstore.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Category> getCategoryBook() {
        List<Category> list = new ArrayList<>();
        String sql = "select cateId,cateName\n" +
                    "from tblCategory";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Book> getBookByCategory(String CName) {
        List<Book> list = new ArrayList<>();
        String sql = "			select b.bookCode, b.bookName, b.img, b.importPrice, b.buyPrice, b.description, b.quantity,p.postID,ca.cateID,ca.cateName,p.postName,pc.companyID,pc.companyName,b.postDate,d.discountPercent,a.authorName\n" +
"         from ((((((tblBook b left join tblDiscount d on b.bookCode=d.bookCode)\n" +
"				inner join tblCompose c on b.bookCode=c.bookCode)\n" +
"                  inner join tblCategory ca on b.cateID=ca.cateID)\n" +
"                  inner join tblAuthor a on c.authorID=a.authorID)\n" +
"                  inner join tblPostHistory p on p.postID=b.postID)\n" +
"                inner join tblPublishCompany pc on pc.companyID=b.companyID )\n" +
"                where ca.cateName= ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, CName);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Book(
                        rs.getLong("bookCode"),//bookcode
                        rs.getString("bookName"),//bookname 
                        rs.getString("img"),//image
                        rs.getInt("importPrice"),//importprice
                        rs.getInt("buyPrice"),//buyprice
                        rs.getString("description"),//description
                        rs.getInt("quantity"),//qty
                        rs.getInt("cateID"),//cateID
                        rs.getString("cateName"),//catename
                        rs.getInt("postID"),//postID 
                        rs.getString("postName"),//postName
                        rs.getInt("companyID"),//companyID 
                        rs.getString("companyName"),//companyName 
                        rs.getDate("postDate"),//postdate
                        rs.getInt("discountPercent"),
                        rs.getString("authorName")//author
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        }
    }

