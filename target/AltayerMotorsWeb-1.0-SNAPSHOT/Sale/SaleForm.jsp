<%-- 
    Document   : SaleForm
    Created on : 14 Jul 2023, 2:13:07 PM
    Author     : kathemacbook
--%>

<%@page import="backend.EmployeeWeb"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE SALE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .btn-group {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <form action="Create" method="POST">
            <div class="container">
                <h2 class="my-4">CREATE SALE</h2>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Data Time</label>
                    <div class="col-9">
                        <input class="form-control" type="text" name="date">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-3 col-form-label">Id Employee</label>
                    <div class="col-9">
                    <input class="form-control" type="text" name="idEmployee" >
                    </div>
            </div>
                    <div class="row mb-3">
                        <label class="col-3 col-form-label">Id Car</label>
                        <div class="col-9">
                            <input class="form-control" type="text" name="idCar">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-3 col-form-label">Id Customer</label>
                        <div class="col-9">
                            <input class="form-control" type="text" name="idCustomer">
                        </div>
                    </div>
                    <div class="row py-4">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">Save</button>
                            <a href="/AltayerMotorsWeb" class="btn btn-secondary">Menu</a>
                        </div>
                    </div>

                </div>
        </form>
    </body>
