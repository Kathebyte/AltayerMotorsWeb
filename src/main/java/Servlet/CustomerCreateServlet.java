/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import PersistenciaDatos.ControladorDao;
import backend.CustomerWeb;
import java.io.IOException;
import java.io.PrintWriter;
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
       
        
        response.sendRedirect("CreateCustomer.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String name= request.getParameter("name");
        String phoneNumber= request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email= request.getParameter("email");
        
        
        CustomerWeb customerNew = new CustomerWeb(name, phoneNumber, address, email);
        
        customerNew.setName(name);
        customerNew.setPhoneNumber(phoneNumber);
        customerNew.setAddress(address);
        customerNew.setEmail(email);
        
        ControladorDao.createCustomer(customerNew);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("customer", customerNew);

        response.sendRedirect("List");
        
                
                }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
