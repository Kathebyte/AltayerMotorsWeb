package Servlet;

import PersistenciaDatos.VehicleDao;
import backend.VehicleWeb;
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
@WebServlet(name = "VehicleListServlet", urlPatterns = {"/Vehicle/List"})
public class VehicleListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<VehicleWeb> listaVehicles = new ArrayList<>();

        listaVehicles = VehicleDao.mostrarVehicles();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaVehicles", listaVehicles);
        response.sendRedirect("MostrarVehicles.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String make = request.getParameter("make");
        String brand = request.getParameter("brand");
        String year = request.getParameter("year");
        String color = request.getParameter("color");
        String prices = request.getParameter("prices");
        String miliage = request.getParameter("miliage");
        String warrantyTime = request.getParameter("warrantyTime");
        String accidentHistory = request.getParameter("accidentHistory");
        String typeCar = request.getParameter("typeCar");
        
        VehicleWeb vehicle1 = new VehicleWeb();

        int prices1 = 0;

        if (prices != null) {
            prices1 = Integer.parseInt(prices);
        }

        vehicle1.setMake(make);
        vehicle1.setBrand(brand);
        vehicle1.setYear(year);
        vehicle1.setMiliage(miliage);
        vehicle1.setColor(color);
        vehicle1.setPrices(prices1);
        vehicle1.setTypeCar(typeCar);
        vehicle1.setWarrantyTime(warrantyTime);
        vehicle1.setAccidentHistory(accidentHistory);

        response.setContentType("text/plain");
        response.getWriter().println("Make:" + (make));
        response.getWriter().println("Brand:" + (brand));
        response.getWriter().println("Year:" + (year));
        response.getWriter().println("Miliage:" + (miliage));
        response.getWriter().println("Color" + (color));
        response.getWriter().println("Prices" + (prices1));
        response.getWriter().println("Type car:" + (typeCar));
        response.getWriter().println("Warranty time:" + (warrantyTime));
        response.getWriter().println("Accidentent History" + (accidentHistory));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
