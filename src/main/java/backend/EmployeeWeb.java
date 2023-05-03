/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


public class EmployeeWeb extends UserWeb{
    
    double salary;
    String jobPosition;
    int idEmploployee;

    public EmployeeWeb( int idEmployee, String name, String phoneNumber, String address, String email,double salary, String jobPosition) {
        super(name, phoneNumber, address, email);
        this.idEmploployee=idEmployee;
        this.salary = salary;
        this.jobPosition = jobPosition;
    }

    public int getIdEmploployee() {
        return idEmploployee;
    }

    public void setIdEmploployee(int idEmploployee) {
        this.idEmploployee = idEmploployee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    
    
}
 