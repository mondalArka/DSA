public class binarySerach {
    public static void main(String[] args) {
        int[] arr = { 1,12, 5, 3, 4,16, 8, 6, 9, 7, 11,2 };
        int s=100;
        //Sort Asc
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
        System.out.println("Sorted Array");
        for(int val:arr) System.out.print(val+", ");
        System.out.println("");
        //Binary Search

        int lEnd = 0;
        int hEnd= arr.length-1;
        int mid=(hEnd-lEnd)/2;
        int index=-1;

        while(lEnd<=hEnd){
            if(arr[mid]==s){
                index=mid;
                break;
            }
            else if(s>arr[mid]){
                lEnd=mid+1;
                mid=((hEnd-lEnd)/2)+lEnd;
            }
            else if(s<arr[mid]) {
                hEnd=mid-1;
                mid=hEnd-((hEnd-lEnd)/2);
            }
            else break;
        }

        if(index!=-1)
        System.out.println("Element "+s+" found at index "+(index+1));
        else System.out.println("Element not found!");

    }
    }
