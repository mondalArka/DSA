public class cycleSort {
    public static void main(String[] args) { // cycle sort write complexity-  n times so n,
                                             // better than other sorts write but time complexity is same, and the diff should be 1 for each value,
                                            // Note:- constraint is the last value has to be there cannot be 1,2,3,
                                            // Best case - O(n^2) or my intuition O(n)
                                            // swap complexity- n
        int[] arr = {6,7,5,1,2,3,4,8,9,0,14,13,12,11,10}; // for consistent numbers only starting from 1
        for (int j = 0; j <arr.length; j++) {
            int i = 0;
            while (i < arr.length) {
                for (int val : arr)
                    System.out.print(val + ", ");
                System.out.println("before "+j);
                int correctIndex = arr[i];
                if (arr[i]!= i) {
                    int temp = arr[i];
                    arr[i] = arr[correctIndex];
                    arr[correctIndex] = temp;
                }
                for (int val : arr)
                    System.out.print(val + ", ");
                System.out.println("after "+j);
                i++;
            }
        }

        for(int val:arr) System.out.print(val+", ");

    }
}
