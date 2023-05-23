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
        
        CustomerWeb customerUpdate= CustomerDao.getCustomer(idCustomer);
        String action = "Update";
        
        HttpSession session = request.getSession(false);
        
        session.setAttribute("customer", customerUpdate);
        session.setAttribute("action", action);
        
        response.sendRedirect("CustomerForm.jsp");

    }
        
        
        
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
