import java.util.ArrayList;
import java.util.List;

public class subSetLoop { // vvimp
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        System.out.println(subSet(arr));
    }

    static List<List<Integer>> subSet(int[] arr) {
        List<List<Integer>> outer= new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num:arr){
            int n= outer.size();
            for(int i=0;i<n;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}
