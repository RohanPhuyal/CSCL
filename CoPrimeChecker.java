import java.util.Scanner;

public class CoPrimeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();
        
        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();
        
        if (areCoPrime(num1, num2)) {
            System.out.println(num1 + " and " + num2 + " are co-prime.");
        } else {
            System.out.println(num1 + " and " + num2 + " are not co-prime.");
        }
        
        sc.close();
    }
    
    public static boolean areCoPrime(int a, int b) {
        return gcd(a, b) == 1;
    }
    
    // Helper method to calculate GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
