/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDatos;

import backend.CustomerWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static void includeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
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

    public static void createCustomer(CustomerWeb customer) {
        includeDriver();

        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "insert into customer (name, phoneNumber, address, email) values  (?,?,?,?)";
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

    public static void deleteCustomer(int idCustomer) {
        includeDriver();

        Conexion db_connect = new Conexion();
        String query = "delete from customer where idCustomer = ?";

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idCustomer);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public static CustomerWeb getCustomer(int idCustomer) {

        includeDriver();
        CustomerWeb customer = new CustomerWeb();
        Conexion db_connect = new Conexion();
        String query = "select * from customer where idCustomer=?";

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idCustomer);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String name = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String address = rs.getString(4);
                String email = rs.getString(5);

                customer = new CustomerWeb(idCustomer, name, phoneNumber, address, email);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;

    }

    public static void updateCustomer(CustomerWeb customer) {

        includeDriver();

        Conexion db_connect = new Conexion();
        String query = "update customer set name=?, address=?, phoneNumber=?, email=?";

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getPhoneNumber());
            ps.setString(4, customer.getEmail());

            ps.executeUpdate();
            db_connect.closeConection();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
