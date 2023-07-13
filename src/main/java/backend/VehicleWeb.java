
package backend;


public class VehicleWeb {
    
     int carId;
     String make;
     String brand;
     String year;
     String miliage;
     String color;
     int prices;
     String typeCar;
     String warrantyTime;
     int accidentHistory;

    public VehicleWeb(int carId, String make, String brand, String year, String miliage, String color, int prices, String typeCar, String warrantyTime, int accidentHistory) {
        this.carId = carId;
        this.make = make;
        this.brand = brand;
        this.year = year;
        this.miliage = miliage;
        this.color = color;
        this.prices = prices;
        this.typeCar = typeCar;
        this.warrantyTime = warrantyTime;
        this.accidentHistory = accidentHistory;
    }
    
    public VehicleWeb() {
    }
    
      public VehicleWeb( String make, String brand, String year, String miliage, String color, int prices, String typeCar, String warrantyTime, int accidentHistory) {
          
        this.make = make;
        this.brand = brand;
        this.year = year;
        this.miliage = miliage;
        this.color = color;
        this.prices = prices;
        this.typeCar = typeCar;
        this.warrantyTime = warrantyTime;
        this.accidentHistory = accidentHistory;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMiliage() {
        return miliage;
    }

    public void setMiliage(String miliage) {
        this.miliage = miliage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(String warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public int getAccidentHistory() {
        return accidentHistory;
    }

    public void setAccidentHistory(int accidentHistory) {
        this.accidentHistory = accidentHistory;
    }

}
    

