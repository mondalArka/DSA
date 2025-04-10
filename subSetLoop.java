import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetLoop { // vvimp
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        System.out.println(subSet(arr));
    //    System.out.println(subSet2("abc"));
    }

    static List<List<Integer>> subSet(int[] arr) { // always 2^n*n
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
        outer.removeFirst();
        return outer;
    }

    static List<List<Character>> subSet2(String s) {
        List<List<Character>> outer= new ArrayList<>();
        outer.add(new ArrayList<>());
        char[] arr= s.toCharArray();
        System.out.println(Arrays.toString(arr)+" char arr");

        for(char c:arr){
            int n =outer.size();
            for(int i=0;i<n;i++){
                List<Character> inner = new ArrayList<>(outer.get(i));
                inner.add(c);
                outer.add(inner);
            }
        }
        outer.removeFirst();
        return outer;
    }
}
