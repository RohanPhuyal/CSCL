import java.util.Scanner;;
public class NKeyCipher {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter text: ");
        String input = sc.next();
        generateCipher(input);
    }
    public static void generateCipher(String input){
        for (int j = 0; j < 26; j++) {
            String newText="";
            for(int i=0; i<input.length();i++){
                char currentChar= input.charAt(i);
                char base ='A';
                newText+=((char)((currentChar-base+j)%26+base));
            }
            System.out.println(newText);
        }
    }
}