import java.util.Arrays;

public class selectionSortRecursion {
    public static void main(String[] args) {
        int[] arr = { 16, 14, 11, 5, 4, 3, 2, 1, 9, 8, 7, 10 };
        System.out.println("Sorted Array " + Arrays.toString(selectionSort(arr, 0, 1)));
    }

    static int[] selectionSort(int[] arr, int fIndex, int sIndex) {
       
        if(fIndex>arr.length-1) return arr;
        if (sIndex > arr.length - 1)
            return selectionSort(arr, fIndex + 1, fIndex+1+1);
        if (arr[fIndex] > arr[sIndex]) {
            System.out.println(fIndex+" "+sIndex);
            int temp = arr[sIndex];
            arr[sIndex] = arr[fIndex];
            arr[fIndex] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return selectionSort(arr, fIndex, sIndex + 1);

    }
}
