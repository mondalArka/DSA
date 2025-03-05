public class BubbleSort { // check two adjacent elements every time
    public static void main(String[] args) {
        int[] arr = { 6,7,5,1,2,3,4,8,9,0,14,13,12,11,10 };
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;    // if array is sorted then it will go to j loop once to check whether array is sorted or not for the first time. then if swapped=false means not sorting done break out else continue with the sort.
            // Best case is O(n)
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // 

                    for (int val : arr)
                        System.out.print(val + ", ");
                    System.out.println();
                }
            }
            if(!swapped){
                System.out.println("break");
                break;
            } 
        }
        System.out.println("Sorted Array");
        for (int val : arr)
            System.out.print(val + ", ");
    }
}
