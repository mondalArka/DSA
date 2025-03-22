import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class zeroesInNumRecur {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n= Integer.parseInt(br.readLine());
        System.out.println("number of 0s "+count(n));
    }

    static int count(int n){
        if(n==0) return 0;
        int r=n%10;
        if( r==0) return 1 +count(n/10);
        else
        return count(n/10);
    }
}
