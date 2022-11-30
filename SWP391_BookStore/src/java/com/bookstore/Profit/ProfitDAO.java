/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Profit;

import com.bookstore.Order.Return;
import com.bookstore.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tramy
 */
public class ProfitDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Return> listOrder() {
        List<Return> list = new ArrayList<>();

        String sql = " Select o.orderID,o.accountID,o.orderDate,o.userAddress,o.totalPrice,o.orderNote,o.status,a.userName,a.email,a.phoneNumber,o.receivedDate,o.requestDate,o.returnReason,o.approveDate\n"
                + "from [dbo].[tblOrder] o inner join [dbo].[tblAccount] a on  o.accountID=a.accountID\n"
                + "where o.status ='returning'or o.status ='reject' or o.status='confirm' or status= 'wait to approve' or o.status='out of date' or o.status='delivering' or o.status='received' ";
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

    public List<Return> listOrderMonth() {
        List<Return> list = new ArrayList<>();

        String sql = " Select o.orderID,o.accountID,o.orderDate,o.userAddress,o.totalPrice,o.orderNote,o.status,a.userName,a.email,a.phoneNumber,o.receivedDate,o.requestDate,o.returnReason,o.approveDate\n"
                + "from [dbo].[tblOrder] o inner join [dbo].[tblAccount] a on  o.accountID=a.accountID\n"
                + "where o.status ='returning'or o.status ='reject' or o.status='confirm' or status= 'wait to approve' or o.status='out of date' or o.status='delivering' or o.status='received' \n"
                + "and o.orderDate > dateadd(month, -6,  cast(getdate() as date)) ";
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

    public List<Return> listOrderYear() {
        List<Return> list = new ArrayList<>();

        String sql = " Select o.orderID,o.accountID,o.orderDate,o.userAddress,o.totalPrice,o.orderNote,o.status,a.userName,a.email,a.phoneNumber,o.receivedDate,o.requestDate,o.returnReason,o.approveDate\n"
                + "from [dbo].[tblOrder] o inner join [dbo].[tblAccount] a on  o.accountID=a.accountID\n"
                + "where o.status ='returning'or o.status ='reject' or o.status='confirm' or status= 'wait to approve' or o.status='out of date' or o.status='delivering' or o.status='received' \n"
                + "and o.orderDate > dateadd(year, -6,  cast(getdate() as date)) ";
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

    public Profit totalProfit() {
        Profit profit = new Profit();

        String sql = " select sum(o.totalPrice) from tblOrder o\n"
                + "where o.status ='returning'or o.status ='reject' or o.status='confirm' or status= 'wait to approve' or o.status='out of date' or o.status='delivering' or o.status='received' ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Profit(rs.getInt(1), "");
            }
            
        } catch (Exception e) {
        }
        return null;
    }

    public List<Profit> calculateProfit(List<Return> list) {
        List<Profit> pList = new ArrayList<>();
        List<Profit> finalList = new ArrayList<>();
        Long now = System.currentTimeMillis();
        Long temp = now - Long.parseLong("604800000");
        List<Return> tempList = new ArrayList<>();
//        List<Return> finalList= new ArrayList<>();
        LocalDate mydate = LocalDate.now();
        for (Return return1 : list) {
            Long orderDate = return1.getOrderDate().getTime();
            if (temp < orderDate) {
                tempList.add(return1);
            }
        }
        for (int i = 0; i < 7; i++) {
            String tempdate = String.valueOf(mydate);
            int total = 0;
            for (Return return1 : tempList) {
                LocalDate orDate = return1.getOrderDate().toLocalDate();
                if (mydate.equals(orDate)) {
                    total = total + return1.getTotal();
                    System.out.println(total);
                }
            }
            pList.add(new Profit(total, tempdate));
            mydate = mydate.minusDays(1);
        }
//        
        for (int i = pList.size() - 1; i >= 0; i--) {
            Profit indexProfit = pList.get(i);
            finalList.add(indexProfit);
        }
        return finalList;
    }

    public List<Profit> calculateProfitbyMonth(List<Return> list) {
        List<Profit> pList = new ArrayList<>();
        List<Profit> finalList = new ArrayList<>();
//        List<Return> finalList= new ArrayList<>();
        LocalDate mydate = LocalDate.now();
        Month myMonth = mydate.getMonth();
        int myYear = mydate.getYear();
        int lastYear = mydate.minusYears(1).getYear();

        for (int i = 0; i < 7; i++) {
            String tempmonth = String.valueOf(myMonth);
            int total = 0;

            for (Return return1 : list) {
                Month orMonth = return1.getOrderDate().toLocalDate().getMonth();

                if (myMonth.equals(orMonth)) {
                    total = total + return1.getTotal();
                }
            }
            pList.add(new Profit(total, tempmonth));

            myMonth = myMonth.minus(1);
        }
//        
        for (int i = pList.size() - 1; i >= 0; i--) {
            Profit indexProfit = pList.get(i);
            finalList.add(indexProfit);
        }
        return finalList;
    }

    public List<Profit> calculateProfitbyYear(List<Return> list) {
        List<Profit> pList = new ArrayList<>();
        List<Profit> finalList = new ArrayList<>();
//        List<Return> finalList= new ArrayList<>();
        LocalDate mydate = LocalDate.now();
        int myYear = mydate.getYear();

        for (int i = 0; i < 7; i++) {
            String tempmonth = String.valueOf(myYear);
            int total = 0;

            for (Return return1 : list) {
                int orYear = return1.getOrderDate().toLocalDate().getYear();

                if (myYear == orYear) {
                    total = total + return1.getTotal();
                }
            }
            pList.add(new Profit(total, tempmonth));

            myYear = myYear - 1;
        }
//        
        for (int i = pList.size() - 1; i >= 0; i--) {
            Profit indexProfit = pList.get(i);
            finalList.add(indexProfit);
        }
        return finalList;
    }

    public static void main(String[] args) {
        ProfitDAO dAO = new ProfitDAO();
        List<Return> list = dAO.listOrderYear();
        List<Profit> tempList = dAO.calculateProfitbyYear(list);
        
        Profit porfit= dAO.totalProfit();
        System.out.println(porfit);

    }
}
