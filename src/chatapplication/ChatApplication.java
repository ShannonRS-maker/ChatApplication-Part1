package chatapplication;

import java.util.Scanner;
import registration.UserRegistration;
import login.LoginAuthenticator;

public class ChatApplication {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRegistration registration = new UserRegistration();
        
        // Registration
        System.out.println("=== REGISTRATION ===");
        System.out.print("Enter username (must contain _ and be max 5 chars): ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password (8+ chars, uppercase, lowercase, digit, special char): ");
        String password = scanner.nextLine();
        
        System.out.print("Enter phone number (10 digits or XXX-XXX-XXXX): ");
        String phone = scanner.nextLine();
        
        String regResult = registration.registerUser(username, password, phone);
        if (regResult.isEmpty()) {
            System.out.println("✓ Registration successful!");
        } else {
            System.out.println("✗ " + regResult);
            return;
        }
        
        // Login
        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();
        
        LoginAuthenticator authenticator = new LoginAuthenticator(username, password);
        String loginResult = authenticator.authenticate(loginUsername, loginPassword);
        System.out.println(loginResult);
        
        scanner.close();
    }
}