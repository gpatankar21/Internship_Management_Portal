/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/feedback"})
public class feedback extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session=request.getSession();
        PrintWriter pw=response.getWriter();
        String feedback=request.getParameter("feedback");
        String userid=(String)session.getAttribute("userid");
        
        StudentDAO stu=new StudentDAO();
       int res=stu.setFeedback(userid,feedback);
        if(res==1)
        {
            request.setAttribute("res",(String)"Feedback Recorded Successfully");
            RequestDispatcher rd=request.getRequestDispatcher("student_home.jsp");
            rd.forward(request,response);
        }
        else
        {
            RequestDispatcher rd=request.getRequestDispatcher("student_home.jsp");
            rd.forward(request,response);
        }
            }

}
