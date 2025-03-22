import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class reverseNumRecursion {
    static int sum = 0; // for rev2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("reverse num is " + reverse(n));
        rev2(n);
        System.out.println("reverse2 " + sum);
    }

    static int reverse(int n) {
        if (n < 1)
            return 0;
        int q = n / 10;
        int r = n - q * 10;
        return r * (int) Math.pow(10, (int) Math.log10(n)) + reverse(q);
    }

    static void rev2(int n) { // not that of a good way
        if (n < 1)
            return;
        int r = n % 10;
        sum = sum * 10 + r;
        rev2(n / 10);
    }
}