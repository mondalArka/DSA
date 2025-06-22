public class bitwise {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;

        // left shift right shift
        // System.out.println("left shift it " + (a << b)); // left shift means to double it that many times a<<b=
                                                         // a*Math.pow(2,b)
        // System.out.println("right shift it " + (a >> b)); // right shift means to double it that many times a>>b=
                                                          // a/Math.pow(2,b)
        // evenOdd(24);
        int[] arr= {0,3,4,0,1,3,4};
        int [] arr2= {2,3,4,2,3,1,4,6}; 
        int [] arr3 ={ 2,3,4,-2,8,-4,-3};
        // findUnique(arr); // constraint numbers should repeat only twice
        // swap(5, 3); // swap
        // makeNegativeNos(69); // find its negative
        // findIthBitNo(13,2); // find ith bit
        // bitSettingOnOff(15, 4);
        // bitToggle(10, 1);
        // findSetBit(12); // find the right most on bit
        // findAllUnique(arr2); // constraint is numbers shpould repeat twice and 2 nos should only be unique
        findUniqueSigned(arr3);
    }

    static void evenOdd(int n) {
        if ((n & 1) == 1) // even numbers ends with 0 and odd nos ends with 1 so if multiply 1 with lsb of
                          // a number and we get 1 means odd and if we get 0 means even
            System.out.println("Odd");
        else
            System.out.println("Even");
    }

    static void findUnique(int[] arr){
        int unique=0;
        for(int val : arr){
            unique^=val;
        }

        System.out.println("Unique is "+unique);
    }

    static void swap(int a,int b){
        a^=b; // 5 ^3 = 6 = a
        b^=a; // 3 ^ 6 = 5 = b
        a^=b; // 6 ^ 5 = 3= a

        System.out.println("swapped a and b "+a+" "+b);
    }

    static void makeNegativeNos(int n){
        n= ~n+1;
        System.out.println("neagative is "+n);
    }

    static void findIthBitNo(int n,int pos){
        System.out.println("ith bit "+((n&(1<<(pos-1)))!=0?1:0)); // the concept is that say num is 1011101 find 5th bit need to mulitply with 10000 gives 1 at 5th bit if fith was 0 then 00000 8*0.left shidt it always to find ith0000 
        // here !=0 means whether the bit is on at that postion or not if not on then it is 1 may have any value but not on then it is something like this 00000 so has to be 0 at that position
    }

    static void bitSettingOnOff(int n,int pos){
        System.out.println("turned on "+(n | (1<<(pos-1))));
        System.out.println("turned off "+(n & ~(1<<(pos-1))));
    }

    static void bitToggle(int n,int pos){
        int x= n^(1<<(pos-1));
        System.out.println("toggled "+ (n^(1<<(pos-1))));
        System.out.println("binary form "+String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
    }

    static void findSetBit(int n){
        System.out.println("num"+String.format(Integer.toBinaryString(n)));
        int x=  ~n;
        System.out.println("not"+String.format(Integer.toBinaryString(x)));
        x+=1;
         System.out.println("add"+String.format(Integer.toBinaryString(x)));
        int y= n & x;
        System.out.println("pos if right 1 bit "+(Integer.numberOfTrailingZeros(y)+1));
    }

    static void findAllUnique(int[] arr){
        int un=0;
        for(int val: arr){
            un^=val;
            // System.out.println("num "+String.format(Integer.toBinaryString(un))+" "+val);
            System.out.println(
            "val = " + val + 
            " (" + String.format("%8s", Integer.toBinaryString(val)).replace(' ', '0') + "), " +
            "un = " + un + 
            " (" + String.format("%8s", Integer.toBinaryString(un)).replace(' ', '0') + ")"
        );
        }

        int mask= un & (~un+1);
        int a=0; int b=0;
        for(int val :arr){
            if((val & mask)==0)
                a^=val;
            else b^=val;
        }
        System.out.println("two uniques are "+a+" "+b);
        System.out.println("unique "+un);
    }

    static void findUniqueSigned(int[] arr){
        int un=0;
        for(int val: arr){
            un^=Math.abs(val); 
        }

        System.out.println("unique "+un);
    }
}
