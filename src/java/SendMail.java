/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/SendMail"})
public class SendMail extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AdminDAO admin=new AdminDAO();
        String recepient=request.getParameter("recepient");
        String message=request.getParameter("message");
        String sub=request.getParameter("subject");
        
        admin.sendMail(recepient, message, sub);
        
            request.setAttribute("res",(String)"Mail Sent Successfully");
            RequestDispatcher rd=request.getRequestDispatcher("admin_home.jsp");
            rd.forward(request,response);
           
        }

    }

        


