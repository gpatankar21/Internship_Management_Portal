/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.StudentDAO;
import dto.InternshipApplicationBean;
import dto.StudentBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(maxFileSize = 16177215)
/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/InternshipApplication"})
public class InternshipApplication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String userid=request.getParameter("userid");
        String comp_name=request.getParameter("comp_name");
        String res=request.getParameter("res");
        Part resume=request.getPart("resume");
        PrintWriter pw=response.getWriter();
        pw.println(userid);
        pw.println(comp_name);
        pw.println(res);
        StudentDAO stu=new StudentDAO();
        StudentBean ob=stu.displayStudent(userid);
        InternshipApplicationBean intern=new InternshipApplicationBean();
        
        intern.setComp_name(comp_name);
        intern.setUserid(userid);
        intern.setName(ob.getName());
        intern.setDept(ob.getDept());
        intern.setYear(ob.getYear());
        intern.setEmail(ob.getEmail());
        intern.setSec(ob.getSec());
        intern.setRes(res);
        
        if(resume!=null)
        intern.setResume(resume);
        
        int count=stu.addApplicationDetails(intern);
        if(count==1)
        {
            request.setAttribute("res",(String)"Applied Successfully");
            RequestDispatcher rd=request.getRequestDispatcher("student_home.jsp");
            rd.forward(request,response);
        }
        else
        {
            request.setAttribute("res",(String)"Application failed");
            RequestDispatcher rd=request.getRequestDispatcher("student_home.jsp");
            rd.forward(request,response);
        }
    }

}
