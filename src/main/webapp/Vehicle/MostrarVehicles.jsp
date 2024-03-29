<%--
    Document   : MostrarVehicles
    Created on : 22 Apr 2023, 5:12:59 PM
    Author     : kathemacbook
--%>

<%@page import="backend.VehicleWeb"%>
<%@page import="java.util.List"%>
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
            <h1 class="display-3">All vehicles</h1>
            <% if (request.getAttribute("message") != null) {%>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("message")%>
            </div>
            <% } %>

            <table class="table table-hover table-md table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Car Id #</th>
                        <th scope="col">Make</th>
                        <th scope="col">Brand</th>
                        <th scope="col">Year</th>
                        <th scope="col">Color</th>
                        <th scope="col">Prices</th>
                        <th scope="col">Miliage</th>
                        <th scope="col">Warranty Time</th>
                        <th scope="col">Accident History</th>
                        <th scope="col">Type Car</th>

                    </tr>
                </thead>
                <tbody>

                    <%
                        List<VehicleWeb> listaVehicles = (List) request.getSession().getAttribute("listaVehicles");
                        for (VehicleWeb vehiculo : listaVehicles) {
                    %>
                    <tr>
                        <th scope="row"> <%=vehiculo.getCarId()%></th>
                        <td> <%=vehiculo.getMake()%> </td>
                        <td> <%=vehiculo.getBrand()%> </td>
                        <td> <%=vehiculo.getYear()%></td>
                        <td> <%=vehiculo.getColor()%></td>
                        <td> <%=vehiculo.getPrices()%></td>
                        <td> <%=vehiculo.getMiliage()%></td>
                        <td> <%=vehiculo.getWarrantyTime()%></td>
                        <td>
                            <% if (vehiculo.getAccidentHistory() == 0) { %>
                                <span class="badge bg-danger">Not</span>
                            <% } else if (vehiculo.getAccidentHistory() == 1) { %>
                                <span class="badge bg-success">Yes</span>
                             <% } %>
                        </td>
                        <td> <%=vehiculo.getTypeCar()%></td>
                        <td>
                            <form action="Delete" method="POST">
                                <input type="hidden" name="carId" value="<%=vehiculo.getCarId()%>">
                                <button class="btn btn-danger" type="submit">Delete</button>
                            </form>

                        </td>
                        <td>
                            <form action="Update" method="GET">
                                <input type="hidden" name="carIdUpdate" value="<%=vehiculo.getCarId()%>">
                                <button class="btn btn-primary" type="submit">Update</button>
                            </form>
                        </td>
                    </tr>
                    <% }%>

                </tbody>
            </table>
                    <div class="btn-group">



            <div class="btn-group">
                <a href="../index.html" class="btn btn-primary" aria-current="page">Menu</a>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
