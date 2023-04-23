
package PersistenciaDatos;

import backend.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ControladorDao {
    
    private static void includeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public static void createVehicledDB(Vehicle vehicle) {
        includeDriver();
        
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.getConnection()){
            PreparedStatement ps=null;
            
            try{
                String query= "insert into vehicle(make, brand, year, miliage, color, prices, type_car, warranty_time) VALUES (?,?,?,?,?,?,?,?)";
                ps= conexion.prepareStatement(query);
                ps.setString(1,vehicle.getMake());
                ps.setString(2,vehicle.getBrand());
                ps.setString(3,vehicle.getYear());
                ps.setString(4,vehicle.getMiliage());
                ps.setString(5,vehicle.getColor());
                ps.setDouble(6,vehicle.getPrices());
                ps.setString(7,vehicle.getTypeCar());
                ps.setString(8,vehicle.getWarrantyTime());
                ps.executeUpdate();
                db_connect.closeConection();
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static List<Vehicle> mostrarVehicles(){
        includeDriver();
        List<Vehicle> ListVehicles = new ArrayList<>();

        String query="select * from vehicle";
        Conexion db_connect = new Conexion();
        
        try(
           Connection conexion = db_connect.getConnection()){
           PreparedStatement ps=conexion.prepareStatement(query);
           ResultSet rs= ps.executeQuery();


                while (rs.next()){
                    int carId= rs.getInt(1);
                    String make= rs.getString(2);
                    String brand= rs.getString(3);
                    String year= rs.getString(4);
                    String miliage= rs.getString(5);
                    String color = rs.getString(6);
                    double prices = rs.getDouble(7);
                    String type_car= rs.getString(8);
                    String warrantyTime= rs.getString(9);
                    
                    Vehicle vehicleNew = new Vehicle(carId,make, brand, year, miliage, color, prices, type_car, warrantyTime, warrantyTime);
                    ListVehicles.add(vehicleNew);

                }

            }catch(SQLException ex){
                    System.out.println(ex);
                    System.out.println("Error printer list Vehicles");
            }

        return ListVehicles;
        
    }
    
   
}
