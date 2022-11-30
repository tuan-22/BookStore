/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Customer;

import com.bookstore.Author.Author;
import com.bookstore.Author.AuthorDAO;
import com.bookstore.Book.Book;
import com.bookstore.Book.BookDAO;
import com.bookstore.Book.BookShop;
import com.bookstore.Book.BookShopDAO;
import com.bookstore.Category.Category;
import com.bookstore.Category.CategoryDAO;
import com.bookstore.Discount.Discount;
import com.bookstore.Discount.DiscountDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CusShoppingController extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */
        //url: shopping

        String price = request.getParameter("price");
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        if (price != null) {
//            String indexString = request.getParameter("index");
            
            String[] list = request.getParameter("categories").split("-");
            List<String> listCategory2 = new ArrayList<>();
            listCategory2.add("Art - Literary");
            listCategory2.add("Comics");
            listCategory2.add("Textbook - Syllabus");
            listCategory2.add("Novel");
            listCategory2.add("Foreign language");
            listCategory2.add("Science");
            listCategory2.add("Horror");
            BookShopDAO dao = new BookShopDAO();
//            int pageSize = 8;
            

            for (int i = 0; i < list.length; i++) {
                if (list[i].equalsIgnoreCase("false")) {
                    listCategory2.set(i, null);
                }
            }
            listCategory2.removeIf(n -> (n == null));
            List<BookShop> result = new ArrayList<>();
            int count;
            switch (listCategory2.size()) {
                case 1:
//                    count = dao.countFilter(listCategory2.get(0), price);
//                    endPage = count / pageSize;
//                    if (count % pageSize != 0) {
//                        endPage++;
//                    }
                    result = dao.getBookFilter(price, listCategory2.get(0));
                    break;
                case 2:
//                    count = dao.countFilter(listCategory2.get(0), price) + dao.countFilter(listCategory2.get(1), price);
//                    endPage = count / pageSize;
//                    if (count % pageSize != 0) {
//                        endPage++;
//                    }
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(0)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(1)));
                    break;
                case 3:
//                    count = dao.countFilter(listCategory2.get(0), price)
//                            + dao.countFilter(listCategory2.get(1), price)
//                            + dao.countFilter(listCategory2.get(2), price);
//                    endPage = count / pageSize;
//                    if (count % pageSize != 0) {
//                        endPage++;
//                    }
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(0)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(1)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(2)));
                    break;
                case 4:
//                    count = dao.countFilter(listCategory2.get(0), price)
//                            + dao.countFilter(listCategory2.get(1), price)
//                            + dao.countFilter(listCategory2.get(2), price)
//                            + dao.countFilter(listCategory2.get(3), price);
//                    endPage = count / pageSize;
//                    if (count % pageSize != 0) {
//                        endPage++;
//                    }
                    result.addAll(dao.getBookFilter(price, listCategory2.get(0)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(1)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(2)));
                    result.addAll(dao.getBookFilter(price, listCategory2.get(3)));
                    break;
                case 5:
//                    count = dao.countFilter(listCategory2.get(0), price)
//                            + dao.countFilter(listCategory2.get(1), price)
//                            + dao.countFilter(listCategory2.get(2), price)
//                            + dao.countFilter(listCategory2.get(3), price)
//                            + dao.countFilter(listCategory2.get(4), price);
//                    endPage = count / pageSize;
//                    if (count % pageSize != 0) {
//                        endPage++;
//                    }
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(0)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(1)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(2)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(3)));
                    result.addAll(dao.getBookFilter(price, listCategory2.get(4)));
                    break;
                case 6:
//                    count = dao.countFilter(listCategory2.get(0), price)
//                            + dao.countFilter(listCategory2.get(1), price)
//                            + dao.countFilter(listCategory2.get(2), price)
//                            + dao.countFilter(listCategory2.get(3), price)
//                            + dao.countFilter(listCategory2.get(4), price)
//                            + dao.countFilter(listCategory2.get(5), price);
//                    endPage = count / pageSize;
//                    if (count % pageSize != 0) {
//                        endPage++;
//                    }
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(0)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(1)));
                    result.addAll(dao.getBookFilter(price, listCategory2.get(2)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(3)));
                    result.addAll(dao.getBookFilter(price, listCategory2.get(4)));
                    result.addAll(dao.getBookFilter(price, listCategory2.get(5)));
                    break;
                case 7:
//                    count = dao.countFilter(listCategory2.get(0), price)
//                            + dao.countFilter(listCategory2.get(1), price)
//                            + dao.countFilter(listCategory2.get(2), price)
//                            + dao.countFilter(listCategory2.get(3), price)
//                            + dao.countFilter(listCategory2.get(4), price)
//                            + dao.countFilter(listCategory2.get(5), price)
//                            + dao.countFilter(listCategory2.get(6), price);
//                    endPage = count / pageSize;
//                    if (count % pageSize != 0) {
//                        endPage++;
//                    }
                    result.addAll(dao.getBookFilter(price, listCategory2.get(0)));
                    result.addAll(dao.getBookFilter(price, listCategory2.get(1)));
                    result.addAll(dao.getBookFilter(price, listCategory2.get(2)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(3)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(4)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(5)));
                    result.addAll(dao.getBookFilter(price,  listCategory2.get(6)));
                    break;
                default:
            }
            AuthorDAO authordAO = new AuthorDAO();
            for (BookShop b : result) {
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
                List<Discount> listDiscount = dAO.getDiscountByBookCode(codeB);
                if (listDiscount.size() > 0) {
                    b.setDiscountPercent(listDiscount.get(0).getPercent());
                }
            }
            CategoryDAO daoC = new CategoryDAO();
            List<Category> listC = daoC.getCategoryBook();
            String employeeJsonString = gson.toJson(result);
            out.print(employeeJsonString);
            out.flush(); 
//            for (BookShop o : result) {
//                out.println("<div class=\"col-6 col-md-4 col-lg-4 col-xl-3\">\n"
//                        + "                                        <div class=\"product\">\n"
//                        + "                                            <figure class=\"product-media\">\n"
//                        + "                                                 <c:if test=\"" + o.getDiscountPercent() + "\">\n"
//                        + "                                                    <span class=\"product-label label-new\">Discount</span>\n"
//                        + "                                                </c:if>\n"
//                        + "                                                <a href=\"detail?pbookCode=" + o.getBookCode() + "&categoryBook=" + o.getCateName() + "\">\n"
//                        + "                                                    <img style=\"width: 	277px; height: 	375px;\" src=\"" + o.getImage()+ "\" alt=\"Product image\" class=\"product-image\">\n"
//                        + "                                                </a>\n"
//                        + "                                                <div class=\"product-action\">\n"
//                        + "                                                    <a href=\"#\" class=\"btn-product btn-cart\"><span>Add to Cart</span></a>\n"
//                        + "                                                </div>\n"
//                        + "                                            </figure>\n"
//                        + "\n"
//                        + "                                            <div class=\"product-body\">\n"
//                        + "                                                <div class=\"product-cat\">\n"
//                        + "                                                    <a href=\"\">" + o.getCateName() + "</a>\n"
//                        + "                                                </div><!-- End .product-cat -->\n"
//                        + "                                                <h3 class=\"product-title\"><a href=\"detail?pbookCode=" + o.getBookCode() + "&categoryBook=" + o.getCateName() + "\">" + o.getBookName() + "</a></h3><!-- End .product-title -->\n"
//                        + "                                                    <c:if test=\"${listAll.discountPercent == 0}\">\n"
//                        + "                                                    <div class=\"product-price\">\n"
//                        + "                                                        Price <fmt:formatNumber value=\"${listAll.buyPrice}\" pattern=\" #,##0 VND\" />\n"
//                        + "\n"
//                        + "                                                    </div>\n"
//                        + "                                                </c:if>\n"
//                        + "                                                <c:if test=\"" + o.getAuthor()+ "\">\n"
//                        + "                                                    <div class=\"product-price\" style=\"text-decoration: line-through\">\n"
//                        + "                                                        Old Price: <fmt:formatNumber value=\"" + o.getBuyPrice() + " pattern=\" #,##0 VND\" />\n"
//                        + "                                                    </div>\n"
//                        + "                                                    <div class=\"product-price\">\n"
//                        + "                                                        Sale Price: <fmt:formatNumber value=\"" + o.getBuyPrice()  + "\" pattern=\" #,##0 VND\" />\n"
//                        + "                                                    </div>\n"
//                        + "                                                </c:if>\n"
//                        + "\n"
//                        + "                                                <div class=\"product-author\">\n"
//                        + "                                                    Author: \n"
//                        + "                                                    <c:if test=\"" + o.getAuthorNum() == 1 + "\">\n"
//                        + "                                                        ${listAll.author}\n"
//                        + "                                                    </c:if>\n"
//                        + "                                                    <c:if test=\"" + o.getDiscountPercent() + "\">\n"
//                        + "\n"
//                        + "                                                        <div class=\"product\">\n"
//                        + "                                                            <c:forTokens var=\"token\" items=\"" + o.getAuthor() + "\" delims=\",\">\n"
//                        + "                                                                <li><c:out value=\"${token}\"/></li>\n"
//                        + "                                                                </c:forTokens>\n"
//                        + "\n"
//                        + "                                                        </div>\n"
//                        + "                                                    </c:if>\n"
//                        + "                                                </div>\n"
//                        + "                                            </div>\n"
//                        + "                                        </div>\n"
//                        + "                                    </div>");
//            }
//            request.setAttribute("listAll", result);
//            request.setAttribute("endPage", endPage);
//            request.setAttribute("listC", listC);
//            request.getRequestDispatcher("filter.jsp").forward(request, response);
        }else {
            String indexString = request.getParameter("index");
            int index = Integer.parseInt(indexString);
            BookShopDAO dao = new BookShopDAO();
            BookDAO daoB = new BookDAO();
            int count = daoB.countAllBook();
            int pageSize = 8;
            int endPage = 0;
            endPage = count / pageSize;
            if (count % pageSize != 0) {
                endPage++;
            }

            AuthorDAO authordAO = new AuthorDAO();
//        List<Author> listA = authordAO.getListAuthor();

            CategoryDAO daoC = new CategoryDAO();
            List<BookShop> listAll = dao.getAllBook(index, pageSize);
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
//        request.setAttribute("listAuthor", listA);
            request.setAttribute("listC", listC);
            request.setAttribute("endPage", endPage);
            request.getRequestDispatcher("cusShopping.jsp").forward(request, response);
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
