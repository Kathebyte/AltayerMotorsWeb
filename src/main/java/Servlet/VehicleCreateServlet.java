/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import PersistenciaDatos.ControladorDao;
import backend.VehicleWeb;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kathemacbook
 */
@WebServlet(name = "VehicleCreateServlet", urlPatterns = {"/Vehicle/Create"})
public class VehicleCreateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("CreateVehicle.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String make = request.getParameter("make");
        String brand= request.getParameter("brand");
        String year = request.getParameter("year");
        String miliage= request.getParameter("miliage");
        String color= request.getParameter("color");
        String prices= request.getParameter("prices");
        String typeCar =request.getParameter("typeCar");
        String warrantyTime=request.getParameter("warrantyTime");
        String accidentHistory=request.getParameter("accidentHistory");
        
        VehicleWeb vehicle = new VehicleWeb();
        
        double pricesV =0;
        if ( prices != null){
            pricesV = Double.parseDouble(prices);
        }
        
        vehicle.setMake(make);
        vehicle.setBrand(brand);
        vehicle.setYear(year);
        vehicle.setMiliage(miliage);
        vehicle.setColor(color);
        vehicle.setPrices(pricesV);
        vehicle.setTypeCar(typeCar);
        vehicle.setWarrantyTime(warrantyTime);
        vehicle.setAccidentHistory(accidentHistory);
        
        ControladorDao.createVehicledDB(vehicle);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("vehicle", vehicle);

        response.sendRedirect("List");
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
