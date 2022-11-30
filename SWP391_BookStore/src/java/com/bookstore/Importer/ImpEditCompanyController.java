/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Importer;

import com.bookstore.Company.Company;
import com.bookstore.Company.CompanyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class ImpEditCompanyController extends HttpServlet {

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
            int tempID = Integer.parseInt(request.getParameter("id"));
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String add = request.getParameter("add");
            String phone = request.getParameter("phone");
            String email = request.getParameter("mail");

            CompanyDAO dao = new CompanyDAO();
            Company com1 = dao.extistCompanyNameForChange(name, id);
            Company com2 = dao.extistCompanyPhoneForChange(phone, id);
            Company com3 = dao.extistCompanyEmailForChange(email, id);

            if (com1 != null) {
                request.setAttribute("check", "Name of Publish Company has been duplicated!");
                request.setAttribute("id", id);
                request.getRequestDispatcher("editCompNav").forward(request, response);
            } else if (com2 != null) {
                request.setAttribute("id", id);
                request.setAttribute("check", "Phone of Publish Company has been duplicated!");
                request.getRequestDispatcher("editCompNav").forward(request, response);
            } else if (com3 != null) {
                request.setAttribute("id", id);
                request.setAttribute("check", "Email of Publish Company has been duplicated!");
                request.getRequestDispatcher("editCompNav").forward(request, response);
            }else{
                dao.updateCompany(name, add, phone, email, tempID);
            request.setAttribute("check", "Edit Publish Company successful!");
            request.setAttribute("id", id);
            request.getRequestDispatcher("editCompNav").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImpEditCompanyController.class.getName()).log(Level.SEVERE, null, ex);
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
