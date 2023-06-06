/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


public class EmployeeWeb extends UserWeb {
    
    String salary;
    int jobPosition;
    int idEmployee;
    String user;
    String state; 

    public EmployeeWeb() {
        super("", "", "", "");
    }

    public EmployeeWeb(String name, String phoneNumber, String address, String email,String salary, String jobPosition, int idEmployee, String user, String state) {
        super(name, phoneNumber, address, email);
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.idEmployee = idEmployee;
        this.user = user;
        this.state = state;
    }
    
    public EmployeeWeb(String name, String phoneNumber, String address, String email,String salary, String jobPosition, String user, String state) {
        super(name, phoneNumber, address, email);
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.user = user;
        this.state = state;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

 
 
}
 