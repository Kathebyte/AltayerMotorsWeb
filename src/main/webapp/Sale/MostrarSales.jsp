<%-- 
    Document   : MostrarSales
    Created on : 14 Jul 2023, 4:18:59 PM
    Author     : kathemacbook
--%>

<%@page import="backend.EmployeeWeb"%>
<%@page import="java.util.List"%>
<%@page import="backend.Sale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Sales</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .btn-group {
                margin-top: 20px;
            }
        </style>
    <body>
        <div class="container">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id Sale</th>
                        <th scope="col">Date</th>
                        <th scope="col">Employee name</th>
                        <th scope="col">Vehicle Make</th>
                        <th scope="col">Vehicle Brand</th>
                        <th scope="col">Vehicle Prices</th>
                        <th scope="col">Customer Name</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Sale> listSales = (List<Sale>) request.getSession().getAttribute("listSales");
                        for (Sale sale1 : listSales) {
                            //pendiente traer los datos de los customer, employee, vehicle.

                    %>
                    <tr>
                        <td><%= sale1.getIdSale()%></td>
                        <td><%= sale1.getDate()%></td>
                        <td><%=sale1.getEmployee().getName()%></td>
                        <td><%=sale1.getVehicle().getMake()%></td>
                        <td><%=sale1.getVehicle().getBrand()%></td>
                        <td><%=sale1.getVehicle().getPrices()%></td>
                        <td><%=sale1.getCustomer().getName()%></td>
                        <td>
                            <form action="Generate/Invoice" method="GET">
                            <input type="hidden" name="saleId" value="<%= sale1.getIdSale() %>">
                            <button type="submit" class="btn btn-primary">Generar factura</button>
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