/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Customer;

import com.bookstore.Author.Author;
import com.bookstore.Author.AuthorDAO;
import com.bookstore.Book.BookShop;
import com.bookstore.Book.BookShopDAO;
import com.bookstore.Category.Category;
import com.bookstore.Category.CategoryDAO;
import com.bookstore.Feedback.Feedback;
import com.bookstore.Feedback.FeedbackDAO;
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
public class CusDetailController extends HttpServlet {

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
            String bookcode = request.getParameter("pbookCode");
            String categoryBook = request.getParameter("categoryBook");

            BookShopDAO daoB = new BookShopDAO();
            CategoryDAO daoC = new CategoryDAO();
             AuthorDAO authordAO = new AuthorDAO();

            BookShop b = daoB.getBookBybookCode(bookcode);
            
            String code = String.valueOf(b.getBookCode());
            List<Author> listA = authordAO.getListAuthorByBookcode(code);
            
            String plusString = "";
                for (Author a : listA) {
                    plusString = plusString + a.getName() + ",";
                }
                b.setAuthor(plusString);
                
            
            
            List<BookShop> RelatedBook=daoB.getBookByCategoryTop(categoryBook);
            for (BookShop a : RelatedBook) {

            String codeA = String.valueOf(a.getBookCode());
            List<Author> listAA = authordAO.getListAuthorByBookcode(codeA);
            int countNumA = 0;
            String plusStringA = "";
            if (listAA == null) {

            } else if (listAA.size() == 1) {
                a.setAuthor(listAA.get(0).getName());
                countNumA = 1;
                a.setAuthorNum(countNumA);

            } else if (listAA.size() > 1) {
                plusStringA = "";
                for (Author c : listAA) {
                    plusStringA = plusStringA + c.getName() + ",";
                }

                a.setAuthor(plusStringA);
            }
            }
            
            List<Category> listC = daoC.getCategoryBook();
//            List<Book> listRecentArrival = daoB.getRecentBook();
//
//            request.setAttribute("listRecentArrival", listRecentArrival);
            request.setAttribute("listRecentArrival", RelatedBook);
            request.setAttribute("listC", listC);
            request.setAttribute("detailProduct", b);
            FeedbackDAO fdao = new FeedbackDAO();
            List<Feedback> listF = fdao.getFeedbackByBookCode(bookcode);
            request.setAttribute("listF", listF);
            request.getRequestDispatcher("cusproduct.jsp").forward(request, response);
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
