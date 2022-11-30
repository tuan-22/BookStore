/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Customer;

import com.bookstore.Account.Account;
import com.bookstore.Book.BookDAO;
import com.bookstore.Category.Category;
import com.bookstore.Category.CategoryDAO;
import com.bookstore.Order.Order;
import com.bookstore.Order.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
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
public class CusCancelOrderController extends HttpServlet {

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
            CategoryDAO daoC = new CategoryDAO();
            List<Category> listC = daoC.getCategoryBook();
            request.setAttribute("listC", listC);
            OrderDAO odao = new OrderDAO();
            String id = request.getParameter("orderID");
            int orderID = Integer.parseInt(id);
            String status = odao.checkOrderStatus(orderID);
            List<Order> list = odao.getListOrderDetailByOrderID(orderID);
            BookDAO b = new BookDAO();
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            if (action == null) {
                if (status.equals("confirming")) {
                    for (Order o : list) {
                        int detailQuantity = o.getoDetailQty();
                        long bookCode = o.getBookCode();
                        int quanityBookInStore = b.getQuantityByBookCode(bookCode);
                        int quanityBookInStoreAfter = quanityBookInStore + detailQuantity;
                        b.updateQuantityBookByBookCode(quanityBookInStoreAfter, bookCode);
                    }
                    odao.updateOrderStatusByID(orderID);
                    request.setAttribute("checkstatus", "Cancel order success");
                    request.getRequestDispatcher("cusorderhome").forward(request, response);
                } else if (status.equals("received")) {
                    // lay list detail tu ham lay list theo id
                    List<Order> listOrdetail = odao.getOrderDetailByorderID(orderID);
                    // set attribute len
                    request.setAttribute("listOrdetail", listOrdetail);
                    // check account
                    Account acc = (Account) session.getAttribute("acc");
                    // lay account id
                    int accountID = acc.getAccID();
                    // lay history theo order id va account id
                    List<Order> listOrd2 = odao.getOrderByOrderIDAndAccountID(orderID, accountID);
                    // set attribute
                    request.setAttribute("listOrd2", listOrd2);
                    request.getRequestDispatcher("cusReasonForm.jsp").forward(request, response);
                }
            } else if (action.equals("return")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                String requestDate = dtf.format(now);
                String reason = request.getParameter("txtReason");
                odao.updateOrderStatusByIDUpgrade(requestDate, reason, orderID);
                request.setAttribute("wait", "wait");
                request.getRequestDispatcher("cushistoryhome").forward(request, response);

            } else if (action.equals("confirm") && status.equals("delivering")) { // xac nhan da nhan duoc hang
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                String receivedDate = dtf.format(now);
                odao.updateOrderStatusByIDConfirm(receivedDate, orderID);
                request.setAttribute("confirm", "confirm");
                request.getRequestDispatcher("cusorderhome").forward(request, response);
            }
        }
        OrderDAO odao = new OrderDAO();
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        int accountID = acc.getAccID();
        List<Order> listOrd2 = odao.getOrderListByStatus2(accountID);
        request.setAttribute("listOrd2", listOrd2);
        request.getRequestDispatcher("cushistoryhome").forward(request, response);
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
