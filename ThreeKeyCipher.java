import java.util.Scanner;

public class ThreeKeyCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String input = sc.nextLine();
        String encryptedText = encrypt(input);
        String decryptedText = decrypt(encryptedText);

        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + decryptedText);
    }

    public static String encrypt(String input) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                newText.append((char) (((currentChar - base + 3) % 26) + base));
            } else {
                newText.append(currentChar);
            }
        }
        return newText.toString();
    }

    public static String decrypt(String input) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                newText.append((char) (((currentChar - base - 3 + 26) % 26) + base));
            } else {
                newText.append(currentChar);
            }
        }
        return newText.toString();
    }
}
