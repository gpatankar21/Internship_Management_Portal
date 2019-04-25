<%-- 
    Document   : send_mail
    Created on : 27 Jan, 2019, 3:24:42 PM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"%>
<%@include file="admin_nav.jsp"%>
<div class="container">
    <div class="col-12 col-sm-6 offset-sm-4">
        <h2 class="mt-2">Enter the Details !!!</h2>
    </div>
    <div class="col-12 col-sm-7 offset-sm-2 mb-3">
        <form action="SendMail" method="post" class="was-validation">
            <div class="form-group">
                <label for="mail">Enter Email Address of the Organisation or a Person :</label>
                <input class="form-control" type="email" placeholder="Enter e-mail address " name="recepient" required>
            </div>
            <div class="form-group">
                <label for="mail">Enter Subject :</label>
                <input class="form-control" type="text" placeholder="Enter Subject " name="subject" required>
            </div>
            <div class="form-group">
                <label for="mail">Enter Message to Send :</label>
                <textarea class="form-control" placeholder="Enter Message" rows="5" name="message" required></textarea>
            </div>
            <center><button class="btn btn-primary"> Send </button></center>
        </form>
    </div>
    
    
</div>

<%@include file="footer.jsp"%>