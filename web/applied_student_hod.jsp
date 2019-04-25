<%-- 
    Document   : admin_view_students
    Created on : 8 Jan, 2019, 1:46:04 PM
    Author     : Dimple Sharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="hod_nav.jsp" %>
<center><h1 style="padding-top: 10px;"><b>View Students</b></h1></center>
<div class="container ">
    
    <div class="col-12 col-sm-10 offset-sm-1 " style="padding-bottom: 50px;">
            <center><table class="table table-bordered table-hover ">
            <thead class="thead-dark">
                <tr>
                    <th>Student E.no.</th>
                    <th>Student Name</th>
                    <th>Company Name</th>
                    <th>View Application</th>
                </tr>
            </thead>
            <tbody id="loop">
                <tr class="list">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
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
