<%-- 
    Document   : CreateVehicleServlet
    Created on : 24 Apr 2023, 5:34:59 PM
    Author     : kathemacbook
--%>

<%@page import="backend.VehicleWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String carId = "";
    String make = "";
    String brand = "";
    String year = "";
    String miliage = "";
    String color = "";
    String prices = "";
    String typeCar = "";
    String warrantyTime = "";
    String accidentHistory = "";

    VehicleWeb updateVehicle;
    String action = (String) session.getAttribute("action");
    if (action == "Update") {
        updateVehicle = (VehicleWeb) request.getSession().getAttribute("vehicle");
        make = updateVehicle.getMake();
        brand = updateVehicle.getBrand();
        year = updateVehicle.getYear();
        miliage = updateVehicle.getMiliage();
        color = updateVehicle.getColor();
        prices = String.valueOf(updateVehicle.getPrices());
        typeCar = updateVehicle.getTypeCar();
        warrantyTime = updateVehicle.getWarrantyTime();
        accidentHistory = updateVehicle.getAccidentHistory();
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Vehicles</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <form action="<%= action%>" method="POST">
            <div class="container">
                <h2 class="row my-4">CREATE NEW VEHICLE</h2>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Make</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="make" value="<%=make%>">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Brand</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="brand" value="<%=brand%>">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Year</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="year" value="<%=year%>">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Mileage</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="miliage" value="<%=miliage%>">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Color</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="color" value="<%=color%>">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Price</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="prices" value="<%=prices%>">

                    </div>
                </div>
                <div class="form-group row my-2">
                    <label for="typeCar" class="col-3 col-form-label">Type Car</label>
                    <div class="col-9">
                        <select class="form-control" id="typeCar" name="typeCar">
                            <option></option>
                            <option <%= (typeCar.equals("Coupe")) ? "selected" : ""%>>Coupe</option>
                            <option <%= (typeCar.equals("Sports Car")) ? "selected" : ""%>>Sports Car</option>
                            <option <%= (typeCar.equals("Pickup Truck")) ? "selected" : ""%>>Pickup Truck</option>
                            <option <%= (typeCar.equals("SUV")) ? "selected" : ""%>>SUV</option>
                            <option <%= (typeCar.equals("Luxury")) ? "selected" : ""%>>Luxury</option>
                            <option <%= (typeCar.equals("Convertible")) ? "selected" : ""%>>Convertible</option>
                        </select>

                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Warranty Time</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="warrantyTime" value="<%=warrantyTime%>">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Accident History</label>
                    <div class="col-9">
                        <select class="form-control" id="accidentHistory" name="accidentHistory">
                            <option> </option>
                            <option <%=(accidentHistory.equals("Yes")) ? "selected" : ""%>>Yes</option>
                            <option <%=(accidentHistory.equals("No")) ? "selected" : ""%>>No</option>
                        </select>
                        <div>
                        </div>
                    </div>
                    <div class="row py-4 my-2 mx-auto">
                        <div class="col-12 text-center">
                            <button type="submit" class="btn btn-outline-primary">Save</button>
                        </div>
                    </div>
                </div>
        </form>
        <div class="btn-group">
            <a href="http://localhost:8080/AltayerMotorsWeb" class="btn btn-primary" aria-current="page">Menu</a>
        </div>
    </body>
</html>
