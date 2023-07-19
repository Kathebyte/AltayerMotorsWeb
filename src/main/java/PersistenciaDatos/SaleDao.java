/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDatos;

import backend.CustomerWeb;
import backend.EmployeeWeb;
import backend.Sale;
import backend.VehicleWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleDao {

    private static void includeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void CreateSale(Sale sale) {
        includeDriver();

        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps;

            try {
                String query = "insert into sale (date, id_employee, id_vehicle, id_customer)  VALUES (?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setObject(1, sale.getDate());
                ps.setInt(2, sale.getEmployeeId());
                ps.setInt(3, sale.getCarId());
                ps.setInt(4, sale.getCustomerId());
                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<Sale> ListSale() {
        includeDriver();

        List<Sale> listSales = new ArrayList<>();

        String query = "select id_sale, date, employee.name as Employee_Name , make.name as Make,  brand.name as Brand, vehicle.prices as Prices,\n"
                + "       customer.name as Customer_Name\n"
                + "\n"
                + "    from sale\n"
                + "    inner join vehicle  on sale.id_vehicle = vehicle.carId\n"
                + "    inner join  customer  on sale.id_customer = customer.idCustomer\n"
                + "    inner join employee  on sale.id_employee = employee.id_employee\n"
                + "    inner join make on vehicle.id_make = make.id_make\n"
                + "    inner   join brand on  vehicle.id_brand = brand.id_brand";

        Conexion db_connect = new Conexion();

        try (
                Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idSale = rs.getInt(1);
                LocalDate date = rs.getObject(2, LocalDate.class);
                String employeeName = rs.getString(3);
                String vehicleMake = rs.getString(4);
                String vehicleBrand = rs.getString(5);
                int vehiclePrices = rs.getInt(6);
                String customerName = rs.getString(7);

                VehicleWeb vehicle = new VehicleWeb();
                vehicle.setMake(vehicleMake);
                vehicle.setBrand(vehicleBrand);
                vehicle.setPrices(vehiclePrices);

                EmployeeWeb employee = new EmployeeWeb();
                employee.setName(employeeName);

                CustomerWeb customer = new CustomerWeb();
                customer.setName(customerName);

                Sale newSale = new Sale(idSale, date, 0, 0, 0, vehicle, employee, customer);
                listSales.add(newSale);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error printer list Customers");
        }

        return listSales;

    }

    public static Sale GenerateInvoice(int saleId) throws SQLException {
    includeDriver();
    Conexion db_connect = new Conexion();

    String query = "SELECT sale.id_sale, sale.date, customer.name AS nameCustomer, customer.address AS Address, customer.email AS Email, customer.phoneNumber AS PhoneNumber,\n"
            + "       employee.name AS EmployeeName, employee.address AS EmployeeOffice, make.name AS Make,\n"
            + "       brand.name AS Brand, vehicle.prices AS Prices\n"
            + "    FROM sale\n"
            + "        INNER JOIN customer ON sale.id_customer = customer.idCustomer\n"
            + "        INNER JOIN employee ON sale.id_employee = employee.id_employee\n"
            + "        INNER JOIN vehicle ON sale.id_vehicle = vehicle.carId\n"
            + "        INNER JOIN make ON vehicle.id_make = make.id_make\n"
            + "        INNER JOIN brand ON vehicle.id_brand = brand.id_brand\n"
            + "    WHERE sale.id_sale = ?";

    Sale invoiceSale = null;

    try (Connection conexion = db_connect.getConnection();
         PreparedStatement ps = conexion.prepareStatement(query)) {

        ps.setInt(1, saleId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int idSale = rs.getInt("id_sale");
            LocalDate date = rs.getObject("date", LocalDate.class);
            String nameCustomer = rs.getString("nameCustomer");
            String address = rs.getString("Address");
            String email = rs.getString("Email");
            String phoneNumber = rs.getString("PhoneNumber");
            String employeeName = rs.getString("EmployeeName");
            String make = rs.getString("Make");
            String brand = rs.getString("Brand");
            int totalprices = rs.getInt("Prices");

            VehicleWeb vehicle = new VehicleWeb();
            vehicle.setMake(make != null ? make : "");
            vehicle.setBrand(brand != null ? brand : "");
            vehicle.setPrices(totalprices);

            EmployeeWeb employee = new EmployeeWeb();
            employee.setName(employeeName != null ? employeeName : "");

            CustomerWeb customer = new CustomerWeb();
            customer.setName(nameCustomer != null ? nameCustomer : "");
            customer.setAddress(address != null ? address : "");
            customer.setEmail(email != null ? email : "");
            customer.setPhoneNumber(phoneNumber != null ? phoneNumber : "");

            invoiceSale = new Sale();
            invoiceSale.setCarId(idSale);
            invoiceSale.setDate(date);
            invoiceSale.setCustomer(customer);
            invoiceSale.setEmployee(employee);
            invoiceSale.setVehicle(vehicle);
        }

    } catch (SQLException ex) {
        System.out.println(ex);
        throw new SQLException("Error en la consulta de la factura.", ex);
    }

    return invoiceSale;
}

}
