import java.util.Arrays;

public class findMissingNum {
    public static void main(String[] args){ // write complexity is n which is n for finding the missing value which are continous in nature
        int[] arr={6,7,5,1,2,3,8,9,0};
        int[] misArr= new int[arr.length];
        int c=0;
        int p=0;
        for(int j=0;j<2;j++){
            // if(c==-1) break;
            int i=0;
            while(i<arr.length){
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.print("iiiiii "+i+" j: "+j);
                int correctIndex= arr[i];
                if(arr[i]!=i && arr[i]<arr.length){
                    System.out.println("in");
                        int temp= arr[i];
                        arr[i]=arr[correctIndex];
                        arr[correctIndex]=temp;
                        p++;
                }
                System.out.println("\n"+Arrays.toString(arr)+" arr");
                System.out.println("-----------------------");
                i++;
            }
        }
        System.out.println("Sorted Array");
        for(int val:arr) System.out.print(val+", ");

        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=i){
                // c=i; // for finding  a single missing value
                // break;
                misArr[i]=i; // for findinf multiple given value within a range 
            }
        }
        System.out.println("Missing values "+Arrays.toString(Arrays.stream(misArr).filter(num->num!=0).toArray())+" and running for "+p+" times");
        // System.out.println("Missing value in range is "+c+" ran for "+p+" times ");// for single missing print
    }
}
