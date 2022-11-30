/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Seller;

import com.bookstore.Order.Order;
import com.bookstore.Order.OrderDAO;
import com.bookstore.OrderDetail.OrderDetail;
import com.bookstore.OrderDetail.OrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tramy
 */
public class SellerUpdateStatusController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String check = request.getParameter("check");
            String orderid = request.getParameter("orderid");

            OrderDAO dao = new OrderDAO();
            boolean retur = false;
            try {
                if(check.equals("received")){
                retur = dao.updateOrderStatusReceived(orderid, check);
                }else if (check.equals("delivering")) {
                 retur =dao.updateOrderStatusNormal(orderid, check);
                }else if (check.equals("delivery fail")) {
                 retur =dao.updateOrderStatusAndAddQty(orderid, check);
                }else if (check.equals("not confirm")){
                    retur=dao.updateOrderStatusAndAddQty(orderid, check);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SellerUpdateStatusController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (retur == true) {

                Order order = dao.getOrderByID(orderid);

                OrderDetailDAO detailDAO = new OrderDetailDAO();
                List<OrderDetail> list = detailDAO.getListDetailByOrder(orderid);
                
                
                request.setAttribute("mess", "Update Status of Order Successfull!");
                request.setAttribute("order", order);
                request.setAttribute("detail", list);
                request.getRequestDispatcher("sellerOrderDetail.jsp").forward(request, response);
            }

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
