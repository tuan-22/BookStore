/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Receipt;

import com.bookstore.Company.Company;
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
public class ReceiptDetailDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ReceiptDetail> getListReceiptDetails() {
        try {
            String query = "  Select * from tblReceiptDetail ";

            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            List<ReceiptDetail> list = new ArrayList<>();
            while (rs.next()) {

                ReceiptDetail c = new ReceiptDetail(rs.getInt(1));
                list.add(c);
            }
            return list;
        } catch (Exception e) {

        }

        return null;
    }

    public List<ReceiptDetail> getListRDetailByRID(String id) {
        List<ReceiptDetail> list = new ArrayList<>();
        String sql = " select d.RdetailID , d.bookcode , b.bookName , d.importQty , d.importPrice\n"
                + "from tblReceiptDetail d inner join tblBook b on d.bookcode=b.bookCode\n"
                + "where d.receiptID= ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new ReceiptDetail(rs.getInt(1),
                        rs.getLong(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertRDetail(String code, String qty, String price, int repid) {

        ReceiptDetailDAO dao = new ReceiptDetailDAO();
        int lastCID;

        List<ReceiptDetail> list = dao.getListReceiptDetails();

            int sizeList = list.size() - 1;
        lastCID = list.get(sizeList).getRdID() + 1;

        
        
        String query = " insert into tblReceiptDetail\n"
                + "values(?,?,?,?,?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, lastCID);
            ps.setString(2, code);
            ps.setString(3, qty);
            ps.setString(4, price);
            ps.setInt(5, repid);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        ReceiptDetailDAO dao = new ReceiptDetailDAO();
        dao.insertRDetail("1111111111","20", "9999", 62);
    }
}
