package model;

/**
 * Abstract base class for all vehicles in the system.
 * Car and Bike extend this class.
 */
public abstract class Vehicle {

    private int     vehicleId;
    private String  brand;
    private String  model;
    private double  rentPerDay;
    private boolean available;

    // Constructor
    public Vehicle(int vehicleId, String brand, String model,
                   double rentPerDay, boolean available) {
        this.vehicleId  = vehicleId;
        this.brand      = brand;
        this.model      = model;
        this.rentPerDay = rentPerDay;
        this.available  = available;
    }

    // ---------- Getters ----------
    public int     getVehicleId()  { return vehicleId; }
    public String  getBrand()      { return brand; }
    public String  getModel()      { return model; }
    public double  getRentPerDay() { return rentPerDay; }
    public boolean isAvailable()   { return available; }

    // ---------- Setters ----------
    public void setVehicleId(int vehicleId)      { this.vehicleId  = vehicleId; }
    public void setBrand(String brand)            { this.brand      = brand; }
    public void setModel(String model)            { this.model      = model; }
    public void setRentPerDay(double rentPerDay)  { this.rentPerDay = rentPerDay; }
    public void setAvailable(boolean available)   { this.available  = available; }
}
