/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author kathemacbook
 */
public class Sales {
    
    int idVenta;
    int idVehicle;
    int idCustomer;
    int idEmployee;
    int comision;
    int precioVenta;
    
    public Sales() {
    }

    public Sales(int idVehicle, int idCustomer, int idEmployee) {
        this.idVehicle = idVehicle;
        this.idCustomer = idCustomer;
        this.idEmployee = idEmployee;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }
    
    
    
    
}
