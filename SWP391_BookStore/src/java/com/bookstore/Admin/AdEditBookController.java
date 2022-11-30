/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.Admin;

import com.bookstore.Author.Author;
import com.bookstore.Author.AuthorDAO;
import com.bookstore.Book.BookShopDAO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class AdEditBookController extends HttpServlet {

    /*
     create images folder at, C:\Users\Dharmesh Mourya\Documents\NetBeansProjects\ImageProject\build\web\images
     */
    public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String code = request.getParameter("code");
        String cate = request.getParameter("cate");
        int sell = Integer.parseInt(request.getParameter("sell"));
        String des = request.getParameter("des");
        String author[] = request.getParameterValues("author");
        String save = "";

        for (int i = 0; i < author.length; i++) {
            AuthorDAO dAO = new AuthorDAO();
            dAO.addAuthor(author[i]);
        }

        int authorNum = author.length;

        AuthorDAO dAO = new AuthorDAO();
        List<Author> list = dAO.getAllAuthorDesc();
        int[] temp = new int[authorNum];

        try {

            Part part = request.getPart("image");//
            String fileName = extractFileName(part);//file name

            /**
             * *** Get The Absolute Path Of The Web Application ****
             */
            String applicationPath = getServletContext().getRealPath("");
            String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
            System.out.println("applicationPath:" + applicationPath);
            File fileUploadDirectory = new File(uploadPath);
            if (!fileUploadDirectory.exists()) {
                fileUploadDirectory.mkdirs();
            }
            String savePath = uploadPath + File.separator + fileName;
            String sRootPath = new File(savePath).getAbsolutePath();
            part.write(savePath + File.separator);
            File fileSaveDir1 = new File(savePath);
            /*if you may have more than one files with same name then you can calculate some random characters
         and append that characters in fileName so that it will  make your each image name identical.*/
            dbFileName = UPLOAD_DIR + File.separator + fileName;
            part.write(savePath + File.separator);
            //out.println(id+" "+firstName+" "+lastName+" "+fileName+" "+savePath);
            /*
         You need this loop if you submitted more than one file
         for (Part part : request.getParts()) {
         String fileName = extractFileName(part);
         part.write(savePath + File.separator + fileName);
         }*/
            FileInputStream stream = new FileInputStream(sRootPath);

            // get byte array from image stream
            int bufLength = 2048;
            byte[] buffer = new byte[2048];

            byte[] data;

            ByteArrayOutputStream outc = new ByteArrayOutputStream();
            int readLength;
            while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
                outc.write(buffer, 0, readLength);
            }

            data = outc.toByteArray();

            String imageString = Base64.getEncoder().encodeToString(data);
            save = "data:image/jpeg;base64," + imageString;

        } catch (Exception e) {
        } finally {
            List<Author> listtemp = dAO.getListAuthorByBookcode(code);
            int size = listtemp.size();
            int[] comp = new int[size];
            for (int i = 0; i < size; i++) {
                comp[i] = listtemp.get(i).getCompid();
                dAO.deleteCompose(comp[i]);
            }

            for (int i = 0; i < authorNum; i++) {
                temp[i] = list.get(i).getAuID();

                AuthorDAO authorDAO = new AuthorDAO();
                authorDAO.createCompose(code, temp[i]);
            }

            BookShopDAO dao = new BookShopDAO();
            dao.uploadBookInforVs2(save, sell, des, cate, code);

            request.setAttribute("check", "Edit Book sucessful!");
            request.getRequestDispatcher("adbook").forward(request, response);
        }
    }

    // file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"
    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
