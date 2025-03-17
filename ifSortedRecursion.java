public class ifSortedRecursion {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        boolean bool = isSorted(arr, 0);
        System.out.println("Is Sorted: " + bool);
    }

    static boolean isSorted(int[] arr, int index) {
        System.out.println("index " + index);
        if(index < arr.length - 1){
        if (arr[index] <= arr[index + 1])
            return isSorted(arr, index + 1);
        else 
            return false;
        }else
            return true;
    }
}
