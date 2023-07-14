package Servlet.Sale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import PersistenciaDatos.SaleDao;
import backend.Sale;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        
        String action="Create";
        HttpSession session= request.getSession();
        
        session.setAttribute("action", action);
        response.sendRedirect("SaleForm.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String date= request.getParameter("date");
        String employeeId= request.getParameter("idEmployee");
        String carId= request.getParameter("idCar");
        String customerId=request.getParameter("idCustomer");
        
        int employeeId1 =(employeeId != null) ? Integer.parseInt(employeeId) : 0;
        int carId1 =  (carId != null) ? Integer.parseInt(carId) : 0;
        int customerId1 = (customerId !=null) ? Integer.parseInt(customerId) : 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
       
        Sale newSale = new Sale();

        newSale.setDate(localDate);
        newSale.setCustomerId(customerId1);
        newSale.setCarId(carId1);
        newSale.setEmployeeId(employeeId1);
        
       SaleDao.CreateSale(newSale);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("employee", newSale);

        response.sendRedirect("List");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
