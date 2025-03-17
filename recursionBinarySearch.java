import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class recursionBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int s = Integer.parseInt(br.readLine());
        int[] arr = { 27, 30, 43, 47, 58, 50 };

        for (int i = 0; i < arr.length-1; i++) { // insertion sort
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        System.out.println("Sorted Array" + Arrays.toString(arr));
        int hend = arr.length - 1;
        int lend = 0;
        int index = binarySearch(arr, s, lend, hend);

        if (index == -1)
            System.out.println("Not found!");
        else
            System.out.println("Found at index: " + index);
    }

    static int binarySearch(int[] arr, int s, int lEnd, int hEnd) {
        if (lEnd > hEnd)
            return -1;

        int mid = lEnd + (hEnd - lEnd) / 2;

        if (arr[mid] == s)
            return mid;

        else if (arr[mid] < s)
            lEnd = mid + 1;

        else if (arr[mid] > s)
            hEnd = mid - 1;

        return binarySearch(arr, s, lEnd, hEnd);
    }
}
