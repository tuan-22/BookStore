/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Cart;

import com.bookstore.Account.Account;
import com.bookstore.Book.BookDAO;
import com.bookstore.Order.Order;
import com.bookstore.Order.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class CheckOutController extends HttpServlet {

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

            OrderDAO odao = new OrderDAO();
            List<Order> list = odao.getOrderManage();
            getLastOrderID(list);

            int orderID = getLastOrderID(list);

            HttpSession session = request.getSession();

            Account account = (Account) session.getAttribute("acc");
            int accountID = account.getAccID();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String orderDate = dtf.format(now);

            String address =(String) session.getAttribute("tempAddress");

            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
            int total = totalPrice(cart);

            String note = (String) session.getAttribute("tempNote");
            if (note.equals("")) {
                note = "(empty)";
            }

            String status = "confirming";

            odao.addNewOrder(orderID, accountID, orderDate, address, total, note, status);

            for (Cart c : cart) {
                // lay id tiep theo trong orderDetail
                List<Order> list2 = odao.getOrderDetailManage();
                // gan id
                int oDetailID = getLastOrderDetailID(list2);
                // lay ma sach
                long bookCode = c.getBook().getBookCode();
                // lay quantity cua 1 quyen sach trong cart
                int oDetailQty = c.getQty();
                // lay gia sach
                int buyPrice = c.getBuyPrice();
                // sach chua dc danh gia
                String statusFeed = "not yet";
                //lay so luong 1 quyen sach trong cart
                int quantityBookInCart = c.getQty();
                //goi book dao
                BookDAO bdao = new BookDAO();
                //lay so luong sach co san trong kho
                int quanityBookAvailable = bdao.getQuantityByBookCode(bookCode);
                //tinh so luong sach con lai trong kho sau khi thanh toan
                int quanityBookAvailableAfter = quanityBookAvailable - quantityBookInCart;
                //cap nhat so luong quyen sach do trong kho
                bdao.updateQuantityBookByBookCode(quanityBookAvailableAfter, bookCode);
                // in hoa don xuong database
                odao.addNewOrderDetail(oDetailID, bookCode, oDetailQty, buyPrice, orderID, statusFeed);
            }
            // lam rong cart
            cart = null;
            // set cart lai
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("cusorderhome").forward(request, response);
        }
    }

    private int totalPrice(List<Cart> cart) { // tinh tong tien
        int totalPrice = 0;
        for (Cart c : cart) {
            totalPrice += c.getBuyPrice() * c.getQty();
        }
        return totalPrice;
    }

    private int getLastOrderID(List<Order> list) {
        if (list.size() > 0) {
            int lastOrderID;
            int sizeList = list.size() - 1;
            lastOrderID = (int) (list.get(sizeList).getOrderID() + 1);
            return lastOrderID;
        }
        return 1;
    }

    private int getLastOrderDetailID(List<Order> list2) {
        if (list2.size() > 0) {
            int lastOrderDetailID;
            int sizeList2 = list2.size() - 1;
            lastOrderDetailID = (int) (list2.get(sizeList2).getoDetailID() + 1);
            return lastOrderDetailID;
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
            Logger.getLogger(CheckOutController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CheckOutController.class.getName()).log(Level.SEVERE, null, ex);
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
