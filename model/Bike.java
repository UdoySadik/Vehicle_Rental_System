package model;

/**
 * Bike extends Vehicle.
 * Contains bike-specific field: engineCC.
 */
public class Bike extends Vehicle {

    private int engineCC;

    // Constructor — common fields passed to Vehicle via super()
    public Bike(int vehicleId, String brand, String model, double rentPerDay,
                boolean available, int engineCC) {
        super(vehicleId, brand, model, rentPerDay, available);
        this.engineCC = engineCC;
    }

    // ---------- Getter ----------
    public int getEngineCC() { return engineCC; }

    // ---------- Setter ----------
    public void setEngineCC(int engineCC) { this.engineCC = engineCC; }
}
