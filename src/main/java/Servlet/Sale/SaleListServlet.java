/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Sale;

import PersistenciaDatos.SaleDao;
import backend.Sale;
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
@WebServlet(name = "SaleListServlet", urlPatterns = {"/Sale/List"})
public class SaleListServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Sale> listSales = SaleDao.ListSale();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listSales", listSales);
        request.getRequestDispatcher("MostrarSales.jsp").forward(request, response);
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
        misesion.setAttribute("listSales", newSale);

//        response.sendRedirect("MostrarSales.jsp");

    }
    


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
