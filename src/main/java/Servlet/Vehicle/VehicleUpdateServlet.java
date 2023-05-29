package Servlet.Vehicle;

import PersistenciaDatos.VehicleDao;
import backend.VehicleWeb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "VehicleUpdateServlet", urlPatterns = {"/Vehicle/Update"})
public class VehicleUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idVehicle = Integer.parseInt(request.getParameter("carIdUpdate"));
        System.out.println("id vehicle enviado: " +idVehicle);
        
        String action = "Update";
        
        VehicleWeb updateVehicle = VehicleDao.getVehicle(idVehicle);
        
        System.out.println("**********************");
        System.out.println("CarId: " +updateVehicle.getCarId());
        System.out.println("Make: " +updateVehicle.getMake());
       
        HttpSession session = request.getSession(false);
        session.setAttribute("vehicle", updateVehicle);
        session.setAttribute("action", action);
        
        response.sendRedirect("VehicleForm.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String make = request.getParameter("make");
        String brand= request.getParameter("brand");
        String year = request.getParameter("year");
        String miliage= request.getParameter("miliage");
        String color= request.getParameter("color");
        String prices= request.getParameter("prices");
        String typeCar =request.getParameter("typeCar");
        String warrantyTime=request.getParameter("warrantyTime");
        String accidentHistory=request.getParameter("accidentHistory");
        
        VehicleWeb newVehicle= (VehicleWeb) request.getSession().getAttribute("vehicle");
        
        int pricesV =0;
        if ( prices != null){
            pricesV = Integer.parseInt(prices);
        }
        
        newVehicle.setMake(make);
        newVehicle.setBrand(brand);
        newVehicle.setYear(year);
        newVehicle.setMiliage(miliage);
        newVehicle.setColor(color);
        newVehicle.setPrices(pricesV);
        newVehicle.setTypeCar(typeCar);
        newVehicle.setWarrantyTime(warrantyTime);
        newVehicle.setAccidentHistory(accidentHistory);
        
        VehicleDao.updateVehicle(newVehicle);
        System.out.println("Servlet de actualización ejecutado");
        response.sendRedirect("List");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
