/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Customer;

import com.bookstore.Author.Author;
import com.bookstore.Author.AuthorDAO;
import com.bookstore.Book.BookDAO;
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
 * @author tramy
 */
public class CusSearchController extends HttpServlet {

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
            String searchKey = request.getParameter("searchKey");
        String indexString = request.getParameter("index");
        int index = Integer.parseInt(indexString);

        CategoryDAO daoC = new CategoryDAO();
        BookDAO daoB = new BookDAO();

        int count = daoB.count(searchKey);
        int pageSize = 8;
        int endPage = 0;
        endPage = count / pageSize;
        if (count % pageSize != 0) {
            endPage++;
        }

        List<Category> listC = daoC.getCategoryBook();
        BookShopDAO dao = new BookShopDAO();
        AuthorDAO authordAO = new AuthorDAO();
        List<BookShop> list = dao.SearchBook(searchKey, index, pageSize);

        if (list != null) {
            for (BookShop b : list) {

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
                List<Discount> listD = dAO.getDiscountByBookCode(codeB);
                if (listD.size() > 0) {
                    b.setDiscountPercent(listD.get(0).getPercent());
                }
            }
            request.setAttribute("listAll", list);
            request.setAttribute("endPage", endPage);
            request.setAttribute("searchKey", searchKey);
            request.setAttribute("listC", listC);
            request.getRequestDispatcher("cusShopping.jsp").forward(request, response);

        } else {

            request.setAttribute("nullProduct", list);
            request.getRequestDispatcher("cusShopping.jsp").forward(request, response);
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
