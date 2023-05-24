package Servlet.Customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
@WebServlet(urlPatterns = {"/Customer/Update"})
public class CustomerUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
    
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        System.out.println("id Enviado customer: " +idCustomer);
        String action = "Update";
        
        CustomerWeb updateCustomer = CustomerDao.getCustomer(idCustomer);
        
        System.out.println("**********************");
        System.out.println("id Customer: " +updateCustomer.getId());
        System.out.println("name: " +updateCustomer.getName());
        System.out.println("Estoy obteniendo el id para hacer la actualizacion");
       
        
        HttpSession session = request.getSession(false);
        
        session.setAttribute("customer", updateCustomer);
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
        
        CustomerWeb customer1= (CustomerWeb)request.getSession().getAttribute("customer");
        
        customer1.setName(name);
        customer1.setPhoneNumber(phoneNumber);
        customer1.setAddress(address);
        customer1.setEmail(email);
        
        CustomerDao.updateCustomer(customer1);
        System.out.println("Servlet de actualización ejecutado" + customer1.getName());
        response.sendRedirect("List");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
