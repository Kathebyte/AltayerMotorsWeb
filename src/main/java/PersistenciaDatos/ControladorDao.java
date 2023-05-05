package PersistenciaDatos;

import backend.CustomerWeb;
import backend.EmployeeWeb;
import backend.VehicleWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorDao {

    private static void includeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void createVehicledDB(VehicleWeb vehicle) {
        includeDriver();

        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "insert into vehicle(make, brand, year, miliage, color, prices, type_car, warranty_time) VALUES (?,?,?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, vehicle.getMake());
                ps.setString(2, vehicle.getBrand());
                ps.setString(3, vehicle.getYear());
                ps.setString(4, vehicle.getMiliage());
                ps.setString(5, vehicle.getColor());
                ps.setDouble(6, vehicle.getPrices());
                ps.setString(7, vehicle.getTypeCar());
                ps.setString(8, vehicle.getWarrantyTime());
                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<VehicleWeb> mostrarVehicles() {
        includeDriver();
        List<VehicleWeb> ListVehicles = new ArrayList<>();

        String query = "select * from vehicle";
        Conexion db_connect = new Conexion();

        try (
                Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int carId = rs.getInt(1);
                String make = rs.getString(2);
                String brand = rs.getString(3);
                String year = rs.getString(4);
                String miliage = rs.getString(5);
                String color = rs.getString(6);
                double prices = rs.getDouble(7);
                String type_car = rs.getString(8);
                String warrantyTime = rs.getString(9);

                VehicleWeb vehicleNew = new VehicleWeb(carId, make, brand, year, miliage, color, prices, type_car, warrantyTime, warrantyTime);
                ListVehicles.add(vehicleNew);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error printer list Vehicles");
        }

        return ListVehicles;

    }

    public static List<CustomerWeb> mostrarCustomers() {
        includeDriver();

        List<CustomerWeb> listCustomer = new ArrayList<>();

        String query = "select * from customer";
        Conexion db_connect = new Conexion();

        try (
                Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int idCustomer = rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);

                CustomerWeb customerNew = new CustomerWeb(idCustomer, name, phone, address, email);
                listCustomer.add(customerNew);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error printer list Customer");
        }

        return listCustomer;

    }

    public static List<EmployeeWeb> mostrarEmployees() {
        includeDriver();
        List<EmployeeWeb> ListEmployees = new ArrayList<>();

        String query = "select * from employee";
        Conexion db_connect = new Conexion();

        try (
                Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt(1);
                String name = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String address = rs.getString(4);
                String email = rs.getString(5);
                String jobPosition = rs.getString(6);
                String prices = rs.getString(7);

                EmployeeWeb newEmployee = new EmployeeWeb(customerId, name, phoneNumber, address, email, jobPosition, prices);
                ListEmployees.add(newEmployee);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error printer list Customers");
        }

        return ListEmployees;

    }

    public static void createEmployeeDB(EmployeeWeb employee) {
        includeDriver();

        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "insert into employee(name, phone_number, address, email, salary, job_position) VALUES (?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getPhoneNumber());
                ps.setString(3, employee.getAddress());
                ps.setString(4, employee.getEmail());
                ps.setString(5, employee.getSalary());
                ps.setString(6, employee.getJobPosition());

                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void createCustomer(CustomerWeb customer) {
        includeDriver();

        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "insert into customer ( name, address, phone_number, email)  values (?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getAddress());
                ps.setString(3, customer.getPhoneNumber());
                ps.setString(4, customer.getEmail());

                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
    


