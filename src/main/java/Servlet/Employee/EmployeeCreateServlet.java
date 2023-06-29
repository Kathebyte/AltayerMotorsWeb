package Servlet.Employee;

import PersistenciaDatos.EmployeeDao;
import backend.EmployeeWeb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EmployeeCreateServlet", urlPatterns = {"/Employee/Create"})
public class EmployeeCreateServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action="Create";
        HttpSession session= request.getSession();
        
        session.setAttribute("action", action);
        response.sendRedirect("EmployeeForm.jsp");
  
  
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String phoneNumber =request.getParameter("phoneNumber");
        String address =request.getParameter("address");
        String email=request.getParameter("email");
        String user=request.getParameter("user");
        String state=request.getParameter("state");
        String jobPosition=request.getParameter("jobPosition");
        String salary=request.getParameter("salary");
        
        
        
        EmployeeWeb newEmployee = new EmployeeWeb(name, phoneNumber, address, email, salary, jobPosition, user, state);
        
        newEmployee.setName(name);
        newEmployee.setPhoneNumber(phoneNumber);
        newEmployee.setAddress(address);
        newEmployee.setEmail(email);
        newEmployee.setUser(user);
        newEmployee.setState(state);
        newEmployee.setJobPosition(jobPosition);
        newEmployee.setSalary(salary);
        
        EmployeeDao.createEmployeeDB(newEmployee);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("employee", newEmployee);

        response.sendRedirect("List");
      
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
