/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import PersistenciaDatos.ControladorDao;
import backend.EmployeeWeb;
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
@WebServlet(name = "EmployeeCreateServlet", urlPatterns = {"/Employee/Create"})
public class EmployeeCreateServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("CreateEmployee.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String phoneNumber =request.getParameter("phoneNumber");
        String address =request.getParameter("address");
        String email=request.getParameter("email");
        String salary=request.getParameter("salary");
        String jobPosition=request.getParameter("jobPosition");
        
        EmployeeWeb newEmployee = new EmployeeWeb(name, phoneNumber, address, email, salary, jobPosition);
        
//        double salary1 = 0;
//        if(salary != null ){
//            salary1 = Double.parseDouble(salary);
//        }
        
        newEmployee.setName(name);
        newEmployee.setPhoneNumber(phoneNumber);
        newEmployee.setAddress(address);
        newEmployee.setEmail(email);
        newEmployee.setSalary(salary);
        newEmployee.setJobPosition(jobPosition);
        
        
        ControladorDao.createEmployeeDB(newEmployee);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("employee", newEmployee);

        response.sendRedirect("List");
      
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
