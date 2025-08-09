import java.util.Arrays;
import java.util.Stack;

public class Histogram { // find largset rectangle in a histogram
    public static void main(String[] args){
        int[] arr ={2,1,5,6,2,3};
        System.out.println("The largest rectangle area is "+largestRectangle(arr));
    }

    static int largestRectangle(int[] arr){
        Stack<Integer> idxStack = new Stack();
        int[] right = new int[arr.length];
        int[] left = new int[arr.length];
        int n = arr.length;

        // right nearest idx
        for(int i=n-1;i>=0;i--){
            while(idxStack.size()>0 && arr[i]<=arr[idxStack.peek()])
                idxStack.pop();

            right[i]= idxStack.empty()? n : idxStack.peek();
            idxStack.push(i);
        }

        //clear the stack 
        while(idxStack.size()>0)
            idxStack.pop();

        // left nearest idx
        for(int i=0;i<n;i++){
            while(idxStack.size()>0 && arr[i]<=arr[idxStack.peek()])
                idxStack.pop();

            left[i]= idxStack.empty()? -1 : idxStack.peek();
            idxStack.push(i);
        }

        System.out.println("Left "+ Arrays.toString(left));
        System.out.println("Right "+ Arrays.toString(right));

        int area=0;
        for(int i=0;i<n;i++)
            area = Math.max(area, arr[i]*(right[i]-left[i]-1));

            //to find the max area for each index
        int[] idxMaxAreas = new int[arr.length];
        for(int i=0;i<n;i++)
            idxMaxAreas[i] = arr[i]*(right[i]-left[i]-1);

            System.out.println("Max areas for each idx "+Arrays.toString(idxMaxAreas));

        return area;
    }
}
