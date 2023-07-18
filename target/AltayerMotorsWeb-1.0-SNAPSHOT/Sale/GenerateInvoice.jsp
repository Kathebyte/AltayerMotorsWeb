<%-- 
    Document   : GenerateInvoice
    Created on : 18 Jul 2023, 3:04:53 PM
    Author     : kathemacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>Factura</h1>
            </div>
            
            <div class="invoice-details">
                <p>Cliente: ${Sale.customer.name}</p>
                <p>Dirección: ${Sale.customer.address}</p>
                <p>Email: ${Sale.customer.email}</p>
                <p>Teléfono: ${Sale.customer.phoneNumber}</p>
            </div>
 
    </body>
       