import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sqrtFind {
    public static void main(String[] args) throws IOException {
        float arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        s = Integer.parseInt(br.readLine());
        System.out.println("Enter the decimal place u want to find");
        int place=Integer.parseInt(br.readLine());
        int index = -1;
        float lEnd = 0;
        float hEnd = arr.length - 1;
        int mid = (int) (hEnd - lEnd) / 2;
        while (lEnd <= hEnd) {
            if (arr[mid] * arr[mid] == s) {
                index = mid;
                break;
            } else if (s > arr[mid] * arr[mid]) {
                lEnd = (int) mid + 1;
                mid = (int) (((hEnd - lEnd) / 2) + lEnd);
            } else if (s < arr[mid] * arr[mid]) {
                hEnd = (int) mid - 1;
                mid = (int) (hEnd - lEnd) / 2;
            }
        }
        if (index == -1 && (s > arr[0] * arr[0]) && (s < arr[arr.length - 1] * arr[arr.length - 1])) {
            System.out.println("Sqrt is :" + lEnd);
            float sqrt = lEnd;
            float finalSqrt = 0.0f;
            float div = 1;
            float c=1;
            for(int i=0;i<place;i++) c*=10;
            System.out.println(c+"c");
            div=1/c;
            do {
                System.out.println("div"+div);
                sqrt = sqrt + div;
                finalSqrt = sqrt * sqrt;
                System.out.println("finalsqrt: " + finalSqrt);
                System.out.println("sqrt"+sqrt);
                System.out.println("ssss"+(s-.4));
            } while (!(finalSqrt > s - 0.1) || !(finalSqrt < s));

            float num=(sqrt*c)- (int)sqrt*c;
            num=(int)sqrt+ (int)num/c;
            System.out.println("The square root upto:"+place+" is: "+num);
        } else if (index == -1)
            System.out.println("Out of range!");
        else {
            System.out.println("The number found is at index " + index);
            System.out.println("The sqrt of number 36 is: " + arr[mid]);
        }
    }
}
