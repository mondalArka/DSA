import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sqrtNewton {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());

        double x = n;
        double root = 0.0;

        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 0.01)
                break;
            x = root;
        }

        System.out.println("Sqrt is " + root);
    }
}
