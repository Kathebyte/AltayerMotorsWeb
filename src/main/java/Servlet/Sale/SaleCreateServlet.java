package Servlet.Sale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import PersistenciaDatos.CustomerDao;
import PersistenciaDatos.EmployeeDao;
import PersistenciaDatos.SaleDao;
import PersistenciaDatos.VehicleDao;
import backend.CustomerWeb;
import backend.EmployeeWeb;
import backend.Sale;
import backend.VehicleWeb;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
@WebServlet(name = "SaleCreateServlet", urlPatterns = {"/Sale/Create"})
public class SaleCreateServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<EmployeeWeb> listEmployee= EmployeeDao.mostrarEmployees();
        
        List<VehicleWeb> listVehicles = VehicleDao.mostrarVehicles();
        
        List<CustomerWeb> listCustomer = CustomerDao.mostrarCustomers();
        
        HttpSession session= request.getSession();
        
        session.setAttribute("listEmployee", listEmployee);
        session.setAttribute("listVehicles", listVehicles);
        session.setAttribute("listCustomer", listCustomer);
        response.sendRedirect("SaleForm.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String date= request.getParameter("date");
        String employeeId= request.getParameter("idEmployee");
        String carId= request.getParameter("carId");
        String customerId=request.getParameter("idCustomer");
        
        int employeeId1 =(employeeId != null) ? Integer.parseInt(employeeId) : 0;
        int carId1 =  (carId != null) ? Integer.parseInt(carId) : 0;
        int customerId1 = (customerId !=null) ? Integer.parseInt(customerId) : 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        System.out.println("Estoy en el servlet Sale Create");
        System.out.println("date: "+date +" employee "+employeeId + " customerId "+ customerId + "employee id " + employeeId);
        Sale newSale = new Sale();

        newSale.setDate(localDate);
        newSale.setCustomerId(customerId1);
        newSale.setCarId(carId1);
        newSale.setEmployeeId(employeeId1);
        
        SaleDao.CreateSale(newSale);
        
        HttpSession misesion = request.getSession();
        
        response.sendRedirect("List");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
