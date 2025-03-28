import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface patternRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        print(n, 0, n - 1);
    }

    static void print(int n, int r, int c) {
        // System.out.println(c+"xxxx");
        if (r > n - 1)
            return;
        if (c < 0) {
            // System.out.print(" r "+r+" c1 "+c+" ");
            System.out.println();
            print(n, r + 1, n - 1-(r+1));
        } else {
            // System.out.print(" r2 "+r+" c2 "+c+" ");
            System.out.print("*");
            print(n, r, --c);
        }

    }
}
