

import login.LoginAuthenticator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Login Authenticator
 * Tests authentication logic and decision structures
 */
public class LoginAuthenticatorTest {
    
    private LoginAuthenticator authenticator;
    
    @Before
    public void setUp() {
        authenticator = new LoginAuthenticator("user_1", "Pass123!");
    }
    
    @Test
    public void testSuccessfulLogin() {
        String result = authenticator.authenticate("user_1", "Pass123!");
        assertTrue("Successful login should return success message", 
                   result.startsWith("Success"));
    }
    
    @Test
    public void testInvalidUsername() {
        String result = authenticator.authenticate("wrong_user", "Pass123!");
        assertTrue("Invalid username should return error", 
                   result.startsWith("Error"));
        assertTrue("Error should mention invalid username", 
                   result.contains("username"));
    }
    
    @Test
    public void testInvalidPassword() {
        String result = authenticator.authenticate("user_1", "WrongPass123!");
        assertTrue("Invalid password should return error", 
                   result.startsWith("Error"));
        assertTrue("Error should mention invalid password", 
                   result.contains("password"));
    }
    
    @Test
    public void testEmptyUsername() {
        String result = authenticator.authenticate("", "Pass123!");
        assertTrue("Empty username should return error", 
                   result.startsWith("Error"));
    }
    
    @Test
    public void testEmptyPassword() {
        String result = authenticator.authenticate("user_1", "");
        assertTrue("Empty password should return error", 
                   result.startsWith("Error"));
    }
    
    @Test
    public void testNullUsername() {
        String result = authenticator.authenticate(null, "Pass123!");
        assertTrue("Null username should return error", 
                   result.startsWith("Error"));
    }
    
    @Test
    public void testNullPassword() {
        String result = authenticator.authenticate("user_1", null);
        assertTrue("Null password should return error", 
                   result.startsWith("Error"));
    }
    
    @Test
    public void testIsValidLoginTrue() {
        assertTrue("Valid credentials should return true", 
                   authenticator.isValidLogin("user_1", "Pass123!"));
    }
    
    @Test
    public void testIsValidLoginFalse() {
        assertFalse("Invalid credentials should return false", 
                    authenticator.isValidLogin("user_1", "WrongPass"));
    }
}