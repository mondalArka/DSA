import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class diceProb {
    public static void main(String[] args) throws IOException { // ?how many ways can 4 be made from a dice
        int[] diceArr = { 1, 2, 3,  };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> combos = findCombos(n, diceArr, 0, new ArrayList<Integer>(),
                new ArrayList<>(new ArrayList<>()));

        combos.forEach(x -> System.out.println(x));
    }

    static ArrayList<ArrayList<Integer>> findCombos(int search, int[] arr, int s, ArrayList<Integer> pick,
            ArrayList<ArrayList<Integer>> newArr) {

        if (s > arr.length - 1) {
            // int c = 0;
            // for (int val : pick)
            //     c += val;
            // if (c == search) {
            //     newArr.add(new ArrayList<>(pick));
            //     return newArr;
            // } else
            //     return newArr;
            newArr.add(new ArrayList<>(pick));
                return newArr;
        }

        pick.add(arr[s]);
        findCombos(search, arr, s + 1, pick, newArr);
        pick.removeLast();
        findCombos(search, arr, s + 1, pick, newArr);
        return newArr;
    }
}
