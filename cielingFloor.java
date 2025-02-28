import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cielingFloor { // more like rounding of....
    public static void main(String[] args) { // n*n+log(n)-- complexity of total ceil
        try {
            int[] arr = { 13, 12, 5, 3, 4, 15, 6, 9, 7, 11, 1, 100, 102 }; // sample set
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the number");
            float s = Float.parseFloat(br.readLine());
            int min;
            for (int i = 0; i < arr.length; i++) {
                min = arr[i];
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] < min) {
                        min = arr[j];
                        arr[j] = arr[i];
                        arr[i] = min;
                    }
                }
            }
            System.out.println("Sorted Array");
            for (int val : arr)
                System.out.print(val + ", ");
            System.out.println("");

            // ceiling
            // binary seraching
            int s1 = (int) s;
            int lend = 0;
            int hend = arr.length - 1;
            int mid = (hend - lend) / 2;
            int index = -1;
            int ceilIndex = -1;
            int hBound = -1, lBound = -1;
            float decimal = s * 10 - s1 * 10;
            while (lend <= hend) {
                if (s1 == arr[mid]) {
                    index = mid;
                    break;
                } else if (s1 > arr[mid]) {
                    lBound = mid;
                    lend = mid + 1;
                    mid = ((hend - lend) / 2) + lend;
                } else if (s1 < arr[mid]) {
                    hBound = mid;
                    hend = mid - 1;
                    mid = hend - ((hend - lend) / 2);
                } else
                    break;
            }
            if (index == -1 && s > arr[0] && s < arr[arr.length - 1]) {
                System.out.println("in");
                ceilIndex = (int) decimal >= 5 ? hBound : lBound;
                System.out.println("Element found in between index: " + lBound + " and " + hBound
                        + " and the ceil value is: " + arr[ceilIndex]);
            } else if (index != -1) {
                if (s1 == arr[arr.length - 1]) {
                    System.out.println(
                            "Since it is the last element in the sample range only lower bound can be found which is: "
                                    + arr[index]);
                }
                else {
                    System.out.println(index + "index");
                    ceilIndex = (int) decimal >= 5 ? index + 1 : index;
                    System.out.println("Element found at index: " + index + " and ciel index is  " + ceilIndex
                            + " and the ceil value is: " + arr[ceilIndex]);
                }
            } else
                System.out.println("Element out of sample range!");
        } catch (IOException e) {
            System.out.println("Invaild input");
            throw new Error("Invaild input!");
        }
    }
}
