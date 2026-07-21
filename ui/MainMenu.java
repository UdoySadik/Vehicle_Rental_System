package ui;

import java.util.Scanner;
import model.Admin;
import service.CustomerService;
import service.VehicleService;

/**
 * MainMenu handles the CLI welcome menu for the Vehicle Rental System.
 */
public class MainMenu {

    private final Scanner scanner;
    private final CustomerService customerService;
    private final VehicleService vehicleService;

    // Constructor initializes Scanner and services
    public MainMenu() {
        this.scanner         = new Scanner(System.in);
        this.customerService = new CustomerService();
        this.vehicleService  = new VehicleService();
    }

    // Starts the main menu loop
    public void start() {
        printWelcomeBanner();

        boolean running = true;

        while (running) {
            printMenu();

            String input = scanner.nextLine().trim();

            // Check if input is a valid integer
            if (!isInteger(input)) {
                System.out.println("\n[!] Invalid input. Please enter a number.\n");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    handleAdminLogin();
                    break;
                case 2:
                    customerService.loginCustomer(scanner);
                    break;
                case 3:
                    customerService.registerCustomer(scanner);
                    break;
                case 0:
                    System.out.println("\nThank you for using Vehicle Rental System. Goodbye!\n");
                    running = false;
                    break;
                default:
                    System.out.println("\n[!] Invalid choice. Please select from the menu.\n");
            }
        }

        scanner.close();
    }

    // Prints the welcome banner
    private void printWelcomeBanner() {
        System.out.println("====================================");
        System.out.println("      VEHICLE RENTAL SYSTEM         ");
        System.out.println("            Version 1.0             ");
        System.out.println("====================================");
        System.out.println();
    }

    // Prints the main menu options
    private void printMenu() {
        System.out.println("------------------------------------");
        System.out.println("           MAIN MENU               ");
        System.out.println("------------------------------------");
        System.out.println("  1. Admin Login");
        System.out.println("  2. Customer Login");
        System.out.println("  3. Customer Registration");
        System.out.println("  0. Exit");
        System.out.println("------------------------------------");
        System.out.print("Enter your choice: ");
    }

    // Handles the Admin Login flow
    private void handleAdminLogin() {
        System.out.println("\n------------------------------------");
        System.out.println("           ADMIN LOGIN              ");
        System.out.println("------------------------------------");

        System.out.print("Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        Admin admin = new Admin();

        if (admin.login(username, password)) {
            System.out.println("\n[✔] Login Successful!\n");
            showAdminMenu();   // Open Admin Menu after successful login
        } else {
            System.out.println("\n[✘] Invalid Username or Password.\n");
        }
    }

    // Displays the Admin Menu and handles admin options
    private void showAdminMenu() {
        boolean inAdminMenu = true;

        while (inAdminMenu) {
            System.out.println("------------------------------------");
            System.out.println("           ADMIN MENU              ");
            System.out.println("------------------------------------");
            System.out.println("  1. Add Vehicle");
            System.out.println("  0. Back");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    vehicleService.addVehicle(scanner);
                    break;
                case "0":
                    inAdminMenu = false;
                    break;
                default:
                    System.out.println("\n[!] Invalid choice. Please try again.\n");
            }
        }
    }

    // Helper: checks if a string is a valid integer
    private boolean isInteger(String input) {
        if (input == null || input.isEmpty()) return false;
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
