<%-- 
    Document   : admin_view_students
    Created on : 8 Jan, 2019, 1:46:04 PM
    Author     : Dimple Sharma
--%>

<%@page import="java.util.List"%>
<%@page import="dao.AdminDAO"%>
<%@page import="dto.InternshipApplicationBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="admin_nav.jsp" %>
<center><h1 style="padding-top: 10px;"><b>View Students</b></h1></center>
<div class="container ">
    
    <%
        InternshipApplicationBean intern=new InternshipApplicationBean();
        AdminDAO admin=new AdminDAO();
        List<InternshipApplicationBean> application_list=admin.getApplicationDetails();        
    %>
    <div class="col-12 col-sm-10 offset-sm-1 " style="padding-bottom: 50px;">
            <center><table class="table table-bordered table-hover ">
            <thead class="thead-dark">
                <tr>
                    <th>Student E.no.</th>
                    <th>Student Name</th>
                    <th>Student Department</th>
                    <th>Current Year</th>
                    <th>Section</th>
                    <th>Company Name</th>
                    <th>Student Response</th>
                    <th>Student Resume</th>
                </tr>
            </thead>
            <tbody id="loop">
                                      <%  
                        for (InternshipApplicationBean intern_application : application_list)
                        { 
                            if(intern_application!=null)
                            {
                                String userid=intern_application.getUserid();
                                String comp_name=intern_application.getComp_name();
                        %>
                <tr class="list">
                    
                    <td><%out.println(intern_application.getUserid());%></td>
                    <td><%out.println(intern_application.getName());%></td>
                    <td><%out.println(intern_application.getDept());%></td>
                    <td><%out.println(intern_application.getYear());%></td>
                    <td><%out.println(intern_application.getSec());%></td>
                    <td><%out.println(intern_application.getComp_name());%></td>
                    <td><%out.println(intern_application.getRes());%></td>
                    <td><a href="DisplayResume?userid=<%=userid%>&comp_name=<%=comp_name%>"><img src="DisplayResume?userid=<%=userid%>&comp_name=<%=comp_name%>" height="60" width="60"></a></td>
                </tr>
                <%
                            }
                        }
                %>
            </tbody>
                </table></center>
                    <nav>
                        <ul class="pagination">
                            <li id="previous" class="page-item disabled">
                                <a class="page-link" href="javascript:void(0)" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </ul>
                    </nav>            
        
    </div>
    
</div>

    <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="js/style.js" type="text/javascript"></script>

<%@include file = "footer.jsp"%>
