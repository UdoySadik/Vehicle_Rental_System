package model;

/**
 * Admin extends Person.
 * Hardcoded credentials are passed to Person via super().
 */
public class Admin extends Person {

    // Pass hardcoded admin credentials to Person's constructor
    public Admin() {
        super(0, "Admin", "admin", "admin123");
    }

    /**
     * Checks if the provided credentials match the admin credentials.
     * @return true if login is successful, false otherwise
     */
    public boolean login(String enteredUsername, String enteredPassword) {
        return getUsername().equals(enteredUsername) && getPassword().equals(enteredPassword);
    }
}
