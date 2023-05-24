/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Customer;

import PersistenciaDatos.CustomerDao;
import backend.CustomerWeb;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CustomerDeleteServlet", urlPatterns = {"/Customer/Delete"})
public class CustomerDeleteServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        CustomerDao.deleteCustomer(idCustomer);
        
        List<CustomerWeb> listaCustomers = CustomerDao.mostrarCustomers();
        request.setAttribute("listaCustomer", listaCustomers);
        
        request.setAttribute("message", "Customer deleted successfully");
        request.getRequestDispatcher("MostrarCustomer.jsp").forward(request, response);
 
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
