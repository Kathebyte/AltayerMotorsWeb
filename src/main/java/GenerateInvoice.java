/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import PersistenciaDatos.SaleDao;
import backend.Sale;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Sale/GenerateInvoice"})
public class GenerateInvoice extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idSale = Integer.parseInt(request.getParameter("saleId"));
        
        System.out.println("ID ENVIADO PARA IMPRIMIR FACTURA " + idSale);
        
        
        Sale saleInvoice = SaleDao.GenerateInvoice(idSale);
       

        HttpSession misesion = request.getSession();
        misesion.setAttribute("Sale",saleInvoice);
        request.getRequestDispatcher("GenerateInvoice.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
