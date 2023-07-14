package backend;

import java.time.LocalDate;




public class Sale {
 
    int idSale;
    LocalDate date;
    int employeeId;
    int carId;
    int customerId;

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
    
    
    
}
