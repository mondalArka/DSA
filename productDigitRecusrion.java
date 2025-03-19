import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class productDigitRecusrion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Product is " + productDigit(n));
    }

    static int productDigit(int n) {
        int q = n / 10;
        int r = n - q * 10;
        if(n<=1) return 1;
        return r * productDigit(q);
    }
}