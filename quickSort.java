import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = { 0, 10, 9, 11, 142, 100, -1, 5, 4, 3, 2, 1, 8, 99, 7, 6 };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static int[] sort(int[] arr, int low, int high) {
        int s=low;
        int e=high;
        if(s>=e)  return arr;
        int pivot = s + (e - s) / 2;
        System.out.println(pivot+" pivot");
        while (s <= e) {
            while (arr[s] < arr[pivot]) {
                s++;
                System.out.println("s "+s);
            }
            while (arr[e] > arr[pivot]) {
                e--;
                System.out.println("e "+e);
            }

            if (s < pivot) {
                System.out.println(s+" "+e+" final");
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                System.out.println("Arr "+ Arrays.toString(arr)+"inside left");
            }
            if(e>pivot){
                System.out.println(s+" "+e+" final");
                int temp = arr[e];
                arr[e] = arr[pivot];
                arr[pivot] = temp;
                e--;
                System.out.println("Arr "+ Arrays.toString(arr)+"inside right");
            }
        }
        
        sort(arr, low, e);
        sort(arr,e, high);
        return arr;
    }

}
