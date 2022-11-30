/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.VerifyLogin;

import com.bookstore.VerifyEmail.UserVerify;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author tramy
 */
public class SendMailLogin {
    public String getRandome() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        return String.format("%06d", number);
    }

    public boolean sendEmail(UserVerifyLogin user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "myntthe163364@fpt.edu.vn";
        String password = "TramyMynguyen290402";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

    		//set from email address
            mess.setFrom(new InternetAddress(fromEmail));
    		//set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
    		
    		//set email subject
            mess.setSubject("User Email Verification");
            
    		//set message text
            mess.setText("Please verify your account by using this code: " + user.getCode());
            //send the message
            Transport.send(mess);
            
            test=true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
    public boolean sendEmailForResetPass(UserVerifyLogin user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "myntthe163364@fpt.edu.vn";
        String password = "TramyMynguyen290402";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

    		//set from email address
            mess.setFrom(new InternetAddress(fromEmail));
    		//set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
    		
    		//set email subject
            mess.setSubject("User Email Verification");
            
    		//set message text
            mess.setText("This is code for reset password. Please verify your account by using this code: " + user.getCode());
            //send the message
            Transport.send(mess);
            
            test=true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}
