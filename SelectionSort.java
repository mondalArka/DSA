public class SelectionSort{ // is linear sort only
    public static void main(String[] args){
        int[] arr = { 13,12, 5, 3, 4,16, 8, 6, 9, 7, 11,2 };
        int min;
        for(int i=0;i<arr.length;i++){
            min=arr[i];
            for(int j=i;j<arr.length;j++){
                if(min>arr[j]){
                    System.out.println(min);
                    min=arr[j];
                    arr[j]=arr[i];
                    arr[i]=min;
                }
                for(int val:arr) System.out.print(val+", ");
                System.out.println();    
            }
        }
    }
}