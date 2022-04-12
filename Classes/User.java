// Model class for User

package Classes;

// Import statements
import java.util.*;

public class User {
    // Fields
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;

    // Constructor
    public User() {

    }

    // Getter & Setters
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDOB() {
        return dateOfBirth;
    }
    public void setDOB(Date dob) {
        this.dateOfBirth = dob;
    }

}
