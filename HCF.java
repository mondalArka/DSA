import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HCF { //gcd((b,a),a)
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the 1st number");
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enter the 2nd number");
        int b= Integer.parseInt(br.readLine());

       int res= hcf(a,b);
       System.out.println("HCF is "+res);
    }

    static int hcf(int a,int b){
        if(a==0) return b;
        return hcf(b%a,a);
    }
}
