<%-- 
    Document   : EmployeeCreate.jsp
    Created on : 4 May 2023, 3:00:28 PM
    Author     : kathemacbook
--%>

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
                String user="";
                String state="";
                String salary ="";
                
    EmployeeWeb updateEmployee;
    String action= (String) session.getAttribute("action");
    if(action == "Update"){
    updateEmployee = (EmployeeWeb) request.getSession().getAttribute("employee");
    
    name= updateEmployee.getName();
    phoneNumber=updateEmployee.getPhoneNumber();
    address=updateEmployee.getAddress();
    email=updateEmployee.getEmail();
    jobPosition= updateEmployee.getJobPosition();
    user=updateEmployee.getUser();
    state=updateEmployee.getState();
    salary=updateEmployee.getSalary();
    
    }
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE EMPLOYEE</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <form action="<%=action%>" method="POST">
            <div class="container" >
                <h2 class="row my-4"> CREATE NEW EMPLOYEE </h2>
                <div class="row my-2">
                    <label class="col-3">Name: </label>
                    <input class="col-9" type="text" name="name" value="<%=name%>">
                    </div>
                <div class="row my-2">
                    <label class="col-3">Phone Number: </label>
                    <input class="col-9" type="text" name="phoneNumber" value="<%=phoneNumber%>">
                    </div>
                <div class="row my-2">
                    <label class="col-3">Address: </label>
                    <input class="col-9" type="text" name="address" value="<%=address%>">
                    </div>
                <div class="row my-2">
                    <label class="col-3">Email: </label>
                    <input class="col-9" type="text" name="email" value="<%=email%>">
                    </div>

                <div class="row my-2">
                    <label class="col-3">Job position: </label>
                    <input class="col-9" type="text" name="jobPosition" value="<%=jobPosition%>">
                    </div>
                <div class="row my-2">
                    <label class="col-3">User: </label>
                    <input class="col-9" type="text" name="user" value="<%=user%>">
                    </div>
                <div class="row my-2">
                <label for="states">State</label>
                <select class="form-control col-3  " id="state" name="state" value="<%=state%>">>
                 <option <%= (state.equals("Active")) ? "selected" : ""%>>Active</option>
                 <option <%= (state.equals("Inactive")) ? "selected" : ""%>>Inactive</option>
                 </select>
                    </div>
                <div class="row my-2">
                    <label class="col-3">Salary: </label>
                    <input class="col-9" type="text" name="salary" value="<%=salary%>">
                    </div>
                <div class="row py-4 my-2 mx-auto">
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-outline-primary">Save</button>
                    </div>
                </div>
            </div>
        <div class="btn-group">
            <a href="http://localhost:8080/AltayerMotorsWeb" class="btn btn-primary" aria-current="page">Menu</a>
        </div>
        </form>
    </body>
</html>
