package ui;

import java.util.Scanner;
import model.Admin;
import service.CustomerService;

/**
 * MainMenu handles the CLI welcome menu for the Vehicle Rental System.
 */
public class MainMenu {

    private final Scanner scanner;
    private final CustomerService customerService;

    // Constructor initializes Scanner and services
    public MainMenu() {
        this.scanner         = new Scanner(System.in);
        this.customerService = new CustomerService();
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
                    System.out.println("\n>> Feature Coming Soon...\n");
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
        } else {
            System.out.println("\n[✘] Invalid Username or Password.\n");
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
