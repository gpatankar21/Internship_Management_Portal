/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AdminDAO;
import dao.FacultyDAO;
import dao.HodDAO;
import dto.InternshipDetailsBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/rejectDetails"})
public class rejectDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html;charset=UTF-8");
     
        
        String eno=request.getParameter("eno");
        String session=request.getParameter("session");
        String user=request.getParameter("user");
        String type=request.getParameter("type");
        FacultyDAO fac=new FacultyDAO();
        AdminDAO admin=new AdminDAO();
        
    if(user.equals("admin"))
     {
            int res=admin.rejectInternshipDetails(eno,session);
            if(res==1)
        {
            int res1=admin.notificationUpdate(eno);
            if(res1==1)
            {
            request.setAttribute("res",(String)"Record Rejected");
            RequestDispatcher rd=request.getRequestDispatcher("admin_home.jsp");
            rd.forward(request,response);
            }
            else
            {
            RequestDispatcher rd=request.getRequestDispatcher("admin_home.jsp");
            rd.forward(request,response);
            }
        }
     }
    else if(user.equals("fac"))
      {
          
        int res=fac.rejectInternshipDetails(eno,session);
        if(res==1)
        {
            int res1=fac.notificationUpdate(eno);
            if(res1==1)
            {
                if(type.equals("ver"))
                {
            request.setAttribute("res",(String)"Record Rejected");
            RequestDispatcher rd=request.getRequestDispatcher("verified_student.jsp");
            rd.forward(request,response);
                }
                else if(type.equals("unv"))
                {
            request.setAttribute("res",(String)"Record Rejected");
            RequestDispatcher rd=request.getRequestDispatcher("unverified_student.jsp");
            rd.forward(request,response);
                }    
            }
            else
            {
            if(type.equals("ver"))
                {
            
            RequestDispatcher rd=request.getRequestDispatcher("verified_student.jsp");
            rd.forward(request,response);
                }
                else if(type.equals("unv"))
                {
            
            RequestDispatcher rd=request.getRequestDispatcher("unverified_student.jsp");
            rd.forward(request,response);
                }
            }
        }
    }
    else
    {
        HodDAO hod=new HodDAO();
        int res=hod.rejectInternshipDetails(eno, session);
        if(res==1)
        {
        request.setAttribute("res",(String)"Record Rejected");
        RequestDispatcher rd=request.getRequestDispatcher("hod_home.jsp");
        rd.forward(request,response);
        }
        else
        {
        request.setAttribute("res",(String)"Record could not be Rejected");
        RequestDispatcher rd=request.getRequestDispatcher("hod_home.jsp");
        rd.forward(request,response);    
        }
    }
    }
    }




    

