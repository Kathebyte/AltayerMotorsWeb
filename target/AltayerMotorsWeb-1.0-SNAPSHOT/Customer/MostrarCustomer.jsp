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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container">
            <h1 class="display-3">All Customers</h1>
            <table class="table table-hover table-md table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Id #</th>
                        <th scope="col">Name</th>
                        <th scope="col">Phone number</th>
                        <th scope="col">Address</th>
                        <th scope="col">Email</th>

                    </tr>
                </thead>
                <tbody>

                    <%
                        List<CustomerWeb> listaCustomers = (List) request.getSession().getAttribute("listaCustomers");
                        for (CustomerWeb customer : listaCustomers) {
                    %>
                    <tr>
                        <th scope="row"> <%=customer.getId()%></th>
                        <th scope="row"> <%=customer.getName()%></th>
                        <th scope="row"> <%=customer.getAddress()%></th>
                        <th scope="row"> <%=customer.getPhoneNumber()%></th>
                        <th scope="row"> <%=customer.getEmail()%></th>
                    </tr>
                    <% }%>

                </tbody>
            </table>
            <div class="btn-group">
                <a href="http://localhost:8080/AltayerMotorsWeb" class="btn btn-primary" aria-current="page">Menu</a>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>