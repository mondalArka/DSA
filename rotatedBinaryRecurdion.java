public class rotatedBinaryRecurdion {
    public static void main(String[] args) { // cant be done
        int[] arr = { 8, 9, 11, 13, 2, 4, 5,9,3,19,21};
        int hend = arr.length - 1;
        int lend = 0;
        int s = 0;
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
        if (arr[mid] == n)
            return mid;
        if(lend<=hend){
            if (arr[lend] < arr[mid]) { // if left side is sorted then search here
                if (n <= arr[mid] && n >= arr[lend]) { // lies in between lend and mid
                    hend = mid - 1;
                    return binarySearch(arr, n, hend, lend);
                } else { // lies in between mid and hend
                    lend = mid + 1;
                    return binarySearch(arr, n, hend, lend);
                }
            } else if(n>=arr[mid] && n<=arr[hend]){ // if target is greater than mid and less than hend
                lend = mid + 1;
                return binarySearch(arr, n, hend, lend);
            }else return binarySearch(arr, n, mid-1, lend); // if target is less than mid
        }
        return -1;
    }

}
