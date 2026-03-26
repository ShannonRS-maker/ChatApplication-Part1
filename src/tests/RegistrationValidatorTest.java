package tests;

import registration.RegistrationValidator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Registration Validator
 * Tests all validation rules for username, password, and phone
 */
public class RegistrationValidatorTest {
    
    private RegistrationValidator validator;
    
    @Before
    public void setUp() {
        validator = new RegistrationValidator();
    }
    
    // ===== USERNAME TESTS =====
    
    @Test
    public void testValidUsername() {
        assertTrue("Valid username should pass", 
                   validator.validateUsername("user_1"));
    }
    
    @Test
    public void testValidUsernameTwoChars() {
        assertTrue("Valid 2 char username with underscore should pass", 
                   validator.validateUsername("a_b"));
    }
    
    @Test
    public void testInvalidUsernameNoUnderscore() {
        assertFalse("Username without underscore should fail", 
                    validator.validateUsername("user1"));
    }
    
    @Test
    public void testInvalidUsernameTooLong() {
        assertFalse("Username longer than 5 chars should fail", 
                    validator.validateUsername("user_test"));
    }
    
    @Test
    public void testInvalidUsernameNull() {
        assertFalse("Null username should fail", 
                    validator.validateUsername(null));
    }
    
    @Test
    public void testInvalidUsernameEmpty() {
        assertFalse("Empty username should fail", 
                    validator.validateUsername(""));
    }
    
    // ===== PASSWORD TESTS =====
    
    @Test
    public void testValidPassword() {
        assertTrue("Valid password should pass", 
                   validator.validatePassword("Pass123!"));
    }
    
    @Test
    public void testValidPasswordComplex() {
        assertTrue("Complex valid password should pass", 
                   validator.validatePassword("MySecure@Pass99"));
    }
    
    @Test
    public void testInvalidPasswordTooShort() {
        assertFalse("Password less than 8 chars should fail", 
                    validator.validatePassword("Pass1!"));
    }
    
    @Test
    public void testInvalidPasswordNoUppercase() {
        assertFalse("Password without uppercase should fail", 
                    validator.validatePassword("pass123!"));
    }
    
    @Test
    public void testInvalidPasswordNoLowercase() {
        assertFalse("Password without lowercase should fail", 
                    validator.validatePassword("PASS123!"));
    }
    
    @Test
    public void testInvalidPasswordNoDigit() {
        assertFalse("Password without digit should fail", 
                    validator.validatePassword("Password!"));
    }
    
    @Test
    public void testInvalidPasswordNoSpecialChar() {
        assertFalse("Password without special char should fail", 
                    validator.validatePassword("Password123"));
    }
    
    @Test
    public void testInvalidPasswordNull() {
        assertFalse("Null password should fail", 
                    validator.validatePassword(null));
    }
    
    // ===== PHONE TESTS =====
    
    @Test
    public void testValidPhoneTenDigits() {
        assertTrue("Valid 10 digit phone should pass", 
                   validator.validatePhoneRegex("1234567890"));
    }
    
    @Test
    public void testValidPhoneFormatted() {
        assertTrue("Valid formatted phone (XXX-XXX-XXXX) should pass", 
                   validator.validatePhoneRegex("123-456-7890"));
    }
    
    @Test
    public void testInvalidPhoneTooShort() {
        assertFalse("Phone with fewer than 10 digits should fail", 
                    validator.validatePhoneRegex("123456789"));
    }
    
    @Test
    public void testInvalidPhoneTooLong() {
        assertFalse("Phone with more than 10 digits should fail", 
                    validator.validatePhoneRegex("12345678901"));
    }
    
    @Test
    public void testInvalidPhoneWrongFormat() {
        assertFalse("Phone with wrong format should fail", 
                    validator.validatePhoneRegex("123456-7890"));
    }
    
    @Test
    public void testInvalidPhoneWithLetters() {
        assertFalse("Phone with letters should fail", 
                    validator.validatePhoneRegex("12345abcde"));
    }
    
    @Test
    public void testInvalidPhoneNull() {
        assertFalse("Null phone should fail", 
                    validator.validatePhoneRegex(null));
    }
}