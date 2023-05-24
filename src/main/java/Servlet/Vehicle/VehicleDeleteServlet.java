package Servlet.Vehicle;

import PersistenciaDatos.VehicleDao;
import backend.VehicleWeb;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Vehicle/Delete"})
public class VehicleDeleteServlet extends HttpServlet {

    
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
        
        int carId= Integer.parseInt(request.getParameter("carId"));
        VehicleDao.deleteVehicle(carId);
        
    
        
        List<VehicleWeb> listaVehicles = VehicleDao.mostrarVehicles();
        request.setAttribute("listaVehicles", listaVehicles);
        
        
        request.setAttribute("message", "Vehicle deleted successfully");
        request.getRequestDispatcher("MostrarVehicles.jsp").forward(request, response);
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
