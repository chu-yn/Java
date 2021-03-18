import java.util.Scanner;

public class FirstProgram0086C047 {
    public static void main(String[] argv) {
        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.println("Hello World");
            System.out.println("Input 2 numbers");
            int num1 = keyboard.nextInt();
            int num2 = keyboard.nextInt();
            System.out.println("Sum of two");
            System.out.println(num1 + num2);
        } finally {
            keyboard.close();
        }
    }
}