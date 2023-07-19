<%-- 
    Document   : GenerateInvoice
    Created on : 18 Jul 2023, 3:04:53 PM
    Author     : kathemacbook
--%>
<%@ page import="backend.CustomerWeb" %>
<%@ page import="backend.EmployeeWeb" %>
<%@ page import="backend.VehicleWeb" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backend.Sale"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .invoice {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            font-family: Arial, sans-serif;
        }
        </style>
    </head>
    <body>
        <div class="container">
        <div class="invoice">
            <div class="invoice-header">
                <h1>Invoice Al tayer Motors</h1>
            </div>
            
            <div class="invoice-details">
                <h2>Customer Information:</h2>
                <% Sale invoice = (Sale) session.getAttribute("Sale");
                    CustomerWeb invoiceCustomer = invoice.getCustomer();%>
                 
                    <p>Customer: <%=invoiceCustomer.getName() %></p>
                    <p>Location: <%=invoiceCustomer.getAddress() %></p>
                    <p>Email: <%=invoiceCustomer.getEmail() %> </p>
                    <p>Phone Number: <%=invoiceCustomer.getPhoneNumber() %></p>
                    
                    <%EmployeeWeb invoiceEmployee = invoice.getEmployee();%>
                    <h2>Employee Information:</h2>
                        <p>Employee Name: <%=invoiceEmployee.getName() %></p>
                        <p>office: <%=invoiceEmployee.getAddress()%></p>
                    
                    <%VehicleWeb invoiceVehicle = invoice.getVehicle();%>
                    <h2>Product: </h2>
                        <p>Make: <%=invoiceVehicle.getMake() %></p>
                        <p>Brand: <%=invoiceVehicle.getBrand()%></p>
                        <p>Total Prices: <%=invoiceVehicle.getPrices()%></p>

                    
                    
            </div>
 
    </body>
       