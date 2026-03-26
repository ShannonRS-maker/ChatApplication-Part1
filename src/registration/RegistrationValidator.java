package registration;

/**
 * Validates user registration data according to requirements
 */
public class RegistrationValidator {
    
    /**
     * Validates username according to requirements:
     * - Must contain underscore
     * - Maximum 5 characters
     * 
     * @param username the username to validate
     * @return true if valid, false otherwise
     */
    public boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        
        // Username must be max 5 characters
        if (username.length() > 5) {
            return false;
        }
        
        // Username must contain underscore
        if (!username.contains("_")) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates password meets complexity requirements:
     * - Minimum 8 characters
     * - At least one uppercase letter
     * - At least one lowercase letter
     * - At least one digit
     * - At least one special character (!@#$%^&*)
     * 
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    public boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        
        // Minimum 8 characters
        if (password.length() < 8) {
            return false;
        }
        
        // At least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        
        // At least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        
        // At least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        
        // At least one special character
        if (!password.matches(".*[!@#$%^&*].*")) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates phone number using regex pattern
     * Accepts: 10 digit format or XXX-XXX-XXXX format
     * 
     * @param phone the phone number to validate
     * @return true if valid, false otherwise
     */
    public boolean validatePhoneRegex(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        
        // Pattern: 10 consecutive digits OR XXX-XXX-XXXX
        return phone.matches("^\\d{10}$") || 
               phone.matches("^\\d{3}-\\d{3}-\\d{4}$");
    }
}