import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class sumOfDigitsRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Sum is "+sum(n));
    }

    static int sum(int n){
        if(n==0) return 0;
        int q= n/10;
        int r=n-q*10;
        return r+sum(q);
    }
}
