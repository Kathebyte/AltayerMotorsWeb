<%-- 
    Document   : Index.jsp
    Created on : 5 May 2023, 8:36:44 PM
    Author     : kathemacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
        <title>Inicio</title>
    </head>
    <body>
        
        <div class="container mt-4 col-lg-4">
            <div class="card co-sm-10" >
                <div class="form-group">
                <form>
                    <div class="form-group">
                        <h3>Login</h3>
                        <img src="../imagenes/enter.png" alt="70" width="170"/>
                        <label>Welcome Altayer motors</label>
                    </div>
                    <div class="form-group">
                        <label>User:</label>
                        <input type="text" name="txtuser" class="form-control">
                       
                    </div>
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" name="txtpass" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="ingresar" class="btn btn-primary">
                </form>
                </div>
            </div>
                       
    </body>
</html>
