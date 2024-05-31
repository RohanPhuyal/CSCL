import java.util.Scanner;  
public class RailFenceCipherEncryption {  
    // Function to encrypt a message using the Rail Fence Cipher  
    public static String encrypt(String message, int rails) {  
        // Create a 2D array to represent the rail fence  
        char[][] railFence = new char[rails][message.length()];          
        // Initialize the rail fence with dots  
        for (int i = 0; i < rails; i++) {  
            for (int j = 0; j < message.length(); j++) {  
                railFence[i][j] = '.';  
            }  
        }  
        // Fill in the characters in a zigzag pattern  
        int row = 0;  
        boolean down = true;  
        for (int i = 0; i < message.length(); i++) {  
            railFence[row][i] = message.charAt(i);  
            if (row == 0) {  
                down = true;  
            } else if (row == rails - 1) {  
                down = false;  
            }  
            if (down) {  
                row++;  
            } else {  
                row--;  
            }  
        }          
        // Read the characters row by row to get the encrypted message  
        StringBuilder encryptedMessage = new StringBuilder();  
        for (int i = 0; i < rails; i++) {  
            for (int j = 0; j < message.length(); j++) {  
                if (railFence[i][j] != '.') {  
                    encryptedMessage.append(railFence[i][j]);  
                }  
            }  
        }         
        return encryptedMessage.toString();  
    }  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter the message to encrypt: ");  
        String message = scanner.nextLine();  
        System.out.print("Enter the number of rails: ");  
        int rails = scanner.nextInt();  
        // Encrypt the message  
        String encryptedMessage = encrypt(message, rails);          
        // Display the encrypted message  
        System.out.println("Encrypted message: " + encryptedMessage);  
    }  
}  