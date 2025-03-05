
public class insertionSort { // COMPLEXITY IS N^2
    // CONCEPT OF INSERTION SORT- j will run i+1 and sort backwards and if current element is not less than previous element then break as it is already sorted ; else swap. code is written reversely but still in asc order. stable sort. Best case is O(n)
    // swap complexity- n^2
    public static void main(String[] args) {
       int[] arr={5,3,4,2,1};

       for(int i=0;i<=arr.length-2;i++){
        for(int j=i+1;j>0;j--){
            if(arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }else break;
        }
       }
       for(int val:arr) System.out.print(val+", ");
    }
}
