<%-- 
    Document   : CreateCustomer
    Created on : 5 May 2023, 10:16:45 AM
    Author     : kathemacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE EMPLOYEE</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <form action="Create" method="POST">
            <div class="container" >
                <h2 class="row my-4"> CREATE NEW CUSTOMER </h2>
                <div class="row my-2">
                    <label class="col-3">Name: </label>
                    <input class="col-9" type="text" name="name">
                </div>
                
                <div class="row my-2">
                    <label class="col-3">Address: </label>
                    <input class="col-9" type="text" name="address">
                </div>
                <div class="row my-2">
                    <label class="col-3">Phone Number: </label>
                    <input class="col-9" type="text" name="phoneNumber">
                </div>
                <div class="row my-2">
                    <label class="col-3">Email: </label>
                    <input class="col-9" type="text" name="email">
                </div>
                <div class="row py-4 my-2 mx-auto">
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-outline-primary">Save</button>
                    </div>
                </div>
            </div> 
            <div class="btn-group">
                    <a href="http://localhost:8080/AltayerMotorsWeb" class="btn btn-primary" aria-current="page">Menu</a>
                  </div>
        </form>
    </body>
</html>
