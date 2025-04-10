import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetRecursionNumbers { // complexity 2^n*n and space is also same
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Enter the number");
        int[] n = { 3, 1, 2,4 };
        List<List<Integer>> list= subSet(n, new ArrayList<>(1), 0, new ArrayList<>((int)Math.pow(2, n.length)-1));
       System.out.println(Arrays.toString(list.toArray())); 
    }

    static List<List<Integer>> subSet(int[] actualArr, List<Integer> n, int s, List<List<Integer>> arr) {

        if (s > actualArr.length - 1) {
            arr.add(new ArrayList<>(n));
            return arr;
        }
        n.add(actualArr[s]);
        subSet(actualArr, n, s + 1, arr);
        n.removeLast();
        subSet(actualArr, n, s + 1, arr);

        return arr;
    }
}
