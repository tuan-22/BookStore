/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Author;

import com.bookstore.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tramy
 */
public class AuthorDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Author> getListAuthorByBookcode(String code) {
        List<Author> list = new ArrayList<>();

        String sql = " select c.composeID, c.bookCode, a.authorID,a.authorName\n"
                + "from [dbo].[tblAuthor] a inner join [dbo].[tblCompose] c on a.authorID = c.authorID\n"
                + "where c.bookCode=? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, code);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Author(rs.getInt(1), rs.getLong(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Author> getListAuthor() {
        List<Author> list = new ArrayList<>();

        String sql = " select c.composeID, c.bookCode, a.authorID,a.authorName\n"
                + "from [dbo].[tblAuthor] a inner join [dbo].[tblCompose] c on a.authorID = c.authorID\n";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Author(rs.getInt(1), rs.getLong(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public List<Author> getAllAuthor() {
        List<Author> list = new ArrayList<>();

        String sql = " select * from [dbo].[tblAuthor]\n";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Author(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addAuthor(String name) {
        AuthorDAO dAO = new AuthorDAO();
        List<Author> list = dAO.getAllAuthor();
        int lastUID;
        if (list.isEmpty()) {
            lastUID=1;
        }else{
        
        int sizeList = list.size() - 1;
        lastUID = list.get(sizeList).getAuID() + 1;
        }

        String sql = " Insert into tblAuthor (authorID,authorName)\n"
                + "values(?,?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lastUID);
            ps.setString(2, name);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Author> getAllAuthorDesc() {
        List<Author> list = new ArrayList<>();

        String sql = " select  authorID from [dbo].[tblAuthor]\n"
                + "order by authorID desc \n";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Author(rs.getInt(1)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Author> getAllCompose() {
        List<Author> list = new ArrayList<>();

        String sql = " select * from tblCompose\n";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Author(rs.getInt(1)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void createCompose(String code, int auID) {
        AuthorDAO dAO = new AuthorDAO();
        List<Author> list = dAO.getAllCompose();
        
        int lastUID;
        if (list.isEmpty()) {
            lastUID=1;
        }else{
        
        int sizeList = list.size() - 1;
        lastUID = list.get(sizeList).getAuID() + 1;
        }

        String sql = " INSERT INTO tblCompose\n"
                + " VALUES(?,?,?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lastUID);
            ps.setString(2, code);
            ps.setInt(3, auID);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public void deleteCompose(int id) {
        String sql = " delete from tblCompose\n"
                + "where composeID=? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {

            AuthorDAO authordAO = new AuthorDAO();
            
            List<Author> list= authordAO.getListAuthor();

        System.out.println(list);
    }
}
