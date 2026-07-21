package model;

/**
 * Car extends Vehicle.
 * Contains car-specific fields: seatCapacity and fuelType.
 */
public class Car extends Vehicle {

    private int    seatCapacity;
    private String fuelType;

    // Constructor — common fields passed to Vehicle via super()
    public Car(int vehicleId, String brand, String model, double rentPerDay,
               boolean available, int seatCapacity, String fuelType) {
        super(vehicleId, brand, model, rentPerDay, available);
        this.seatCapacity = seatCapacity;
        this.fuelType     = fuelType;
    }

    // ---------- Getters ----------
    public int    getSeatCapacity() { return seatCapacity; }
    public String getFuelType()     { return fuelType; }

    // ---------- Setters ----------
    public void setSeatCapacity(int seatCapacity) { this.seatCapacity = seatCapacity; }
    public void setFuelType(String fuelType)       { this.fuelType     = fuelType; }
}
