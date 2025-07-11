import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class checkHappyNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("isHappy " + isHappy(n));
    }

    static boolean isHappy(int n) { // using flyods method to check is any circular path exists
        int slow = n;
        int fast = n;

        do {
            slow = findSquareSum(slow); // move slow by 1 square sum
            fast = findSquareSum(findSquareSum(fast)); // move fast by two square sum
        } while (slow != fast);

        if (slow == 1)
            return true;

        return false;

    }

    static int findSquareSum(int n) { // find sum of square ofeach number 
        int q = n;
        int r, sum = 0;
        while (n != 0) {
            q = n / 10;
            r = n - q * 10;
            sum = sum + (int) Math.pow(r, 2);
            n = q;
        }
        return sum;
    }
}
