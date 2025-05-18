import java.util.Arrays;

public class ownQuickSort {
    public static void main(String[] args) {
        // int[] arr = { 0, 10, 9, 11, 142, 100, -1, 5, 4, 3, 2, 1, 8, 99, 7 };
        int[] arr= {3,4,2,1};
        System.out.println("Sorted "+isSorted(arr, 0, arr.length - 1));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static int[] sort(int[] arr, int low, int high) { // Time Complexity:
        // Best: O(n log n)
        // Average: O(n log n)
        // Worst: O(n²)
        // Space Complexity:
        // Best/Average: O(log n)
        // Worst: O(n)
        if (isSorted(arr, low, high))
            return arr;
        int s = low;
        int e = high;
        if (s >= e)
            return arr;
        // int pivot = s + (e - s) / 2;
         int pivot = arr[low + (high - low) / 2];
        System.out.println(pivot + " e " + e + " s " + s);
        while (s <= e) {
            System.out.println("pivvv "+pivot);
            while (arr[s] < pivot) {
                s++;
                System.out.println("s " + s);
            }
            while (arr[e] > pivot) {
                e--;
                System.out.println("e " + e);
            }

            if (s <= e) {
                System.out.println(s + " " + e + " final");
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
                System.out.println("Arr " + Arrays.toString(arr) + "inside left");
            }
        }
        System.out.println(Arrays.toString(arr)+" after sort");
        sort(arr, low, e);
        sort(arr, s, high);
        return arr;
    }

    static boolean isSorted(int[] arr, int s, int e) { // better if use just a loop as recursion takes space in stack
        if (s == e)
            return true;
        if (arr[s] > arr[s + 1])
            return false;
        else
            return isSorted(arr, s + 1, e);

    }

}
