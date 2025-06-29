import java.util.*;

public class SelectionSort { // find the minimum and then place that minimum in i index Worst O(n^2) best
                             // O(n^2)
    // swap complexity - n
    public static void main(String[] args) {
        int[] arr = { 13, 12, 5, 3, 4, 16, 8, 6, 9, 7, 11, 2 };
        int minIdx;
        for (int i = 0; i < arr.length; i++) {
            minIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
                // for(int val:arr) System.out.print(val+", ");
                // System.out.println();
            }

            if (minIdx != i) {
                arr[minIdx] ^= arr[i];
                arr[i] ^= arr[minIdx];
                arr[minIdx] ^= arr[i];
            }
        }
        System.out.println("Final Array " + Arrays.toString(arr));
    }
}