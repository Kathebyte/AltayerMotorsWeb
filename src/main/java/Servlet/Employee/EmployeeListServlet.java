package Servlet.Employee;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import PersistenciaDatos.EmployeeDao;
import backend.EmployeeWeb;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/Employee/List"})
public class EmployeeListServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        List<EmployeeWeb> listaEmployee = new ArrayList<>();
        
        listaEmployee = EmployeeDao.mostrarEmployees();
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaEmployee", listaEmployee);
        response.sendRedirect("MostrarEmployee.jsp");
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name= request.getParameter("name");
        String phoneNumber =request.getParameter("phoneNumber");
        String address=request.getParameter("address");
        String email=request.getParameter("email");
        String salary=request.getParameter("salary");
        String jobPosition=request.getParameter("jobPosition");
        String user=request.getParameter("user");
        String state=request.getParameter("state");
        
        EmployeeWeb employee1= new EmployeeWeb();
        
         int stateV = 0;
        if ( state != null){
            stateV = Integer.parseInt(state);
        }
        
          double salary1 = 0;
        if ( salary != null){
            salary1 = Double.parseDouble(salary);
        }
        
        
        employee1.setName(name);
        employee1.setPhoneNumber(phoneNumber);
        employee1.setAddress(address);
        employee1.setEmail(email);
        employee1.setSalary(salary1);
        employee1.setJobPosition(jobPosition);
        employee1.setUser(user);
        employee1.setState(stateV);
        
        
        

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
