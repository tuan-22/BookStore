/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.OrderDetail;

import com.bookstore.Account.Account;
import com.bookstore.Order.Order;
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
public class OrderDetailDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<OrderDetail> getListDetailByOrder(String orderID) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = " select d.OdetailID,o.orderID,d.bookcode,b.bookName,b.img,d.oDetailQty,d.price\n"
                + "from (([dbo].[tblOrderDetail] d inner join [dbo].[tblOrder] o on d.orderID=o.orderID)\n"
                + "inner join [dbo].[tblBook] b on d.bookcode=b.bookCode)\n"
                + "where d.orderID= ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, orderID);
     
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    

    public static void main(String[] args) {
        OrderDetailDAO dao = new OrderDetailDAO();
        List<OrderDetail> list = dao.getListDetailByOrder("1");
        System.out.println(list);
    }
}
