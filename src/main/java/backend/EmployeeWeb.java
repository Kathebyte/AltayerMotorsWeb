/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.List;


public class EmployeeWeb extends UserWeb {
    
    Double salary;
    String jobPosition;
    int idEmployee;
    String user;
    int state; 

    public EmployeeWeb() {
        super("", "", "", "");
    }

    public EmployeeWeb(Double salary, String jobPosition, int idEmployee, String user, int state, String name, String phoneNumber, String address, String email) {
        super(name, phoneNumber, address, email);
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.idEmployee = idEmployee;
        this.user = user;
        this.state = state;
    }

  
    public EmployeeWeb(String name, String phoneNumber, String address, String email,Double salary, String jobPosition, int idEmployee, String user, int state) {
        super(name, phoneNumber, address, email);
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.idEmployee = idEmployee;
        this.user = user;
        this.state = state;
    }
    
    public EmployeeWeb(String name, String phoneNumber, String address, String email,Double salary, String jobPosition, String user, int state) {
        super(name, phoneNumber, address, email);
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.user = user;
        this.state = state;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    

    
    public boolean validateNumber(String number){
       try {
           Integer.parseInt(number);
           return true;
       } catch (Exception e) {
           return false;
       }
    }

    public void add(List<EmployeeWeb> employee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
 