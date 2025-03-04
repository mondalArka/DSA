import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCM { //lcm *hcf = a*b
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the 1st number");
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enter the 2nd number");
        int b= Integer.parseInt(br.readLine());

       int res= hcf(a,b);
       System.out.println("HCF is "+res);
       int lc=lcm(a,b,res);

       System.out.println("Lcm "+lc);
    }

    static int hcf(int a,int b){
        if(a==0) return b;
        return hcf(b%a,a);
    }

    static int lcm(int a,int b,int hcf){
        // return (a*b)/hcf(a,b); // can use this too
        return (a*b)/hcf;
    }
}
