import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorialRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("\nFactorial is " + factorial(n));

    }

    static int factorial(int n) {
        if (n < 1)
            return 1;
        System.out.print(n + "*");
        return n * factorial(n - 1);
    }
}
