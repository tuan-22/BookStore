/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Seller;

import com.bookstore.Book.Book;
import com.bookstore.Book.BookDAO;
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
 * @author Admin
 */
public class SellerAddBookController extends HttpServlet {

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
            String bookName = request.getParameter("bookName").trim().toLowerCase();
            String image =request.getParameter("image").trim();
            String author = request.getParameter("author").trim();
            String description = request.getParameter("description");
            String buyprice = request.getParameter("buyprice");
            String postName = request.getParameter("postname");         
            BookDAO dao = new BookDAO();
            Book book = dao.existBook(bookName);
            if (book != null) {
                request.setAttribute("mess", "This book is registered!");
                request.getRequestDispatcher("add_books.jsp").forward(request, response);
            }

            if (book == null) {
                try {
                    dao.addNewBook(bookName, image, author, description, buyprice, postName);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(SellerAddBookController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("displaybook").forward(request, response);
            }

        }

        /*
        public Book(long bookCode, String bookName, String image, String author, String companyName, int qty, String description, int importPrice, int buyPrice, String postName) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.image = image;
        this.importPrice = importPrice;
        this.buyPrice = buyPrice;
        this.description = description;
        this.qty = qty;
        this.companyName = companyName;
        this.author = author;
        this.postName = postName;
    }
         */
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
