/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Importer;

import com.bookstore.Account.Account;
import com.bookstore.Account.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author tramy
 */
public class ImChangeController extends HttpServlet {

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
            String password = request.getParameter("txtCurrentPassword");
            String newpass = request.getParameter("txtNewPassword");
            String confimpass = request.getParameter("txtComfirmPassword");

            //depass
            String depassword = password;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(depassword.getBytes());
            byte[] digest = md.digest();
            String dePass = DatatypeConverter.printHexBinary(digest).toLowerCase();

            HttpSession session = request.getSession();
            Account dto = (Account) session.getAttribute("acc");
            AccountDAO dao = new AccountDAO();
            int accID = dto.getAccID();

            if (dePass.equals(dto.getPassword())) {
                if (newpass.equals(confimpass)) {
                    
                    dao.updatePassword(newpass, accID);
                    Account account=dao.getAccountByID(accID);
                    session.setAttribute("acc", account);
                    request.setAttribute("check", "Password update success!");
                    request.getRequestDispatcher("imChangePass.jsp").forward(request, response);
                } else {
                    request.setAttribute("check", "Confirm password do not match!!!");
                    request.getRequestDispatcher("imChangePass.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("check", "Current password incorrect!!!");
                request.getRequestDispatcher("imChangePass.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImChangeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ImChangeController.class.getName()).log(Level.SEVERE, null, ex);
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
