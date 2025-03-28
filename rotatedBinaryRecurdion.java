public class rotatedBinaryRecurdion {
    public static void main(String[] args) { // vv imp
        int[] arr = { 3, 5, 6, 7, 0, 1, 2,4,9 };
        int hend = arr.length - 1;
        int lend = 0;
        int s = 10;
        if (arr[0] == s)
            System.out.println("Element found at index 0");
        else if (arr[arr.length - 1] == s)
            System.out.println("Element found at index " + (arr.length - 1));
        else {
            int index = binarySearch(arr, s, hend, lend);
            System.out.println("Element found at index " + index);
        }
    }

    static int binarySearch(int[] arr, int n, int hend, int lend) {
        int mid = lend + (hend - lend) / 2;
        System.out.println(hend + " " + lend + " mid " + mid);
        if (lend <= hend) {
            if (arr[mid] == n)
                return mid;
            else if ( n <= arr[mid] && n >= arr[lend]) {
                System.out.println(1);
                hend = mid - 1;
                return binarySearch(arr, n, hend, lend);
            } 
            else if (n >= arr[mid] && n >= arr[lend]) {
                System.out.println(2);
                lend = mid + 1;
                return binarySearch(arr, n, hend, lend);
            } 
            else if (n <= arr[mid] && n <= arr[lend]) {
                System.out.println(3);
                lend = mid + 1;
                return binarySearch(arr, n, hend, lend);
            }
        } else
            return -1;

        return mid;
    }

}
