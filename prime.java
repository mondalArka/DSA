import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.io.IOException;

public class prime {
    public static void main(String[] args) throws IOException {
        try {
            int c=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the number");
            int n = Integer.parseInt(br.readLine());

            for(int i=2;i<n;i++){
                if(i*i>n) break;
                if(n%i==0){
                    System.out.println("i"+i);
                    c++;
                }
            }
            if(c!=0) System.out.println("Not a prime");
            else System.out.println("It is a prime number");

            System.out.println(c);
        } catch (IOException e) {
            System.out.println(e);
            throw new IOException();
        }
    }
}
