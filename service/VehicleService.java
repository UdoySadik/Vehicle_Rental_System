package service;

import model.Vehicle;
import model.Car;
import model.Bike;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * VehicleService handles all vehicle-related business logic.
 */
public class VehicleService {

    // In-memory list of all vehicles
    private ArrayList<Vehicle> vehicleList;

    // Auto-incrementing vehicle ID
    private int nextId;

    // Constructor
    public VehicleService() {
        this.vehicleList = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Asks admin for vehicle type and details, then adds it to the list.
     */
    public void addVehicle(Scanner scanner) {
        System.out.println("\n------------------------------------");
        System.out.println("          ADD VEHICLE               ");
        System.out.println("------------------------------------");
        System.out.println("  1. Car");
        System.out.println("  2. Bike");
        System.out.print("Select vehicle type: ");
        String typeChoice = scanner.nextLine().trim();

        // Collect common vehicle fields
        System.out.print("Brand       : ");
        String brand = scanner.nextLine().trim();

        System.out.print("Model       : ");
        String model = scanner.nextLine().trim();

        System.out.print("Rent/Day    : ");
        double rentPerDay = Double.parseDouble(scanner.nextLine().trim());

        if (typeChoice.equals("1")) {
            // --- Car ---
            System.out.print("Seat Capacity : ");
            int seatCapacity = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Fuel Type     : ");
            String fuelType = scanner.nextLine().trim();

            Car car = new Car(nextId, brand, model, rentPerDay, true, seatCapacity, fuelType);
            vehicleList.add(car);
            nextId++;
            System.out.println("\n[✔] Vehicle Added Successfully!\n");

        } else if (typeChoice.equals("2")) {
            // --- Bike ---
            System.out.print("Engine CC : ");
            int engineCC = Integer.parseInt(scanner.nextLine().trim());

            Bike bike = new Bike(nextId, brand, model, rentPerDay, true, engineCC);
            vehicleList.add(bike);
            nextId++;
            System.out.println("\n[✔] Vehicle Added Successfully!\n");

        } else {
            System.out.println("\n[!] Invalid vehicle type. Returning to Admin Menu.\n");
        }
    }

    // Returns the full vehicle list (for future use)
    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }
}
