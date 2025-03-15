public abstract class aniruddhaProb {
    public static void main(String[] args) { // pattern 2,0,2,2,0,2
        int i=0;
        int n=7;
        int r=2;
        for(int k=0;k<n;k++)
        System.out.print("*");
        while(i<=5){
            System.out.println("");
            r=(r+i)%3;
            if(i>2) n+=r;
            else  n-=r;
            for(int j=0;j<n;j++)
                System.out.print("*");

                // n=n-r;
                i++;
                
        }
    }
}
