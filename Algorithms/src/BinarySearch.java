public class BinarySearch {
    public static Integer binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            } else if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] myList = {1, 34, 5434, 32321, 123131};
        System.out.println(binarySearch(myList,34));
        System.out.println(binarySearch(myList,23));
    }
}
