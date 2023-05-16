/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;



public class EmployeeWeb extends UserWeb {
    
    String salary;
    String jobPosition;
    int idEmploployee;
    String user;
    String state; 

  
    public EmployeeWeb(String name, String phoneNumber, String address, String email,String salary, String jobPosition, int idEmploployee, String user, String state) {
        super(name, phoneNumber, address, email);
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.idEmploployee = idEmploployee;
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

 
   
    public int getIdEmploployee() {
        return idEmploployee;
    }

    public void setIdEmploployee(int idEmploployee) {
        this.idEmploployee = idEmploployee;
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

  
    
    
  
}
 