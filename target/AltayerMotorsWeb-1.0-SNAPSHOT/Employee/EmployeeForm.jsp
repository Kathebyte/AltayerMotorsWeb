<%-- 
    Document   : EmployeeCreate.jsp
    Created on : 4 May 2023, 3:00:28 PM
    Author     : kathemacbook
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
    
   
    
    %>
<%@page import="backend.EmployeeWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String employeeId = "";
    String name = "";
    String phoneNumber = "";
    String address = "";
    String email = "";
    String jobPosition = "";
    String user = "";
    String state = "";
    String salary = "";

    EmployeeWeb updateEmployee;
    String action = (String) session.getAttribute("action");
    if (action == "Update") {
        updateEmployee = (EmployeeWeb) request.getSession().getAttribute("employee");

        name = updateEmployee.getName();
        phoneNumber = updateEmployee.getPhoneNumber();
        address = updateEmployee.getAddress();
        email = updateEmployee.getEmail();
        jobPosition = updateEmployee.getJobPosition();
        user = updateEmployee.getUser();
        state = String.valueOf(updateEmployee.getState());
        salary = String.valueOf(updateEmployee.getSalary());

    }

%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AlTayerMotors/CreateEmployee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <form action="<%=action%>" method="POST">
        <div class="container">
            <h2 class="my-4">CREATE NEW EMPLOYEE</h2>
            <div class="row mb-3">
                <label class="col-3 col-form-label">Name:</label>
                <div class="col-9">
                    <input class="form-control" type="text" name="name" value="<%=name%>">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3 col-form-label">Phone Number:</label>
                <div class="col-9">
                    <input class="form-control" type="text" name="phoneNumber" value="<%=phoneNumber%>">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3 col-form-label">Address:</label>
                <div class="col-9">
                    <input class="form-control" type="text" name="address" value="<%=address%>">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3 col-form-label">Email:</label>
                <div class="col-9">
                    <input class="form-control" type="text" name="email" value="<%=email%>">
                </div>
            </div>
                <div class="row mb-3">
                <label for="jobPosition" class="col-3 col-form-label">Job Position</label>
                <div class="col-9">
                    <select class="form-select" id= "jobPosition" name="jobPosition" value="<%=jobPosition%>">
                        <option <%= (jobPosition.equals(1)) ? "selected" : ""%> value="1">General Manager</option>
                        <option <%= (jobPosition.equals(2)) ? "selected" : ""%> value="2">Sales Manager</option>
                        <option <%= (jobPosition.equals(3)) ? "selected" : ""%> value="3">Car Salesperson</option>
                        <option <%= (jobPosition.equals(4)) ? "selected" : ""%> value="4">Corporate Sales Executive</option>
                        <option <%= (jobPosition.equals(5)) ? "selected" : ""%> value="5">Finance Manager</option>
                        <option <%= (jobPosition.equals(6)) ? "selected" : ""%> value="6">Service Advisor</option>
                        <option <%= (jobPosition.equals(7)) ? "selected" : ""%> value="7">Delivery Coordinator</option>
                        <option <%= (jobPosition.equals(8)) ? "selected" : ""%> value="8">Marketing Specialist</option>
                        <option <%= (jobPosition.equals(9)) ? "selected" : ""%> value="9">Aftersales Manager</option>
                        <option <%= (jobPosition.equals(10)) ? "selected" : ""%> value="10">Administrative Assistant</option>
                    </select>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3 col-form-label">User:</label>
                <div class="col-9">
                    <input class="form-control" type="text" name="user" value="<%=user%>">
                </div>
            </div>
            <div class="row mb-3">
                <label for="states" class="col-3 col-form-label">State:</label>
                <div class="col-9">
                    <select class="form-select" id="state" name="state" value="<%=state%>">
                        <option <%= (state.equals(1)) ? "selected" : ""%> value="1">Active</option>
                        <option <%= (state.equals(0)) ? "selected" : ""%>value="0">Inactive</option>
                    </select>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3 col-form-label">Salary:</label>
                <div class="col-9">
                    <input class="form-control" type="text" name="salary" value="<%=salary%>">
                </div>
            </div>
        
            <div class="row py-4">
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="/AltayerMotorsWeb" class="btn btn-secondary">Menu</a>
                </div>
            </div>
        </div>
        
    </form>
                </div> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>