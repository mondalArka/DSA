public class BubbleSort { // check two adjacent elements every time
    public static void main(String[] args) {
        int[] arr = { 10,20, 30, 40, 50 };
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;    // if array is sorted then it will go to j loop once to check whether array is sorted or not. then is swapped=false break out
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;

                    for (int val : arr)
                        System.out.print(val + ", ");
                    System.out.println();
                }
            }
            if(!swapped) break;
        }
        System.out.println("Sorted Array");
        for (int val : arr)
            System.out.print(val + ", ");
    }
}
