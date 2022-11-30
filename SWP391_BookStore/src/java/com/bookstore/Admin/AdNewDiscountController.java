/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Admin;

import com.bookstore.Discount.Discount;
import com.bookstore.Discount.DiscountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AdNewDiscountController extends HttpServlet {

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

            String bookcode = request.getParameter("name").trim();
        String percent = request.getParameter("percent").trim();
        String a = request.getParameter("date").trim();
        String[] array = a.split("-");
        String start = array[0].trim();
        String end = array[1].trim();
        java.util.Date dStart = null;
        java.util.Date dEnd = null;
        SimpleDateFormat fm = new SimpleDateFormat("MM/dd/yyyy");
        try {
            dStart = fm.parse(start);
            dEnd = fm.parse(end);
        } catch (ParseException ex) {
            Logger.getLogger(AdNewDiscountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        long startD = dStart.getTime();
        long endD = dEnd.getTime();

        DiscountDAO dAO = new DiscountDAO();
        List<Discount> list = dAO.getDiscountBycode(bookcode);
        java.util.Date date = new java.util.Date();
        long now = date.getTime();

        if (now - startD >= 0 || now - endD >= 0) {
            request.setAttribute("mess", "Discount period must start after the current date . Please input another period!");
            request.getRequestDispatcher("addiscountnav").forward(request, response);
        }

        if (list != null) {
            for (Discount discount : list) {
                long temStart = discount.getStartDate().getTime();
                long tempEnd = discount.getEndDate().getTime();

                boolean check1 = false;
                boolean check2 = false;

                if (temStart - startD > 0 && temStart - endD > 0) {
                    check1 = false;
                } else {
                    check1 = true;
                }
                if (startD - tempEnd > 0 && endD - tempEnd > 0) {
                    check1 = false;
                } else {
                    check1 = true;
                }
//                if (temStart - endD < 0 || startD - tempEnd < 0) {
//                    request.setAttribute("mess", "This book is having discount period from " + discount.getStartDate() + "to " + discount.getEndDate() + " . Please input another period!");
//                    request.getRequestDispatcher("addiscountnav").forward(request, response);
//
//                } else if (temStart -startD <0 && endD-tempEnd<0) {
//                        request.setAttribute("mess", "This book is having discount period from " + discount.getStartDate() + "to " + discount.getEndDate() + " . Please input another period!");
//                        request.getRequestDispatcher("addiscountnav").forward(request, response);
//                }else if (startD-temStart<0 && tempEnd-endD<0) {
//                        request.setAttribute("mess", "This book is having discount period from " + discount.getStartDate() + "to " + discount.getEndDate() + " . Please input another period!");
//                        request.getRequestDispatcher("addiscountnav").forward(request, response);
//                }

                if (check1) {
                    request.setAttribute("mess", "This book is having discount period from " + discount.getStartDate() + "to " + discount.getEndDate() + " . Please input another period!");
                    request.getRequestDispatcher("addiscountnav").forward(request, response);
                } else if (check2) {
                    request.setAttribute("mess", "This book is having discount period from " + discount.getStartDate() + "to " + discount.getEndDate() + " . Please input another period!");
                    request.getRequestDispatcher("addiscountnav").forward(request, response);
                }

            }
        }

            dAO.addNewDis(bookcode, start, end, percent);
            request.setAttribute("check", "Add new discount successful!");
            request.getRequestDispatcher("addiscount").forward(request, response);
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
