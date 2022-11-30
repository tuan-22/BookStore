/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Feedback;

import com.bookstore.Book.Book;
import com.bookstore.Order.Order;
import com.bookstore.Utils.DBUtils;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tramy
 */
public class FeedbackDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<FeedbackTitle> getAllTitles() {
        List<FeedbackTitle> list = new ArrayList<>();
        String sql = " select b.bookCode , b.bookName, c.cateID, c.cateName\n"
                + "from tblBook b inner join tblCategory c on b.cateID=c.cateID ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String code = String.valueOf(rs.getLong(1));
                FeedbackDAO dAO = new FeedbackDAO();
                List<Feedback> listFeedback = dAO.getFeedBackByBookcode(code);
                int total;
                float star;
                if (listFeedback != null) {
                    total = listFeedback.size();
                    int totalStar = 0;
                    for (Feedback feedback : listFeedback) {
                        totalStar = totalStar + feedback.getStarID();
                    }
                    star = totalStar / total;
                } else {
                    total = 0;
                    star = 0;
                }

                list.add(new FeedbackTitle(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), total, star));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<FeedbackTitle> getAllTitles2() {
        List<FeedbackTitle> list = new ArrayList<>();
        String sql = " select b.bookCode , b.bookName, c.cateID, c.cateName\n"
                + "from tblBook b inner join tblCategory c on b.cateID=c.cateID ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(new FeedbackTitle(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<FeedbackTitle> getAllTitles(String cateID) {
        List<FeedbackTitle> list = new ArrayList<>();
        String sql = " select b.bookCode , b.bookName, c.cateID, c.cateName\n"
                + "from tblBook b inner join tblCategory c on b.cateID=c.cateID "
                + "where c.cateID= ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cateID);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new FeedbackTitle(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<FeedbackTitle> getTitle(String code) {
        List<FeedbackTitle> list = new ArrayList<>();
        String sql = " select b.bookCode , b.bookName, c.cateID, c.cateName\n"
                + "from tblBook b inner join tblCategory c on b.cateID=c.cateID "
                + "where b.bookCode= ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, code);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new FeedbackTitle(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Feedback> getFeedBackByBookcode(String bookcode) {
        List<Feedback> list = new ArrayList<>();
        String sql = " select f.feedbackID,f.bookCode, f.accountID, a.userName, f.feedbackDetail,f.starID\n"
                + "from tblFeedback f inner join tblAccount a \n"
                + "on f.accountID=a.accountID\n"
                + "where f.bookCode = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookcode);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Feedback(rs.getInt(1), rs.getLong(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));

            }
        } catch (Exception e) {
        }
        return list;

    }

    public List<Feedback> getFeedBackByBookcode() {
        List<Feedback> list = new ArrayList<>();
        String sql = " select f.feedbackID,f.bookCode, f.accountID, a.userName, f.feedbackDetail,f.starID\n"
                + "from tblFeedback f inner join tblAccount a \n"
                + "on f.accountID=a.accountID ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Feedback(rs.getInt(1), rs.getLong(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));

            }
        } catch (Exception e) {
        }
        return list;

    }

    public List<FeedbackTitle> addtotalAndStar() {
        FeedbackDAO dAO = new FeedbackDAO();
        List<FeedbackTitle> listTitles = dAO.getAllTitles2();

        List<Feedback> ListFeedbacks = dAO.getFeedBackByBookcode();

        for (FeedbackTitle list : listTitles) {
            long code = list.getBookcode();
            List<Feedback> ListFeedbackTitle = new ArrayList<>();
            for (Feedback ListFeedback : ListFeedbacks) {
                if (code == ListFeedback.getBookcode()) {
                    ListFeedbackTitle.add(ListFeedback);
                }
            }
            list.setTotalFeed(ListFeedbackTitle.size());
            int totalStar = 0;
            if (ListFeedbackTitle.size() != 0) {
                for (Feedback feedback : ListFeedbackTitle) {
                    totalStar = totalStar + feedback.getStarID();
                }
            }
            float star = 0;
            float fstar = 0;
            if (totalStar != 0) {
                int size = ListFeedbackTitle.size();
                float sumStar = (float) totalStar;
                float fSize = (float) size;

                star = sumStar / fSize;

                DecimalFormat df = new DecimalFormat("0.00");
                String formate = df.format(star);
                fstar = Float.valueOf(formate);

            }
            list.setAveStar(fstar);
        }
        return listTitles;
    }

    public List<FeedbackTitle> addtotalAndStar(String cateID) {
        FeedbackDAO dAO = new FeedbackDAO();
        List<FeedbackTitle> listTitles = dAO.getAllTitles(cateID);

        List<Feedback> ListFeedbacks = dAO.getFeedBackByBookcode();

        for (FeedbackTitle list : listTitles) {
            long code = list.getBookcode();
            List<Feedback> ListFeedbackTitle = new ArrayList<>();
            for (Feedback ListFeedback : ListFeedbacks) {
                if (code == ListFeedback.getBookcode()) {
                    ListFeedbackTitle.add(ListFeedback);
                }
            }
            list.setTotalFeed(ListFeedbackTitle.size());
            int totalStar = 0;
            if (ListFeedbackTitle.size() != 0) {
                for (Feedback feedback : ListFeedbackTitle) {
                    totalStar = totalStar + feedback.getStarID();
                }
            }
            float star = 0;
            float fstar = 0;
            if (totalStar != 0) {
                int size = ListFeedbackTitle.size();
                float sumStar = (float) totalStar;
                float fSize = (float) size;

                star = sumStar / fSize;

                DecimalFormat df = new DecimalFormat("0.00");
                String formate = df.format(star);
                fstar = Float.valueOf(formate);

            }
            list.setAveStar(fstar);
        }
        return listTitles;
    }

    public List<FeedbackTitle> addtotalAndStarOfTitle(String bcode) {
        FeedbackDAO dAO = new FeedbackDAO();
        List<FeedbackTitle> listTitles = dAO.getTitle(bcode);

        List<Feedback> ListFeedbacks = dAO.getFeedBackByBookcode();

        for (FeedbackTitle list : listTitles) {
            long code = list.getBookcode();
            List<Feedback> ListFeedbackTitle = new ArrayList<>();
            for (Feedback ListFeedback : ListFeedbacks) {
                if (code == ListFeedback.getBookcode()) {
                    ListFeedbackTitle.add(ListFeedback);
                }
            }
            list.setTotalFeed(ListFeedbackTitle.size());
            int totalStar = 0;
            if (ListFeedbackTitle.size() != 0) {
                for (Feedback feedback : ListFeedbackTitle) {
                    totalStar = totalStar + feedback.getStarID();
                }
            }
            float star = 0;
            float fstar = 0;
            if (totalStar != 0) {
                int size = ListFeedbackTitle.size();
                float sumStar = (float) totalStar;
                float fSize = (float) size;

                star = sumStar / fSize;

                DecimalFormat df = new DecimalFormat("0.00");
                String formate = df.format(star);
                fstar = Float.valueOf(formate);

            }
            list.setAveStar(fstar);
        }
        return listTitles;
    }

    public List<Feedback> getFeedbackManage() {
        List<Feedback> list = new ArrayList<>();
        String sql = "select *\n"
                + "from tblFeedback";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Feedback(rs.getInt(1),
                        rs.getLong(2),
                        rs.getInt(3),
                        rs.getString(4).trim(),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addFeedback(int feedID, long bookcode, int accID, String detail, int starID, int oDetailID) throws NoSuchAlgorithmException {
        String sql = "insert into tblFeedback\n"
                + "values(?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, feedID);
            ps.setLong(2, bookcode);
            ps.setInt(3, accID);
            ps.setString(4, detail);
            ps.setInt(5, starID);
            ps.setInt(6, oDetailID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Feedback> getFeedbackManageByBookCode(String bookCode) {
        List<Feedback> list = new ArrayList<>();
        String sql = " select *\n"
                + "from tblFeedback\n"
                + "where bookCode = ? ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookCode);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Feedback(rs.getInt(1),
                        rs.getLong(2),
                        rs.getInt(3),
                        rs.getString(4).trim(),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Feedback> getFeedbackManageByBookCodeAndOrder(String bookCode, int oDetailID) {
        List<Feedback> list = new ArrayList<>();
        String sql = " select f.feedbackID, f.bookCode, f.accountID, f.feedbackDetail, f.starID, f.OdetailID\n"
                + "from ((tblFeedback f inner join tblOrderDetail od on od.OdetailID = f.OdetailID)\n"
                + "inner join tblOrder o on o.orderID = od.orderID)\n"
                + "where f.bookCode = ? and od.OdetailID = ? ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookCode);
            ps.setInt(2, oDetailID);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Feedback(rs.getInt(1),
                        rs.getLong(2),
                        rs.getInt(3),
                        rs.getString(4).trim(),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Feedback> getFeedbackByBookCode(String bookCode) {
        List<Feedback> list = new ArrayList<>();
        String sql = " select ac.userName, f.feedbackDetail, f.starID\n"
                + "from tblFeedback f inner join tblAccount ac on f.accountID = ac.accountID\n"
                + "where f.bookCode = ? ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookCode);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Feedback(rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        FeedbackDAO dAO = new FeedbackDAO();
        //List<FeedbackTitle> list = dAO.addtotalAndStar();
        System.out.println(dAO.getFeedbackManageByBookCodeAndOrder("8935244875454", 2));
    }

}
