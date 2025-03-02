import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sqrtFind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Eneter the number");
        int n=Integer.parseInt(br.readLine());
        System.out.println("Enter precision");
        int p=Integer.parseInt(br.readLine());
        int root=-1;
        int hend=n;
        int lend=0;
        int m=(hend-lend)/2;
        while(lend<=hend){
            m= lend +(hend-lend)/2;
            if(m*m==n) {
                root=m;
                break;
            }

            else if(m*m>n) hend=m-1;

            else lend=m+1;
        }
        if(root!=-1)
        System.out.println("Sqrt is: "+m);
        else {
            double inc=1;
            double d=(double)lend-1;
        for(int i=0;i<p;i++){
            inc/=10;
            while(d*d<=n){
                d+=inc;
                System.out.println("d" +d);
                System.out.println("inc "+inc);
            }
            d-=inc;
            if(d*d==n) break;
            
        }
        //rounding off
        System.out.printf("Prceision %.2f",d);
        }
    }
}
