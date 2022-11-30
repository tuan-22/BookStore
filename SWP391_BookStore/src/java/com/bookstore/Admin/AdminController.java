/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Admin;

import com.bookstore.Account.Account;
import com.bookstore.Account.AccountDAO;
import com.bookstore.Book.BookDAO;
import com.bookstore.Book.BookDashboard;
import com.bookstore.Book.BookShop;
import com.bookstore.Book.BookShopDAO;
import com.bookstore.Discount.Discount;
import com.bookstore.Discount.DiscountDAO;
import com.bookstore.Order.Return;
import com.bookstore.Profit.Profit;
import com.bookstore.Profit.ProfitDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tramy
 */
public class AdminController extends HttpServlet {

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
            ProfitDAO dAO = new ProfitDAO();

            Profit porfit = dAO.totalProfit();
            int total = porfit.getProfitEarn();

            AccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.countAccount();
            int acc = account.getAccID();

            BookDAO bdao = new BookDAO();
            BookShop bookShop = bdao.countBook();
            int book = (int) bookShop.getBookCode();

            DiscountDAO discountDAO = new DiscountDAO();
            Discount discount = discountDAO.countDiscount();
            int dis = discount.getDiscountID();

            BookShopDAO bookShopDAO = new BookShopDAO();
            List<BookDashboard> bookdashboard = bookShopDAO.getBookDashboards();

            String nameBook = "";
            String qty = "";
            for (BookDashboard profit : bookdashboard) {
                String temp = "'" + String.valueOf(profit.getBook()) + "',";
                String tempPro = String.valueOf(profit.getQty()) + ",";

                nameBook = nameBook + temp;
                qty = qty + tempPro;
            }
            
            

            List<Discount> discountsChart = discountDAO.getDiscountDashboards();
            String nameDiscount = "";
            String qtyDiscount = "";
            for (Discount profit : discountsChart) {
                String temp = "'" + String.valueOf(profit.getStatus()) + "',";
                String tempPro = String.valueOf(profit.getDiscountID()) + ",";

                nameDiscount = nameDiscount + temp;
                qtyDiscount = qtyDiscount + tempPro;
            }
            
            
                List<Return> list = dAO.listOrder();
                List<Profit> tempList = dAO.calculateProfit(list);
                String dayS = "";
                String proString = "";
                for (Profit profit : tempList) {
                    String temp = "'" + String.valueOf(profit.getTempDate()) + "',";
                    String tempPro = String.valueOf(profit.getProfitEarn()) + ",";

                    dayS = dayS + temp;
                    proString = proString + tempPro;
                }
                request.setAttribute("date", dayS);
                request.setAttribute("profit", proString);

            request.setAttribute("total", total);
            request.setAttribute("customer", acc);
            request.setAttribute("book", book);
            request.setAttribute("discount", dis);
            request.setAttribute("nameBook", nameBook);
            request.setAttribute("qty", qty);
            request.setAttribute("nameDiscount", nameDiscount);
            request.setAttribute("qtyDiscount", qtyDiscount);

            request.getRequestDispatcher("adHome.jsp").forward(request, response);
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
