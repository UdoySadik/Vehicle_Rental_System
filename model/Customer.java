package model;

/**
 * Customer model class with encapsulation.
 */
public class Customer {

    private int customerId;
    private String fullName;
    private String phoneNumber;
    private String username;
    private String password;

    // Constructor
    public Customer(int customerId, String fullName, String phoneNumber,
                    String username, String password) {
        this.customerId   = customerId;
        this.fullName     = fullName;
        this.phoneNumber  = phoneNumber;
        this.username     = username;
        this.password     = password;
    }

    // ---------- Getters ----------
    public int    getCustomerId()  { return customerId; }
    public String getFullName()    { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getUsername()    { return username; }
    public String getPassword()    { return password; }

    // ---------- Setters ----------
    public void setCustomerId(int customerId)      { this.customerId  = customerId; }
    public void setFullName(String fullName)        { this.fullName    = fullName; }
    public void setPhoneNumber(String phoneNumber)  { this.phoneNumber = phoneNumber; }
    public void setUsername(String username)        { this.username    = username; }
    public void setPassword(String password)        { this.password    = password; }
}
