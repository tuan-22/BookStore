/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Customer;

import com.bookstore.Account.Account;
import com.bookstore.Book.BookShopDAO;
import com.bookstore.Category.Category;
import com.bookstore.Category.CategoryDAO;
import com.bookstore.Order.Order;
import com.bookstore.Order.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CusRetrunNavController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //lay orderID khi click vao xem detail
            String orderID = request.getParameter("orderID");
            //parse id sang kieu int
            int id = Integer.parseInt(orderID);
            // goi dao
            OrderDAO odao = new OrderDAO();
            // new session
            HttpSession session = request.getSession();
            // check account
            Account acc = (Account) session.getAttribute("acc");
            // lay account id
            int accountID = acc.getAccID();
            // lay list order theo account id
            List<Order> listOrd = odao.getOrderByOrderIDAndAccountID(id, accountID);
            // set attribute
            request.setAttribute("listOrd", listOrd);
            //chuyen trang
            String status = request.getParameter("status");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate now = LocalDate.now();
            Date today = Date.valueOf(now);
            String tmp = odao.checkRecievedDateByOrderID(id);
            CategoryDAO daoC = new CategoryDAO();
            BookShopDAO daoB = new BookShopDAO();

            List<Category> listC = daoC.getCategoryBook();
            request.setAttribute("listC", listC);
            if (tmp != null) {
                Date recievedDate = Date.valueOf(tmp);

                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();
                c1.setTime(recievedDate);
                c2.setTime(today);
                Long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
                if (noDay <= 5 && status.equals("received")) {
                    request.getRequestDispatcher("cusReasonForm.jsp").forward(request, response);
                } else if (noDay > 5) {
                    request.setAttribute("checkDate", "Refund time expired!!!");
                    request.getRequestDispatcher("cushistoryhome").forward(request, response);
                }
            }
            request.setAttribute("checkstatus", "You can only return products that have status is received");
            request.getRequestDispatcher("cushistoryhome").forward(request, response);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
