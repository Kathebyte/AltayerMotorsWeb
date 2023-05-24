/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Customer;


import PersistenciaDatos.CustomerDao;
import backend.CustomerWeb;
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
@WebServlet(name = "CustomerCreateServlet", urlPatterns = {"/Customer/Create"})
public class CustomerCreateServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = "Create";
       
        HttpSession session = request.getSession();
        
        session.setAttribute("action", action);
        
        response.sendRedirect("CustomerForm.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String name= request.getParameter("name");
        String phoneNumber= request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email= request.getParameter("email");
        
        
        CustomerWeb newCustomer = new CustomerWeb(name, phoneNumber, address, email);
        
        newCustomer.setName(name);
        newCustomer.setPhoneNumber(phoneNumber);
        newCustomer.setAddress(address);
        newCustomer.setEmail(email);
        
        CustomerDao.createCustomer(newCustomer);
        System.out.println("Customer creado nombre: "+name);
        
        
        HttpSession misesion = request.getSession();
        
        misesion.setAttribute("customer", newCustomer);

        response.sendRedirect("List");
        System.out.println("Servlet de creación ejecutado");
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
