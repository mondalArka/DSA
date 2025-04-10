import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetLoop { // vvimp
    public static void main(String[] args) { // spacae and time complexity is always 2^n*n
        int[] arr = { 3, 1, 1,6 };
        // System.out.println(subSet(arr)); // for simple  array of integers
        // System.out.println(subSet2("abc")); // for characters subsets String input
        System.out.println(noRepeatSubSet(arr)); // no repeat subsets
    }

    static List<List<Integer>> subSet(int[] arr) { // always 2^n*n
        List<List<Integer>> outer = new ArrayList<>(); // always taking each list of outerlist and inserting a specific value to it and then inserting it to outer to get the combos
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        outer.removeFirst();
        return outer;
    }

    static List<List<Character>> subSet2(String s) {
        List<List<Character>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr) + " char arr");

        for (char c : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Character> inner = new ArrayList<>(outer.get(i));
                inner.add(c);
                outer.add(inner);
            }
        }
        outer.removeFirst();
        return outer;
    }

    static List<List<Integer>> noRepeatSubSet(int[] arr) { // repeats can only be removed if they are adjacent and to achieve that use sorting like insertion or merge anything so that the repeated elements can be side by side.
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i - 1] == arr[i])
                start = end + 1; // end here is the last iteration loop value not the current outer length

            end = outer.size() - 1; 
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        // outer.removeFirst();
        return outer;
    }
}
