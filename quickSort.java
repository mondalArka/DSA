import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        breakArr(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void breakArr(int[] arr, int mid) {
        int newMid = mid / 2;
        // System.out.println("yyyyyy " + newMid);
        if (mid == 0)
            return;
        breakArr(arr, newMid);
        merge(arr, newMid);
        breakArr(arr, newMid);
        // System.out.println("Array: " + Arrays.toString(arr));

    }

    static void merge(int[] arr, int mid) {
        System.out.println("xxxxx " + mid + " val "+arr[mid]);
        // System.out.println(Arrays.toString(arr) + " inside merge");
        int i = 0;
        int j = mid + 1;
        int k = 0;
        while (i <= mid) {
            if (arr[i] <= arr[mid])
                i++;
            else {
                int temp = arr[mid];
                arr[mid] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        while (j < arr.length) {
            // System.out.println("j "+j+ " mid "+mid);
            if (arr[mid] <= arr[j])
                j++;
            else {
                // System.out.println("yyyyyy");
                int temp = arr[mid];
                arr[mid] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr)+" after sort");
        return;
    }

}
