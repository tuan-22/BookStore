/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Discount;

import com.bookstore.Account.Account;
import com.bookstore.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.tomcat.jni.Time;

/**
 *
 * @author tramy
 */
public class DiscountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Discount> getDiscountByBookCode(String bookcode) {
        String code = String.valueOf(bookcode);
        List<Discount> list = new ArrayList<>();
        String sql = " select * from tblDiscount\n"
                + "where bookCode=? and (select Getdate()) between startDate and endDate ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Discount(rs.getInt(1), rs.getLong(2), rs.getDate(3), rs.getDate(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Discount> getAllDiscount() {
        List<Discount> list = new ArrayList<>();
        String sql = " select d.discountID, b.bookCode, b.bookName, d.discountPercent,d.startDate,d.endDate,b.img\n"
                + "from [dbo].[tblBook] b inner join [dbo].[tblDiscount] d on b.bookCode=d.bookCode ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Discount(rs.getInt(1), rs.getLong(2), rs.getString(3), rs.getDate(5), rs.getDate(6), rs.getInt(4), "", rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Discount> getDiscountBycode(String code) {
        List<Discount> list = new ArrayList<>();
        String sql = " Select * from [dbo].[tblDiscount]\n"
                + "where bookCode= ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Discount(rs.getInt(1), rs.getLong(2), rs.getDate(3), rs.getDate(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Discount> getStatus(List<Discount> list) {
        for (Discount d : list) {
            java.util.Date date = new java.util.Date();
            Long now = date.getTime();
            long start = now - d.getStartDate().getTime();
            long end = d.getEndDate().getTime() - now;

            if (start > 0 && end > 0) {
                d.setStatus("Still due");
            } else if (start <= 0) {
                d.setStatus("Not yet");
            } else if (end <= 0) {
                d.setStatus("Expired");
            }
        }
        return list;
    }

    public Discount countDiscount() {
        Discount dis = new Discount();

        String sql = " select count(d.discountID) from tblDiscount d ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Discount(rs.getInt(1));
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void addNewDis(String bookcode, String percent, String start, String end) {

        DiscountDAO dAO = new DiscountDAO();
        List<Discount> list = dAO.getAllDiscount();
        int lastUID;
        if (list.size() == 0 || list.isEmpty()) {
            lastUID = 1;
        } else {

            int sizeList = list.size() - 1;
            lastUID = list.get(sizeList).getDiscountID() + 1;
        }
        String sql = " insert into tblDiscount\n"
                + "values (?,?,?,?,?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lastUID);
            ps.setString(2, bookcode);
            ps.setString(3, percent);
            ps.setString(4, start);
            ps.setString(5, end);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void deleteDiscount(String id) {
        String sql = " delete from tblDiscount\n"
                + "where discountID= ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Discount> getDiscountDashboards() {
        List<Discount> tempList = new ArrayList<>();
        DiscountDAO dAO = new DiscountDAO();
        List<Discount> list = dAO.getAllDiscount();

        for (Discount d : list) {
            java.util.Date date = new java.util.Date();
            long now = date.getTime();
            long start = now - d.getStartDate().getTime();
            long end = d.getEndDate().getTime() - now;

            if (start > 0 && end > 0) {
                d.setStatus("Still due");
            } else if (start <= 0) {
                d.setStatus("Not yet");
            } else if (end <= 0) {
                d.setStatus("Expired");
            }
        }
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        for (Discount discount : list) {
            if (discount.getStatus().equals("Still due")) {
                temp1 = temp1 + 1;
            }
            if (discount.getStatus().equals("Not yet")) {
                temp2 = temp2 + 1;
            }
            if (discount.getStatus().equals("Expired")) {
                temp3 = temp3 + 1;
            }
        }
        Discount dis1= new Discount(temp1, "Still due");
        Discount dis2= new Discount(temp2, "Not yet");
        Discount dis3= new Discount(temp3, "Expired");
        tempList.add(dis1);
        tempList.add(dis2);
        tempList.add(dis3);

        return tempList;
    }

    public static void main(String[] args) {
        DiscountDAO discountDAO = new DiscountDAO();
        List<Discount> discount = discountDAO.getDiscountDashboards();
        System.out.println(discount);

    }
}
