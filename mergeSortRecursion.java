import java.util.Arrays;

public class mergeSortRecursion { // needs to be deduced
    public static void main(String[] args) {
        int[] arr={ 5,4,3,2,1,-1,-5};
        System.out.println("Sorted Array "+Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length==1) return arr;
        int[] left= mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));
        int[] right = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] first,int[] second){
        System.out.println("arr "+Arrays.toString(first));
        System.out.println("sarr "+Arrays.toString(second));
        int[] mergeArr= new int[first.length+second.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mergeArr[k]=first[i];
                i++;
            }else{
                mergeArr[k]=second[j];
                j++;
            }
            k++;
        }
        if(i>=first.length){
            while(j<second.length){
                mergeArr[k]=second[j];
                k++;
                j++;
            }
        }else {
            while(i<first.length){
                mergeArr[k]=first[i];
                k++;
                i++;
            }
        }
        return mergeArr;
    }
}
