<%-- 
    Document   : view_comp_details_hod
    Created on : 28 Jan, 2019, 11:14:06 PM
    Author     : GAGAN
--%><%-- 
    Document   : view_comp_details_admin
    Created on : Jan 8, 2019, 1:13:25 PM
    Author     : HP
--%>

<%@page import="dao.AdminDAO"%>
<%@page import="java.util.List"%>
<%@page import="dto.CompanyDetailsBean"%>
<%@include file="header.jsp"%>
<%@include file="hod_nav.jsp" %>

<div class="container">
    <div class="col-2 col-sm-6 offset-sm-4">
        <h3 class="mt-3 mb-3"><b>Available Companies</b></h3>
    </div>
        <%AdminDAO ob=new AdminDAO();
         List<CompanyDetailsBean>comp_list=ob.fetchCompanyDetails();
        %>

                        <%     for (CompanyDetailsBean comp : comp_list)
                        {   
                            if(comp!=null)
                            {
                        %> 
        
        <div class="col-12 col-sm-10 offset-sm-1" style="padding-bottom: 5px; padding-top: 10px">
                <div class="card mb-2">
                    <div class="card-body">
                        <h3><%out.print(comp.getComp_name());%></h3>
                        <p class="mb-0">
                            <span> Location : </span> 
                            <span><%out.print(comp.getComp_address());%></span> 
                        </p>
                        <p>
                            <span> Contact : </span> 
                            <span><%out.print(comp.getCont_no());
                                    out.print("\t"+comp.getEmail());%>
                            </span> 
                        </p>

                        <table class="table table-sm table-borderless">
                                <th>Start Date</th>
                                <th>Duration</th>
                                <th>Domain</th>
                                <tr>
                                    <td><%out.print(comp.getStart_date());%></td>
                                    <td><%out.print(comp.getDuration());%></td>
                                    <td><%out.print(comp.getDomain());%></td>
                                </tr>
                        </table>
                        <p>
                            <span><b>#Number of Vacancies : </b></span>
                            <span><%out.print(comp.getVacancy());%></span>
                        </p>
                        <p>
                            <span><b>#Skills Required : </b></span>
                            <span><%out.print(comp.getSkills());%></span>
                            
                        </p>
                        <form method="" action="">
                            <button class="btn btn-danger offset-sm-3" type="submit">Remove</button>
                        </form>
                    </div>
                </div>
            </div>
                       <%
                       }
                    }%>     

</div>
<%@include file="footer.jsp"%>