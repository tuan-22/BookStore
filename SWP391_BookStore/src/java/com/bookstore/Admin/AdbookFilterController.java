/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Admin;

import com.bookstore.Author.Author;
import com.bookstore.Author.AuthorDAO;
import com.bookstore.Book.Book;
import com.bookstore.Book.BookDAO;
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
public class AdbookFilterController extends HttpServlet {

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
            String status = request.getParameter("postid");
            if (status.equals("All")) {
                request.getRequestDispatcher("adbook").forward(request, response);
            }else{
            String check = null;
            check = (String) request.getAttribute("check");
            BookDAO dao = new BookDAO();
            List<Book> list = dao.getBookManagebyStatus(status);
            AuthorDAO authordAO = new AuthorDAO();

            for (Book b : list) {

                String code = String.valueOf(b.getBookCode());
                List<Author> listA = authordAO.getListAuthorByBookcode(code);
                String plusString = "";
                if (listA==null) {
                    
                }else if (listA.size() == 1) {
                    b.setAuthorName(listA.get(0).getName());

                } else if (listA.size() > 1) {
                    plusString = "";
                    for (Author a : listA) {
                        plusString = plusString  + a.getName()+ ",";
                    }
                    b.setAuthorName(plusString);
                }
            }
            request.setAttribute("listB", list);
            request.setAttribute("check", check);
            request.setAttribute("temp", status);

            request.getRequestDispatcher("adBook.jsp").forward(request, response);
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
