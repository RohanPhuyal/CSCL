import java.util.Scanner;  
public class RailFenceCipherDecryption {  
    // Function to decrypt the Rail Fence Cipher  
    public static String decrypt(String encryptedMessage, int rails) {  
        // Create a 2D array to represent the rail fence  
        char[][] railFence = new char[rails][encryptedMessage.length()];          
        // Initialize the rail fence with dots  
        for (int i = 0; i < rails; i++) {  
            for (int j = 0; j < encryptedMessage.length(); j++) {  
                railFence[i][j] = '.';  
            }  
        }          
        // Fill in the characters in a zigzag pattern  
        int row = 0;  
        boolean down = true;  
        for (int i = 0; i < encryptedMessage.length(); i++) {  
            railFence[row][i] = 'X'; // Mark the position of the characters  
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
        // Read the characters in the zigzag pattern to recover the original message  
        int index = 0;  
        for (int i = 0; i < rails; i++) {  
            for (int j = 0; j < encryptedMessage.length(); j++) {  
                if (railFence[i][j] == 'X') {  
                    railFence[i][j] = encryptedMessage.charAt(index++);  
                }  
            }  
        }       
        // Read the characters row by row to get the decrypted message  
        StringBuilder decryptedMessage = new StringBuilder();  
        row = 0;  
        down = true;  
        for (int i = 0; i < encryptedMessage.length(); i++) {  
            decryptedMessage.append(railFence[row][i]);  
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
        return decryptedMessage.toString();  
    }  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter the encrypted message: ");  
        String encryptedMessage = scanner.nextLine();  
        System.out.print("Enter the number of rails: ");  
        int rails = scanner.nextInt();  
        // Decrypt the message  
        String decryptedMessage = decrypt(encryptedMessage, rails);          
        // Display the decrypted message  
        System.out.println("Decrypted message: " + decryptedMessage);  
    }  
}  