<%-- 
    Document   : MostrarCutosmer
    Created on : 24 Apr 2023, 3:56:45 PM
    Author     : kathemacbook
--%>

<%@page import="java.util.List"%>
<%@page import="backend.CustomerWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Vehicles</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>

        <div class="container">
            <h1 class="display-3">All Customers</h1>
            <% if (request.getAttribute("message") != null) {%>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("message")%>
            </div>
            <% } %>
            <table class="table table-hover table-md table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Id #</th>
                        <th scope="col">Name</th>
                        <th scope="col">Phone number</th>
                        <th scope="col">Address</th>
                        <th scope="col">Email</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<CustomerWeb> listaCustomers = (List<CustomerWeb>) request.getSession().getAttribute("listaCustomers");
                        for (CustomerWeb customer : listaCustomers) {
                    %>
                    <tr>
                        <td><%= customer.getId()%></td>
                        <td><%= customer.getName()%></td>
                        <td><%= customer.getPhoneNumber()%></td>
                        <td><%= customer.getAddress()%></td>
                        <td><%= customer.getEmail()%></td>
                        <td>
                            <form action="Delete" method="POST">
                                <input type="hidden" name="idCustomer" value="<%=customer.getId()%>">
                                <button class="btn btn-danger" type="submit">Delete</button>
                            </form>
                        </td>
                        <td>
                            <form action="Update" method="GET">
                                <input type="hidden" name="idCustomer" value="<%=customer.getId()%>">
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

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
