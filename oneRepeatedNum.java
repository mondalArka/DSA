import java.util.Arrays;

public class oneRepeatedNum {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 5, 1 };

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j < arr.length) {
                int correctIndex = arr[j] - 1;
                if (j != arr[j])
                    swap(arr, j, correctIndex);

                j++;
            }
        }

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i] - 1) {
                System.out.println("Repeated value is " + arr[i]);
                break;
            }
        }
    }

    static int[] swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
