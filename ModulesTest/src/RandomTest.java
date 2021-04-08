import java.util.Random;

/**
 * @author 0086C047 潘俊言
 * @version 1.0
 */
public class RandomTest {
    public static void main(String[] args) {
        int[] face = new int[6];
        int[] point = new int[6000000];
        Random randNum = new Random();
        for (int i = 0; i < 6000000; i++) {
            // 1 ~ 6 Random
            point[i] = 1 + randNum.nextInt(6);
        }
        for (int number : point) {
            switch (number) {
                case 1 -> face[0] += 1;
                case 2 -> face[1] += 1;
                case 3 -> face[2] += 1;
                case 4 -> face[3] += 1;
                case 5 -> face[4] += 1;
                case 6 -> face[5] += 1;
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("point " + (i + 1));
            System.out.println(face[i]);
        }
    }
}
