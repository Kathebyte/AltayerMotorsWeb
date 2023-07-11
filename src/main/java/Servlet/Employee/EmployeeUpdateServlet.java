package Servlet.Employee;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import PersistenciaDatos.EmployeeDao;
import backend.EmployeeWeb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Employee/Update"})
public class EmployeeUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        System.out.println("ID ENVIADO PARA ACTUALIZAR " + idEmployee);

        String action = "Update";

        EmployeeWeb updateEmployee = EmployeeDao.getId(idEmployee);

        System.out.println("***************************** SERVLET*******");
        System.out.println("id Employee = " + updateEmployee.getIdEmployee());
        System.out.println("name employee= " + updateEmployee.getName());
        System.out.println("state ="+updateEmployee.getState());
        System.out.println("user ="+updateEmployee.getUser ());
        System.out.println(" jobPOSITION="+updateEmployee.getJobPosition());

        HttpSession session = request.getSession(false);

        session.setAttribute("employee", updateEmployee);
        session.setAttribute("action", action);

        response.sendRedirect("EmployeeForm.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String state = request.getParameter("state");
        String jobPosition = request.getParameter("jobPosition");
        String salary = request.getParameter("salary");

        EmployeeWeb newEmployee = (EmployeeWeb) request.getSession().getAttribute("employee");
        
        boolean state1 = true;
        if (state != null) {
            state1 = Boolean.parseBoolean(state);
        }

        newEmployee.setUser(user);
        newEmployee.setName(name);
        newEmployee.setPhoneNumber(phoneNumber);
        newEmployee.setAddress(address);
        newEmployee.setEmail(email);
        newEmployee.setState(state1);
        newEmployee.setJobPosition(jobPosition);
        newEmployee.setSalary(salary);


        //EmployeeDao.updateEmployee(newEmployee);
        System.out.println("servlet Employee actualizando");
        response.sendRedirect("List");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
