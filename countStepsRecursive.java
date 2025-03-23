import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class countStepsRecursive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("The number of step taken are "+countStep(n));
    }

    static int countStep(int n) { // code not getting compiled
        if(n<=0) return 0;
        if (n % 2 != 0)
            return 1+countStep(n-1);
        int r = n / 2;
        return 1 + countStep(r);
    }
}