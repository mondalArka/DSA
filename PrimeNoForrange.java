import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNoForrange {
    public static void main(String[] args)throws IOException { // Sieve Erothenesis process complexity n*log(log n) maybe sieve atkins value is close
            int c=0;
            int k=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the number");
            int n = Integer.parseInt(br.readLine());
            boolean[] nPrime=new boolean[n-1];

            for(int i=2;i*i<n;i++){
                if(nPrime[i-1]) continue; // so that i does not repeat values like 4 6 9 10 12.....
                for(int j=i*i;j<n;j+=i){
                    // if(nPrime[j-1]) continue; //when i is 3 starts from 9 but does not checks 12 18 indstead gives 9,15 and also redundant
                    nPrime[j-1]=true;
                    c++; // number of times the inner loop went through
                }
                k++; // no of times out loop went through
            }
            System.out.println("Prime numbers are: ");
            for(int i=1;i<nPrime.length;i++){
                if(nPrime[i]==false) System.out.print((i+1)+", ");
            }
            System.out.println("counter "+c+" outloop: "+k);
    }
}
