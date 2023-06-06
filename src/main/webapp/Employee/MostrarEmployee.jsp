<%-- 
    Document   : MostrarEmployee
    Created on : 24 Apr 2023, 5:18:56 PM
    Author     : kathemacbook
--%>

<%@page import="backend.EmployeeWeb"%>
<%@page import="java.util.List"%>
<%@page import="backend.CustomerWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Vehicles</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container">
            <h1 class="display-3">All Employees</h1>
<% if (request.getAttribute("message") != null) {%>
            <div class="alert alert-success" role="alert">
<%= request.getAttribute("message")%>
            </div>
<% } %>
            <table class="table table-striped table-hover ">
                <thead>
                    <tr>
                        <th scope="col">Id#</th>
                        <th scope="col">User</th>
                        <th scope="col">Name</th>
                        <th scope="col">Phone number</th>
                        <th scope="col">Address</th>
                        <th scope="col">Email address</th>
                        <th scope="col">State</th>
                        <th scope="col">Job Position</th>
                        <th scope="col">Salary</th>


                    </tr>
                </thead>

                <tbody>
<%
    List<EmployeeWeb> listaEmployee = (List) request.getSession().getAttribute("listaEmployee");
    for (EmployeeWeb employee : listaEmployee) {

%>
                    <tr>

                        <th scope="row"> <%=employee.getIdEmployee()%></th>
                        <th scope="row"> <%=employee.getUser()%></th>
                        <th scope="row"> <%=employee.getName()%></th>
                        <th scope="row"> <%=employee.getPhoneNumber()%></th>
                        <th scope="row"> <%=employee.getAddress()%></th>
                        <th scope="row"> <%=employee.getEmail()%></th>
                        <th scope="row"> <%=employee.getState()%></th>
                        <th scope="row"> <%=employee.getJobPosition()%></th>
                        <th scope="row"> <%=employee.getSalary()%></th>
                        <td>
                            <form action="Delete" method="POST">
                                <input type="hidden" name="idUser" value="<%=employee.getIdEmployee()%>">
                                <button class="btn btn-danger" type="submit">Delete</button>
                            </form>

                        </td>
                        <td>
                            <form action="Update" method="GET">
                                <input type="hidden" name="idEmployee" value="<%=employee.getIdEmployee()%>">
                                <button class="btn btn-primary" type="submit">Update</button>
                            </form>
                        </td>

                    </tr>
<% }%>

                </tbody>
            </table>
            
            <div class="btn-group">
                <a href="/AltayerMotorsWeb" class="btn btn-primary" aria-current="page">Menu</a>
            </div>      
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
