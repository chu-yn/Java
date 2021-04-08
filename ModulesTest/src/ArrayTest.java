
public class ArrayTest {
    public static void main(String[] args) {
        int[] array;
        array = new int[10];
        array[0] = 1;
        array[2] = 2;
        System.out.println(array[0]+array[2]);
        int[] b = {10, 11, 12};
        System.out.println(b[0]);
        int sum = 0;
        for (int i = 0; i <= 2; i++) {
            sum += b[i];
        }
        System.out.println(sum);
    }
}
