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

<% Sale invoice = (Sale) session.getAttribute("Sale");%>
<% VehicleWeb invoiceVehicle = invoice.getVehicle();%>
<% EmployeeWeb invoiceEmployee = invoice.getEmployee();%>
<%CustomerWeb invoiceCustomer = invoice.getCustomer();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="InvoiceCss.css">
    </head>
    <body>
        <div class="container">
            <div class="col-md-12">
                <div class="invoice">
                    <!-- begin invoice-company -->
                    <div class="invoice-company text-inverse f-w-600">
                        <span class="pull-right hidden-print">
                            <a href="javascript:;" class="btn btn-sm btn-white m-b-10 p-l-5"><i class="fa fa-file t-plus-1 text-danger fa-fw fa-lg"></i> Export as PDF</a>
                            <a href="javascript:;" onclick="window.print()" class="btn btn-sm btn-white m-b-10 p-l-5"><i class="fa fa-print t-plus-1 fa-fw fa-lg"></i> Print</a>
                        </span>
                        Al tayer Motors
                    </div>
                    <!-- end invoice-company -->
                    <!-- begin invoice-header -->
                    <div class="invoice-header">
                        <div class="invoice-from">

                            <address class="m-t-5 m-b-5">
                                <strong class="text-inverse">Al Tayer Motors </strong><br>
                                Street Address:Sheikh Zayed Road, Dubai, UAE<br>
                                City: Dubai, UAE, 000000<br>
                                Phone: (971) 456-7890<br>
                                Employee Name: <%= invoiceEmployee.getName()%><br>
                                EmployeeId: <%=invoiceEmployee.getIdEmployee()%>
                            </address>
                        </div>
                        <div class="invoice-to">

                            <address class="m-t-5 m-b-5">
                                <strong class="text-inverse"> Customes Information</strong><br>
                                Name: <%= invoiceCustomer.getName()%><br>
                                Street Address: <%= invoiceCustomer.getAddress()%> <br>
                                City: Dubai, UAE<br>
                                Phone: <%= invoiceCustomer.getPhoneNumber()%><br>
                                Email: <%= invoiceCustomer.getEmail()%>
                            </address>
                        </div>

                        <div class="invoice-date">
                            <small>Invoice</small>
                            <div class="date text-inverse m-t-5A">Invoice Number: <%= invoice.getIdSale()%></div>
                            <div class="invoice-detail">Date: <%= invoice.getDate()%></div>
                            Services Product
                        </div>
                    </div>
                    <!-- end invoice-header -->
                    <!-- begin invoice-content -->
                    <div class="invoice-content">
                        <!-- begin table-responsive -->
                        <div class="table-responsive">
                            <table class="table table-invoice">
                                <thead>
                                    <tr>
                                <thead>
                                    <tr>
                                        <th class="text-center" scope="col" width="10">Make</th>
                                        <th class="text-center" scope="col" width="10">Brand</th>
                                        <th class="text-center" scope="col" width="10">Year</th>
                                        <th class="text-center" scope="col" width="10">Color</th>                        
                                        <th class="text-center" scope="col" width="10">Mileage</th>
                                        <th class="text-center" scope="col" width="10">Warranty Time</th>
                                        <th class="text-center" scope="col"width="10">Type Car</th>
                                        <th class="text-center" scope="col" width="30">Prices</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <tr>

                                        <td class="text-center"> <%=invoiceVehicle.getMake()%> </td>
                                        <td class="text-center"> <%=invoiceVehicle.getBrand()%> </td>
                                        <td class="text-center"> <%=invoiceVehicle.getYear()%></td>
                                        <td class="text-center"> <%=invoiceVehicle.getColor()%></td>
                                        <td class="text-center"> <%=invoiceVehicle.getMiliage()%></td>
                                        <td class="text-center"> <%=invoiceVehicle.getWarrantyTime()%></td>
                                        <td class="text-center"> <%=invoiceVehicle.getTypeCar()%></td>
                                        <td class="text-center"> <%=invoiceVehicle.getPrices()%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- end table-responsive -->
                        <!-- begin invoice-price -->
                        <div class="invoice-price">
                            <div class="invoice-price-left">
                                <div class="invoice-price-row">
                                    <div class="sub-price">
                                        <small>SUBTOTAL</small>
                                        <span class="text-inverse"><%=invoiceVehicle.getPrices()%></span>
                                    </div>
                                    <div class="sub-price">
                                        <i class="fa fa-plus text-muted"></i>
                                    </div>
                                    <div class="sub-price">
                                        <small>PAYPAL FEE (5%)</small>
                                        <span class="text-inverse"><%=VehicleWeb.calculateVAT(invoiceVehicle.getPrices())%></span>
                                    </div>
                                </div>
                            </div>
                            <div class="invoice-price-right">
                                <small>TOTAL</small> <span class="f-w-600"><%=VehicleWeb.calculateTotalWithVAT(invoiceVehicle.getPrices())%></span>
                            </div>
                        </div>
                        <!-- end invoice-price -->
                    </div>
                    <!-- end invoice-content -->
                    <!-- begin invoice-note -->
                    <div class="invoice-note">
                        * Warranty: All our new vehicles come with a warranty of 3 years or 36,000 miles, whichever comes first. 
                        For more information regarding the terms and conditions of the warranty, please contact us.<br>
                        * If you have any questions concerning this invoice, contact  your asesor.
                    </div>
                    <!-- end invoice-note -->
                    <!-- begin invoice-footer -->
                    <div class="invoice-footer">
                        <p class="text-center m-b-5 f-w-600">
                            Thank you for your purchase.
                        </p>
                        <p class="text-center">
                            <span class="m-r-10"><i class="fa fa-fw fa-lg fa-globe"></i> www.altayermotors.ae</span>
                            <span class="m-r-10"><i class="fa fa-fw fa-lg fa-phone-volume"></i> (971) 456-7890</span>
                            <span class="m-r-10"><i class="fa fa-fw fa-lg fa-envelope"></i> info@altayermotors.com</span>
                        </p>
                    </div>
                    <!-- end invoice-footer -->
                </div>
            </div>
        </div>



</html>