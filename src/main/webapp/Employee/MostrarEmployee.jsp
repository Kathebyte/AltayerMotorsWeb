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
        <title>List Employees</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .btn-group {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="display-3">All Employees</h1>
            <% if (request.getAttribute("message") != null) {%>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("message")%>
            </div>
            <% } %>
            <table class="table table-striped table-hover">
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
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<EmployeeWeb> listaEmployee = (List<EmployeeWeb>) request.getSession().getAttribute("listaEmployee");
                        for (EmployeeWeb employee : listaEmployee) {
                    %>
                    <tr>
                        <td><%= employee.getIdEmployee()%></td>
                        <td><%= employee.getUser()%></td>
                        <td><%= employee.getName()%></td>
                        <td><%= employee.getPhoneNumber()%></td>
                        <td><%= employee.getAddress()%></td>
                        <td><%= employee.getEmail()%></td>
                        <td>
                            <% if (employee.getState()) { %>
                            <span class="badge bg-success">Active</span>
                            <% } else { %>
                            <span class="badge bg-danger">Inactive</span>
                            <% }%>
                        </td>
                        <td><%= employee.getJobPosition()%></td>
                        <td><%= employee.getSalary()%></td>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>