import java.util.Arrays;

public class setMismatch{
    public static void main(String[] args){
        int[] arr = {7,8,9,10,11,12};
        for (int j = 0; j <arr.length; j++) {
            int i = 0;
            while (i < arr.length) {
                for (int val : arr)
                    System.out.print(val + ", ");
                System.out.println("before "+j);
                int correctIndex = arr[i];
                if (i!=arr[i] && arr[i]>=0 && arr[i]<arr.length) {
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

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));

        int c=0;
        for(int i=0;i<arr.length;i++){
            if(i!=arr[i] && i>0) {
                System.out.println("x");
                c=i;
                break;
            }
        }
        System.out.println("Missing least positive num is "+c);
    }
}