import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class multipleRepeatedNum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 1, 4, 9, 10 };
        List<Integer> noMiss = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j < arr.length) {
                int correctIndex = arr[j] - 1;
                if (j != j + 1 && arr[j] < arr.length)
                    swap(arr, j, correctIndex);

                j++;
                System.out.println(Arrays.toString(arr));
            }
        }

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));

        int[] numArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i] - 1) {
                if (arr[i] > arr.length - 1) {
                    if (noMiss.contains(arr[i]))
                        numArr[i] = arr[i];
                    else
                        noMiss.add(arr[i]);
                } else
                    numArr[i] = arr[i];
            }

        }
        System.out.println("Values which are repeating: ");
        System.out.println(Arrays.toString(Arrays.stream(numArr).filter(val -> val != 0).toArray()));
    }

    static int[] swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
