/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Customer;


import PersistenciaDatos.CustomerDao;
import backend.CustomerWeb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CustomerListServlet", urlPatterns = {"/Customer/List"})
public class CustomerListServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        List<CustomerWeb>listaCustomers = new ArrayList<>();
        
        listaCustomers = CustomerDao.mostrarCustomers();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCustomers", listaCustomers);
        response.sendRedirect("MostrarCustomer.jsp");
    
    }
        
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name= request.getParameter("name");
        String phoneNumber= request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email= request.getParameter("email");
        
        CustomerWeb customer1 = new CustomerWeb();
        
        customer1.setName(name);
        customer1.setPhoneNumber(phoneNumber);
        customer1.setAddress(address);
        customer1.setEmail(email);
        
        response.setContentType("text/plain");
        response.getWriter().println("Name:" + (name));
        response.getWriter().println("Phone Numbre:" + (phoneNumber));
        response.getWriter().println("Address:" + (address));
        response.getWriter().println("Email:" + (email));
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
