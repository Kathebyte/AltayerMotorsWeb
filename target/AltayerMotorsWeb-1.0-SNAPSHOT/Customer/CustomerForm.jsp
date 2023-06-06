<%-- 
    Document   : CreateCustomer
    Created on : 5 May 2023, 10:16:45 AM
    Author     : kathemacbook
--%>

<%@page import="backend.CustomerWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <% 
            String idCustomer= "";
            String name="";
            String phoneNumber= "";
            String address= "";
            String email= "";
            
            CustomerWeb customerUpdate;
            String action = (String) session.getAttribute("action");
            if (action == "Update") {
            customerUpdate = (CustomerWeb)request.getSession().getAttribute("customer");
            name = customerUpdate.getName();
            phoneNumber=customerUpdate.getPhoneNumber();
            address=customerUpdate.getAddress();
            email=customerUpdate.getEmail();
            
            }

            %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE CUSTOMER</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        
        <form action="<%= action%>" method="POST">
            <div class="container" >
                <h2 class="row my-4"> CREATE NEW CUSTOMER </h2>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Name: </label>
                    <div class="col-9">
                    <input class="form-control" type="text" name="name" value="<%=name%>">
                </div>
                </div>
                
                <div class="row my-2">
                    <label class="col-3 col-form-label">Address: </label>
                    <div class="col-9">
                    <input class="form-control" type="text" name="address" value="<%=address%>">
                    </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Phone Number: </label>
                    <div class="col-9" >
                    <input class="form-control" name="phoneNumber" value="<%=phoneNumber%>">
                </div>
                </div>
                <div class="row my-2">
                    <label class="col-3 col-form-label">Email: </label>
                     <div class="col-9" >
                    <input class="form-control" type="text" name="email" value="<%=email%>">
                </div>
                </div>
                <div class="row py-4 my-2 mx-auto">
                    <div class="col-12 text-center">
                        <button type="submit" class="btn btn-outline-primary">Save</button>
                    </div>
                </div>
            </div> 
            <div class="btn-group">
                    <a href="/AltayerMotorsWeb" class="btn btn-primary" aria-current="page">Menu</a>
            </div>
        </form>
    </body>
</html>
