package backend;

import java.time.LocalDate;




public class Sale {
 
    int idSale;
    LocalDate date;
    int employeeId;
    int carId;
    int customerId;
    private VehicleWeb vehicle;
    private EmployeeWeb employee;
    private CustomerWeb customer;

    public Sale(int idSale, LocalDate date, int employeeId, int carId, int customerId, VehicleWeb vehicle, EmployeeWeb employee, CustomerWeb customer) {
        this.idSale = idSale;
        this.date = date;
        this.employeeId = employeeId;
        this.carId = carId;
        this.customerId = customerId;
        this.vehicle = vehicle;
        this.employee = employee;
        this.customer = customer;
    }

    public Sale(int idSale, LocalDate date, int employeeId, int carId, int customerId) {
        this.idSale = idSale;
        this.date = date;
        this.employeeId = employeeId;
        this.carId = carId;
        this.customerId = customerId;
    }

    public Sale() {
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public VehicleWeb getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleWeb vehicle) {
        this.vehicle = vehicle;
    }

    public EmployeeWeb getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeWeb employee) {
        this.employee = employee;
    }

    public CustomerWeb getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerWeb customer) {
        this.customer = customer;
    }

  
}
