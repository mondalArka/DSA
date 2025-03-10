import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sieveAtkinPrimeRange {
    public static void main(String[] args) throws IOException { // Sieve Atkin's process complexity n/log(log n) may be not
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        boolean[] Prime = new boolean[n + 1];
        int c=0,k=0;
        int res = 0;
        for (int i = 1; i * i < n; i++) {
            for (int j = 1; j * j < n; j++) {

                if ((res = (4 * i * i) + (j * j)) <= n && (res % 12 == 1 || res % 12 == 5))
                    Prime[res] = !Prime[res];

                if ((res = (3 * i * i) + (j * j)) <= n && res % 12 == 7)
                    Prime[res] = !Prime[res];

                if (i > j && (res = (3 * i * i) - (j * j)) <= n && res % 12 == 11)
                    Prime[res] = !Prime[res];
                    c++;
            }
        }

        System.out.println("arr " + Arrays.toString(Prime));
        if (n > 2) // in atkins method 2 and 3 are excluded so manually include it
            Prime[2] = true;
        if (n > 3)
            Prime[3] = true;

        // Elimination process - eleminating all the multiples of sqaures of prime numbers
        for (int i = 5; i * i < n; i++) {
            if(Prime[i]==false) break; // for not prime nos dont find the multiple
            for (int j = i * i; j < n; j += i * i)// progeressing as i*i* 1, i*i* 2,i*i* 3 so eliminating multiple of
                                                  // squares of prime numbers.
                Prime[j] = false;
                k++;
        }

        for (int i = 2; i <= n; i++) {
            if (Prime[i] == true)
                System.out.print(i + ", ");
        }
        System.out.println("c "+c+", "+k);
        System.out.println("Ran for "+(c+k));

    }
}
