import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class subSetPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string");
        String str = br.readLine();
        System.out.println("-----------------------");
        permutaions("", str);
    }

    static void permutaions(String pick, String str) {
        if (str.length() == 0) {
            System.out.println(pick);
            return;
        }

        char ch = str.charAt(0);
        for (int i = 0; i <= pick.length(); i++) {
            String first = pick.substring(0, i) + ch + pick.substring(i, pick.length());
            permutaions(first, str.substring(1,str.length()));
        }
    }
}
