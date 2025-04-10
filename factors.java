import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factors {
    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(n/i==i) System.out.print(i+" "); // for printing values like 36/6==6
                else System.out.print(i+" "+n/i+" "); // for print the divisor and the dividend like 18 and 2
            } 
        }
    }
}
