package model;

/**
 * Admin model class with default credentials and login logic.
 */
public class Admin {

    // Default admin credentials (hardcoded for now)
    private final String username = "admin";
    private final String password = "admin123";

    /**
     * Checks if the provided credentials match the admin credentials.
     * @return true if login is successful, false otherwise
     */
    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }
}
