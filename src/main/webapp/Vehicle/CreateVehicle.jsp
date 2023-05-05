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
            <div class="container" >
                <h2 class="row my-4"> CREATE NEW VEHICLE </h2>
                <div class="row my-2">
                    <label class="col-3">Make </label>
                    <input class="col-9" type="text" name="make">
                </div>
                <div class="row my-2">
                    <label class="col-3">Brand </label>
                    <input class="col-9" type="text" name="brand">
                </div>
                <div class="row my-2">
                    <label class="col-3">Year: </label>
                    <input class="col-9" type="text" name="year">
                </div>
                <div class="row my-2">
                    <label class="col-3">Miliage: </label>
                    <input class="col-9" type="text" name="miliage">
                </div>
                <div class="row my-2">
                    <label class="col-3">Color: </label>
                    <input class="col-9" type="text" name="color">
                </div>
                <div class="row my-2">
                    <label class="col-3">Prices: </label>
                    <input class="col-9" type="text" name="prices">
                </div>
                <div class="row my-2">
                    <label class="col-3">Type Car: </label>
                    <input class="col-9" type="text" name="typeCar">
                </div>
                <div class="row my-2">
                    <label class="col-3">Warranty Time: </label>
                    <input class="col-9" type="text" name="warrantyTime">
                </div>
                <div class="row my-2 ">
                    <label class="col-3">Accident History: </label>
                    <input class="col-9" type="text" name="accidentHistory">

                    <div class="row py-4 my-2 mx-auto">
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-outline-primary">Save</button>
                        </div>
                    </div>
                </div> 
            </div>
             <div class="btn-group">
                    <a href="http://localhost:8080/AltayerMotorsWeb" class="btn btn-primary" aria-current="page">Menu</a>
                  </div>
        </form>
    </body>
</html>
