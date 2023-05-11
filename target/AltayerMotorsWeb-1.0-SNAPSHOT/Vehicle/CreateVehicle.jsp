<%-- 
    Document   : CreateVehicleServlet
    Created on : 24 Apr 2023, 5:34:59 PM
    Author     : kathemacbook
--%>

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
        <form action="Create" method="POST">
            <div class="container">
                <h2 class="row my-4">CREATE NEW VEHICLE</h2>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Make</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="make">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Brand</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="brand">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Year</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="year">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Mileage</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="miliage">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Color</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="color">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Price</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="prices">
                        
                    </div>
                </div>
                <div class="form-group row my-2">
                    <label for="typeCar" class="col-3 col-form-label">Type Car</label>
                    <div class="col-9">
                        <select class="form-control" id="typeCar" name="typeCar">
                            <option> </option>
                            <option>Coupe</option>
                            <option>Sports Car</option>
                            <option>Pickup Truck</option>
                            <option>SUV</option>
                            <option>Luxury</option>
                            <option>Convertible</option>
                        </select>
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Warranty Time</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="warrantyTime">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Accident History</label>
                    <div class="col-9">
                        <select class="form-control" id="accidentHistory" name="accidentHistory">
                            <<option> </option>
                            <option>Yes</option>
                            <option>No</option>
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
