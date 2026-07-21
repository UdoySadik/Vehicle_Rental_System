package model;

/**
 * Person is the base class for all people in the system.
 * Contains common fields shared by Admin and Customer.
 */
public class Person {

    private int    id;
    private String fullName;
    private String username;
    private String password;

    // Constructor
    public Person(int id, String fullName, String username, String password) {
        this.id       = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    // ---------- Getters ----------
    public int    getId()       { return id; }
    public String getFullName() { return fullName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // ---------- Setters ----------
    public void setId(int id)             { this.id       = id; }
    public void setFullName(String name)  { this.fullName = name; }
    public void setUsername(String uname) { this.username = uname; }
    public void setPassword(String pwd)   { this.password = pwd; }
}
