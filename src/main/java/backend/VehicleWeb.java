
package backend;


public class VehicleWeb {
    
    private int carId;
    private String make;
    private String brand;
    private String year;
    private String miliage;
    private String color;
    private double prices;
    private String typeCar;
    private String warrantyTime;
    private String accidentHistory;
    

    public VehicleWeb(){
    }

    public VehicleWeb(int carId,String make, String brand, String year, String miliage, String color, double prices, String typeCar, String warrantyTime, String accidentHistory) {
        this.carId=carId;
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

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
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

    public String getAccidentHistory() {
        return accidentHistory;
    }

    public void setAccidentHistory(String accidentHistory) {
        this.accidentHistory = accidentHistory;
    }


    
}
    

