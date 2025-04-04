import java.util.Arrays;

public class inPlaceMergeSort {
    public static void main(String[] args) { // complexity is nlogn and write is 
        int[] arr={ 5,4,3,2,1};
        breakArr(arr, (arr.length-1/2), 0, arr.length-1);
        System.out.println(Arrays.toString(arr)+" pop");
    }

    static void breakArr(int[] arr,int mid,int s,int e){
        // System.out.println(Arrays.toString(arr));
        if(s==e) return;
        mid=s+(e-s)/2;
         breakArr(arr,mid,s,mid);
         breakArr(arr,mid, mid+1, e);

        merge(arr, mid, s, e);  
       System.out.println(Arrays.toString(arr)+" xxxxx");
    }

    static void merge(int[] arr,int mid,int s,int e){
        int[] arr2= new int[(e-s)+1];
        int k=0;
        int i=s;
        int j=mid+1;
        while(i<=mid && j<=e){
            if(arr[i]>arr[j]){
                arr2[k]=arr[j];
                k++;
                j++;
            }else {
                arr2[k]=arr[i];
                k++;
                i++;
            }
        }
        // System.out.println("i "+i+" j "+j);

      
            while(i<=mid){
                // System.out.println("i "+i+" j "+j);
                arr2[k]=arr[i];
                k++;
                i++;
            }
        
       
            while (j<=e) {
                arr2[k]=arr[j];
                k++;
                j++;
            }
        
        for(int l=0;l<arr2.length;l++){
            arr[s+l]=arr2[l];
           
        }
        System.out.println(Arrays.toString(arr2)+" arr2");
        System.out.println(Arrays.toString(arr));
    }
}
