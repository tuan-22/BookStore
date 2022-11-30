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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tramy
 */
public class ImCreateComController extends HttpServlet {

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
            String name = request.getParameter("name");
            String add = request.getParameter("add");
            String phone = request.getParameter("phone");
            String email = request.getParameter("mail");
            
            CompanyDAO dao = new CompanyDAO();
            Company com1 = dao.extistCompanyName(name);
            Company com2 = dao.extistCompanyPhone(phone);
            Company com3 = dao.extistCompanyEmail(email);

            if (com1 != null) {
                request.setAttribute("check", "Name of Publish Company has been duplicated!");
                request.getRequestDispatcher("imCreatCom").forward(request, response);
            } else if (com2 != null) {
                request.setAttribute("check", "Phone of Publish Company has been duplicated!");
                request.getRequestDispatcher("imCreatCom").forward(request, response);
            } else if (com3 != null) {
                request.setAttribute("check", "Email of Publish Company has been duplicated!");
                request.getRequestDispatcher("imCreatCom").forward(request, response);
            }else{
                dao.insertCompany(name, add, phone, email);
            request.setAttribute("check", "Create Publish Company successful!");
            request.getRequestDispatcher("pcompany").forward(request, response);
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
