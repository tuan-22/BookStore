/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Receipt;

import com.bookstore.Company.Company;
import com.bookstore.Company.CompanyDAO;
import com.bookstore.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ReceiptDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Receipt> getListReceipt() {
        List<Receipt> list = new ArrayList<>();
        String sql = " Select r.receiptID , r.accountID, a.userName, r.orderDate , r.totalImportPrice , pc.companyID,pc.companyName\n"
                + "from ((tblReceipt r inner join tblAccount a on r.accountID=a.accountID) inner join tblPublishCompany pc on r.companyID=pc.companyID) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Receipt(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Receipt getReceiptByid(String id) {
        String sql = " Select r.receiptID , r.accountID, a.userName, r.orderDate , r.totalImportPrice , pc.companyID,pc.companyName\n"
                + "from ((tblReceipt r inner join tblAccount a on r.accountID=a.accountID) inner join tblPublishCompany pc on r.companyID=pc.companyID)\n"
                + "where r.receiptID=? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Receipt(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

//    public List<Receipt> getReceiptByReceiptID(String receiptID) {
//        List<Receipt> list = new ArrayList<>();
//        try {
//            String query = "select  r.orderDate, b.importPrice,pc.companyName,b.bookCode,rd.importQty, b.bookName, r.receiptID,b.quantity\n"
//                    + "from tblBook b  inner join tblPublishCompany pc on pc.companyID=b.companyID\n"
//                    + " inner join tblReceiptDetail rd on rd.bookcode = b.bookCode\n"
//                    + "inner join tblReceipt r on rd.receiptID = r.receiptID\n"
//                    + "where r.receiptID = ? ";
//
//            conn = new DBUtils().getConnection();
//            stm = conn.prepareStatement(query);
//            stm.setString(1, receiptID);
//            rs = stm.executeQuery();
//            while (rs.next()) {
//                list.add(new Receipt(rs.getDate(1),
//                        rs.getInt(2),
//                        rs.getString(3),
//                        rs.getLong(4),
//                        rs.getInt(5),
//                        rs.getString(6),
//                        rs.getInt(7),
//                        rs.getInt(8)));
//            }
//
//        } catch (Exception e) {
//
//        }
//        return list;
//
//    }
//
//    public void insertReceipt(int receiptID, int accountID, Date orderDate, int totalImportPrice, int companyID) throws SQLException {
//        try {
//            String query = " Insert into tblReceipt values (?, ?, ?, ?, ?)";
//            conn = new DBUtils().getConnection();
//            stm = conn.prepareStatement(query);
//            rs = stm.executeQuery();
//
//            stm = conn.prepareStatement(query);
//            stm.setInt(1, receiptID);
//            stm.setInt(2, companyID);
//            stm.setDate(3, orderDate);
//            stm.setInt(4, totalImportPrice);
//            stm.setInt(5, companyID);
//        } finally {
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                stm.close();
//            }
//
//        }
//
//    }
//
//    //dem so luong trong db
//    public int getToTalReceipt() throws ClassNotFoundException, SQLException {
//
//        try {
//            String query = "select count(*) from tblReceipt";
//            conn = new DBUtils().getConnection();
//            stm = conn.prepareStatement(query);
//            rs = stm.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//
//        }
//
//        return 0;
//    }
    public void createReceipt(String accountID, String day, int totalPrice, String comID) {

        ReceiptDAO dao = new ReceiptDAO();
        int lastCID;
        List<Receipt> list = dao.getListReceipt();
        
            int sizeList = list.size() - 1;
        lastCID = list.get(sizeList).getReceiptID() + 1;

        String query = " insert into tblReceipt\n"
                + "values(?,?,?,?,?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, lastCID);
            ps.setString(2, accountID);
            ps.setString(3,day);
            ps.setInt(4, totalPrice);
            ps.setString(5, comID);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        ReceiptDAO receiptDAO = new ReceiptDAO();
        List<Receipt> receipts= receiptDAO.getListReceipt();
        int lastCID;
        int sizeList = receipts.size() - 1;
        lastCID = receipts.get(sizeList).getReceiptID() + 1;
        System.out.println(lastCID);
        
        System.out.println(receipts);
//        Date now= new Date(System.currentTimeMillis());
        receiptDAO.createReceipt("3", "2022-11-11", 11111, "10");
    }

}
