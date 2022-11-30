/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.Author.Author;
import com.bookstore.Author.AuthorDAO;
import com.bookstore.Book.Book;
import com.bookstore.Book.BookShop;
import com.bookstore.Book.BookShopDAO;
import com.bookstore.Category.Category;
import com.bookstore.Category.CategoryDAO;
import com.bookstore.Discount.Discount;
import com.bookstore.Discount.DiscountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CategoryController extends HttpServlet {

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
            String categoryName = request.getParameter("categoryName").trim();
            CategoryDAO daoC = new CategoryDAO();
            AuthorDAO authordAO = new AuthorDAO();

            BookShopDAO dao = new BookShopDAO();
            List<BookShop> listAll = dao.getBookByCategory(categoryName);
            for (BookShop b : listAll) {

                String code = String.valueOf(b.getBookCode());
                List<Author> listA = authordAO.getListAuthorByBookcode(code);
                int countNum = 0;
                String plusString = "";
                if (listA == null) {

                } else if (listA.size() == 1) {
                    b.setAuthor(listA.get(0).getName());
                    countNum = 1;
                    b.setAuthorNum(countNum);

                } else if (listA.size() > 1) {
                    plusString = "";
                    for (Author a : listA) {
                        plusString = plusString + a.getName() + ",";
                    }

                    b.setAuthor(plusString);
                }

                String codeB = String.valueOf(b.getBookCode());
                DiscountDAO dAO = new DiscountDAO();
                List<Discount> list = dAO.getDiscountByBookCode(codeB);
                if (list.size() > 0) {
                    b.setDiscountPercent(list.get(0).getPercent());
                }
            }

            List<Category> listC = daoC.getCategoryBook();

            request.setAttribute("listAll", listAll);
            request.setAttribute("listC", listC);
            // listAll vì sort bằng category ở trong shopping
            request.getRequestDispatcher("shopping.jsp").forward(request, response);

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
