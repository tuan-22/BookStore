/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Cart;

import com.bookstore.Book.Book;
import com.bookstore.Book.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Admin
 */
public class CusShoppingPageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //lay action
            String action = request.getParameter("action");
            // goi session
            HttpSession session = request.getSession();
            // new list cart
            List<Cart> cart = new ArrayList<Cart>();
            // goi dao
            BookDAO b = new BookDAO();
            // lay ma sach
            String bookCode = request.getParameter("bookCode");
            // parse ma sach sang long
            long ibookCode = Long.parseLong(bookCode);
            //lay so luong sach co san trong kho
            int quantityBookAvailable = b.getQuantityByBookCode(ibookCode);

            // lay so luong 1 sach trong cart theo vi tri
            //int quantityBookInCart = (int) session.getAttribute("quantityBookInCart");
            if (action.equals("addToCart")) { // them sach vao cart
                if (session.getAttribute("cart") == null) { // add cuon sach dau tien vao cart
                    if (quantityBookAvailable > 0) { // kiem tra sach add vao co qua so luong trong kho khong?
                        cart.add(new Cart(b.getBookBybookCode(request.getParameter("bookCode")), 1));
                    } else {
                        session.setAttribute("checkQuanityAddShop4", "Store has no more quantity of this book left. We apologize for the inconvenience.");
                        request.getRequestDispatcher("cusshopping?index=1").forward(request, response);
                    }
                } else { // add nhung cuon tiep theo
                    cart = (List<Cart>) session.getAttribute("cart");
                    int index = isExisting(ibookCode, cart);
                    if (index == -1) {
                        if (quantityBookAvailable > 0) {
                            cart.add(new Cart(b.getBookBybookCode(request.getParameter("bookCode")), 1));
                        } else {
                            session.setAttribute("checkQuanityAddShop5", "Store has no more quantity of this book left. We apologize for the inconvenience.");
                            request.getRequestDispatcher("cusshopping?index=1").forward(request, response);
                        }
                    } else {
                        int quantityBookInCart = cart.get(index).getQty();
                        if (quantityBookInCart < quantityBookAvailable) {
                            int quantity = cart.get(index).getQty() + 1;
                            cart.get(index).setQty(quantity);
                        } else {
                            request.setAttribute("checkQuanityAddShop6", "Store has no more quantity of this book left. We apologize for the inconvenience.");
                            request.getRequestDispatcher("cusshopping?index=1").forward(request, response);
                        }
                    }
                }
                //tinh discount sach
                for (int i = 0; i < cart.size(); i++) {
                    // lay % discount
                    int discountPercent = b.getDisCountByBookCode(request.getParameter("bookCode"));
                    // lay ma sach
                    Book book = b.getBookBybookCode(request.getParameter("bookCode"));
                    Book book2 = b.getBookBybookCodeV2(request.getParameter("bookCode"));

                    if (discountPercent > 0) {// sach co discount
                        for (Cart c : cart) {
                            if (book.getBookCode() == (book2.getBookCode())) {
                                int tmp = c.getBook().getBuyPrice();
                                int tmp2 = c.getBook().getBuyPrice() * discountPercent / 100;
                                int ibuyPrice = tmp - tmp2;
                                c.setBuyPrice(ibuyPrice);
                                ibuyPrice = +ibuyPrice;
                                session.setAttribute("ibuyPrice", ibuyPrice);
                            }
                        }
                    } else if (discountPercent == 0) { // sach ko discount
                        bookCode = request.getParameter("bookCode");
                        for (Cart c : cart) {
                            if (String.valueOf(c.getBook().getBookCode()).equals(String.valueOf(bookCode))) {
                                int ibuyPrice = c.getBook().getBuyPrice();
                                c.setBuyPrice(ibuyPrice);
                                break;
                            }
                        }
                    }
                }

                // lay tong tien
                int totalPrice = totalPrice(cart);
                session.setAttribute("totalPrice", totalPrice);// set tong tien

                session.setAttribute("cart", cart);
                request.getRequestDispatcher("cusshopping?index=1").forward(request, response);

            } else if (action.equals("remove")) { // xoa sach trong cart
                cart = (List<Cart>) session.getAttribute("cart");
                bookCode = request.getParameter("bookCode");
                for (Cart c : cart) {
                    if (String.valueOf(c.getBook().getBookCode()).equals(String.valueOf(bookCode))) {
                        cart.remove(c);
                        break;
                    }
                }
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).getBook().getDiscountPercent() > 0) {
                        int ibuyPrice = cart.get(i).getBook().getBuyPrice() * cart.get(i).getBook().getDiscountPercent() % 100;
                        cart.get(i).setBuyPrice(ibuyPrice);
                    }
                }
                int totalPrice = totalPrice(cart);
                session.setAttribute("totalPrice", totalPrice);// set tong tien
                session.setAttribute("cart", cart);
                if(cart.isEmpty()){
                    cart=null;
                    session.setAttribute("cart", cart);
                    request.getRequestDispatcher("cusshopping?index=1").forward(request, response);
                }
                request.getRequestDispatcher("cusshopping?index=1").forward(request, response);
            }
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("cusshopping?index=1").forward(request, response);
        }
    }

    private int isExisting(long bookCode, List<Cart> cart) { // kiem tra xem 1 cuon sach co trong cart chua tra ve vi tri
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getBook().getBookCode() == bookCode) {
                return i;
            }
        }
        return -1;
    }

    private int totalPrice(List<Cart> cart) { // tinh tong tien
        int totalPrice = 0;
        for (Cart c : cart) {
            totalPrice += c.getBuyPrice() * c.getQty();
        }
        return totalPrice;
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
