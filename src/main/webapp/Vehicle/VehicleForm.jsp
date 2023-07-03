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
    System.out.println("hola este es el make que estoy seleccionando"+ make);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AltayerMotors/CreateVehicles</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <form action="<%= action%>" method="POST">
            <div class="container">
                <h2 class="my-4">CREATE NEW VEHICLE</h2>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Make</label>
                    <div class="col-9">
                        <select class="form-select" name="make" value="<%=make%>">
                            <option <%= (make.equals("1")) ? "selected" : ""%> value="1">Toyota</option>
                            <option <%= (make.equals("2")) ? "selected" : ""%> value="2">Ford</option>
                            <option <%= (make.equals("3")) ? "selected" : ""%> value="3">Volkswagen</option>
                            <option <%= (make.equals("4")) ? "selected" : ""%> value="4">Chevrolet</option>
                            <option <%= (make.equals("5")) ? "selected" : ""%> value="5">Honda</option>
                            <option <%= (make.equals("6")) ? "selected" : ""%>value="6">Nissan</option>
                            <option <%= (make.equals("7")) ? "selected" : ""%>value="7">BMW</option>
                            <option <%= (make.equals("8")) ? "selected" : ""%>values="8">Mercedes-Benz</option>
                            <option <%= (make.equals("9")) ? "selected" : ""%>value="9">Audi</option>
                            <option <%= (make.equals("10")) ? "selected" : ""%>value="10">Hyundai</option>
                            <option <%= (make.equals("11")) ? "selected" : ""%>value="11">Kia</option>
                            <option <%= (make.equals("12")) ? "selected" : ""%>value="12">Subaru</option>
                            <option <%= (make.equals("13")) ? "selected" : ""%>value="13">Tesla</option>
                            <option <%= (make.equals("14")) ? "selected" : ""%>value="14">Mazda</option>
                            <option <%= (make.equals("15")) ? "selected" : ""%>value="15">Volvo</option>
                            <option <%= (make.equals("16")) ? "selected" : ""%>value="16">Land Rover</option>
                            <option <%= (make.equals("17")) ? "selected" : ""%>value="17">Jaguar</option>
                            <option <%= (make.equals("18")) ? "selected" : ""%>value="18">Fiat</option>
                            <option <%= (make.equals("19")) ? "selected" : ""%>value="19">Jeep</option>
                            <option <%= (make.equals("20")) ? "selected" : ""%>value="20">Mitsubishi</option>
                            <option <%= (make.equals("21")) ? "selected" : ""%>value="21">Rolls-Royce</option>
                            <option <%= (make.equals("22")) ? "selected" : ""%>value="22">Bentley</option>
                            <option <%= (make.equals("23")) ? "selected" : ""%>value="23">Lamborghini</option>
                            <option <%= (make.equals("24")) ? "selected" : ""%>value="24">Ferrari</option>
                            <option <%= (make.equals("25")) ? "selected" : ""%>value="25">Porsche</option>
                            <option <%= (make.equals("26")) ? "selected" : ""%>value="26">Aston Martin</option>
                            <option <%= (make.equals("27")) ? "selected" : ""%>value="27">Maserati</option>
                            <option <%= (make.equals("28")) ? "selected" : ""%>value="28">McLaren</option>
                            <option <%= (make.equals("29")) ? "selected" : ""%>value="29">Bugatti</option>
                            <option <%= (make.equals("30")) ? "selected" : ""%>value="30">Lexus</option>
                            <option <%= (make.equals("31")) ? "selected" : ""%>value="31">Hyunday</option>
                        </select>
                    </div>        



                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Brand</label>
                    <div class="col-9">
                        <select class="form-select" name="brand" value="<%=brand%>">
                            <option <%= (brand.equals("1")) ? "selected" : ""%> value="1">Camry</option>
                            <option <%= (brand.equals("2")) ? "selected" : ""%> value="2">Mustang</option>
                            <option <%= (brand.equals("3")) ? "selected" : ""%> value="3">Golf</option>
                            <option <%= (brand.equals("4")) ? "selected" : ""%> value="4">Camaro</option>
                            <option <%= (brand.equals("5")) ? "selected" : ""%> value="5">Civic</option>
                            <option <%= (brand.equals("6")) ? "selected" : ""%> value="6">Altima</option>
                            <option <%= (brand.equals("7")) ? "selected" : ""%> value="7">3 Series</option>
                            <option <%= (brand.equals("8")) ? "selected" : ""%> value="8">C-Class</option>
                            <option <%= (brand.equals("9")) ? "selected" : ""%> value="9">A4</option>
                            <option <%= (brand.equals("10")) ? "selected" : ""%> value="10">Sonata</option>
                            <option <%= (brand.equals("11")) ? "selected" : ""%> value="11">Optima</option>
                            <option <%= (brand.equals("12")) ? "selected" : ""%> value="12">Outback</option>
                            <option <%= (brand.equals("13")) ? "selected" : ""%> value="13">Model S</option>
                            <option <%= (brand.equals("14")) ? "selected" : ""%> value="14">Mazda3</option>
                            <option <%= (brand.equals("15")) ? "selected" : ""%> value="15">XC60</option>
                            <option <%= (brand.equals("16")) ? "selected" : ""%> value="16">Range Rover</option>
                            <option <%= (brand.equals("17")) ? "selected" : ""%> value="17">F-PACE</option>
                            <option <%= (brand.equals("18")) ? "selected" : ""%> value="18">500</option>
                            <option <%= (brand.equals("19")) ? "selected" : ""%> value="19">Wrangler</option>
                            <option <%= (brand.equals("20")) ? "selected" : ""%> value="20">Outlander</option>
                            <option <%= (brand.equals("21")) ? "selected" : ""%> value="21">Phantom</option>
                            <option <%= (brand.equals("22 ")) ? "selected" : ""%> value="22">Continental GT</option>
                            <option <%= (brand.equals("23")) ? "selected" : ""%> value="23">Aventador</option>
                            <option <%= (brand.equals("24")) ? "selected" : ""%> value="24">488 GTB</option>
                            <option <%= (brand.equals("25")) ? "selected" : ""%> value="25">911</option>
                            <option <%= (brand.equals("26")) ? "selected" : ""%> value="26">DB11</option>
                            <option <%= (brand.equals("27")) ? "selected" : ""%> value="27">Ghibli</option>
                            <option <%= (brand.equals("28")) ? "selected" : ""%> value="28">720S</option>
                            <option <%= (brand.equals("29")) ? "selected" : ""%> value="29">Chiron</option>
                            <option <%= (brand.equals("30")) ? "selected" : ""%> value="30">RX</option>
                        </select>
                    </div>

                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Year</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="year" value="<%=year%>">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Mileage</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="miliage" value="<%=miliage%>">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Color</label>
                    <div class="col-9">
                        <select class="form-select" id="color" name="color" value="<%=color%>">
                            <option <%= (color.equals("1")) ? "selected" : ""%>value="1">Black</option>
                            <option <%= (color.equals("2")) ? "selected" : ""%> value="2">White</option>
                            <option <%= (color.equals("3")) ? "selected" : ""%> value="3">Red</option>
                            <option <%= (color.equals("4")) ? "selected" : ""%> value="4">Blue</option>
                            <option <%= (color.equals("5")) ? "selected" : ""%> value="5">Green</option>
                            <option <%= (color.equals("6")) ? "selected" : ""%> value="6">Yellow</option>
                            <option <%= (color.equals("7")) ? "selected" : ""%> value="7">Silver</option>
                            <option <%= (color.equals("8")) ? "selected" : ""%> value="8">Gray</option>
                            <option <%= (color.equals("9")) ? "selected" : ""%> value="9">Orange</option>
                            <option <%= (color.equals("10")) ? "selected" : ""%> value="10">Purple</option>
                            <option <%= (color.equals("11")) ? "selected" : ""%> value="11">Brown</option>
                            <option <%= (color.equals("12")) ? "selected" : ""%> value="12">Beige</option>
                            <option <%= (color.equals("13")) ? "selected" : ""%> value="13">Gold</option>
                            <option <%= (color.equals("14")) ? "selected" : ""%> value="14">Bronze</option>
                            <option <%= (color.equals("15")) ? "selected" : ""%> value="15">Pink</option>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Price</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="prices" value="<%=prices%>">
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="typeCar" class="col-3 col-form-label">Type Car</label>
                    <div class="col-9">
                        <select class="form-select" id="typeCar" name="typeCar">
                            <option <%= (typeCar.equals("300")) ? "selected" : ""%> value="300">Sedan</option>
                            <option <%= (typeCar.equals("301")) ? "selected" : ""%> value="301">SUV</option>
                            <option <%= (typeCar.equals("302")) ? "selected" : ""%> value="302">Hatchback</option>
                            <option <%= (typeCar.equals("303")) ? "selected" : ""%> value="303">Coupe</option>
                            <option <%= (typeCar.equals("304")) ? "selected" : ""%> value="304">Convertible</option>
                            <option <%= (typeCar.equals("305")) ? "selected" : ""%> value="305">Minivan</option>
                            <option <%= (typeCar.equals("306")) ? "selected" : ""%> value="306">Pickup Truck</option>
                            <option <%= (typeCar.equals("307")) ? "selected" : ""%> value="307">Sports Car</option>
                            <option <%= (typeCar.equals("308")) ? "selected" : ""%> value="308">Luxury Car</option>
                            <option <%= (typeCar.equals("309")) ? "selected" : ""%> value="309">Electric Car</option>
                            <option <%= (typeCar.equals("310")) ? "selected" : ""%> value="310">Hybrid Car</option>
                            <option <%= (typeCar.equals("311")) ? "selected" : ""%> value="311">Crossover</option>
                            <option <%= (typeCar.equals("312")) ? "selected" : ""%> value="312">Wagon</option>
                            <option <%= (typeCar.equals("313")) ? "selected" : ""%> value="313">Van</option>
                            <option <%= (typeCar.equals("314")) ? "selected" : ""%> value="314">Compact Car</option>
                            <option <%= (typeCar.equals("315")) ? "selected" : ""%> value="315">Off-road Vehicle</option>
                            <option <%= (typeCar.equals("316")) ? "selected" : ""%> value="316">Roadster</option>
                            <option <%= (typeCar.equals("317")) ? "selected" : ""%> value="317">Muscle Car</option>
                            <option <%= (typeCar.equals("318")) ? "selected" : ""%> value="318">Supercar</option>
                            <option <%= (typeCar.equals("319")) ? "selected" : ""%> value="319">Commercial Vehicle</option>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Warranty Time</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="warrantyTime" value="<%=warrantyTime%>">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Accident History</label>
                    <div class="col-9">
                        <select class="form-select" id="accidentHistory" name="accidentHistory" value="<%=accidentHistory%>">
                            <option <%=(accidentHistory.equals("1")) ? "selected" : ""%> value="1">True</option>
                            <option <%=(accidentHistory.equals("0")) ? "selected" : ""%> value="0">False</option>
                        </select>
                    </div>
                </div>
                <div class="row my-4">
                    <div class="col-12 text-center">
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </div>
            </div>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
