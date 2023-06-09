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

        String query = "select employee.id_employee,employee.name,employee.phone_number,employee.address,employee.email,employee.user,job_position.name as job_position,salary,employee.state from employee inner join job_position on employee.id_job_position = job_position.id_job_position";
        
        
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
                String user = rs.getString(6);
                String jobPosition = rs.getString(7);
                double salary = rs.getDouble(8);
                int state = rs.getInt(9);    
                
                

                EmployeeWeb newEmployee = new EmployeeWeb(name, phoneNumber, address, email, salary, jobPosition, employeeId, user, state);

                ListEmployees.add(newEmployee);
                
                System.out.println("salary "+salary);

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
                String query = "INSERT INTO employee (name, phone_number, address, email, user, id_job_position, salary, state) VALUES (?,?,?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getPhoneNumber());
                ps.setString(3, employee.getAddress());
                ps.setString(4, employee.getEmail());
                ps.setString(5, employee.getUser());
                ps.setString(6, employee.getJobPosition());                
                ps.setDouble(7, employee.getSalary());
                ps.setInt(8, employee.getState());

                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void updateEmployee(EmployeeWeb employee) {

        includeDriver();

        Conexion db_connect = new Conexion();
        String Updatequery = "update employee \n" +
                                "set name = ?,\n" +
                                "    phone_number=?,\n" +
                                "    address=?,\n" +
                                "    email=?,\n" +
                                "    user=?,\n" +
                                "    id_job_position=?,\n" +
                                "    salary=?,\n" +
                                "    state=?\n" +
                                "where id_employee=?"; 

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement updateStatement = conexion.prepareStatement(Updatequery);
            updateStatement.setString(1, employee.getName());
            updateStatement.setString(2, employee.getPhoneNumber());
            updateStatement.setString(3, employee.getAddress());
            updateStatement.setString(4, employee.getEmail());
            updateStatement.setString(5, employee.getUser());
            updateStatement.setString(6, employee.getJobPosition());
            updateStatement.setDouble(7, employee.getSalary());
            updateStatement.setInt(8, employee.getState());
            updateStatement.setInt(9, employee.getIdEmployee());

            updateStatement.executeUpdate();
            db_connect.closeConection();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static EmployeeWeb getId(int idEmployee) {

        includeDriver();
        EmployeeWeb employee = new EmployeeWeb();
        Conexion dbConexion = new Conexion();
        String query = "select * from employee where id_employee=?";

        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idEmployee);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String name = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String address = rs.getString(4);
                String email = rs.getString(5);
                String user = rs.getString(6);
                
                String jobPosition = rs.getString(7);
                double salary = rs.getDouble(8);
                int state = rs.getInt(9);
                
                
                
                System.out.println("SALARY: " + salary);

                employee = new EmployeeWeb(name, phoneNumber, address, email, salary, jobPosition, idEmployee, user, state);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;

    }

    public static void deleteEmployee(int id_employee) {
        includeDriver();

        Conexion db_connect = new Conexion();
        String query = "delete from employee where id_employee = ?";

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id_employee);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}
