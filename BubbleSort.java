public class BubbleSort { //  check two adjacent elements every time
    public static void main(String[] args) {
        int[] arr = { 20,30,20,10,40 };

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    
                    for(int val:arr) System.out.print(val+", ");
                    System.out.println();
                }
            }
        }
        System.out.println("Sorted Array");
        for(int val:arr) System.out.print(val+", ");
    }
}
