<%-- 
    Document   : SaleForm
    Created on : 14 Jul 2023, 2:13:07 PM
    Author     : kathemacbook
--%>

<%@page import="backend.CustomerWeb"%>
<%@page import="backend.VehicleWeb"%>
<%@page import="backend.EmployeeWeb"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% List<EmployeeWeb> listEmployee = (List<EmployeeWeb>) session.getAttribute("listEmployee");%>
<% List<VehicleWeb> listVehicles =(List<VehicleWeb>)session.getAttribute("listVehicles");%>
<% List<CustomerWeb> listCustomer = (List<CustomerWeb>)session.getAttribute("listCustomer");%>

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
                    <form action="Create" method="post">
                        <label class="col-3 col-form-label">Select Employee:</label>
                        <div class="col-9">
                            <select class="form-select" name="idEmployee" >
                                <%
                                    for (EmployeeWeb employee : listEmployee) {
                                        %>
                                        <option value="<%=employee.getIdEmployee() %>"><%=employee.getName() %></option>
                                        <%
                                    }
                                %>
                                
                                </select>
                        </div>
                        <div class="row mb-3">
                            <label class="col-3 col-form-label">Select Vehicle:</label>
                            <div class="col-9">
                                <select class="form-select" name="carId">
                                <% 
                                for (VehicleWeb vehicle : listVehicles){
                                    %>
                                    <option value="<%=vehicle.getCarId() %>"><%=vehicle.getMake() %>, <%=vehicle.getBrand()%>, <%=vehicle.getColor()%>, <%=vehicle.getTypeCar()%>, 
                                    <%=vehicle.getMiliage()%>, <%=vehicle.getWarrantyTime()%>, <%=vehicle.getYear()%>, <%=vehicle.getPrices()%>
                                    </option>
                                            
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-3 col-form-label">Select Customer:</label>
                            <div class="col-9">
                                <select class="form-select" name="idCustomer">
                                    <% for (CustomerWeb customer : listCustomer){
                                    %>
                                    <option value="<%=customer.getId()%>"><%=customer.getName() %>, <%=customer.getEmail()%>, <%=customer.getPhoneNumber()%> 
                                    </option>
                                    <%    
                                    }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="row py-4">
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary">Save</button>
                                <a href="/AltayerMotorsWeb" class="btn btn-secondary">Menu</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </form>
    
