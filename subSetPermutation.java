import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string");
        String str = br.readLine();
        System.out.println("-----------------------");
        // permutaions("", str);
       List<List<String>> newArr= permutationList(0, "", str, new ArrayList<>()); // returning  a new list

       newArr.forEach(x->System.out.println(x));
       System.out.println("No.of permutations "+newArr.size());
    }

    static void permutaions(String pick, String str) {
        if (str.length() == 0) {
            System.out.println(pick);
            return;
        }

        char ch = str.charAt(0);
        for (int i = 0; i <= pick.length(); i++) {
            String first = pick.substring(0, i) + ch + pick.substring(i, pick.length()); // finding the different permutations
            permutaions(first, str.substring(1, str.length()));
        }
    }

    static List<List<String>> permutationList(int s, String pick, String str, List<List<String>> arr) {
        if (s >= str.length()) {
            arr.add(new ArrayList<>(Arrays.asList(pick)));
            return arr;
        }
        char ch = str.charAt(s);
        for (int i = 0; i <= pick.length(); i++) {
            String first = pick.substring(0, i) + ch + pick.substring(i, pick.length());
            permutationList(s + 1, first, str, arr);
        }
        
        return arr;
    }
}
