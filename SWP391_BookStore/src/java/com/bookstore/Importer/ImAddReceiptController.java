/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Importer;

import com.bookstore.Book.BookShop;
import com.bookstore.Book.BookShopDAO;
import com.bookstore.Receipt.Receipt;
import com.bookstore.Receipt.ReceiptDAO;
import com.bookstore.Receipt.ReceiptDetail;
import com.bookstore.Receipt.ReceiptDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tramy
 */
public class ImAddReceiptController extends HttpServlet {

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
            String comany = request.getParameter("company");
            String accid = request.getParameter("accid");
            String day = request.getParameter("day");

            String code[] = request.getParameterValues("code");
            String bname[] = request.getParameterValues("bname");
            String qty[] = request.getParameterValues("qty");
            String price[] = request.getParameterValues("price");

            List<ReceiptDetail> list = new ArrayList<>();
            int total = 0;
            for (int i = 0; i < code.length; i++) {
                Long bcode = Long.parseLong(code[i]);
                int quantity = Integer.parseInt(qty[i]);
                int bprice = Integer.parseInt(price[i]);
                int multi = quantity * bprice;
                total = total + multi;
                list.add(new ReceiptDetail(bcode, bname[i], quantity, bprice));
            }

            ReceiptDAO receiptDAO = new ReceiptDAO();
            receiptDAO.createReceipt(accid, day, total, comany);

            List<Receipt> listtem = receiptDAO.getListReceipt();
            int lastCID;
            if (listtem.isEmpty()) {
                lastCID=1;
            }else{
            int sizeList = listtem.size() - 1;
            lastCID = listtem.get(sizeList).getReceiptID();
            }
            for (int i = 0; i < code.length; i++) {
                BookShopDAO dao = new BookShopDAO();
                BookShop book = dao.getBookBybookCodeVS3(code[i]);
                if (book != null) {
                    int currentQty = book.getQty();
                    int quantity = Integer.parseInt(qty[i]);
                    int temp = currentQty + quantity;
                    dao.plusQty(temp, code[i]);
                    ReceiptDetailDAO ddao = new ReceiptDetailDAO();
                    ddao.insertRDetail(code[i],qty[i] , price[i],lastCID );
                } else {
                    BookShopDAO shopDAO = new BookShopDAO();
                    int tempPrice = Integer.parseInt(price[i]);
                    int quantity = Integer.parseInt(qty[i]);
                    shopDAO.insertBook(code[i], bname[i], tempPrice, quantity, comany);
                    ReceiptDetailDAO ddao = new ReceiptDetailDAO();
                    ddao.insertRDetail(code[i],qty[i] , price[i],lastCID );
                }

            }
            request.setAttribute("temptemp", "Add new receipt sucessful!");
            
            request.getRequestDispatcher("listReceipt").forward(request, response);

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
