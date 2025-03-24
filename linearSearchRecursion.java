import java.util.Arrays;

public class linearSearchRecursion {
    public static void main(String[] args) { // find multiple occurences
        int[] arr = { 1, 8, 8, 9, 9 };
        int[] returnedArr = find(arr, 0, 9, new int[arr.length]);
        int[] returnedArr2 = find2(arr, 0, 9);
        // System.out
        // .println("Found at: " + Arrays.toString(Arrays.stream(returnedArr).filter(val
        // -> val != -1).toArray()));
        System.out
                .println(
                        "Found at: " + Arrays.toString(Arrays.stream(returnedArr2).filter(val -> val != -1).toArray()));
    }

    static int[] find(int[] arr, int index, int n, int[] indexArr) { // passing an new array to argument
        if (index > arr.length - 1) {
            return indexArr;
        }

        if (arr[index] == n)
            indexArr[index] = index;
        else
            indexArr[index] = -1;
        return find(arr, index + 1, n, indexArr);
    }

    static int[] find2(int[] arr, int index, int n) { // not passing an new array to argument
        if (index > arr.length - 1)
            return arr;

        if (arr[index] == n)
            arr[index] = index;
        else
            arr[index] = -1;
        return find2(arr, index + 1, n);
    }
}
