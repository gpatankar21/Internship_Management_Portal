<%-- 
    Document   : student_form.jsp
    Created on : Nov 24, 2018, 2:18:37 PM
    Author     : HP
--%>

    <%@include file="header.jsp"%>
    
    <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        
        if(session.getAttribute("userid")==null)
        {
            response.sendRedirect("index.jsp");
        }
    %>

    <%@include file="student_nav.jsp"%>
    
    <div class="container">
        <div class="col-12 col-sm-8 offset-sm-2" style="padding-top: 20px; padding-bottom: 50px;">            
            <center><h2 class="ml-3 col-autos"><b>Enter Internship Details!!!</b></h2></center>

            <form action="studentController" method="post" class="has-validation" enctype="multipart/form-data">
                <div class="row form-group">
                        <label for="Year" class="col-12 col-sm-4 align-self-center">Year :</label>
                            <select id="Year" class="form-control col-12 col-sm-6" name="year" required>
                                <option value="">Select Year </option>
                                <option>I Year</option>
                                <option>II Year</option>
                                <option>III Year</option>
                                <option>IV Year</option>
                            </select>
                </div>
                <div class="row form-group">
                            <label for="Semester" class="col-12 col-sm-4 align-self-center">Semester :</label>
                            <select id="Semester" class="form-control col-12 col-sm-6" name="semester" required>
                                <option value="">Select Semester</option>
                                <option>Even</option>
                                <option>Odd</option>
                            </select>
                </div>

                <div class="row form-group">
                    <label for="InternshipDuration" class="col-12 col-sm-4 align-self-center">Internship Duration:</label>
                            <select id="Semester" class="form-control col-12 col-sm-6" name="duration" required>
                                <option value="">Select Duration</option>
                                <option>1 Month</option>
                                <option>2 Months</option>
                                <option>3 Months</option>
                                <option>4 Months</option>
                                <option>5 Months</option>
                                <option>6 Months</option>
                            </select>
                </div>
                <div class="row form-group">
                            <label for="Internship Session" class="col-12 col-sm-4 align-self-center">Internship Session</label>
                            <input class="form-control col-12 col-sm-6" type="text" placeholder="Enter Session as : MM/YYYY, eg:- jan/2019" name="session" required> 
                </div>
                <div class="row form-group">
                    <label for="Domain" class="col-12 col-sm-4 align-self-center">Domain:</label>
                            <select id="domain" class="form-control col-12 col-sm-6" name="domain" required>
                                <option value="">Select your Domain</option>
                                <option>Web Development</option>
                                <option>Processing</option>
                                <option>Telecom</option>
                                <option>Transmission & Distribution</option>
                                <option>Construction</option>
                                <option>R&D</option>
                            </select>
                </div>
                <div class="row form-group">
                            <label for="Technical Skills" class="col-12 col-sm-4 align-self-center">Technical Skill :</label>
                            <select id="Technical Skills" class="form-control col-12 col-sm-6" name="skills" required>
                                <option value="">Select your skill</option>
                                <option>C</option>
                                <option>C++</option>
                                <option>Auto CAD</option>
                                <option>Robotics</option>
                                <option>Coding</option>
                            </select>
                </div>
                <div class="row form-group">
                    <label for="CertificateImg" class="col-12 col-sm-4 align-self-center">Certificate Image:</label>
                    <input class="form-control-file col-12 col-sm-6" type="file" id="CertificateImg" name="certificate" required>
                </div>

                <div class="row form-group">
                            <label for="Company Name" class="col-12 col-sm-4 align-self-center">Applied to :</label>
                            <input class="form-control col-12 col-sm-6" type="text" placeholder="Enter Company Name " name="comp_name" required>
                </div>
                <div class="row form-group">
                            <label for="Name of Resource Person" class="col-12 col-sm-4 align-self-center">Name of Resource Person :</label>
                            <input class="form-control col-12 col-sm-6" type="text" placeholder="Enter Name of Resource Person " name="cont_name" required>
                </div>
                <div class="row form-group">
                            <label for="Contact of resource person" class="col-12 col-sm-4 align-self-center">Contact no. of Resource Person :</label>
                            <input class="form-control col-12 col-sm-6" type="text" placeholder="Enter Contact of Resource Person " name="cont_no" required>
                </div>
                <div class="row form-group">
                            <label for="Email of Resource Person" class="col-12 col-sm-4 align-self-center">Email of Resource Person :</label>
                            <input class="form-control col-12 col-sm-6" type="email" placeholder="Enter Email of Resource Person " name="cont_email" required>
                </div>
                <div class="row form-group">
                            <label for="CompanyAddress" class="col-12 col-sm-4 align-self-center">Company Address :</label>
                            <textarea class="form-control col-12 col-sm-6" id="CompanyAddress" rows="3" placeholder="Enter Address of Company" name="comp_address" required></textarea>
                </div>
                <div class="row justify-content-center">
                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                    <button type="reset" class="btn btn-warning">Reset</button>
                </div>
            </form>
        </div>
    </div>

<%@include file="footer.jsp"%>
