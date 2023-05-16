/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDatos;

import backend.EmployeeWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
    
    private static void includeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
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
                int employeeId = rs.getInt(1);
                String name = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String address = rs.getString(4);
                String email = rs.getString(5);
                String user=rs.getString(6);
                String state=rs.getString(7);
                String jobPosition = rs.getString(8);
                String salary = rs.getString(9);
                
                
                System.out.println("employeeId: " + employeeId);
                System.out.println("name: " + name);
                System.out.println("phoneNumber: " + phoneNumber);
                System.out.println("address: " + address);
                System.out.println("email: " + email);
                System.out.println("user: " + user);
                System.out.println("state: " + state);
                System.out.println("jobPosition: " + jobPosition);
                System.out.println("salary: " + salary);
                
                EmployeeWeb newEmployee= new EmployeeWeb(name, phoneNumber, address, email, salary, jobPosition, employeeId, user, state);
                
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
                String query = "INSERT INTO employee (name, phone_number, address, email, user, state, job_position, salary) VALUES (?,?,?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getPhoneNumber());
                ps.setString(3, employee.getAddress());
                ps.setString(4, employee.getEmail());
                ps.setString(5, employee.getJobPosition());
                ps.setString(6, employee.getUser());
                ps.setString(7, employee.getState());
                ps.setString(8, employee.getSalary());

                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    public static void updateEmployee(EmployeeWeb employee){
        
     includeDriver();

        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "update employee set name=?, phone_number=?, address=?, email=>, user=?, state=?, job_position=?, salary=?) where id_employee=?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getPhoneNumber());
                ps.setString(3, employee.getAddress());
                ps.setString(4, employee.getEmail());
                ps.setString(5, employee.getJobPosition());
                ps.setString(6, employee.getUser());
                ps.setString(7, employee.getState());
                ps.setString(8, employee.getSalary());
                ps.setInt(9,employee.getIdEmploployee());

                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    public static void deleteEmployee(int id_employee){
        includeDriver();

        Conexion db_connect = new Conexion();
        String query="delete from employee where id_employee = ?" ;
        
        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1,id_employee);
            ps.executeUpdate();
            
          
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
    }
}
