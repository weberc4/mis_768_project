// Application class for getting a new users sign up credentials

package Classes;
import javax.swing.*;

public class SignUp {
    
    public static void main(String[] args) {
        // Fields
        String userInput;  // To hold the user's input
		
		// Get a new user's login credentials
	    userInput = JOptionPane.showInputDialog("Please enter your Username and Password:");

	    // User input validation.
	    
        // Closes dialog box
	    System.exit(0);
    }

}
