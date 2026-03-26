package registration;

//Intial setup
//Adding validation logic
//User registration storage
/**
 * Handles user registration storage and retrieval
 */
public class UserRegistration {
    
    private String username;
    private String password;
    private String phoneNumber;
    private RegistrationValidator validator;
    
    public UserRegistration() {
        this.validator = new RegistrationValidator();
    }
    
    /**
     * Registers a new user with validation
     * @return error message if invalid, empty string if successful
     */
    public String registerUser(String username, String password, String phone) {
        // Validate username
        if (!validator.validateUsername(username)) {
            return "Invalid username: Must contain underscore and be max 5 characters";
        }
        
        // Validate password
        if (!validator.validatePassword(password)) {
            return "Invalid password: Must be 8+ chars with uppercase, lowercase, digit, and special char";
        }
        
        // Validate phone
        if (!validator.validatePhoneRegex(phone)) {
            return "Invalid phone: Use format 1234567890 or 123-456-7890";
        }
        
        // Store user data
        this.username = username;
        this.password = password;
        this.phoneNumber = phone;
        
        return ""; // Empty string indicates success
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
}