/**
 * @author 0086C047 潘俊言
 * @version 1.0
 */
public class AddNumbers {
    public static void main(String[] args) {
        // 1+2+......+100
        int num1 = 0;
        for (int i = 0; i <= 100; i++) {
            num1 += i;
        }
        System.out.println("1+2+......+100\nloop:\t" + num1); //for loop output
        System.out.println("公式:\t" + (1 + 100) * 100 / 2); // formula output

        // 0.1+0.2+......+1
        double num2 = 0, inital = 0.1;
        while (inital - 1 <= 0) {
            num2 += inital;
            inital += 0.1;
        }
        System.out.println("0.1+0.2+......+1\nloop:\t" + num2); // while loop output
        System.out.println("公式:\t" + (0.1 + 1) * 10 / 2); // formula output

        // 1+0.9+0.8+......+0.1
        double num3 = 0;
        for (double i = 1; i - 0.1 >= 0; i = i - 0.1) {
            num3 += i;
        }
        System.out.println("1+0.9+0.8+......+0.1\nloop:\t" + num3); // for loop output
        System.out.println("公式:\t" + (1 + 0.1) * 10 / 2); // formula output

    }
}
