import java.util.Arrays;

public class bitwise {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;

        // left shift right shift
        // System.out.println("left shift it " + (a << b)); // left shift means to
        // double it that many times a<<b=
        // a*Math.pow(2,b)
        // System.out.println("right shift it " + (a >> b)); // right shift means to
        // double it that many times a>>b=
        // a/Math.pow(2,b)
        // evenOdd(24);
        int[] arr = { 0, 3, 4, 0, 1, 3, 4 };
        int[] arr2 = { 2, 3, 4, 2, 3, 1, 4, 6 };
        int[] arr3 = { 2, 3, 4, -2, 8, -4, -3 };
        int[] arr4 = { 2, 2, 4, 2 };
        // findUnique(arr); // constraint numbers should repeat only twice
        // swap(5, 3); // swap
        // makeNegativeNos(69); // find its negative
        // findIthBitNo(13,2); // find ith bit
        // bitSettingOnOff(15, 4);
        // bitToggle(10, 1);
        // findSetBit(12); // find the right most on bit
        // findAllUnique(arr2); // constraint is numbers shpould repeat twice and 2  unique nos
        // should only be unique
        // findUniqueSigned(arr3);
        // findUniqueTriples(arr4);
        // findNumberOfDigits(9, 8); // find number of digits
        // isPowOf2(32); // exception case is for 0 returns true
        // findPower(0, 2); // find Math.pow(a,b) vv IMP*****************
        // countSetBits(19); // find the count of setbits
        // xorTillNum(30); // range from 0 to n
        // System.out.println("xor for a range " + (xorInRange(2) ^ xorInRange(9))); //
        // from range - to range. exmaple 3 to 5

        int[][] arr6 = {
                { 1, 1, 0 },
                { 1, 0, 1 },
                { 0, 0, 0 }
        };
        System.out.println("orginal Array is " + Arrays.deepToString(arr6));
        reverseInvert(arr6);
    }

    static void evenOdd(int n) {
        if ((n & 1) == 1) // even numbers ends with 0 and odd nos ends with 1 so if multiply 1 with lsb of
                          // a number and we get 1 means odd and if we get 0 means even
            System.out.println("Odd");
        else
            System.out.println("Even");
    }

    static void findUnique(int[] arr) {
        int unique = 0;
        for (int val : arr) {
            unique ^= val;
        }

        System.out.println("Unique is " + unique);
    }

    static void swap(int a, int b) {
        a ^= b; // 5 ^3 = 6 = a
        b ^= a; // 3 ^ 6 = 5 = b
        a ^= b; // 6 ^ 5 = 3= a

        System.out.println("swapped a and b " + a + " " + b);
    }

    static void makeNegativeNos(int n) {
        n = ~n + 1;
        System.out.println("neagative is " + n);
    }

    static void findIthBitNo(int n, int pos) {
        System.out.println("ith bit " + ((n & (1 << (pos - 1))) != 0 ? 1 : 0)); // the concept is that say num is
                                                                                // 1011101 find 5th bit need to mulitply
                                                                                // with 10000 gives 1 at 5th bit if fith
                                                                                // was 0 then 00000 8*0.left shidt it
                                                                                // always to find ith0000
        // here !=0 means whether the bit is on at that postion or not if not on then it
        // is 1 may have any value but not on then it is something like this 00000 so
        // has to be 0 at that position
    }

    static void bitSettingOnOff(int n, int pos) {
        System.out.println("turned on " + (n | (1 << (pos - 1))));
        System.out.println("turned off " + (n & ~(1 << (pos - 1))));
    }

    static void bitToggle(int n, int pos) {
        int x = n ^ (1 << (pos - 1));
        System.out.println("toggled " + (n ^ (1 << (pos - 1))));
        System.out.println("binary form " + String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
    }

    static void findSetBit(int n) {
        System.out.println("num" + String.format(Integer.toBinaryString(n)));
        int x = ~n;
        System.out.println("not" + String.format(Integer.toBinaryString(x)));
        x += 1;
        System.out.println("add" + String.format(Integer.toBinaryString(x)));
        int y = n & x;
        System.out.println("pos of right 1 bit " + (Integer.numberOfTrailingZeros(y) + 1));
    }

    static void findAllUnique(int[] arr) {
        int un = 0;
        for (int val : arr) {
            un ^= val;
            // System.out.println("num "+String.format(Integer.toBinaryString(un))+" "+val);
            System.out.println(
                    "val = " + val +
                            " (" + String.format("%8s", Integer.toBinaryString(val)).replace(' ', '0') + "), " +
                            "un = " + un +
                            " (" + String.format("%8s", Integer.toBinaryString(un)).replace(' ', '0') + ")");
        }

        int mask = un & (~un + 1);
        int a = 0;
        int b = 0;
        for (int val : arr) {
            if ((val & mask) == 0)
                a ^= val;
            else
                b ^= val;
        }
        System.out.println("two uniques are " + a + " " + b);
        System.out.println("unique " + un);
    }

    static void findUniqueSigned(int[] arr) {
        int un = 0;
        for (int val : arr) {
            un ^= Math.abs(val);
        }

        System.out.println("unique " + un);
    }

    static void findUniqueTriples(int[] arr) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int val : arr)
                sum += (val >> i) & 1;

            if (sum % 3 != 0)
                result |= (1 << i);
        }
        System.out.println("unique " + result);
    }

    static void findNumberOfDigits(int n, int base) {
        int digits = (int) (Math.log(n) / Math.log(base)) + 1;
        System.out.println("number of digits" + digits);
    }

    static void isPowOf2(int n) {
        System.out.println("Is power of 2 " + ((n & (n - 1)) == 0));
    }

    static void findPower(int n, int pow) { // like Math.pow
        int ans = 1;

        while (pow > 0) {
            if ((pow & 1) == 1)
                ans *= n;

            n *= n;
            pow >>= 1;
        }
        System.out.println(ans);
    }

    static void countSetBits(int n) {
        System.out.println("Actual bits " + Integer.toBinaryString(n));
        int count = 0;
        // while(n>0){ // one way
        // count++;
        // n-=n&-n;
        // }

        while (n > 0) { // 2nd way
            count++;
            n = n & (n - 1);
        }
        System.out.println("Count fo setbits " + count);
    }

    static void xorTillNum(int n) { // a,1,a+1,0 is a pattern that comes after ecah 4 numbers
        if (n % 4 == 0)
            System.out.println("ans " + n);
        else if (n % 4 == 1)
            System.out.println("ans " + 1);
        else if (n % 4 == 2)
            System.out.println("ans " + (n + 1));
        else if (n % 4 == 3)
            System.out.println("ans " + 0);
    }

    static int xorInRange(int b) {
        if (b % 4 == 0)
            // System.out.println("ans from 0 to b range "+(b));
            return b;
        else if (b % 4 == 1)
            // System.out.println("ans from 0 to b range "+(1));
            return 1;

        else if (b % 4 == 2)
            // System.out.println("ans from 0 to b range "+(b+1));
            return (b + 1);
        else if (b % 4 == 3)
            // System.out.println("ans from 0 to b range "+(0));
            return 0;

        return 0;
    }

    static void reverseInvert(int[][] arr) {
        for (int[] row : arr) {
            for (int j = 0; j < (arr[0].length + 1) / 2; j++) { // first reverse then invert the image
                int temp = row[j] ^ 1;
                row[j] = row[arr[0].length - j - 1] ^ 1;
                row[arr[0].length - j - 1] = temp;
            }
            
        }

        System.out.println("reverseInvert Array is " + Arrays.deepToString(arr));
    }
}
