/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Vehicle;

import PersistenciaDatos.VehicleDao;
import backend.VehicleWeb;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "VehicleCreateServlet", urlPatterns = {"/Vehicle/Create"})
public class VehicleCreateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = "Create";
       
        HttpSession session = request.getSession();
        
        session.setAttribute("action", action);
        
        response.sendRedirect("VehicleForm.jsp");

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
        
        VehicleWeb newVehicle= new VehicleWeb(make, brand, year, miliage, color, 0, typeCar, warrantyTime, accidentHistory);
        
        int pricesV =0;
        if ( prices != null){
            pricesV = Integer.parseInt(prices);
        }
        
        newVehicle.setMake(make);
        newVehicle.setBrand(brand);
        newVehicle.setYear(year);
        newVehicle.setMiliage(miliage);
        newVehicle.setColor(color);
        newVehicle.setPrices(pricesV);
        newVehicle.setTypeCar(typeCar);
        newVehicle.setWarrantyTime(warrantyTime);
        newVehicle.setAccidentHistory(accidentHistory);
        VehicleDao.createVehicledDB(newVehicle);
        
        HttpSession misesion = request.getSession();
        
        misesion.setAttribute("vehicle", newVehicle);

        response.sendRedirect("List");
        System.out.println("Servlet de creación ejecutado");
      
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
