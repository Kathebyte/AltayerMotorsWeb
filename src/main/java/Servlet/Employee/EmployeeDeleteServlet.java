package Servlet.Employee;

import PersistenciaDatos.EmployeeDao;
import backend.EmployeeWeb;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EmployeeDeleteServlet", urlPatterns = {"/Employee/Delete"})
public class EmployeeDeleteServlet extends HttpServlet {

    
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
        
        int id_employee = Integer.parseInt(request.getParameter("idUser"));
        EmployeeDao.deleteEmployee(id_employee);
        
        List<EmployeeWeb> listEmployee = EmployeeDao.mostrarEmployees();
        request.setAttribute("listEmployee", listEmployee);
        
        request.setAttribute("message", "Employee deleted successfully");
        request.getRequestDispatcher("MostrarEmployee.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
