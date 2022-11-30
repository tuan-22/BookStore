/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Company;

import com.bookstore.Book.BookDAO;
import com.bookstore.Receipt.Receipt;
import com.bookstore.Receipt.ReceiptDAO;
import com.bookstore.Utils.DBUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Admin
 */
public class CompanyDAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public List<Company> getListPublishCompany() {
        try {
            String query = "  Select companyID, companyName, comAddress, phone, comEmail from tblPublishCompany ";

            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();

            List<Company> list = new ArrayList<>();
            while (rs.next()) {

                Company c = new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                list.add(c);
            }
            return list;
        } catch (Exception e) {

        }

        return null;
    }

    public void insertCompany(String companyName, String comAddress, String phone, String comEmail) {

        CompanyDAO dao = new CompanyDAO();

        List<Company> list = dao.getListPublishCompany();
        int lastCID;
        if (list.size()==0 ||list.isEmpty()) {
            lastCID=1;
        }else{
        
        int sizeList = list.size() - 1;
        lastCID = list.get(sizeList).getCompanyID() + 1;
        }
        String query = " insert into tblPublishCompany\n"
                + "values (?,?,?,?,?) ";
        try {
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setInt(1, lastCID);
            stm.setString(2, companyName);
            stm.setString(3, comAddress);
            stm.setString(4, phone);
            stm.setString(5, comEmail);
            stm.executeUpdate();

        } catch (Exception e) {

        }
    }

    public Company extistCompanyNameForChange(String companyName, String id) {
        try {
            String query = " Select * from tblPublishCompany where companyName =? and companyID!=? ";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, companyName);
            stm.setString(2, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Company extistCompanyAddressForChange(String comAddress, String id) {
        String query = " Select * from tblPublishCompany where comAddress =? and companyID!=? ";
        try {
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, comAddress);
            stm.setString(2, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                comAddress = rs.getString(1);
                int compantID = rs.getInt(2);
                String companyName = rs.getString(3).trim();
                String phone = rs.getString(4).trim();
                String comEmail = rs.getString(5).trim();

                return new Company(compantID, companyName, comAddress, phone, comEmail);
            }

        } catch (Exception e) {

        }
        return null;
    }

    public Company extistCompanyPhoneForChange(String phone, String id) {
        try {
            String query = " Select * from tblPublishCompany where phone =? and companyID!=? ";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, phone);
            stm.setString(2, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Company extistCompanyEmailForChange(String comEmail, String id) {
        try {
            String query = " Select * from tblPublishCompany where comEmail =? and companyID!=? ";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, comEmail);
            stm.setString(2, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public boolean updatePhone(String phone, int companyID) throws SQLException, NoSuchAlgorithmException {
        String Phone = phone;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(phone.getBytes());
        byte[] digest = md.digest();
        String dePass = DatatypeConverter.printHexBinary(digest).toLowerCase();
        String sql = " UPDATE tblPublishCompany\n"
                + "set phone=?\n"
                + "where companyID= ? ";
        boolean check = false;
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(2, companyID);
            ps.setString(1, Phone);

            check = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Update error!" + ex.getMessage());
        }
        return check;
    }

    public void delecompanyByID(int companyID) {

        String sql = " delete from tblPublishCompany\n"
                + "where companyID = ? ";
        try {
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, companyID);
            rs = stm.executeQuery();

        } catch (Exception e) {
        }
    }

    public boolean updateCompany(String companyname, String comAddress, String phone, String comEmail, int companyID) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblPublishCompany Set companyName = ?, comAddress = ?, phone = ?, comEmail = ? where companyID= ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, companyname);
                stm.setString(2, comAddress);
                stm.setString(3, phone);
                stm.setString(4, comEmail);
                stm.setInt(5, companyID);

                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public List<Company> getListPublishCompanyByCompanyID(int companyID) {
        List<Company> list = new ArrayList<>();
        String sql = " Select pc.companyID, pc.companyName, pc.comAddress, pc.phone, pc.comEmail\n"
                + "from tblPublishCompany pc inner join tblBook b on pc.companyID = b.companyID\n"
                + "where pc.companyID = ? ";
        try {
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, companyID);
            rs = stm.executeQuery();

            while (rs.next()) {
                list.add(new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Company> getListPublishCompanyVS2() {
        try {
            String query = "  Select companyID, companyName, comAddress, phone, comEmail from tblPublishCompany ";

            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();

            List<Company> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                BookDAO dAO = new BookDAO();
                int a = dAO.getBookByCompanyID(id);

                Company c = new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5), a);
                list.add(c);
            }

            return list;
        } catch (Exception e) {

        }

        return null;
    }

    public Company getCompanybyID(String id) {

        String query = "  Select companyID, companyName, comAddress, phone, comEmail from tblPublishCompany "
                + "where companyID=? ";
        try {
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public Company extistCompanyName(String companyName) {
        try {
            String query = " Select * from tblPublishCompany where companyName =? ";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, companyName);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Company extistCompanyAddress(String comAddress) {
        try {
            String query = " Select * from tblPublishCompany where comAddress =? ";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, comAddress);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Company extistCompanyPhone(String phone) {
        try {
            String query = " Select * from tblPublishCompany where phone =? ";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, phone);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Company extistCompanyEmail(String comEmail) {
        try {
            String query = " Select * from tblPublishCompany where comEmail =? ";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, comEmail);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        CompanyDAO dao = new CompanyDAO();

//        List<Company> list = dao.getListPublishCompany();
//        for (Company c : list) {
//            System.out.println("CompanyID: " + c.getCompanyID() + "CompanyName: " + c.getCompanyName());
//        }
        //dao.insertCompany(39, "HIHIHI");
        System.out.println(dao.extistCompanyName("National Geographic Learning"));

    }
}
