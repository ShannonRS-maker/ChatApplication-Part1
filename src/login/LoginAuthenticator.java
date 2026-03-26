package login;

/**
 * Handles user login authentication with appropriate decision structure
 */
public class LoginAuthenticator {
    
    private String storedUsername;
    private String storedPassword;
    
    public LoginAuthenticator(String username, String password) {
        this.storedUsername = username;
        this.storedPassword = password;
    }
    
    /**
     * Authenticates user login attempt with decision structure
     * Provides appropriate confirmation and error messages
     * 
     * @param enteredUsername username entered by user
     * @param enteredPassword password entered by user
     * @return confirmation or error message
     */
    public String authenticate(String enteredUsername, String enteredPassword) {
        
        // Decision Structure: Check for empty inputs
        if (enteredUsername == null || enteredUsername.trim().isEmpty()) {
            return "Error: Username cannot be empty";
        }
        
        if (enteredPassword == null || enteredPassword.trim().isEmpty()) {
            return "Error: Password cannot be empty";
        }
        
        // Decision Structure: Validate username
        if (!enteredUsername.equals(storedUsername)) {
            return "Error: Invalid username. Please try again.";
        }
        
        // Decision Structure: Validate password
        if (!enteredPassword.equals(storedPassword)) {
            return "Error: Invalid password. Please try again.";
        }
        
        // Success confirmation message
        return "Success: User authenticated successfully. Welcome!";
    }
    
    public boolean isValidLogin(String username, String password) {
        String result = authenticate(username, password);
        return result.startsWith("Success");
    }
}