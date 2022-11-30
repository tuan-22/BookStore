/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Order;

import com.bookstore.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tramy
 */
public class ReturnDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Return> listReturn() {
        List<Return> list = new ArrayList<>();

        String sql = " Select o.orderID,o.accountID,o.orderDate,o.userAddress,o.totalPrice,o.orderNote,o.status,a.userName,"
                + "a.email,a.phoneNumber,o.receivedDate,o.requestDate,o.returnReason,o.approveDate\n"
                + "from [dbo].[tblOrder] o inner join [dbo].[tblAccount] a on  o.accountID=a.accountID\n"
                + "where o.status ='returning'or o.status ='reject' or o.status='returned' or status= 'wait to approve' or o.status='out of date' ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                //int orderID, int accountID, Date orderDate, String address, int total, String Note, String status, String accName, String email, String phone
                list.add(new Return(rs.getInt(1),//oID
                        rs.getInt(2),//accID
                        rs.getDate(3),//orDate
                        rs.getString(4),//Address
                        rs.getInt(5),//price
                        rs.getString(6),//note
                        rs.getString(7),//status
                        rs.getString(8),//name
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getDate(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Return> listReturnByStatus(String status) {
        List<Return> list = new ArrayList<>();

        String sql = " Select o.orderID,o.accountID,o.orderDate,o.userAddress,o.totalPrice,o.orderNote,o.status,a.userName,"
                + "a.email,a.phoneNumber,o.receivedDate,o.requestDate,o.returnReason,o.approveDate\n"
                + "from [dbo].[tblOrder] o inner join [dbo].[tblAccount] a on  o.accountID=a.accountID\n"
                + "where o.status =? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();

            while (rs.next()) {
                //int orderID, int accountID, Date orderDate, String address, int total, String Note, String status, String accName, String email, String phone
                list.add(new Return(rs.getInt(1),//oID
                        rs.getInt(2),//accID
                        rs.getDate(3),//orDate
                        rs.getString(4),//Address
                        rs.getInt(5),//price
                        rs.getString(6),//note
                        rs.getString(7),//status
                        rs.getString(8),//name
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getDate(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Return getReturnByID(String id) {
        String sql = " Select o.orderID,o.accountID,o.orderDate,o.userAddress,o.totalPrice,o.orderNote,o.status,a.userName,"
                + "a.email,a.phoneNumber,o.receivedDate,o.requestDate,o.returnReason,o.approveDate\n"
                + "from [dbo].[tblOrder] o inner join [dbo].[tblAccount] a on  o.accountID=a.accountID\n"
                + "where o.orderID=? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Return(rs.getInt(1),//oID
                        rs.getInt(2),//accID
                        rs.getDate(3),//orDate
                        rs.getString(4),//Address
                        rs.getInt(5),//price
                        rs.getString(6),//note
                        rs.getString(7),//status
                        rs.getString(8),//name
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getDate(14));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean updateReturn(String orderid) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " update [dbo].[tblOrder]\n"
                        + "set [status]='out of date'\n"
                        + "where [orderID] = ? ";
                ps = conn.prepareStatement(sql);

                ps.setString(1, orderid);
                int row = ps.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
    public boolean updateReturnVS2(String orderid) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " update [dbo].[tblOrder]\n"
                        + "set [status]='out of date'\n"
                        + "where [orderID] = ? ";
                ps = conn.prepareStatement(sql);

                ps.setString(1, orderid);
                int row = ps.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReturnDAO dAO = new ReturnDAO();
        List<Return> list = dAO.listReturn();
        System.out.println(list);
    }
}
