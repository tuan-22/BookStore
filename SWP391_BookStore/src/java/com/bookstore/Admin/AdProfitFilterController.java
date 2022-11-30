/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Admin;

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
public class AdProfitFilterController extends HttpServlet {

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
            String cate = request.getParameter("cate");
            if (cate.equals("Week")) {
                ProfitDAO dAO = new ProfitDAO();
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
                request.setAttribute("temp", "Week");
                request.setAttribute("date", dayS);
                request.setAttribute("profit", proString);
                request.getRequestDispatcher("adProfit.jsp").forward(request, response);
            } else if (cate.equals("Month")) {
                ProfitDAO dAO = new ProfitDAO();
                List<Return> list = dAO.listOrderMonth();
                List<Profit> tempList = dAO.calculateProfitbyMonth(list);
                String dayS = "";
                String proString = "";
                for (Profit profit : tempList) {
                    String temp = "'" + String.valueOf(profit.getTempDate()) + "',";
                    String tempPro = String.valueOf(profit.getProfitEarn()) + ",";

                    dayS = dayS + temp;
                    proString = proString + tempPro;
                }
                request.setAttribute("temp", "Month");
                request.setAttribute("date", dayS);
                request.setAttribute("profit", proString);
                request.getRequestDispatcher("adProfit.jsp").forward(request, response);
            } else if (cate.equals("Year")) {
                ProfitDAO dAO = new ProfitDAO();
                List<Return> list = dAO.listOrderYear();
                List<Profit> tempList = dAO.calculateProfitbyYear(list);
                String dayS = "";
                String proString = "";
                for (Profit profit : tempList) {
                    String temp = "'" + String.valueOf(profit.getTempDate()) + "',";
                    String tempPro = String.valueOf(profit.getProfitEarn()) + ",";

                    dayS = dayS + temp;
                    proString = proString + tempPro;
                }
                request.setAttribute("temp", "Year");
                request.setAttribute("date", dayS);
                request.setAttribute("profit", proString);
                request.getRequestDispatcher("adProfit.jsp").forward(request, response);
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
