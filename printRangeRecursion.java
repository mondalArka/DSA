import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class printRangeRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Ascending order");
        printAscRange(n);
        System.out.println("Descending order");
        printDescRange(n);
    }

    static void printAscRange(int n) {// asc order
        if (n < 1)
            return;
        printAscRange(n - 1);
        System.out.print(n + ", ");
    }

    static void printDescRange(int n) { // desc order
        if (n < 1)
            return;
        System.out.print(n + ", ");
        printDescRange(n - 1);
    }
}
