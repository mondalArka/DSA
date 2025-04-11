import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetPremutations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string");
        String str = br.readLine();
        List<List<String>> list = subSets("", str, 0, new ArrayList<>(new ArrayList<>()));
        System.out.println("combinations " + list);
    }

    static List<List<String>> subSets(String pick, String str, int s, List<List<String>> arr) {
        if (s > str.length() - 1) {
            arr.add(new ArrayList<>(Arrays.asList(pick)));
            return arr;
        }
        if (s > 0 && s < str.length())
            permut(pick + str.charAt(s), arr, s);

        char ch = str.charAt(s);

        subSets(pick + ch, str, s + 1, arr);
        subSets(pick, str, s + 1, arr);

        return arr;
    }

    static List<List<String>> permut(String pick, List<List<String>> arr, int s) {
        System.out.println("xxxxx");
        System.out.println(s - 1 + " " + s+" "+pick);
        String newStr = pick.charAt(pick.length() - 1) + pick.substring(0, pick.length() - 1);
        arr.add(new ArrayList<>(Arrays.asList(newStr)));
        return arr;

    }
}
