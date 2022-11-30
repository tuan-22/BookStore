/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Customer;

import com.bookstore.Account.Account;
import com.bookstore.Book.BookShopDAO;
import com.bookstore.Cart.Cart;
import com.bookstore.Category.Category;
import com.bookstore.Category.CategoryDAO;
import com.bookstore.Feedback.Feedback;
import com.bookstore.Feedback.FeedbackDAO;
import com.bookstore.Order.Order;
import com.bookstore.Order.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CusFeedBackController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            FeedbackDAO fdao = new FeedbackDAO();

            List<Feedback> list = fdao.getFeedbackManage();

            int feedbackID = getLastFeedBackID(list);

            String bookid = request.getParameter("txtbookCode");
            long bookCode = Long.parseLong(bookid);

            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            int accountID = acc.getAccID();

            String feedBack = request.getParameter("txtfeedback");

            String star = request.getParameter("rate");
            int rateStar = Integer.parseInt(star);

            String iddetail = request.getParameter("txtOrderDetailID");

            int oderDetailID = Integer.parseInt(iddetail);

            if (feedBack == null) {
                feedBack = "(empty)";
                fdao.addFeedback(feedbackID, bookCode, accountID, feedBack, rateStar, oderDetailID);
            }
            fdao.addFeedback(feedbackID, bookCode, accountID, feedBack, rateStar, oderDetailID);

            String orderID = request.getParameter("txtorderID");
            //parse id sang kieu int
            int id = Integer.parseInt(orderID);
            // goi dao
            OrderDAO odao = new OrderDAO();
            // lay list detail tu ham lay list theo id
            List<Order> listOrdetail = odao.getOrderDetailByorderID(id);
            // set attribute len
            request.setAttribute("listOrdetail", listOrdetail);
            CategoryDAO daoC = new CategoryDAO();
            BookShopDAO daoB = new BookShopDAO();

            List<Category> listC = daoC.getCategoryBook();
            request.setAttribute("listC", listC);
            request.setAttribute("fed", "fed");
            //day du lieu va chuyen trang
            request.getRequestDispatcher("cushistoryhome").forward(request, response);
        }
    }

    private int getLastFeedBackID(List<Feedback> list) {
        if (list.size() > 0) {
            int sizeList = list.size() - 1;
            int lastFeedID = (int) (list.get(sizeList).getFeedID() + 1);
            return lastFeedID;
        }
        return 1;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CusFeedBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CusFeedBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
