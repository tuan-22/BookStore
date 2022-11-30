/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Customer;

import com.bookstore.Account.Account;
import com.bookstore.Account.AccountDAO;
import com.bookstore.Category.Category;
import com.bookstore.Category.CategoryDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CusEditProfileController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            CategoryDAO daoC = new CategoryDAO();
            List<Category> listC = daoC.getCategoryBook();
            request.setAttribute("listC", listC);
            String username = request.getParameter("txtUserName");
            String phone = request.getParameter("txtPhoneNumber");
            HttpSession session = request.getSession();
            Account dto = (Account) session.getAttribute("acc");
            AccountDAO dao = new AccountDAO();
            int accID = dto.getAccID();
            String email = dto.getEmail();
            if (dao.existUsername(username) == null || username.equals(dto.getUsername())) {
                if (dao.existPhoneNumber(phone) == null || phone.equals(dto.getPhone()) ) {
                    dto.setUsername(username);
                    dto.setPhone(phone);
                    dao.updateAccountDetails(username, email, phone, accID);
                    session.setAttribute("acc", dto);
                    request.setAttribute("check", "UPDATE SUCCESS");
                    request.getRequestDispatcher("cusEditProfile.jsp").forward(request, response);
                } else {
                    request.setAttribute("check","The phone numer is already used!!!");
                    request.getRequestDispatcher("cusEditProfile.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("check","The user name is already used!!!");
                request.getRequestDispatcher("cusEditProfile.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CusEditProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(CusEditProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
