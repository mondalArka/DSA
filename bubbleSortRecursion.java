import java.util.Arrays;

public class bubbleSortRecursion {
    public static void main(String[] args) { // bubble sort recursion
        int[] arr = { 16,14,11,5, 4, 3, 2, 1,9,8,7,10 };
        System.out.println("Sorted Array " + Arrays.toString(bubbleSort(arr, 0, 0)));
    }

    static int[] bubbleSort(int[] arr, int r, int c) {
        if (r > arr.length - 1)
            return arr;
        if (c > arr.length - 2) {
            return bubbleSort(arr, r + 1, 0);
        } else {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            return bubbleSort(arr, r, ++c);
        }
    }
}
