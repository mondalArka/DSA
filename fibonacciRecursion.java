import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacciRecursion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Fibonacci is "+fib(n));
    }

    static int fib(int n){
        if(n<2) return n;

        return fib(n-1)+ fib(n-2);
    }
}
