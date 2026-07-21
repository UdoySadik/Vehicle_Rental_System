package service;

import model.Customer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CustomerService handles all customer-related business logic.
 */
public class CustomerService {

    // In-memory list of registered customers
    private ArrayList<Customer> customerList;

    // Auto-incrementing ID counter
    private int nextId;

    // Constructor
    public CustomerService() {
        this.customerList = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Collects customer details from the console and registers a new customer.
     */
    public void registerCustomer(Scanner scanner) {
        System.out.println("\n------------------------------------");
        System.out.println("     CUSTOMER REGISTRATION          ");
        System.out.println("------------------------------------");

        System.out.print("Full Name     : ");
        String fullName = scanner.nextLine().trim();

        System.out.print("Phone Number  : ");
        String phoneNumber = scanner.nextLine().trim();

        System.out.print("Username      : ");
        String username = scanner.nextLine().trim();

        System.out.print("Password      : ");
        String password = scanner.nextLine().trim();

        // Create and store the new customer
        Customer customer = new Customer(nextId, fullName, phoneNumber, username, password);
        customerList.add(customer);
        nextId++;

        System.out.println("\n[✔] Customer Registered Successfully!\n");
    }

    // Returns the full customer list (for future use)
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
