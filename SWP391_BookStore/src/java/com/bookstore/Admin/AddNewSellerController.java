/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Admin;

import com.bookstore.Account.Account;
import com.bookstore.Account.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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
public class AddNewSellerController extends HttpServlet {

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
            
            AccountDAO dao = new AccountDAO();
            
            
            String email = request.getParameter("email").trim().toLowerCase();
            String role = request.getParameter("rolename").trim().toLowerCase();
            String phone = request.getParameter("phone").trim();
            String username = request.getParameter("username").trim();
            Account account = dao.existMail(email);
            Account account1 = dao.existUsername(username);
            if (account != null) {
                request.setAttribute("mess", "This email is registered!");
                
                    request.getRequestDispatcher("addsellernav").forward(request, response);
            }
            
            if (account1 != null) {
                request.setAttribute("mess", "This username already existed!");
                
                    request.getRequestDispatcher("addsellernav").forward(request, response);
            }
            if (account==null&&account1==null) {
                try {
                dao.addNewAccount(username, phone, email, "2");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AddNewImpController.class.getName()).log(Level.SEVERE, null, ex);
            }
                request.setAttribute("check", "Add new seller account sucessful!");
            request.getRequestDispatcher("adseller").forward(request, response);
            
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
