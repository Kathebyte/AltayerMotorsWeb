package PersistenciaDatos;


import backend.VehicleWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static void includeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void createVehicledDB(VehicleWeb vehicle) {
        includeDriver();

        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO vehicle (make, brand, year, color, prices, miliage, warrantyTime, accidentHistory, typeCar) VALUES (?,?,?,?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, vehicle.getMake());
                ps.setString(2, vehicle.getBrand());
                ps.setString(3, vehicle.getYear());
                ps.setString(4, vehicle.getColor());
                ps.setInt(5, vehicle.getPrices());
                ps.setString(6, vehicle.getMiliage());
                ps.setString(7, vehicle.getWarrantyTime());
                ps.setString(8, vehicle.getAccidentHistory());
                ps.setString(9, vehicle.getTypeCar());
                
                ps.executeUpdate();
                db_connect.closeConection();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<VehicleWeb> mostrarVehicles() {
        includeDriver();
        List<VehicleWeb> ListVehicles = new ArrayList<>();

        String query = "select * from vehicle";
        Conexion db_connect = new Conexion();

        try (
            Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int carId = rs.getInt(1);
                String make = rs.getString(2);
                String brand = rs.getString(3);
                String year = rs.getString(4);
                String color = rs.getString(5);
                int prices = rs.getInt(6);
                String miliage = rs.getString(7);
                String warrantyTime = rs.getString(8);
                String accidentHistory = rs.getString(9);
                String type_car = rs.getString(10);
                

                VehicleWeb vehicleNew = new VehicleWeb(carId, make, brand, year, miliage, color, prices, type_car, warrantyTime, accidentHistory);
                ListVehicles.add(vehicleNew);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error printer list Vehicles");
        }

        return ListVehicles;

    }
    
    public static void deleteVehicle(int carId){
    
    includeDriver();
        
        Conexion db_connect = new Conexion();
        String query="delete from vehicle where carId = ?" ;
        
        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1,carId);
            ps.executeUpdate();
            
          
        } catch (SQLException ex) {
            System.out.println("ex");
            System.out.println("Error delete list Vehicles");
            ex.printStackTrace();
        }
    
    }
    
}
    
    


