package model;

/**
 * Customer extends Person.
 * Only contains customer-specific field: phoneNumber.
 */
public class Customer extends Person {

    // Customer-specific field
    private String phoneNumber;

    // Constructor — common fields go to Person via super()
    public Customer(int id, String fullName, String phoneNumber,
                    String username, String password) {
        super(id, fullName, username, password);
        this.phoneNumber = phoneNumber;
    }

    // ---------- Getter ----------
    public String getPhoneNumber() { return phoneNumber; }

    // ---------- Setter ----------
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
